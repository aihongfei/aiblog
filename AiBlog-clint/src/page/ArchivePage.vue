<template>
  <div>
    <home-header></home-header>
    <div class="bg"></div>
    <div class="archive">
      <h2 class="archiveTitle">AiBlog - 归档</h2>
      <br>
      <el-row type="flex" justify="center">
        <el-col :xs="22" :sm="18" :md="15" :lg="14" :xl="14">
          <div class="block">
            <el-timeline>
              <el-timeline-item v-for="(item,index) in blogList" :timestamp="item.createTime" placement="top"
                                :key="index">
                <el-card>
                  <ul>
                    <li v-for="(item,index) in item.subList" class="title" :key="index" @click="toRead(item.id)">
                      <span>{{ item.title }}</span>
                    </li>
                  </ul>
                </el-card>
              </el-timeline-item>
            </el-timeline>
          </div>
        </el-col>
      </el-row>
    </div>
    <home-footer></home-footer>
  </div>
</template>

<script>
import HomeHeader from "../components/HomeHeader";
import HomeFooter from "../components/HomeFooter";
import {getBlogList} from "../api";

export default {
  name: "ArchivePage",
  data() {
    return {
      blogList: [],
    }
  },
  components: {
    HomeHeader,
    HomeFooter
  },
  created() {
    this.getBlog();
  },
  methods: {
    getBlog: function () {
      getBlogList({pageSize: 10000})
        .then(res => {
          this.blogList = this.dataResort(res.blogList);
        })
    },
    dataResort(arr) {
      let newArr = [];
      arr.map((item, i) => {
        let index = -1;
        let isExists = newArr.some((newItem, j) => {
          if (item.createTime.substr(0, 10) == newItem.createTime) {
            index = j;
            return true;
          }
        })
        if (!isExists) {
          newArr.push({
            createTime: item.createTime.substr(0, 10),
            subList: [item]
          })
        } else {
          newArr[index].subList.push(item);
        }
      });
      return newArr;
    },
    toRead(id) {
      let routeData = this.$router.resolve({path: '/blog', query: {id: id}});
      window.open(routeData.href, '_blank');
    }
  }
}
</script>

<style scoped>
@import "../assets/css/ArchivePage.css";
</style>
