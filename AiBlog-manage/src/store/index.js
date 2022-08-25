import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

// 如果当前环境是开发环境，就开启debug模式
const debug = process.env.NODE_ENV !== 'production'

const files = require.context('./modules', false, /\.js$/)
const modules = {}

// 使用下面这种具体的写法，构造modules对象
// 为啥这么写？我也不知道，因为大神们都这么写
files.keys().forEach(key => {
  modules[key.replace(/(\.\/|\.js)/g, '')] = files(key).default
})

export default new Vuex.Store({
  strict: debug,
  modules,
})
