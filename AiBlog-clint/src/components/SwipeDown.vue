<template>
  <div >
  <div class="animate__animated" :class="{'animate__shakeY':down}"  @click="scrollToContent" @mouseover="changeDown1" @mouseout="changeDown2">
    <svg t="1633361448895" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
         p-id="1375" width="40" height="40">
      <path
        d="M966.4 323.2c-9.6-9.6-25.6-9.6-35.2 0l-416 416-425.6-416c-9.6-9.6-25.6-9.6-35.2 0-9.6 9.6-9.6 25.6 0 35.2l441.6 432c9.6 9.6 25.6 9.6 35.2 0l435.2-432C976 345.6 976 332.8 966.4 323.2z"
        p-id="1376" fill="#dbdbdb"></path>
    </svg>
  </div>
  </div>
</template>

<script>

export default {
  name: "swipedown",
  data(){
    return{
      down: false
    }
  },
  methods:{
    changeDown1(){
      this.down = true;
    },
    changeDown2(){
      this.down = false;
    },
    scrollToContent(){
      window.scrollTo({
        top: window.innerHeight ,
        behavior: "smooth"
      });
    }
  }
}
</script>

<style scoped>
</style>
