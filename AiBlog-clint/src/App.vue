<template>
  <div id="app">
    <router-view/>
    <the-aisde-bar class="sideBar"></the-aisde-bar>
    <song-audio class="audio"></song-audio>
    <scroll-top></scroll-top>
  </div>
</template>

<script>
import "animate.css";
import TheAisdeBar from "./components/TheAisdeBar";
import SongAudio from "./components/SongAudio";
import ScrollTop from "./components/ScrollTop";

export default {
  name: 'App',
  components: {
    TheAisdeBar,
    SongAudio,
    ScrollTop
  },
  beforeCreate() {
    document.querySelector('body').setAttribute('style', 'padding:0;margin:0;height:100%');
    document.querySelector('html').setAttribute('style', 'height:100%')
  },
  mounted() {

  }
}
</script>

<style>
.sideBar {
  position: fixed;
  right: 5%;
  top: 5%;
  background: rgba(0, 0, 0, .6);
  padding-top: 5px;
  display: flex;
  align-items: center;
  justify-content: center;
}

#app {
  height: 100%;
}

.audio {
  position: fixed;
  bottom: 50px;
  left: 5px;
}


</style>
