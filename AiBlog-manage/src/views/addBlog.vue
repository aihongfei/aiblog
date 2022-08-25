<template>
  <div>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <i class="el-icon-edit"></i>&nbsp;&nbsp;
        <span v-if="$route.query.id">修改博客</span>
        <span v-else>新建博客</span>
        <el-button style="float: right" size="mini" icon="el-icon-back" @click="$router.go(-1)"></el-button>
      </div>
      <div class="text item">
        <el-form ref="form" :model="form" label-width="80px" :rules="rules">
          <el-form-item label="标题" prop="title">
            <el-input v-model="form.title"></el-input>
          </el-form-item>
          <el-form-item label="描述" prop="description">
            <el-input type="textarea" v-model="form.description"></el-input>
          </el-form-item>
          <el-form-item label="发布" prop="published">
            <el-switch v-model="form.published"></el-switch>
          </el-form-item>
          <el-form-item label="标签" prop="tags">
            <div style="display: flex;flex-wrap: wrap">
              <el-checkbox v-model="item.status" v-for="(item,index) in tagList" :key="index">
                {{ item.name }}
              </el-checkbox>
              <div>
                <el-input
                  class="input-new-tag"
                  v-if="inputTagVisible"
                  v-model="inputTagValue"
                  ref="saveTagInput"
                  size="small"
                  @keyup.enter.native="inputTag"
                  @blur="inputTag"
                ></el-input>
              </div>
              <div @click="addTag">
                <el-icon class="add el-icon-circle-plus"></el-icon>
              </div>
            </div>
          </el-form-item>
          <el-form-item label="分类" prop="types">
            <div style="display: flex;align-items: center;flex-wrap: wrap">
              <el-radio-group v-model="form.types">
                <el-radio v-for="(item,index) in typeList" :key="index" :label="item.id">{{ item.name }}</el-radio>
              </el-radio-group>
              <div>
                <el-input
                  class="input-new-tag"
                  v-if="inputTypeVisible"
                  v-model="inputTypeValue"
                  ref="saveTypeInput"
                  size="small"
                  @keyup.enter.native="inputType"
                  @blur="inputType"
                ></el-input>
              </div>
              <div @click="addType">
                <el-icon class="add el-icon-circle-plus"></el-icon>
              </div>
            </div>
          </el-form-item>
          <el-form-item label="内容" prop="content">
            <mavon-editor @imgAdd="imgAdd" ref="md" style="height: 1000px" :ishljs="true"
                          @imgDel="imgDel" codeStyle="atelier-savanna-light"
                          v-model="form.content"></mavon-editor>
          </el-form-item>
          <el-form-item>
            <el-button  v-if="$route.query.id" type="primary" @click="onUpdate">立即修改</el-button>
            <el-button v-else type="primary" @click="onSubmit">立即创建</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
  </div>
</template>
<script>
import 'mavon-editor/dist/css/index.css'
import {mavonEditor} from 'mavon-editor'
import {
  addBlog,
  addimg,
  addTag,
  addType,
  deleteimg,
  getBlogById,
  getTag,
  getTagByBlogId,
  getType,
  updateBlog
} from "../api";

