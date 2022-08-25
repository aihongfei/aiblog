<template>
  <div style="height: 100%">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <i class="el-icon-edit"></i>&nbsp;&nbsp;
        <span>AiBlog标签列表</span>
      </div>
      <div class="text item">
        <el-button icon="el-icon-back" @click="$router.go(-1)"></el-button>
        <el-button style="float: right" type="primary" @click="addTag">新建标签</el-button>
        <el-input v-if="inputTagVisible" v-model="inputTagValue" ref="saveTypeInput"
                  style="width: 150px;float: right" @keyup.enter.native="inputType" @blur="inputType">
        </el-input>
        <el-table :data="tagList" border style="margin-top: 5px;width: 100%" :height="tableHeight">
          <el-table-column width="50" align="center">
            <template slot-scope="scope">
              {{ (scope.$index + 1) + pageSize * (pageNum - 1) }}
            </template>
          </el-table-column>
          <el-table-column align="center" prop="name" label="名字"></el-table-column>
          <el-table-column align="center" prop="count" label="博客数量"></el-table-column>
          <el-table-column align="center" label="操作">
            <template slot-scope="scope">
              <el-button @click="showBlog(scope.row)">内容</el-button>
              <el-tooltip effect="dark" content="博客数量为0时可删除" placement="bottom">
                <el-popconfirm icon="el-icon-info" icon-color="red"
                               title="这个标签确定删除吗？" @onConfirm="deleteTag(scope.row)">
                  <el-button slot="reference" type="danger" plain>删除</el-button>
                </el-popconfirm>
              </el-tooltip>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination v-if="show" style="text-align: center;padding-top: 15px" :current-page="currentpage"
                       background :page-count="page" @current-change="handleCurrentChange"
                       layout="prev, pager, next">
        </el-pagination>
      </div>
    </el-card>
    <el-dialog :title="title" align="center" :modal-append-to-body="false" :visible.sync="dialogVisible" width="50%">
      <el-table :data="blogList" stripe height="300">
        <el-table-column prop="title" label="标题" align="center"></el-table-column>
        <el-table-column prop="createTime" label="创建时间" align="center"></el-table-column>
      </el-table>
    </el-dialog>
  </div>
</template>
<script>
import {
  addTag,
  deleteBlog,
  deleteTag,
  getBlogById, getBlogByTagId,
  getBlogByTypeId,
  getBlogList,
  getTag,
  updatePublish
} from "../api";

export default {
  name: "notes",
  data() {
    return {
      tableHeight: document.documentElement.clientHeight - 300,
      multipleSelection: [],
      input: '',
      tagList: [],
      pageNum: 1,
      pageSize: 7,
      page: 1,
      currentpage: 1,
      show: true, // 分页展示
      title: '', // 弹出框标题
      blogList: [], // 弹出框内容
      dialogVisible: false, // 预览展示
      inputTagVisible: false,
      inputTagValue: ''
    };
  },
  created() {
    this.getTag(this.pageNum, this.pageSize);
  },
  methods: {
    getTag(pageNum, pageSize) { // 获取博客列表
      getTag({
        pageNum: pageNum,
        pageSize: pageSize
      })
        .then(res => {
          this.tagList = res.tagList
          this.page = res.pages;
          this.pageNum = res.pageNum;
        })
    },
    inputType() {
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
              this.getTag(this.pageNum,this.pageSize);
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
        this.$refs.saveTypeInput.$refs.input.focus();
      });
    },
    deleteTag(row) {
      if (row.count != 0) {
        this.$message.error('此标签中含有博客，无法删除');
        return
      }
      deleteTag({id: row.id})
        .then(res => {
          if (res.status == 1) {
            this.$notify({
              type: "success",
              title: res.msg
            })
            if (this.tagList.length == 1) {
              this.getTag(this.pageNum - 1, this.pageSize);
            } else {
              this.getTag(this.pageNum, this.pageSize);
            }
          } else {
            this.$notify({
              type: "error",
              title: res.msg
            })
          }
        })
    },
    showBlog(row) { // 弹出框
      this.title = row.name
      getBlogByTagId({tagId: row.id, pageSize: 10000})
        .then(res => {
          this.blogList = res.blogList;
          this.dialogVisible = true;
        })
    },
    handleCurrentChange(val) {
      this.getTag(val, this.pageSize);
    },
  }
};
</script>
<style scoped lang="scss">

</style>
