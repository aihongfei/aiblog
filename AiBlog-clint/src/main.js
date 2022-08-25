import Vue from 'vue'
import App from './App'
import router from './router'

Vue.config.productionTip = false
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import less from 'less'
Vue.use(less)
Vue.use(ElementUI);
import {components} from './components/load';
Vue.use(components.YsLoad5)
const https = require('https')
const fs = require('fs')

new Vue({
  el: '#app',
  router,
  render: h => h(App)
});
