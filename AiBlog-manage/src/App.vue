<template>
  <div id="app">
    <router-view/>
  </div>
</template>
<script>
import {logout} from "./api";

export default {
  name: "app",
  created() {
    window.addEventListener('beforeunload', e =>this.test(e));
  },
  destroyed() {
    window.removeEventListener('beforeunload', e => this.test(e))
  },
  methods: {
    test(e) {
      alert(111)

    }
  },

};
</script>
<style lang="scss">
@import "./assets/scss/global.scss";
</style>
