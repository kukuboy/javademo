webpackJsonp([15],{Jp9y:function(n,e){},sFAB:function(n,e,t){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var c=t("1gj8"),r=t("sEZ5"),o={name:"Attended",components:{myServiceP:c.a},data:function(){return{concern_data:[{name:"服务人员",online:!0,id:"112",reputably:"112",concerned:!0},{name:"服务人员",online:!0,id:"112",reputably:"112",concerned:!0}]}},mounted:function(){this.query()},query:function(){this.getSubscribeAdvisor()},getSubscribeAdvisor:function(){this.$http.getSubscribeAdvisor({}).then({})},methods:{cancelConcern:function(n){this.concern_data[n].concerned?this.concern_data[n].concerned=!1:this.concern_data[n].concerned=!0,this.query()},query:function(){this.concern_data=r.a.sortObject(this.concern_data,"reputably")}}},a={render:function(){var n=this,e=n.$createElement,t=n._self._c||e;return t("div",{attrs:{id:"Attended"}},n._l(n.concern_data,function(e,c){return t("my-service-p",{key:c,attrs:{data:e},on:{clickC:function(e){return n.cancelConcern(c)}}})}),1)},staticRenderFns:[]};var i=t("VU/8")(o,a,!1,function(n){t("Jp9y")},"data-v-19c6f7d6",null);e.default=i.exports}});
//# sourceMappingURL=15.ba1e083887a170412b3a.js.map