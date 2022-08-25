import Vue from 'vue'
import Router from 'vue-router'
import HomePage from "../page/HomePage";
import BlogContent from "../page/BlogContent";
import SearchPage from "../page/SearchPage";
import TypePage from "../page/TypePage";
import TagPage from "../page/TagPage";
import load from "../components/load/loading";
import ArchivePage from "../page/ArchivePage";
import notfound from "../page/404"
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HomePage',
      component: HomePage
    },
    {
      path: '/blog',
      name: 'BlogContent',
      component: BlogContent
    },
    {
      path: '/search',
      name: 'SearchPage',
      component: SearchPage
    },
    {
      path: '/type',
      name: 'TypePage',
      component: TypePage
    },
    {
      path: '/tag',
      name: 'TagPage',
      component: TagPage
    },
    {
      path: '/archive',
      name: 'ArchivePage',
      component: ArchivePage
    },
    {
      path: '/load',
      name: 'load',
      component: load
    },
    {
      path: '/*',
      name: 'notfound',
      component: notfound
    },
  ]
})
