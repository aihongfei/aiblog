<template>
  <div>
    <home-header></home-header>
    <home-content></home-content>
    <home-footer></home-footer>
  </div>
</template>

<script>
import Vue from 'vue'
import VueParticles from 'vue-particles'
import HomeHeader from "../components/HomeHeader";
import HomeContent from "../components/HomeContent";
import HomeFooter from "../components/HomeFooter";

Vue.use(VueParticles)
export default {
  name: "HomePage",
  components: {
    HomeContent,
    HomeFooter,
    HomeHeader,
  }
}
</script>

<style scoped>
</style>