export default {
  name: "addBlog",
  data() {
    return {
      form: {
        title: '',
        description: '',
        published: true,
        content: '',
        types: [],
        tags: []
      },
      rules: {
        title: [
          {required: true, message: "必填"},
          {min: 1, max: 50, message: '长度在 1 到 20 个字符', trigger: 'blur'}],
        description: [
          {required: true, message: "必填"},
          {min: 1, max: 100, message: '长度在 1 到 100 个字符', trigger: 'blur'}],
        content: [
          {required: true, message: "必填"}],
        types: [{required: true, message: "必选"}]
      },
      typeList: [],
      tagList: [],
      inputTagVisible: false,
      inputTagValue: '',
      inputTypeVisible: false,
      inputTypeValue: ''
    }
  },
  components: {
    mavonEditor
  },
  created() {
    this.getType();
    this.getTag();
  },
  mounted() {
    if (this.$route.query.id) {
      this.getBlogById(this.$route.query.id);
      this.getBlogTag(this.$route.query.id);
    }
  },
  methods: {
    getBlogById(id) {
      getBlogById({id: id})
        .then(res => {
            this.form.description = res.blog.description
            this.form.content = res.blog.content
            this.form.id = res.blog.id
            this.form.published = res.blog.published == 1
            this.form.title = res.blog.title
            this.form.types = res.blog.typeId
          }
        )
    },
    getBlogTag(id) {
      getTagByBlogId({blogId: id})
        .then(res => {
          for (let i = 0; i < this.tagList.length; i++) {
            res.tagList.map(item => {
              if (this.tagList[i].id == item.id) {
                this.tagList[i].status = true;
              }
            })
          }

        })
    },
    getType() {
      getType({pageSize: 100000})
        .then(res => {
          this.typeList = res.typeList;
        })
    }
    ,
    getTag() {
      getTag({pageSize: 100000})
        .then(res => {
          this.tagList = res.tagList.map(item => {
              return {
                id: item.id,
                name: item.name,
                status: false
              }
            }
          )
        })
    }
    ,
    inputTag() {
      let inputTagValue = this.inputTagValue;
      if (inputTagValue.trim()) {
        let param = new URLSearchParams();
        param.append("name", inputTagValue)
        addTag(param)
          .then(res => {
            if (res.status == 1) {
              this.$notify({
                type: "success",
                title: res.msg
              })
              this.getTag();
            } else {
              this.$notify({
                type: "error",
                title: res.msg
              })
            }
          })
      }
      this.inputTagVisible = false;
      this.inputTagValue = '';
    }
    ,
    addTag() {
      this.inputTagVisible = true;
      this.$nextTick(_ => {
        this.$refs.saveTagInput.$refs.input.focus();
      });
    }
    ,
    inputType() {
      let inputTypeValue = this.inputTypeValue;
      if (inputTypeValue.trim()) {
        let param = new URLSearchParams();
        param.append("name", inputTypeValue)
        addType(param)
          .then(res => {
            if (res.status == 1) {
              this.$notify({
                type: "success",
                title: res.msg
              })
              this.getType();
            } else {
              this.$notify({
                type: "error",
                title: res.msg
              })
            }
          })
      }
      this.inputTypeVisible = false;
      this.inputTypeValue = '';
    }
    ,
    addType() {
      this.inputTypeVisible = true;
      this.$nextTick(_ => {
        this.$refs.saveTypeInput.$refs.input.focus();
      });
    }
    ,
    imgAdd(pos, $file) {
      var _this = this;
      // 第一步.将图片上传到服务器.
      var formdata = new FormData();
      formdata.append('file', $file);
      addimg(formdata)
        .then(res => {
          _this.$refs.md.$imglst2Url([[pos, 'https://aihf.club/api/' + res.url]])
        })
    }
    ,
    imgDel(pos) {
      let path = pos[0];
      var index = path.lastIndexOf("/");
      path = path.substring(index + 1, path.length);
      deleteimg({path: path})
        .then(res => {
          console.log(res)
        })
    }
    ,
    onSubmit() {
      if (!this.checkForm()) {
        this.$message.error('请完善相关信息！');
        return;
      }
      let params = new URLSearchParams();
      params.append("title", this.form.title);
      params.append("description", this.form.description);
      params.append("published", this.form.published ? '1' : '0');
      params.append("typeId", this.form.types);
      this.tagList.map(item => {
        if (item.status) {
          this.form.tags.push(item.id);
        }
      })
      params.append("tagIds", this.form.tags);
      params.append("content", this.form.content);
      addBlog(params)
        .then(res => {
          if (res.status == 1) {
            this.$notify({
              type: "success",
              title: res.msg
            })
            this.$router.push('/blogs')
          } else {
            this.$notify({
              type: "error",
              title: res.msg
            })
          }
        })
    },
    onUpdate(){
      if (!this.checkForm()) {
        this.$message.error('请完善相关信息！');
        return;
      }
      let params = new URLSearchParams();
      params.append("id", this.form.id);
      params.append("title", this.form.title);
      params.append("description", this.form.description);
      params.append("published", this.form.published ? '1' : '0');
      params.append("typeId", this.form.types);
      this.tagList.map(item => {
        if (item.status) {
          this.form.tags.push(item.id);
        }
      })
      params.append("tagIds", this.form.tags);
      params.append("content", this.form.content);
      updateBlog(params)
        .then(res => {
          if (res.status == 1) {
            this.$notify({
              type: "success",
              title: res.msg
            })
            this.$router.push('/blogs')
          } else {
            this.$notify({
              type: "error",
              title: res.msg
            })
          }
        })
    }
    ,
// 表单校验
    checkForm() {
      // 1.校验必填项
      let validForm = false;
      this.$refs.form.validate(valid => {
        validForm = valid
      })
      if (!validForm) {
        return false;
      }
      return true;
    }
    ,
  }
}
;
</script>
<style lang="scss" scoped>
.add {
  margin-left: 20px;
  cursor: pointer;
}

.input-new-tag {
  width: 90px;
  margin-left: 10px;
  vertical-align: bottom;
}
</style>
