<template>
  <div>
    <div class="songAudio ">
      <div @click="audioType=!audioType,show = false" class="tip animate__animated animate__shakeX">
        <svg v-if="audioType" t="1633489452830" class="icon" viewBox="0 0 1024 1024" version="1.1"
             xmlns="http://www.w3.org/2000/svg"
             p-id="2194" width="20" height="50">
          <path
            d="M803.606993 579.886453c18.237435-18.173444 28.348014-42.234061 28.348013-67.830461 0-25.788374-10.110578-49.912981-28.348013-67.958443L366.356481 18.749363c-25.276445-24.95649-66.102704-24.95649-91.37915 0s-25.276445 65.526785 0 90.419285l414.405725 402.823353-414.405725 402.759362a63.543064 63.543064 0 0 0 0 90.547267c25.276445 24.95649 66.102704 24.95649 91.37915-0.127982l437.250512-425.284195z"
            p-id="2195" fill="#8a8a8a"></path>
        </svg>
        <svg v-if="!audioType" t="1633490050681" class="icon" viewBox="0 0 1024 1024" version="1.1"
             xmlns="http://www.w3.org/2000/svg"
             p-id="2446" width="20" height="50">
          <path
            d="M220.415784 579.84116a95.339145 95.339145 0 0 1 0-135.778299L657.632143 18.747899c25.274471-24.954541 66.097541-24.954541 91.372012 0s25.274471 65.521667 0 90.412222L334.6308 512.015997l414.373355 402.727903a63.538101 63.538101 0 0 1 0 90.540194c-25.274471 24.954541-66.097541 24.954541-91.372012-0.127972L220.415784 579.905146z"
            p-id="2447" fill="#8a8a8a"></path>
        </svg>
      </div>
      <div :hidden="show" class="animate__animated"
           :class="{'animate__rotateInDownLeft':audioType,'animate__rotateOutDownLeft':!audioType}">

        <aplayer class="audio" :music="audio[0]" :list="audio" theme='#000000' :showlrc="true"
                 listFolded="false" volume="1"></aplayer>
      </div>
    </div>
  </div>
</template>

<script>
import aplayer from "vue-aplayer";
import {bgm} from "../assets/data/song";

export default {
  name: "SongAudio",
  components: {
    aplayer
  },
  data() {
    return {
      show: true,
      audioType: false,
      // 音频列表
      audio: [],
    }
  },
  created() {
    this.audio = bgm;
  }
}
</script>

<style scoped>
@import "../assets/css/SongAudio.css";
</style>
