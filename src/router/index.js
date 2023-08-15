import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/Index.vue'
import VisitorIndex from '../views/VisitorIndex.vue'
import RootIndex from '../views/RootIndex.vue'
import Login from '../views/login.vue'
Vue.use(VueRouter)

const routes = [
  //配置默认的路径，默认显示有游客页
  { path: '/', component: () => import('../views/VisitorIndex.vue') },
  {
    path: '/login',
    component: () => import("../views/login.vue")
  },
  /* 游客路由 */
  {
    path: "/VisitorIndex",
    name: "疫情概况",
    component: VisitorIndex,
    meta: 100,
    children: [{
      path: "/VisitorEChart",
      name: "防疫数据可视化",
      component: () => import('../views/EChart.vue')
    }
    ]
  },
  /* 管理员路由 */
  {
    path: "/RootIndex",
    name: "疫情概况",
    component: RootIndex,
    meta: 100,
    children: [{
      path: "/RootEChart",
      name: "防疫数据可视化",
      component: () => import('../views/EChart.vue')
    }
    ]
  },

  {
    path: "/RootIndex",
    name: "日常防控管理",
    component: RootIndex,
    meta: 0,
    children: [
      {
        path: "/RootRecordManage",
        name: "打卡记录",
        component: () => import('../views/RecordManage.vue')
      },
      {
        path: "/RootAddRecord",
        name: "健康打卡申报",
        component: () => import('../views/AddRecord.vue')
      }
    ]
  },
  {
    path: "/RootIndex",
    name: "异常人员管理",
    component: RootIndex,
    meta: 0,
    children: [
      {
        path: "/RootIdenManage",
        name: "疫情防控管理",
        component: () => import('../views/IdenManage.vue')

      },
      {
        path: "/RootIsManage",
        name: "隔离人员登记",
        component: () => import('../views/IsManage.vue')
      }
    ]
  },
  {
    path: "/RootIndex",
    name: "防疫物资管理",
    component: RootIndex,
    meta: 0,
    children: [{
      path: "/RootMaterialManage",
      name: "防疫物资查看",
      component: () => import('../views/MaterialManage.vue')
    }
    ]
  },
  {
    path: "/RootIndex",
    name: "系统管理",
    component: RootIndex,
    meta: 0,
    children: [{
      path: "/RootDepartManager",
      name: "部门管理",
      component: () => import('../views/DepartManager.vue')
    },
    {
      path: "/RootUserManager",
      name: "用户管理",
      component: () => import('../views/UserManager.vue')
    }
    ]
  },
  /* 用户路由 */
  {
    path: "/Index",
    name: "疫情概况",
    component: Index,
    meta: 100,
    children: [{
      path: "/EChart",
      name: "防疫数据可视化",
      component: () => import('../views/EChart.vue')
    }
    ]
  },

  {
    path: "/Index",
    name: "日常防控管理",
    component: Index,
    meta: 1,
    children: [
      {
        path: "/RecordManage",
        name: "打卡记录",
        component: () => import('../views/RecordManage.vue')
      },
      {
        path: "/AddRecord",
        name: "健康打卡申报",
        component: () => import('../views/AddRecord.vue')
      }
    ]
  },
  {
    path: "/Index",
    name: "异常人员管理",
    component: Index,
    meta: 1,
    children: [
      {
        path: "/IdenManage",
        name: "疫情防控管理",
        component: () => import('../views/IdenManage.vue')

      },
      {
        path: "/IsManage",
        name: "隔离人员登记",
        component: () => import('../views/IsManage.vue')
      }
    ]
  },
  {
    path: "/Index",
    name: "防疫物资管理",
    component: Index,
    meta: 1,
    children: [{
      path: "/MaterialManage",
      name: "防疫物资查看",
      component: () => import('../views/MaterialManage.vue')
    }
    ]
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
})

export default router
