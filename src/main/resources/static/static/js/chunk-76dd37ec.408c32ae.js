(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-76dd37ec"],{"4d9b":function(e,t,a){"use strict";a.r(t);var l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("el-button",{attrs:{type:"primary",size:"medium"},on:{click:function(t){e.addDialogFormVisible=!0}}},[e._v("新增记录")]),a("el-input",{staticClass:"input-with-select",staticStyle:{width:"40%"},attrs:{placeholder:"请输入内容"},model:{value:e.stext,callback:function(t){e.stext=t},expression:"stext"}},[a("el-select",{attrs:{slot:"prepend",placeholder:"请选择"},on:{change:e.getKey},slot:"prepend",model:{value:e.cname,callback:function(t){e.cname=t},expression:"cname"}},[a("el-option",{attrs:{label:"姓名",value:"name"}}),a("el-option",{attrs:{label:"就诊医院",value:"place"}}),a("el-option",{attrs:{label:"所属部门",value:"depart"}}),a("el-option",{attrs:{label:"就诊日期",value:"idate"}})],1),a("el-button",{attrs:{slot:"append",icon:"el-icon-search"},on:{click:function(t){return e.search()}},slot:"append"})],1),a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData,border:""}},[a("el-table-column",{attrs:{fixed:"",prop:"id",label:"编号",width:"50"}}),a("el-table-column",{attrs:{fixed:"",prop:"name",label:"姓名",width:"100"}}),a("el-table-column",{attrs:{prop:"sex",label:"性别",width:"50"}}),a("el-table-column",{attrs:{prop:"idcard",label:"身份证号码",width:"170"}}),a("el-table-column",{attrs:{prop:"status",label:"状态",width:"70"}}),a("el-table-column",{attrs:{prop:"idate",label:"就诊日期",width:"120"}}),a("el-table-column",{attrs:{prop:"place",label:"就诊医院",width:"200"}}),a("el-table-column",{attrs:{prop:"depart",label:"所属部门",width:"120"}}),a("el-table-column",{attrs:{prop:"phonenum",label:"手机号码",width:"120"}}),a("el-table-column",{attrs:{prop:"register",label:"登记时间",width:"170"}}),a("el-table-column",{attrs:{width:"120",label:"操作",fixed:"right"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{staticClass:"修改",attrs:{type:"primary",size:"small",icon:"el-icon-edit"},on:{click:function(a){e.dialogFormVisible=!0,e.edit(t.row)}}}),a("el-button",{staticClass:"删除",attrs:{type:"primary",size:"small",icon:"el-icon-delete"},on:{click:function(a){return e.deleteRecord(t.row)}}})]}}])})],1),a("div",{staticClass:"block"},[a("el-pagination",{attrs:{background:"","page-size":10,layout:"total, sizes, prev, pager, next, jumper",total:e.total},on:{"current-change":e.handleCurrentChange,"size-change":e.handleSizeChange}}),a("el-dialog",{attrs:{slot:"",title:"修改确诊/疑似病例记录",visible:e.dialogFormVisible},on:{"update:visible":function(t){e.dialogFormVisible=t}},slot:"default"},[a("el-form",{ref:"EmpIden",attrs:{model:e.EmpIden}},[a("el-form-item",{attrs:{label:"姓名","label-width":e.formLabelWidth}},[a("el-input",{attrs:{autocomplete:"off"},model:{value:e.EmpIden.name,callback:function(t){e.$set(e.EmpIden,"name",t)},expression:"EmpIden.name"}})],1),a("el-form-item",{attrs:{label:"性别","label-width":e.formLabelWidth}},[a("el-radio",{attrs:{label:"男"},model:{value:e.EmpIden.sex,callback:function(t){e.$set(e.EmpIden,"sex",t)},expression:"EmpIden.sex"}},[e._v("男")]),a("el-radio",{attrs:{label:"女"},model:{value:e.EmpIden.sex,callback:function(t){e.$set(e.EmpIden,"sex",t)},expression:"EmpIden.sex"}},[e._v("女")])],1),a("el-form-item",{attrs:{label:"身份证号","label-width":e.formLabelWidth}},[a("el-input",{attrs:{autocomplete:"off"},model:{value:e.EmpIden.idcard,callback:function(t){e.$set(e.EmpIden,"idcard",t)},expression:"EmpIden.idcard"}})],1),a("el-form-item",{attrs:{label:"状态","label-width":e.formLabelWidth}},[a("el-radio",{attrs:{label:"确诊"},model:{value:e.EmpIden.status,callback:function(t){e.$set(e.EmpIden,"status",t)},expression:"EmpIden.status"}},[e._v("确诊")]),a("el-radio",{attrs:{label:"疑似"},model:{value:e.EmpIden.status,callback:function(t){e.$set(e.EmpIden,"status",t)},expression:"EmpIden.status"}},[e._v("疑似")]),a("el-radio",{attrs:{label:"治愈"},model:{value:e.EmpIden.status,callback:function(t){e.$set(e.EmpIden,"status",t)},expression:"EmpIden.status"}},[e._v("治愈")]),a("el-radio",{attrs:{label:"死亡"},model:{value:e.EmpIden.status,callback:function(t){e.$set(e.EmpIden,"status",t)},expression:"EmpIden.status"}},[e._v("死亡")])],1),a("el-form-item",{attrs:{label:"就诊日期","label-width":e.formLabelWidth}},[a("el-date-picker",{attrs:{align:"right",type:"date",placeholder:"选择日期","picker-options":e.pickerOptions,"value-format":"yyyy-MM-dd"},model:{value:e.EmpIden.idate,callback:function(t){e.$set(e.EmpIden,"idate",t)},expression:"EmpIden.idate"}})],1),a("el-form-item",{attrs:{label:"就诊医院","label-width":e.formLabelWidth}},[a("el-input",{attrs:{autocomplete:"off"},model:{value:e.EmpIden.place,callback:function(t){e.$set(e.EmpIden,"place",t)},expression:"EmpIden.place"}})],1),a("el-form-item",{attrs:{label:"所属部门","label-width":e.formLabelWidth}},[a("el-select",{attrs:{clearable:"",placeholder:"请选择"},model:{value:e.EmpIden.depart,callback:function(t){e.$set(e.EmpIden,"depart",t)},expression:"EmpIden.depart"}},e._l(e.options2,(function(e,t){return a("el-option",{key:t,attrs:{label:e,value:e}})})),1)],1),a("el-form-item",{attrs:{label:"手机号码","label-width":e.formLabelWidth}},[a("el-input",{attrs:{autocomplete:"off"},model:{value:e.EmpIden.phonenum,callback:function(t){e.$set(e.EmpIden,"phonenum",t)},expression:"EmpIden.phonenum"}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.dialogFormVisible=!1,e.update()}}},[e._v("确 定")])],1)],1),a("el-dialog",{attrs:{slot:"",title:"新增确诊/疑似病例记录",visible:e.addDialogFormVisible},on:{"update:visible":function(t){e.addDialogFormVisible=t}},slot:"default"},[a("el-form",{attrs:{model:e.addEmpIden}},[a("el-form-item",{attrs:{label:"姓名","label-width":e.formLabelWidth}},[a("el-input",{attrs:{autocomplete:"off"},model:{value:e.addEmpIden.name,callback:function(t){e.$set(e.addEmpIden,"name",t)},expression:"addEmpIden.name"}})],1),a("el-form-item",{attrs:{label:"性别","label-width":e.formLabelWidth}},[a("el-radio",{attrs:{label:"男"},model:{value:e.addEmpIden.sex,callback:function(t){e.$set(e.addEmpIden,"sex",t)},expression:"addEmpIden.sex"}},[e._v("男")]),a("el-radio",{attrs:{label:"女"},model:{value:e.addEmpIden.sex,callback:function(t){e.$set(e.addEmpIden,"sex",t)},expression:"addEmpIden.sex"}},[e._v("女")])],1),a("el-form-item",{attrs:{label:"身份证号","label-width":e.formLabelWidth}},[a("el-input",{attrs:{autocomplete:"off"},model:{value:e.addEmpIden.idcard,callback:function(t){e.$set(e.addEmpIden,"idcard",t)},expression:"addEmpIden.idcard"}})],1),a("el-form-item",{attrs:{label:"状态","label-width":e.formLabelWidth}},[a("el-radio",{attrs:{label:"确诊"},model:{value:e.addEmpIden.status,callback:function(t){e.$set(e.addEmpIden,"status",t)},expression:"addEmpIden.status"}},[e._v("确诊")]),a("el-radio",{attrs:{label:"疑似"},model:{value:e.addEmpIden.status,callback:function(t){e.$set(e.addEmpIden,"status",t)},expression:"addEmpIden.status"}},[e._v("疑似")]),a("el-radio",{attrs:{label:"治愈"},model:{value:e.addEmpIden.status,callback:function(t){e.$set(e.addEmpIden,"status",t)},expression:"addEmpIden.status"}},[e._v("治愈")]),a("el-radio",{attrs:{label:"死亡"},model:{value:e.addEmpIden.status,callback:function(t){e.$set(e.addEmpIden,"status",t)},expression:"addEmpIden.status"}},[e._v("死亡")])],1),a("el-form-item",{attrs:{label:"就诊日期","label-width":e.formLabelWidth}},[a("el-date-picker",{attrs:{align:"right",type:"date",placeholder:"选择日期","picker-options":e.pickerOptions},model:{value:e.addEmpIden.idate,callback:function(t){e.$set(e.addEmpIden,"idate",t)},expression:"addEmpIden.idate"}})],1),a("el-form-item",{attrs:{label:"就诊医院","label-width":e.formLabelWidth}},[a("el-input",{attrs:{autocomplete:"off"},model:{value:e.addEmpIden.place,callback:function(t){e.$set(e.addEmpIden,"place",t)},expression:"addEmpIden.place"}})],1),a("el-form-item",{attrs:{label:"所属部门","label-width":e.formLabelWidth}},[a("el-select",{attrs:{clearable:"",placeholder:"请选择"},model:{value:e.addEmpIden.depart,callback:function(t){e.$set(e.addEmpIden,"depart",t)},expression:"addEmpIden.depart"}},e._l(e.options2,(function(e,t){return a("el-option",{key:t,attrs:{label:e,value:e}})})),1)],1),a("el-form-item",{attrs:{label:"手机号码","label-width":e.formLabelWidth}},[a("el-input",{attrs:{autocomplete:"off"},model:{value:e.addEmpIden.phonenum,callback:function(t){e.$set(e.addEmpIden,"phonenum",t)},expression:"addEmpIden.phonenum"}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.addDialogFormVisible=!1}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.addDialogFormVisible=!1,e.submitForm()}}},[e._v("确 定")])],1)],1)],1)],1)},n=[],o=a("ade3"),i=(a("b0c0"),a("4de4"),{data:function(){var e;return e={options2:[{value:"",label:""}],value:"",cname:"",stext:"",pickerOptions:{disabledDate:function(e){return e.getTime()>Date.now()},shortcuts:[{text:"今天",onClick:function(e){e.$emit("pick",new Date)}},{text:"昨天",onClick:function(e){var t=new Date;t.setTime(t.getTime()-864e5),e.$emit("pick",t)}},{text:"一周前",onClick:function(e){var t=new Date;t.setTime(t.getTime()-6048e5),e.$emit("pick",t)}}]},options:[]},Object(o["a"])(e,"value",[]),Object(o["a"])(e,"list",[]),Object(o["a"])(e,"loading",!1),Object(o["a"])(e,"tableData",null),Object(o["a"])(e,"total",null),Object(o["a"])(e,"dialogTableVisible",!1),Object(o["a"])(e,"dialogFormVisible",!1),Object(o["a"])(e,"addDialogFormVisible",!1),Object(o["a"])(e,"formLabelWidth","120px"),Object(o["a"])(e,"addLabelWidth","50px"),Object(o["a"])(e,"currentpage",1),Object(o["a"])(e,"pagesize",10),Object(o["a"])(e,"EmpIden",{id:"",name:"",sex:"",idcard:"",idate:"",place:"",depart:"",phonenum:"",status:"",register:""}),Object(o["a"])(e,"addEmpIden",{id:"",name:"",sex:"",idcard:"",idate:"",place:"",depart:"",phonenum:"",status:"",register:""}),e},methods:{reload:function(){var e=this;axios.get("http://localhost:8080/empiden/findAll/"+this.currentpage+"/"+this.pagesize).then((function(t){e.tableData=t.data.data.records,e.total=t.data.data.total}))},search:function(){var e=this;this.stext?axios.get("http://localhost:8080/empiden/search/"+this.searchKey+"/"+this.stext).then((function(t){e.tableData=t.data.data,e.total=t.data.data.total})):axios.get("http://localhost:8080/empiden/findAll/"+this.currentpage+"/"+this.pagesize).then((function(t){e.tableData=t.data.data.records,e.total=t.data.data.total,e.cname=""}))},getKey:function(e){this.searchKey=e},submitForm:function(){var e=this;axios.post("http://localhost:8080/empiden/save",this.addEmpIden).then((function(t){"success"==t.data&&e.$alert("确诊/疑似病例添加成功！","消息",{confirmButtonText:"确定",callback:function(t){e.reload()}})}))},deleteRecord:function(e){var t=this;this.$confirm("是否确定要删除"+e.name+"的病例记录?","删除数据",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){axios.delete("http://localhost:8080/empiden/deleteById/"+e.id).then((function(a){t.$alert(e.name+"的病例记录删除成功！","消息",{confirmButtonText:"确定",callback:function(e){t.reload()}})}))}))},update:function(){var e=this;axios.put("http://localhost:8080/empiden/update",this.EmpIden).then((function(t){console.log(t),"success"==t.data&&e.$alert(e.EmpIden.name+"的病例记录修改成功！","消息",{confirmButtonText:"确定",callback:function(t){e.reload()}})}))},edit:function(e){var t=this;axios.get("http://localhost:8080/empiden/findById/"+e.id).then((function(e){console.log(e.data),t.EmpIden=e.data.data}))},handleCurrentChange:function(e){var t=this;this.currentpage=e,axios.get("http://localhost:8080/empiden/findAll/"+this.currentpage+"/"+this.pagesize).then((function(e){console.log(e.data),t.tableData=e.data.data.records,t.total=e.data.data.total}))},handleSizeChange:function(e){var t=this;this.pageSize=e,axios.get("http://localhost:8080/empiden/findAll/"+this.currentpage+"/"+this.pagesize).then((function(e){t.tableData=e.data.data.records,t.total=e.data.data.total}))},remoteMethod:function(e){var t=this;""!==e?(this.loading=!0,setTimeout((function(){t.loading=!1,t.options=t.list.filter((function(t){return t.label.toLowerCase().indexOf(e.toLowerCase())>-1}))}),200)):this.options=[]}},created:function(){var e=this;axios.get("http://localhost:8080/empiden/findAll/"+this.currentpage+"/"+this.pagesize).then((function(t){console.log(t.data.data),e.tableData=t.data.data.records,e.total=t.data.data.total})),axios.get("http://localhost:8080/depart/findAll").then((function(t){e.options2=t.data.data}))}}),d=i,s=(a("d221"),a("2877")),r=Object(s["a"])(d,l,n,!1,null,null,null);t["default"]=r.exports},"58b0":function(e,t,a){},ade3:function(e,t,a){"use strict";function l(e,t,a){return t in e?Object.defineProperty(e,t,{value:a,enumerable:!0,configurable:!0,writable:!0}):e[t]=a,e}a.d(t,"a",(function(){return l}))},b0c0:function(e,t,a){var l=a("83ab"),n=a("9bf2").f,o=Function.prototype,i=o.toString,d=/^\s*function ([^ (]*)/,s="name";l&&!(s in o)&&n(o,s,{configurable:!0,get:function(){try{return i.call(this).match(d)[1]}catch(e){return""}}})},d221:function(e,t,a){"use strict";a("58b0")}}]);
//# sourceMappingURL=chunk-76dd37ec.408c32ae.js.map