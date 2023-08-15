<template>
  <div style="margin-top: 20px; margin: 50px; margin-right: 100px">
    <!-- 按钮 -->

    <el-row>
      <el-button
        style="float: right"
        type="primary"
        @click="
          dialogFormVisible = true;
          dept = {};
        "
        >+ 新增部门</el-button
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
          prop="name"
          label="部门名称"
          header-align="center"
          align="center"
        ></el-table-column>
        <el-table-column
          prop="charge"
          label="负责人"
          header-align="center"
          align="center"
        ></el-table-column>
        <!-- <el-table-column label="最后操作时间" header-align="center" align="center">
          <template slot-scope="scope">
              {{scope.row.updateTime ? scope.row.updateTime.replace('T',' '):''}}
          </template>
        </el-table-column> -->

        <el-table-column
          label="操作"
          width="420"
          header-align="center"
          align="center"
        >
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="primary"
              plain
              @click="selectById(scope.row.id)"
              >编辑</el-button
            >

            <el-button
              size="mini"
              type="danger"
              plain
              @click="deleteById(scope.row)"
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </template>

    <!-- 新建对话框 -->

    <el-dialog title="保存部门" :visible.sync="dialogFormVisible">
      <el-form :model="dept">
        <el-form-item label="部门名称" :label-width="formLabelWidth">
          <el-input
            v-model="dept.name"
            placeholder="请输入部门名称"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item label="部门负责人" :label-width="formLabelWidth">
          <el-input
            v-model="dept.charge"
            placeholder="请输入部门负责人"
            autocomplete="off"
          ></el-input>
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
      formLabelWidth: "120px",
      dialogFormVisible: false, //控制对话框是否可见
      dept: {
        id: "",
        name: "",
        charge: "",
      },
      tableData: [],
    };
  },

  methods: {
    /* 

    

    //保存方法
     */

    //初始化 - 查询全部
    /* init() {
      findAll().then((result) => {
        console.log(result);
        if (result.data.code == 1) {
          this.tableData = result.data.data;
        }
      });
    }, */

    /* deleteById(id) {
      this.$confirm("确认删除?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
          deleteById(id).then((result) => {
          	if(result.data.code == 1){
	          	this.$message({
	              message: "恭喜你，删除成功",
	              type: "success",
	            });
	        }else{
	        	this.$message.error(result.data.msg);
	        }
            //重新查询数据
            this.init();
          });
        }).catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    }, */

    add() {
      // 关闭新建窗口
      this.dialogFormVisible = false;

      if (this.dept.id) {
        //修改
        axios
          .post("http://localhost:8080/depart/update" , this.dept)
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
          .post("http://localhost:8080/depart/save" , this.dept)
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
      this.dept = {};
    },

    
    deleteById(row) {
      this.$confirm("是否确定要删除" + row.name + "部门?", "删除数据", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        axios
          .delete("http://localhost:8080/depart/deleteById/" + row.id)
          .then((resp) => {
            this.$alert(row.name + "部门删除成功！", "消息", {
              confirmButtonText: "确定",
              callback: (action) => {
                // window.location.reload();
                this.list();
              },
            });
          });
      });
    },

    //根据ID查询部门 -- 回显
    selectById(id) {
      this.dialogFormVisible = true;
      axios.get("http://localhost:8080/depart/selectById/" + id).then((res) => {
        this.dept = res.data.data;
      });
    },

    list() {
      axios.get("http://localhost:8080/depart/list").then((res) => {
        console.log(res.data.data);
        this.tableData = res.data.data;
        /* this.tableData = JSON.parse();
      console.log(this.tableData) */
      });
    },
  },

  mounted() {
    //当页面加载完成后自动执行。
    this.list();
  },
};
</script>
<style>
</style>