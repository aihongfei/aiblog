<template>
  <div style="height: 100%">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <i class="el-icon-edit"></i>&nbsp;&nbsp;
        <span>AiBlog博客列表</span>
      </div>
      <div class="text item">
        <el-button icon="el-icon-back" @click="$router.go(-1)"></el-button>
        <el-input v-model="input" @input="search" placeholder="请输入关键字(标题、描述、内容)"
                  style="margin-bottom: 20px;width: 30%"></el-input>
        <el-button style="float: right" type="primary" @click="$router.push('/add')">新建博客</el-button>
        <el-table :data="blogList" border style="width: 100%" :height="tableHeight" stripe>
          <el-table-column width="50" align="center">
            <template slot-scope="scope">
              {{ (scope.$index + 1) + pageSize * (pageNum - 1) }}
            </template>
          </el-table-column>
          <el-table-column align="center" prop="title" label="标题" width="180"  :show-overflow-tooltip="true"></el-table-column>
          <el-table-column prop="description" align="center" label="简介" :show-overflow-tooltip="true"></el-table-column>
          <el-table-column align="center" prop="createTime" label="发布时间" width="180"></el-table-column>
          <el-table-column align="center" prop="clickNum" label="点击数" width="100"></el-table-column>
          <el-table-column align="center" label="发布" width="100">
            <template slot-scope="scope">
              <el-switch
                v-model="scope.row.published"
                active-color="#13ce66"
                inactive-color="#ff4949"
                @change="changePublish(scope.row)">
              </el-switch>
            </template>
          </el-table-column>
          <el-table-column align="center" prop="typeName" label="分类名称" width="150"></el-table-column>
          <el-table-column align="center" label="操作" width="200">
            <template slot-scope="scope">
              <el-button type="info" plain size="mini" @click="showBlog(scope.row)">预览</el-button>
              <el-popconfirm icon="el-icon-info" icon-color="red"
                             title="这个博客确定删除吗？" @onConfirm="onDelete(scope.row)">
                <el-button slot="reference" type="danger" plain size="mini">删除</el-button>
              </el-popconfirm>
              <el-button type="success" plain size="mini" @click="updateBlog(scope.row)">修改</el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination v-if="show" style="text-align: center;padding-top: 15px" :current-page="currentpage"
                       background :page-count="page" @current-change="handleCurrentChange"
                       layout="prev, pager, next">
        </el-pagination>
      </div>
    </el-card>
    <el-dialog :title="blog.title" :modal-append-to-body="false" :visible.sync="dialogVisible" width="70%">
      <mavon-editor :ishljs="true" style="height: 500px" :value="blog.content" :subfield="prop.subfield"
                    :defaultOpen="prop.defaultOpen" :editable="prop.editable" :toolbars="toolbars"
                    :scrollStyle="prop.scrollStyle" codeStyle="atelier-savanna-light"></mavon-editor>
    </el-dialog>
  </div>
</template>
<script>
import 'mavon-editor/dist/css/index.css'
import {mavonEditor} from 'mavon-editor'
import {deleteBlog, getBlogById, getBlogKeyWord, getBlogList, updatePublish} from "../api";
import {debounce} from "../util/util";

export default {
  name: "notes",
  data() {
    return {
      tableHeight: document.documentElement.clientHeight - 300,
      multipleSelection: [],
      input: '',
      blogList: [],
      pageNum: 1,
      pageSize: 8,
      page: 1,
      currentpage: 1,
      show: true, // 分页展示
      dialogVisible: false, // 预览展示
      blog: {}, // 预览内容
      toolbars: {
        navigation: true, // 导航目录
        subfield: true,  // 单双栏模式
        preview: true,  // 预览
      }
    };
  },
  components: {
    mavonEditor
  },
  computed: {
    // 解析器配置
    prop() {
      let data = {
        subfield: false,// 单双栏模式
        defaultOpen: 'preview',//edit： 默认展示编辑区域 ， preview： 默认展示预览区域
        editable: false,	// 是否允许编辑
        toolbarsFlag: true,
        scrollStyle: true
      }
      return data
    }
  },
  created() {
    this.getBlog(this.pageNum, this.pageSize);
  },
  methods: {
    search: debounce(function () {
      if (this.input === '') {
        this.getBlog(1, this.pageSize);
        this.show = false;
        this.$nextTick(() => {
          this.show = true
        })
      } else {
        this.getBlogKeyWord(this.input, 1, this.pageSize);
        this.show = false;
        this.$nextTick(() => {
          this.show = true
        })
      }
    }, 500),
    getBlogKeyWord(keyword, pageNum, pageSize) {
      getBlogKeyWord(
        {
          keyword: keyword,
          pageNum: pageNum,
          pageSize: pageSize
        }
      ).then(res => {
        this.blogList = res.blogList.map(item => {
          return {
            clickNum: item.clickNum,
            createTime: item.createTime,
            description: item.description,
            id: item.id,
            published: item.published == 1,
            title: item.title,
            typeName: item.typeName,
          }
        });
        this.page = res.pages;
        this.pageNum = res.pageNum;
      })
    },
    getBlog(pageNum, pageSize) { // 获取博客列表
      getBlogList({
        pageNum: pageNum,
        pageSize: pageSize
      })
        .then(res => {
          this.blogList = res.blogList.map(item => {
            return {
              clickNum: item.clickNum,
              createTime: item.createTime,
              description: item.description,
              id: item.id,
              published: item.published == 1,
              title: item.title,
              typeName: item.typeName,
            }
          });
          this.page = res.pages;
          this.pageNum = res.pageNum;
        })
    },
    changePublish(row) { //修改发布
      let publish = row.published ? '1' : '0';
      let params = new URLSearchParams();
      params.append("blogId", row.id);
      params.append("published", publish);
      updatePublish(params)
        .then(res => {
          if (res.status == 1) {
            this.$notify({
              type: "success",
              title: res.msg
            })
          } else {
            this.$notify({
              type: "error",
              title: res.msg
            })
          }
        })
    },
    toComment(row) { // 查看评论

    },
    onDelete(row) { // 删除博客
      if (this.blogList.length == 1) {
        this.deleteBlog(row.id, this.pageNum - 1, this.pageSize);
      } else {
        this.deleteBlog(row.id, this.pageNum, this.pageSize);
      }
    },
    showBlog(row) { // 预览博客
      getBlogById({id: row.id})
        .then(res => {
          this.blog.content = res.blog.content;
          this.blog.title = res.blog.title;
          this.dialogVisible = !this.dialogVisible;
        })
    },
    updateBlog(row) { // 修改博客
      this.$router.push({path: '/add', query: {id: row.id}});
    },
    handleCurrentChange(val) {
      if (this.input == '' || this.input == null) {
        this.getBlog(val, this.pageSize);
      } else {
        this.getBlogKeyWord(this.input, val, this.pageSize);
      }
    },

    deleteBlog(id, pageNum, pageSize) {
      if (this.input == '' || this.input == null) {
        deleteBlog({id: id})
          .then(res => {
            if (res.status == 1) {
              this.getBlog(pageNum, pageSize);
              this.$notify({
                type: "success",
                title: res.msg
              })
            } else {
              this.$notify({
                type: "error",
                title: res.msg
              })
            }
          })
      }
    }
  }
};
</script>
<style scoped lang="scss">

</style>
