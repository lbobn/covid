<template>
  <div style="margin-top: 20px; margin: 50px; margin-right: 100px">
    <!-- 按钮 -->

    <el-row>
      <el-button
        style="float: right"
        type="primary"
        @click="
          dialogFormVisible = true;
          user = {};
        "
        >+ 新增用户</el-button
      >
    </el-row>
    <br />
    <!-- 数据表格 -->
    <template>
      <el-table
        highlight-current-row
        ref="multipleTable"
        :data="tableData"
        tooltip-effect="dark"
        style="width: 100%"
        border
      >
        <el-table-column
          type="index"
          width="100"
          label="序号"
          header-align="center"
          align="center"
        >
        </el-table-column>
        <el-table-column
          prop="username"
          label="用户名"
          header-align="center"
          align="center"
        ></el-table-column>
        <el-table-column
          prop="password"
          label="密码"
          header-align="center"
          align="center"
        ></el-table-column>
        <el-table-column
          prop="depart"
          label="部门"
          header-align="center"
          align="center"
        ></el-table-column>

        <el-table-column
          prop="isAdministrator"
          label="用户权限"
          header-align="center"
          align="center"
        >
          <template slot-scope="scope">
            <div slot="reference">
              <p size="medium">
                {{ scope.row.isAdministrator == true ? "管理员" : "普通用户" }}
              </p>
            </div>
          </template>
        </el-table-column>

        <el-table-column
          label="操作"
          width="200"
          header-align="center"
          align="center"
        >
          <template slot-scope="scope">
            <!-- 根用户不可删除 -->
            <el-button
              size="mini"
              type="primary"
              plain
              :disabled="scope.row.username === 'root'"
              @click="selectById(scope.row.id)"
              >编辑</el-button
            >
            <el-button
              size="mini"
              type="danger"
              plain
              :disabled="scope.row.username === 'root'"
              @click="deleteById(scope.row)"
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </template>

    <!-- 新建对话框 -->

    <el-dialog title="保存用户" :visible.sync="dialogFormVisible">
      <el-form :model="user">
        <el-form-item label="用户名" :label-width="formLabelWidth">
          <el-input
            v-model="user.username"
            placeholder="请输入用户名"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth">
          <el-input
            v-model="user.password"
            placeholder="请输入密码"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <!-- 部门 -->
        <el-form-item label="所属部门" :label-width="formLabelWidth">
          <el-select v-model="user.depart" clearable placeholder="请选择">
            <el-option
              v-for="(item, index) in options"
              :key="index"
              :label="item"
              :value="item"
            >
            </el-option>
          </el-select>
        </el-form-item>

        <!-- 权限 -->
        <el-form-item label="权限" :label-width="formLabelWidth">
          <el-radio v-model="user.isAdministrator" :label="true"
            >管理员</el-radio
          >
          <el-radio v-model="user.isAdministrator" :label="false"
            >普通用户</el-radio
          >
        </el-form-item>
      </el-form>

      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="add()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>


<script>
// import { findAll, add, update, deleteById, selectById } from "@/api/dept.js";

export default {
  data() {
    return {
      options: [
        {
          value: "",
          label: "",
        },
      ],
      formLabelWidth: "120px",
      dialogFormVisible: false, //控制对话框是否可见
      user: {
        id: "",
        username: "",
        password: "",
        depart: "",
        isAdministrator: "",
      },
      tableData: [],
    };
  },

  methods: {
    add() {
      // 关闭新建窗口
      this.dialogFormVisible = false;

      if (this.user.id) {
        //修改
        axios
          .post("http://localhost:8080/userlogin/update", this.user)
          .then((res) => {
            if (res.data == "success") {
              /* 判断 */
              this.$alert("修改成功！", "消息", {
                confirmButtonText: "确定",
                callback: (action) => {
                  // window.location.reload();
                  this.list();
                },
              });
            }
          });
      } else {
        //添加
        axios
          .post("http://localhost:8080/userlogin/save", this.user)
          .then((res) => {
            if (res.data == "success") {
              /* 判断 */
              this.$alert("添加成功！", "消息", {
                confirmButtonText: "确定",
                callback: (action) => {
                  // window.location.reload();
                  this.list();
                },
              });
            }
          });
      }

      // 清空模型数据
      this.user = {};
    },

    deleteById(row) {
      this.$confirm("是否确定要删除用户" + row.username + "?", "删除数据", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        axios
          .delete("http://localhost:8080/userlogin/deleteById/" + row.id)
          .then((resp) => {
            this.$alert(row.username + "用户删除成功！", "消息", {
              confirmButtonText: "确定",
              callback: (action) => {
                this.list();
              },
            });
          });
      });
    },

    //根据ID查询用户 -- 回显
    selectById(id) {
      this.dialogFormVisible = true;
      axios
        .get("http://localhost:8080/userlogin/selectById/" + id)
        .then((res) => {
          this.user = res.data.data;
          console.log(this.user);
        });
    },

    list() {
      //查询显示在页面
      axios.get("http://localhost:8080/userlogin/list").then((res) => {
        console.log(res.data.data);
        this.tableData = res.data.data;
      });
    },
  },
  mounted() {
    //当页面加载完成后自动执行。
    this.list();
    //获取部门选项
    axios.get("http://localhost:8080/depart/findAll").then((resp) => {
      console.log(resp.data);
      this.options = resp.data.data;
    });
  },
};
</script>
<style>
</style>