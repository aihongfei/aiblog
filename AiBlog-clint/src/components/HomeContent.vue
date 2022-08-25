<template>
  <div class="all">
    <div class="bg"></div>
    <loading v-if="load"></loading>
    <el-row style="margin-top: 20px;">
      <div v-if="typeAndTagId!=-1">
        <h1>AiBlog - {{ typeAndTagName }}</h1>
        <div style="text-align: center">共{{ typeAndTagCount }}篇文章</div>
        <br>
        <br>
      </div>

      <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24" v-for="(item,index) in blogList"
              :key="index">
        <div class="animate__animated" :id="index" :class="{'animate__fadeInUp':item.flag}">
          <div>
            <el-card class="box-card">
              <h3 class="title" @click="toBlog(item.id)">{{ item.title }}</h3>
              <div class="text item" @click="toBlog(item.id)">
                {{ item.description }}
              </div>
              <div style="color: darkgray;font-size: 70%">
                <el-row>
                  <el-col :xs="12" :sm="12" :md="6" :lg="6" :xl="6">
                    {{item.createTime.substr(0,11) }}
                  </el-col>
                  <el-col :xs="12" :sm="12" :md="6" :lg="6" :xl="6">
                    作者：繁华落幕
                  </el-col>
                  <el-col :xs="12" :sm="12" :md="6" :lg="6" :xl="6">
                    {{ item.typeName }}
                  </el-col>
                  <el-col :xs="12" :sm="12" :md="6" :lg="6" :xl="6">
                    浏览量:{{ item.clickNum }}
                  </el-col>
                </el-row>
              </div>
            </el-card>
          </div>
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
        <el-card class="box-card" style="text-align: center">
          <div class="page">
            <span v-for="item in page" :key="item">
              <span @click="item!=pageNum&&changePage(item)" class="pageNum"
                    :class="item==pageNum?'select':'toSelect'">{{ item }}</span>&nbsp;&nbsp;
            </span>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import {blogList} from '../assets/data/blogList'
import loading from "./load/loading";
import {dataFormat} from "../util/util";
import {getBlogByTagId, getBlogByTypeId, getBlogList, getType, getTypeById} from "../api";

export default {
  name: "HomeContent",
  data() {
    return {
      load: false,
      blogList: [], //博客列表
      height: 0,     //滚动条高度
      typeAndTagId: -1,
      typeAndTagName: '',
      typeAndTagCount: 0,
      page: '',
      pageNum: 1,
      pageSize: 9
    }
  },
  components: {
    loading
  },
  computed: {},
  watch: {},
  beforeCreate() {
    // this.$YsLoad5.startLoad();
  },
  mounted() {//可以在这里面直接进行滚动条的获取
    window.addEventListener('scroll', this.handleScroll, true)
  },
  destroyed() {
    window.removeEventListener('scroll', this.handleScroll, true)
  },
  created() {
    // this.blogList = blogList;
    if (this.$route.query.typeId != null) {
      this.typeAndTagId = this.$route.query.typeId;
      this.typeAndTagName = this.$route.query.typeName;
      this.typeAndTagCount = this.$route.query.count
      this.getBlogByType(this.pageNum, this.pageSize);
    } else if (this.$route.query.tagId != null) {
      this.typeAndTagId = this.$route.query.tagId;
      this.typeAndTagName = this.$route.query.tagName;
      this.typeAndTagCount = this.$route.query.count
      this.getBlogByTag(this.pageNum, this.pageSize);
    } else if (this.$route.query.tagId == null && this.$route.query.typeId == null) {
      this.getBlog(this.pageNum, this.pageSize);
    }

  },
  methods: {
    handleScroll() {
      this.height = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop;
      for (let i = 0; i < this.blogList.length; i++) {
        if (this.height > this.getTop(document.getElementById(i)) - window.innerHeight) {
          this.blogList[i].flag = true;
        }
      }
    },
    getTop(e) { //获取元素距离最上高度
      var offset = e.offsetTop;
      if (e.offsetParent != null)
        offset += this.getTop(e.offsetParent);
      return offset;
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
          this.blogList = res.blogList.map(item => {
            return {
              clickNum: item.clickNum,
              createTime: item.createTime,
              description: item.description,
              id: item.id,
              published: item.published,
              title: item.title,
              typeName: item.typeName,
              flag: false
            }
          });
          this.page = res.pages;
          this.pageNum = res.pageNum;
          this.load = false;
        })
    },
    getBlogByType(pageNum, pageSize) {
      getBlogByTypeId(
        {
          typeId: this.typeAndTagId,
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
              published: item.published,
              title: item.title,
              typeName: item.typeName,
              flag: false
            }
          })
          this.page = res.pages;
          this.pageNum = res.pageNum;
          this.load = false;
        })
    },
    getBlogByTag(pageNum, pageSize) {
      getBlogByTagId(
        {
          tagId: this.typeAndTagId,
          pageNum: pageNum,
          pageSize: pageSize
        })
        .then(res => {
          console.log(res)
          this.blogList = res.blogList.map(item => {
            return {
              clickNum: item.clickNum,
              createTime: item.createTime,
              description: item.description,
              id: item.id,
              published: item.published,
              title: item.title,
              typeName: item.typeName,
              flag: false
            }
          })
          this.page = res.pages;
          this.pageNum = res.pageNum;
          this.load = false;
        })
    },
    changePage(pageNum) {
      if (this.$route.query.typeId != null) {
        this.getBlogByType(pageNum, this.pageSize);
      } else if (this.$route.query.tagId != null) {
        this.getBlogByTag(pageNum, this.pageSize);
      } else if (this.$route.query.tagId == null && this.$route.query.typeId == null) {
        this.getBlog(pageNum, this.pageSize);
      }
    }
  }
}

</script>

<style scoped>
@import "../assets/css/HomeContent.css";
</style>
