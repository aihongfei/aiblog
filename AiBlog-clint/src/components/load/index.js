
import YsLoad5 from './YSLoadCan5'
const components = {
  YsLoad5,
}
// 全局导入
function install (Vue) {
  Object.keys(components).forEach(name => {
    Vue.component(name, components[name])
  })
}
// 按需导入
Object.keys(components).forEach(component => {
  components[component].install = function (Vue) {
    // 普通
    Vue.component(component, components[component])
    // 函数式调用
    // 创建构造器
    const AlertContrystor = Vue.extend(components[component])
    // new的方式 根据组件构造器，可以创建组件对象
    const load = new AlertContrystor()
    // 手动挂载某一个元素上
    load.$mount(document.createElement('div'))
    // toast.$el对应的就是div
    document.body.appendChild(load.$el)
    // 这里应该用load而不是components[component]
    Vue.prototype['$' + `${component}`] = load
  }
})
export { install, components }
