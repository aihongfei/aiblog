<template>
  <div>
    <home-header></home-header>
    <div class="bg"></div>
    <div class="tagContent">
      <div>
        <h2 class="title">AiBlog - 标签墙</h2>
        <div style="text-align: center">{{ tagList.length }}个标签</div>
        <br>
        <br>
      </div>
      <div>
        <el-row type="flex" justify="center">
          <el-col :xs="22" :sm="18" :md="15" :lg="14" :xl="14">
            <el-card class="box-card">
              <div class="text">
                <div v-for="(item,index) in tagList" :key="index" @click="chooseTag(item)">
                  <div style="height: 40px">
                    <div>
                      <span class="tag">
                       {{ item.name }} - {{ item.count }}篇
                      </span>&nbsp;&nbsp;&nbsp;&nbsp;
                    </div>
                  </div>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>
      </div>
    </div>
    <home-footer></home-footer>
  </div>
</template>

<script>
import HomeFooter from "../components/HomeFooter";
import {tag} from "../assets/data/tag";
import HomeHeader from "../components/HomeHeader";
import {getTag} from "../api";

export default {
  name: "TagPage",
  data() {
    return {
      conheight: {
        height: ''
      },
      tagList: [] //标签列表
    }
  },
  components: {
    HomeHeader,
    HomeFooter
  },
  created() {
    this.getTag();
    window.addEventListener('resize', this.getHeight);
    this.getHeight()
  },
  methods: {
    getHeight() {
      this.conheight.height = window.innerHeight + 'px';
    },
    chooseTag(item) { //根据tag跳转
      console.log(item)
      let routeData = this.$router.resolve({
        path: '/',
        query: {tagId: item.id, tagName: item.name, count: item.count}
      });
      window.open(routeData.href, '_blank');
    },
    getTag(){
      getTag()
      .then(res=>{
        console.log(res)
        this.tagList = res.tagList
      })
    }
  }
}
</script>

<style scoped>
@import "../assets/css/TagPage.css";
</style>
