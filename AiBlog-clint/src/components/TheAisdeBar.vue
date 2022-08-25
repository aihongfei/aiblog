<template>
  <div>
    <div class="animate__animated" :class="{'animate__fadeIn':sideBtn}" @click="openSide" @mouseover="onSideBtn"
         @mouseout="outSideBtn">
      <svg t="1633399529550" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
           p-id="2233" width="40" height="30">
        <path
          d="M902.779659 795.440467c-6.179746-6.181793-14.304797-9.577123-22.950711-9.577123L129.341299 785.863345c-17.945721 0-32.540114 14.59644-32.540114 32.525788 0 17.962094 14.594393 32.555463 32.540114 32.555463l750.487649 0c17.931395 0 32.525788-14.594393 32.525788-32.555463C912.354735 809.745265 908.959406 801.61919 902.779659 795.440467"
          p-id="2234" fill="#e6e6e6"></path>
        <path
          d="M879.828948 461.055724 129.341299 461.055724c-17.945721 0-32.525788 14.594393-32.525788 32.541137 0 17.930371 14.580067 32.525788 32.525788 32.525788l750.487649 0c17.931395 0 32.525788-14.594393 32.525788-32.525788 0-8.647961-3.39533-16.800641-9.575076-22.980387C896.599913 464.436728 888.474862 461.055724 879.828948 461.055724"
          p-id="2235" fill="#e6e6e6"></path>
        <path
          d="M902.779659 154.426115c-6.179746-6.179746-14.304797-9.574053-22.950711-9.574053L129.341299 144.852062c-17.945721 0-32.540114 14.594393-32.540114 32.540114 0 17.946744 14.594393 32.525788 32.540114 32.525788l750.487649 0c17.931395 0 32.525788-14.579043 32.525788-32.525788C912.354735 168.745239 908.959406 160.606885 902.779659 154.426115"
          p-id="2236" fill="#e6e6e6"></path>
      </svg>
    </div>
    <el-drawer class="div"
               :modal="false"
               :wrapperClosable="true"
               :visible.sync="drawer"
               :with-header="false"
               :modal-append-to-body="false">
      <div class="content">
        <ul class="point">
          <li><span @click="toHome">首页</span></li>
          <li><span @click="toType">分类</span></li>
          <li><span @click="toTag">标签</span></li>
          <li><span @click="search">Search</span></li>
          <li><span @click="archive">归档</span></li>
          <li><span>关于</span></li>
          <li><span>友链</span></li>
        </ul>
      </div>
      <div class="logo">MAs.Ai</div>
    </el-drawer>
  </div>
</template>

<script>
export default {
  name: "TheAisdeBar",
  data() {
    return {
      sideBtn: false,
      drawer: false,
    }
  },
  methods: {
    onSideBtn() {
      this.sideBtn = true;
    },
    outSideBtn() {
      this.sideBtn = false;
    },
    openSide() {
      this.drawer = true;
    },
    search() {
      let routeData = this.$router.resolve({path: '/search'});
      window.open(routeData.href, '_blank');
    },
    toHome() {
      let routeData = this.$router.resolve({path: '/'});
      window.open(routeData.href, '_blank');
    },
    toType() {
      let routeData = this.$router.resolve({path: '/type'});
      window.open(routeData.href, '_blank');
    },
    toTag() {
      let routeData = this.$router.resolve({path: '/tag'});
      window.open(routeData.href, '_blank');
    },
    archive(){
      let routeData = this.$router.resolve({path: '/archive'});
      window.open(routeData.href, '_blank');
    }
  }
}
</script>

<style scoped>
@import "../assets/css/TheAsideBar.css";
</style>
