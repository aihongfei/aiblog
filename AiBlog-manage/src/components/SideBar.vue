<!-- 左侧导航组件 -->
<!-- 使用说明：<side-bar></side-bar> -->
<template>
  <div id="sidebar-wrap" :class="{ collapsed: toggSiderBar }">
    <!-- 顶部图标 -->
    <h3 class="logo">
      <span class="rythm twist1">{{toggSiderBar ? 'AiBlog': 'AiBlog后台管理'}}</span>
    </h3>

    <!-- 循环生成侧栏菜单 -->
    <el-menu background-color="#3f4d67" text-color="#fff" :default-active="$route.path" :unique-opened="true" :router="true" mode="vertical" :collapse="toggSiderBar">
      <template v-for="item in menu">

        <!-- 多级菜单外壳 -->
        <el-submenu v-if="item.children.length !== 0" :index="item.router" :key="item.router">

          <!-- 一级菜单包裹层 -->
          <template slot="title">
            <i :class="item.icon"></i>
            <span slot="title">{{ item.name}}</span>
          </template>

<!--           二级菜单选项-->
          <el-menu-item v-for="child in item.children" :index="child.router" :key="child.router">
            <i class="fa fa-long-arrow-right"></i>
            <span slot="title">{{child.name}}</span>
          </el-menu-item>
        </el-submenu>

        <!-- 单级菜单 -->
        <el-menu-item v-else :index="item.router" :key="item.router">
          <i :class="item.icon"></i>
          <span slot="title">{{item.name}}</span>
        </el-menu-item>
      </template>
    </el-menu>

    <!-- 侧栏菜单下方图标 -->
    <div class="animated bounceInDown imgWrap">
      <img src="../../static/img/player.gif" height="60px" class="gif rythm pulse3" @click="toggleDance">
    </div>
  </div>
</template>
<script>
import Rythm from "rythm.js";
const rythm = new Rythm();
const music = require("../../static/audio/romeostune.mp3");

export default {
  name: "sidebar",
  data() {
    return {
      isMusicOn: false,
      menu: [
        {
          name: "主页",
          router: "/info",
          icon: "el-icon-s-home",
          children: []
        },
        {
          name: "博客管理",
          router: "/",
          icon: "el-icon-s-operation",
          children: [
            {
              name: "博客管理",
              router: "/blogs",
              children: []
            },
            {
              name: "分类管理",
              router: "/types",
              children: []
            },
            {
              name: "标签管理",
              router: "/tags",
              children: []
            },
          ]
        },
        {
          name: "魔幻立方",
          router: "/cube",
          icon: "el-icon-menu",
          children: []
        },
        {
          name: "空白页面",
          router: "/blank",
          icon: "el-icon-setting",
          children: []
        }
      ]
    };
  },
  computed: {
    toggSiderBar() {
      return this.$store.state.common.isCollapse;
    }
  },
  created() {
    this.initRythm();
    this.$bus.$on("stopMusic", () => {
      this.isMusicOn = false;
      rythm.stop();
    });
  },
  methods: {
    initRythm() {
      rythm.setMusic(music);
      rythm.addRythm("twist1", "twist", 0, 10);
      rythm.addRythm("pulse3", "pulse", 0, 10, {
        min: 0.75,
        max: 1.5
      });
    },
    toggleDance() {
      if (this.isMusicOn) {
        this.isMusicOn = false;
        rythm.stop();
      } else {
        this.isMusicOn = true;
        rythm.start();
      }
    }
  }
};
</script>
<style scoped lang="scss">
#sidebar-wrap {
  width: 180px;
  height: 100%;
  position: fixed;
  left: 0;
  top: 0;
  bottom: 0;
  z-index: 5;
  transition: all 0.3s;
  background: #3f4d67;
  box-shadow: 0px 0px 15px rgba(0,0,0,0.6);
  &.collapsed {
    width: 64px;
    transition: all 0.3s;
  }

  /* 图标动画 */
  .imgWrap {
    text-align: center;
    position: absolute;
    bottom: 30px;
    width: 100%;
    .gif {
      width: 60px;
      height: 60px;
      border-radius: 30px;
      &:hover {
        cursor: pointer;
      }
    }
  }
  .logo {
    color: #fff;
    text-align: center;
    padding: 18px 0;
    margin: 0;
    height: 60px;
    box-sizing: border-box;
  }
}

.el-menu {
  height: 100%;
  // box-shadow: 0px 15px 15px rgba(0,0,0,0.6);
}

// 美化左侧导航的留白
.el-submenu .el-menu-item {
  padding: 0 20px;
  min-width: 160px;
  padding-left: 26px !important;
  i {
    padding-right: 10px;
  }
}

// 改变元素属性，要不动画效果不管用，是不是很厉害啊？哈哈哈
.rythm.twist1 {
  display: block;
}
</style>
