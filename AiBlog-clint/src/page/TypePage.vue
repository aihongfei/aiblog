<template>
  <div>
    <home-header></home-header>
    <div class="bg"></div>
    <div class="typeContent">
      <div>
        <h2 class="type">AiBlog - 分类</h2>
        <div style="text-align: center">{{ typeList.length }}个分类</div>
        <br>
        <br>
      </div>
      <div>
        <el-row type="flex" justify="center">
          <el-col :xs="22" :sm="18" :md="15" :lg="14" :xl="14">
            <el-card class="box-card">
              <div class="text item">
                <ul>
                  <li v-for="(item,index) in typeList" :key="index" @click="chooseType(item)">
                    {{ item.name }} - 共{{ item.count }}篇文章
                  </li>
                </ul>
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
import {type} from "../assets/data/type";
import HomeHeader from "../components/HomeHeader";
import {getType} from "../api";

export default {
  name: "TypePage",
  data() {
    return {
      conheight: {
        height: ''
      },
      typeList: [] //分类列表
    }
  },
  components: {
    HomeHeader,
    HomeFooter
  },
  created() {
    this.getType();
    window.addEventListener('resize', this.getHeight);
    this.getHeight()
  },
  methods: {
    getHeight() {
      this.conheight.height = window.innerHeight + 'px';
    },
    chooseType(item) { //根据type跳转
      let routeData = this.$router.resolve({
        path: '/',
        query: {typeId: item.id, typeName: item.name, count: item.count}
      });
      window.open(routeData.href, '_blank');
    },
    getType(){
      getType()
        .then(res=>{
          console.log(res)
          this.typeList = res.typeList;
        })
    },
  }
}
</script>

<style scoped>
@import "../assets/css/TypePage.css";
</style>
