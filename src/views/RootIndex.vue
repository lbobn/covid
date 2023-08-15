<template >
  <!-- <el-container style="margin-left: -8px;margin-top: -8px;"> -->
    <div class="index" style="margin: -8px; height: 100%;">
    <el-container>
      <el-header style="background-color: #545c64">
        <img
          src="@/assets/logo.png"
          alt=""
          style="width: 30px; position: relative; top: 6px; left: 20px"
        />
        <span
          style="
            color: #eee;
            font-size: 24px;
            margin-left: 40px;
            margin-top: 11px;
          "
          >疫情管理系统(管理员)</span
        >
        <el-button
          type="danger"
          size="mini"
          style="position: absolute; right: 40px; top: 15px"
          @click="exit"
          >退出登录</el-button
        >
      </el-header>

      <el-container style="height: 100%;margin-bottom: -8px; /* border: 1px solid #545c64 */">
        <!-- 侧边栏 -->
        <el-aside width="200px" style="background-color: #545c64">
          <el-menu
            router
            default-active="/RootEChart"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
          >
          <el-menu-item index="/RootEChart" route="/RootEChart">
              <i class="el-icon-setting"></i>
              <span slot="title">概览</span>
            </el-menu-item>
            <el-submenu
              v-for="(item, index) in router"
              :index="index + ''"
              :key="index"
            >
              <template slot="title"
                ><i class="el-icon-setting"></i>{{ item.name }}</template
              >
              <el-menu-item
                v-for="(item2, index2) in item.children"
                :index="item2.path"
                :key="index2"
              >
                {{ item2.name }}
              </el-menu-item>
            </el-submenu>
          </el-menu>
        </el-aside>
        <!-- 主窗体 -->
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
  <!-- </el-container> -->
  
</template>
<script>
export default {
  data() {
    return {
      currentMenu: "",
      router: "",
    };
  },
  methods: {
    exit() {
      this.$router.push("/login");
    },
  },
  created() {
    this.router = this.$router.options.routes.filter((i) => {
      return i.meta==0;
    });
  },
  mounted(){
    this.$router.push('/RootEChart');
  },
  name: "visitorIndex",
};
</script>

<style>

.el-header {
  height: 70px;
}

.el-aside {
  height: calc(100vh - 60px);

  /* // 设置左侧 aside 高度 */
}

.el-main {
  padding: 0;
  height: calc(100vh - 60px);
  /* // 设置主体 main 高度 */
}
</style>
