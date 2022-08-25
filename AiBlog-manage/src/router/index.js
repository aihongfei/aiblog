import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

import signin from "../views/signin";
import home from "../views/home";
import blogs from "../views/blogs";
import types from "../views/types"
import tags from "../views/tags"
import notfound from "../views/404";
import addBlog from "../views/addBlog";
import info from "../views/info";
import cube from "../views/cube";
import blank from "../views/blank";
import {getCookie} from "../util/util";

const router = new Router({
  routes: [
    // 首先是登录页的路由
    {
      path: "/",
      name: "Signin",
      meta: {
        title: "Aiblog"
      },
      component: signin
    },
    {
      path: "/login",
      name: "Signin",
      meta: {
        title: "Aiblog"
      },
      component: signin
    },
    {
      path: "/blogs",
      component: home,
      children: [
        {
          path: "/blogs",
          component: blogs
        },
        {
          path: "/types",
          component: types
        },
        {
          path: "/tags",
          component: tags
        },
        {
          path: "/add",
          component: addBlog
        },
        {
          path: "/info",
          component: info
        },
        {
          path: "/cube",
          component: cube
        },
        {
          path: "/blank",
          component: blank
        },
        {
          path: "/*",
          component: notfound
        }
      ]
    },

  ]
});
router.beforeEach((to, from, next) => {
  let cookie = getCookie();
  if (to.path === '/') {
    for (let i = 0; i < cookie.length; i++) {
      if (cookie[i].key == "token"){
        next('/info')
        break;
      }
    }
    next();
  } else {
    let flag = false;
    for (let i = 0; i < cookie.length; i++) {
      if (cookie[i].key == "token"){
        next();
        flag = true;
        break;
      }
    }
    if (!flag) {
      next({
        path: '/', // 将跳转的路由path作为参数，登录成功后跳转到该路由
        query: {redirect: to.fullPath}
      })
    }
  }
});

export default router;
