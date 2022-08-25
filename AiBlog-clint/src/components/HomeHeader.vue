<template>
  <div class="homeImg animate__fadeIn animate__animated" :style="conheight">
    <vue-particles
      color="#fff"
      :particleOpacity="0.7"
      :particlesNumber="100"
      shapeType="triangle"
      :particleSize="4"
      linesColor="#fff"
      :linesWidth="0"
      :lineLinked="false"
      :lineOpacity="0.4"
      :linesDistance="150"
      :moveSpeed="2"
      :hoverEffect="true"
      hoverMode="grab"
      :clickEffect="true"
      clickMode="push"
    >
    </vue-particles>
    <div class="title1" @click="toHome">AiBlog</div>
    <div class="title2">在这里分享生活、总结技术</div>
    <swipe-down class="down"></swipe-down>
  </div>
</template>

<script>
import SwipeDown from "./SwipeDown";
import TheAisdeBar from "./TheAisdeBar";

export default {
  name: "HomeHeader",
  data() {
    return {
      conheight: {
        height: ''
      }
    }
  },
  components:{
    SwipeDown,
    TheAisdeBar,
  },
  created() {
    window.addEventListener('resize', this.getHeight);
    this.getHeight()
  },
  methods: {
    getHeight() {
      this.conheight.height = window.innerHeight + 'px';
    },
    toHome() {
      let routeData = this.$router.resolve({path: '/'});
      window.open(routeData.href, '_blank');
    },
  }
}
</script>

<style scoped>
@import "../assets/css/HomeHeader.css";
</style>
