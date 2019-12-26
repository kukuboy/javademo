/*
* 配置文件
 */
// 获取项目当前地址
var http = window.location.protocol + '//' + location.hostname + ':' + location.port
window.envConf = {}
window.envConf.nowEnv = 'DEV' // 当前环境
window.envConf.baseUrl = http + '/advisor-h5/tougu' // 项目基础地址
window.envConf.wsAddress = 'ws://cbas.ths8.com:81/live' // websocket地址
// window.envConf.wsAddress = 'ws://10.10.38.190:8088/live' // websocket地址
// window.envConf.wsAddress = 'ws://10.10.38.49:11610/live' // websocket地址
window.envConf.aliyun = 'https://ths-tgzb-test1.oss-cn-hzfinance.aliyuncs.com' // 阿里云访问地址

// 开发时候使用
//if (location.hostname === 'localhost') { // 开发环境
//window.envConf.nowEnv = 'DEV'
//}
//if (window.location.href.indexOf('http://point.stocke.com.cn') !== -1) { // 测试环境
//window.envConf.nowEnv = 'TEST'
//}
// 项目基础地址配置
//if (window.envConf.nowEnv === 'DEV') {
//window.envConf.baseUrl = ''
//} else {
//window.envConf.baseUrl = http + '/advisor-h5/tougu'
//}
//// websocket链接地址
//if (window.envConf.nowEnv === 'DEV' || window.envConf.nowEnv === 'TEST') {
//window.envConf.wsAddress = 'ws://115.236.66.21:11600/live'
//} else {
//window.envConf.wsAddress = 'wss:/fzmall.stocke.com.cn/live'
//}
