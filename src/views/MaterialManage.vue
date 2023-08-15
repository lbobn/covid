<template>
  <div>
    <el-button
      @click="(addDialogFormVisible = true), edit(scope.row)"
      type="primary"
      size="medium"
    >
      新增
    </el-button>

    <el-input
      placeholder="请输入内容"
      v-model="stext"
      class="input-with-select"
      style="width: 40%"
    >
      <el-select
        v-model="cname"
        slot="prepend"
        placeholder="请选择"
        @change="getKey"
      >
        <el-option label="物资名称" value="name"></el-option>
        <el-option label="负责人" value="charge"></el-option>
        <el-option label="更新时间" value="updateTime"></el-option>
      </el-select>
      <el-button
        slot="append"
        icon="el-icon-search"
        @click="search()"
      ></el-button>
    </el-input>

    <el-table :data="tableData" border="1" style="width: 100%">
      <el-table-column fixed prop="id" label="编号" width="80">
      </el-table-column>
      <el-table-column prop="name" label="名称" width="180"> </el-table-column>
      <el-table-column prop="count" label="数量" width="100"> </el-table-column>
      <el-table-column prop="type" label="计量单位" width="80">
      </el-table-column>
      <el-table-column prop="isImp" label="是否为重点物资" width="120">
      </el-table-column>
      <el-table-column prop="charge" label="负责人" width="100">
      </el-table-column>
      <el-table-column prop="cnum" label="负责人电话" width="150">
      </el-table-column>
      <el-table-column prop="updateTime" label="更新时间" width="200">
      </el-table-column>

      <el-table-column width="120" label="操作" fixed="right">
        <template slot-scope="scope">
          <el-button
            class="修改"
            @click="(dialogFormVisible = true), edit(scope.row)"
            type="primary"
            icon="el-icon-edit"
            size="small"
          ></el-button>
          <el-button
            class="删除"
            type="primary"
            icon="el-icon-delete"
            size="small"
            @click="deleteRecord(scope.row)"
          ></el-button>
        </template>
      </el-table-column>
    </el-table>

    <div class="block">
      <!-- 分页条 -->
      <el-pagination
        background
        @current-change="handleCurrentChange"
        @size-change="handleSizeChange"
        :page-size="10"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      >
      </el-pagination>

      <el-dialog title="更新物资详情" :visible.sync="dialogFormVisible" slot>
        <el-form :model="Mat2" ref="Mat2">
          <el-form-item label="物资名称" :label-width="formLabelWidth">
            <el-input v-model="Mat2.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="物资数量" :label-width="formLabelWidth">
            <el-input v-model="Mat2.count" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="计量单位" :label-width="formLabelWidth">
            <el-input v-model="Mat2.type" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item
            label="是否为重要物资"
            :label-width="formLabelWidth"
            prop="isImp"
          >
            <el-radio v-model="Mat2.isImp" label="是" @change="test($event)"
              >是</el-radio
            >
            <el-radio v-model="Mat2.isImp" label="否" @change="test($event)"
              >否</el-radio
            >
          </el-form-item>
          <el-form-item label="负责人" :label-width="formLabelWidth">
            <el-input v-model="Mat2.charge" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="负责人电话" :label-width="formLabelWidth">
            <el-input v-model="Mat2.cnum" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button
            type="primary"
            @click="(dialogFormVisible = false), update()"
            >确 定</el-button
          >
        </div>
      </el-dialog>

      <el-dialog title="新增物资" :visible.sync="addDialogFormVisible" slot>
        <el-form
          style="width: 100%"
          :model="Mat1"
          :rules="rules"
          ref="Mat1"
          label-width="100px"
          class="demo-Mat"
        >
          <el-form-item
            label="物资名称"
            :label-width="formLabelWidth"
            prop="name"
          >
            <el-input v-model="Mat1.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item
            label="物资数量"
            :label-width="formLabelWidth"
            prop="count"
          >
            <el-input v-model="Mat1.count" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item
            label="计量单位"
            :label-width="formLabelWidth"
            prop="type"
          >
            <el-input v-model="Mat1.type" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item
            label="是否为重要物资"
            :label-width="formLabelWidth"
            prop="isImp"
          >
            <el-radio v-model="Mat1.isImp" label="是">是</el-radio>
            <el-radio v-model="Mat1.isImp" label="否">否</el-radio>
          </el-form-item>
          <el-form-item
            label="负责人"
            :label-width="formLabelWidth"
            prop="charge"
          >
            <el-input v-model="Mat1.charge" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item
            label="负责人电话"
            :label-width="formLabelWidth"
            prop="cnum"
          >
            <el-input v-model="Mat1.cnum" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="(addDialogFormVisible = false),submitForm('Mat1')"
              >立即创建</el-button
            >
            <el-button @click="resetForm('Mat1')">重置</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      cname: "",
      stext: "",
      formLabelWidth: "120px",
      options: [],
      value: [],
      list: [],
      loading: false,
      tableData: null,
      total: null,
      dialogTableVisible: false,
      dialogFormVisible: false,
      addDialogFormVisible: false,
      formLabelWidth: "120px",
      currentpage: 1, //当前所在页默认是第一页
      pagesize: 10, //每页显示多少行数据 默认设置为10
      Mat2: {
        id: "",
        name: "",
        count: "",
        type: "",
        isImp: "",
        charge: "",
        cnum: "",
        updateTime: "",
      },
      Mat1: {
        name: "",
        count: "",
        type: "",
        isImp: "",
        charge: "",
        cnum: "",
      },
      rules: {
        name: [
          { required: true, message: "请输入物资名称", trigger: "blur" },
          {
            min: 3,
            max: 20,
            message: "长度在 3 到 20 个字符",
            trigger: "blur",
          },
        ],
        count: [{ required: true, message: "请输入物资数量", trigger: "blur" }],
        type: [{ required: true, message: "请输入计量单位", trigger: "blur" }],
        isImp: [
          { required: true, message: "请输入是否为重要物资", trigger: "blur" },
        ],
        charge: [{ required: true, message: "请输入负责人", trigger: "blur" }],
        cnum: [
          { required: true, message: "请输入负责人电话", trigger: "blur" },
        ],
      },
    };
  },

  methods: {
    reload() {
      axios
        .get(
          "http://localhost:8080/Material/findAll/" +
            this.currentpage +
            "/" +
            this.pagesize
        )
        .then((resp) => {
          this.tableData = resp.data.data.records;
          this.total = resp.data.data.total;
        });
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios
            .post("http://localhost:8080/Material/save", this.Mat1)
            .then((resp) => {
              if (resp.data == "success") {
                this.$alert("物资添加成功！", "消息", {
                  confirmButtonText: "确定",
                  callback: (action) => {
                    console.log(
                      "--------------------------------------------------------------------------------------------------"
                    );
                    reload();
                    console.log(
                      "--------------------------------------------------------------------------------------------------"
                    );
                  },
                });
              }
            });
        } else {
          return false;
        }
      });
    },
    update() {
      axios
        .put("http://localhost:8080/Material/update", this.Mat2)
        .then((resp) => {
          console.log(resp.data);
          if (resp.data == "success") {
            this.$alert(this.Mat2.name + "的物资记录修改成功！", "消息", {
              confirmButtonText: "确定",
              callback: (action) => {
                this.reload();
              },
            });
          }
        });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },

    test(dd) {
      this.Mat2.isImp = dd;
    },
    search() {
      if (!this.stext) {
        axios
          .get(
            "http://localhost:8080/Material/findAll/" +
              this.currentpage +
              "/" +
              this.pagesize
          )
          .then((resp) => {
            this.tableData = resp.data.data.records;
            this.total = resp.data.data.total;
            this.cname = "";
          });
      } else {
        axios
          .get(
            "http://localhost:8080/Material/search/" +
              this.searchKey +
              "/" +
              this.stext
          )
          .then((resp) => {
            this.tableData = resp.data.data;
            this.total = resp.data.data.total;
          });
      }
    },
    getKey(e) {
      this.searchKey = e;
    },
    deleteRecord(row) {
      this.$confirm("是否确定要删除" + row.name + "的物资记录?", "删除数据", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }).then(() => {
        axios
          .delete("http://localhost:8080/Material/deleteById/" + row.id)
          .then((resp) => {
            this.$alert(row.name + "的物资记录删除成功！", "消息", {
              confirmButtonText: "确定",
              callback: (action) => {
                // window.location.reload();
                this.reload();
              },
            });
          });
      });
    },

    edit(row) {
      axios
        .get("http://localhost:8080/Material/findById/" + row.id)
        .then((resp) => {
          this.Mat2 = resp.data.data;
        });
    },

    handleCurrentChange(currentPage) {
      this.currentpage = currentPage;
      axios
        .get(
          "http://localhost:8080/Material/findAll/" +
            this.currentpage +
            "/" +
            this.pagesize
        )
        .then((resp) => {
          this.tableData = resp.data.data.records;
          this.total = resp.data.data.total;
        });
    },
    handleSizeChange(size) {
      this.pageSize = size;
      axios
        .get(
          "http://localhost:8080/Material/findAll/" +
            this.currentpage +
            "/" +
            this.pagesize
        )
        .then((resp) => {
          this.tableData = resp.data.data.records;
          this.total = resp.data.data.total;
        });
    },

    remoteMethod(query) {
      if (query !== "") {
        this.loading = true;
        setTimeout(() => {
          this.loading = false;
          this.options = this.list.filter((item) => {
            return item.label.toLowerCase().indexOf(query.toLowerCase()) > -1;
          });
        }, 200);
      } else {
        this.options = [];
      }
    },
  },
  created() {
    axios
      .get(
        "http://localhost:8080/Material/findAll/" +
          this.currentpage +
          "/" +
          this.pagesize
      )
      .then((resp) => {
        this.tableData = resp.data.data.records;
        this.total = resp.data.data.total;
      });
  },
};
</script>
<style>
.el-select .el-input {
  width: 130px;
}

.input-with-select {
  float: right;
}

.el-dialog {
  width: 500px;
}

.input-with-select .el-input-group__prepend {
  background-color: #fff;
}
</style>