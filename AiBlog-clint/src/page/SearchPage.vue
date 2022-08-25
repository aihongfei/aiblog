<template>
  <div class="all">
    <div class="bg"></div>
    <div class="searchClass">
      <input class="search" @keyup.enter="onEnterPress" v-model="keyword" placeholder=" 请输入关键字"></input>
      <i class="el-icon-search el-input__icon"
         slot="suffix"
         @click="onEnterPress">
      </i>
    </div>
    <div class="content">
      <div v-for="(item,index) in blogList" :key="index">
        <div class="title">
          <h3 @click="toBlog(item.id)">{{ item.title }}</h3>
        </div>
        <div class="description">
          <p @click="toBlog(item.id)">{{ item.description }}</p>
        </div>
        <div class="msg">
          <el-row>
            <el-col :xs="{span:10,offset:4}" :sm="{span:4,offset:5}" :md="{span:4,offset:5}" :lg="{span:4,offset:5}"
                    :xl="{span:4,offset:5}">
              {{ item.createTime }}
            </el-col>
            <el-col :xs="10" :sm="4" :md="4" :lg="4" :xl="4">
              作者：繁华落幕
            </el-col>
            <el-col :xs="{span:10,offset:4}" :sm="4" :md="4" :lg="4" :xl="4">
              {{ item.typeName }}
            </el-col>
            <el-col :xs="10" :sm="4" :md="4" :lg="4" :xl="4">
              浏览量:{{ item.clickNum }}
            </el-col>
          </el-row>
        </div>
      </div>
      <br>
      <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
        <div style="display: flex;justify-content: center;align-items: center;margin-top: 20px">
          <div class="page">
            <span v-for="item in page" :key="item">
              <span @click="item!=pageNum&&changePage(item)" class="pageNum"
                    :class="item==pageNum?'select':'toSelect'">{{ item }}</span>&nbsp;&nbsp;
            </span>
          </div>
        </div>
      </el-col>
    </div>
    <br>
    <br>
    <br>
    <br>
    <br>
  </div>
</template>

<script>
import {blogList} from "../assets/data/blogList";
import {getBlogKeyWord, getBlogList} from "../api";

export default {
  name: "SearchPage",
  data() {
    return {
      keyword: '', //搜索关键字
      blogList: [], //博客列表
      page: 1,
      pageNum: 1,
      pageSize: 8
    }
  },
  created() {
    // this.blogList = blogList;
    this.getBlog(this.pageNum, this.pageSize)
  },
  methods: {
    onEnterPress() {
      this.pageNum = 1;
      if (this.keyword != '') {
        //向后台发请求
        this.getBlogByKeyWord(this.keyword, this.pageNum, this.pageSize)
      } else {
        this.getBlog(1, this.pageSize)
      }
    },
    toBlog(id) {
      let routeData = this.$router.resolve({path: '/blog', query: {id: id}});
      window.open(routeData.href, '_blank');
    },
    getBlog(pageNum, pageSize) {
      getBlogList({
        pageNum: pageNum,
        pageSize: pageSize
      })
        .then(res => {
          this.blogList = res.blogList;
          this.page = res.pages;
          this.pageNum = res.pageNum;
          this.load = false;
        })
    },
    getBlogByKeyWord(keyword, pageNum, pageSize) {
      this.load = true;
      getBlogKeyWord(
        {
          keyword: this.keyword,
          pageNum: pageNum,
          pageSize: pageSize
        }
      )
        .then(res => {
          console.log(res)
          this.blogList = res.blogList;
          this.page = res.pages;
          this.pageNum = res.pageNum;
          this.load = false;
        })
    },
    changePage(pageNum) {
      if (this.keyword == '') {
        this.getBlog(pageNum, this.pageSize);
      } else {
        this.getBlogByKeyWord(this.keyword, pageNum, this.pageSize);
      }
    }
  }
}
</script>

<style scoped>
@import "../assets/css/SearchPage.css";

</style>
