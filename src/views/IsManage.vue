<template>
  <div>
    <!-- 隔离人员管理 -->
    <el-button type="primary" @click="addDialogFormVisible = true" size="medium">新增记录</el-button>
    <el-input placeholder="请输入内容" v-model="stext" class="input-with-select" style="width:40%">
      <el-select v-model="cname" slot="prepend" placeholder="请选择" @change="getKey">
        <el-option label="姓名" value="name"></el-option>
        <el-option label="隔离方式" value="type"></el-option>
        <el-option label="隔离地点" value="place"></el-option>
        <el-option label="出发地" value="leaved"></el-option>
        <el-option label="途径地" value="arrived"></el-option>
      </el-select>
      <el-button slot="append" icon="el-icon-search" @click="search()"></el-button>
    </el-input>

    <el-table :data="tableData" border style="width: 100%">
      <el-table-column fixed prop="id" label="编号" width="50">
      </el-table-column>
      <el-table-column fixed prop="name" label="姓名" width="100">
      </el-table-column>
      
      <el-table-column prop="sex" label="性别" width="60">
      </el-table-column>
      <el-table-column prop="phone" label="手机号码" width="120">
      </el-table-column>
      <el-table-column prop="temp" label="体温" width="100">
        <template slot-scope="scope">
          <div slot="reference">
            <p size="medium" :class="scope.row.temp > 36 && scope.row.temp < 37.3 ? '' : 'red'">{{ scope.row.temp + "°C" }}
            </p>
          </div>
        </template>
      </el-table-column>
      <el-table-column prop="type" label="隔离方式" width="120">
      </el-table-column>
      <el-table-column prop="place" label="隔离地点" width="200">
      </el-table-column>
      <el-table-column prop="begin" label="隔离开始日期" width="150">
      </el-table-column>
      <el-table-column prop="end" label="隔离结束日期" width="150">
        </el-table-column>
      <el-table-column prop="leaved" label="出发地" width="120">
      </el-table-column>
      <el-table-column prop="arrived" label="途径地" width="120">
      </el-table-column>
      <el-table-column prop="depart" label="所属部门" width="120">
      </el-table-column>
      <el-table-column prop="content" label="备注" width="120">
      </el-table-column>
      <el-table-column width="120" label="操作" fixed="right">
        <template slot-scope="scope">
          <el-button class="修改" @click="dialogFormVisible = true, edit(scope.row)" icon="el-icon-edit" size="small"
            type="primary"></el-button>
          <el-button class="删除" icon="el-icon-delete" size="small" @click="deleteRecord(scope.row)"
            type="primary"></el-button>
        </template>
      </el-table-column>
    </el-table>

    <div class="block">
      <!-- 分页 -->
      <el-pagination background @current-change="handleCurrentChange" @size-change="handleSizeChange" :page-size="10"
        layout="total, sizes, prev, pager, next, jumper" :total="total">
      </el-pagination>

      <el-dialog title="修改隔离记录" :visible.sync="dialogFormVisible" slot>
        <el-form :model="EmpIs" ref="EmpIs">
          <el-form-item label="姓名" :label-width="formLabelWidth">
            <el-input v-model="EmpIs.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="性别" :label-width="formLabelWidth">
            <el-radio v-model="EmpIs.sex" label="男">男</el-radio>
            <el-radio v-model="EmpIs.sex" label="女">女</el-radio>
          </el-form-item>
          <el-form-item label="手机号码" :label-width="formLabelWidth">
            <el-input v-model="EmpIs.phone" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="体温" :label-width="formLabelWidth">
            <el-input v-model="EmpIs.temp" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="隔离方式" :label-width="formLabelWidth">
            <el-input v-model="EmpIs.type" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="隔离地点" :label-width="formLabelWidth">
            <el-input v-model="EmpIs.place" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="隔离开始日期" :label-width="formLabelWidth">
            <el-date-picker v-model="EmpIs.begin" type="date" :picker-options="pickerOptions" value-format="yyyy-MM-dd">
              </el-date-picker>
          </el-form-item>
          <!-- <el-form-item label="隔离结束日期" :label-width="formLabelWidth">
            <el-date-picker v-model="EmpIs.end" type="date" :picker-options="pickerOptions" value-format="yyyy-MM-dd">
                </el-date-picker>
            <el-input v-model="EmpIs.end" autocomplete="off"></el-input>
          </el-form-item> -->
          <el-form-item label="出发地" :label-width="formLabelWidth">
            <el-input v-model="EmpIs.leaved" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="途径地" :label-width="formLabelWidth">
            <el-input v-model="EmpIs.arrived" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="所属部门" :label-width="formLabelWidth" prop="depart">
            <el-select v-model="EmpIs.depart" clearable placeholder="请选择">
              <el-option v-for="(item, index) in options3" :key="index" :label="item" :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="备注" :label-width="formLabelWidth">
            <el-input v-model="EmpIs.content" autocomplete="off"></el-input>
          </el-form-item>

        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="dialogFormVisible = false, update()">确 定</el-button>
        </div>
      </el-dialog>


      <el-dialog title="新增隔离记录" :visible.sync="addDialogFormVisible" slot>
        <el-form :model="addEmpIs">
          <el-form-item label="姓名" :label-width="formLabelWidth">
            <el-input v-model="addEmpIs.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="性别" :label-width="formLabelWidth">
            <el-radio v-model="addEmpIs.sex" label="男">男</el-radio>
            <el-radio v-model="addEmpIs.sex" label="女">女</el-radio>
          </el-form-item>
          <el-form-item label="手机号码" :label-width="formLabelWidth">
            <el-input v-model="addEmpIs.phone" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="体温" :label-width="formLabelWidth">
            <el-input v-model="addEmpIs.temp" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="隔离方式" :label-width="formLabelWidth">
            <el-input v-model="addEmpIs.type" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="隔离地点" :label-width="formLabelWidth">
            <el-input v-model="addEmpIs.place" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="隔离开始日期" :label-width="formLabelWidth">
            <el-date-picker v-model="addEmpIs.begin" type="date" placeholder="选择日期" :picker-options="pickerOptions"
            value-format="yyyy-MM-dd">
            </el-date-picker>
          </el-form-item>
          
          <el-form-item label="出发地" :label-width="formLabelWidth">
            <el-input v-model="addEmpIs.leaved" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="途径地" :label-width="formLabelWidth">
            <el-input v-model="addEmpIs.arrived" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="所属部门" :label-width="formLabelWidth" prop="depart">
            <el-select v-model="addEmpIs.depart" clearable placeholder="请选择">
              <el-option v-for="(item, index) in options3" :key="index" :label="item" :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="备注" :label-width="formLabelWidth">
            <el-input v-model="addEmpIs.content" autocomplete="off"></el-input>
          </el-form-item>

        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="addDialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="addDialogFormVisible = false, submitForm()">确 定</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
export default {
  data() {

    return {
      options3: [
        {
          value: "",
          label: "",
        },
      ],
      cname: '',
      stext: '',
      pickerOptions: {

        shortcuts: [{
          text: '今天',
          onClick(picker) {
            picker.$emit('pick', new Date());
          }
        }, {
          text: '昨天',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24);
            picker.$emit('pick', date);
          }
        }, {
          text: '一周前',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
            picker.$emit('pick', date);
          }
        }]
      },
      options: [],
      value: [],
      list: [],
      loading: false,
      tableData: null,
      total: null,
      dialogTableVisible: false,
      dialogFormVisible: false,
      addDialogFormVisible: false,
      formLabelWidth: '120px',
      addLabelWidth: '50px',
      currentpage: 1,  //当前所在页默认是第一页
      pagesize: 10,  //每页显示多少行数据 默认设置为10
      EmpIs: {
        id: "",
        name: "",
        sex: "",
        phone: "",
        temp: "",
        type: "",
        place: "",
        leaved: "",
        begin: "",
        end: "",
        content: "",
        depart: ""
      },
      addEmpIs: {
        id: "",
        name: "",
        sex: "",
        phone: "",
        temp: "",
        type: "",
        place: "",
        leaved: "",
        begin: "",
        end: "",
        content: "",
        depart: ""
      }
    }
  },
  methods: {

    reload(){
      axios.get('http://localhost:8080/empis/findAll/' + this.currentpage + '/' + this.pagesize).then((resp) => {
        this.tableData = resp.data.data.records
        this.total = resp.data.data.total
      })
    },

    search() {
      if (!this.stext) {
        axios.get('http://localhost:8080/empis/findAll/' + this.currentpage + '/' + this.pagesize).then((resp) => {
          this.tableData = resp.data.data.records
          this.total = resp.data.data.total
          this.cname = ""
        })
      } else {
        axios.get('http://localhost:8080/empis/search/' + this.searchKey + "/" + this.stext).then((resp) => {
          this.tableData = resp.data.data
          this.total = resp.data.data.total
        })
      }
    },
    getKey(e) {
      this.searchKey = e
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },

    submitForm() {
      console.log(this.addEmpIs.end)
      axios.post('http://localhost:8080/empis/save', this.addEmpIs).then((resp) => {
        if (resp.data == 'success') {
          this.$alert('隔离记录添加成功！', "消息", {
            confirmButtonText: "确定",
            callback: action => {
              // window.location.reload()
              this.reload();
            }
          })
        }
      })
    },

    deleteRecord(row) {
      this.$confirm('是否确定要删除' + row.name + '的隔离记录?', '删除数据', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        axios.delete('http://localhost:8080/empis/deleteById/' + row.id).then((resp) => {
          this.$alert(row.name + '的隔离记录删除成功！', "消息", {
            confirmButtonText: "确定",
            callback: action => {
              // window.location.reload()
              this.reload();
            }
          })
        })
      })
    },
    update() {
      axios.put('http://localhost:8080/empis/update', this.EmpIs).then((resp) => {
        console.log(resp)
        if (resp.data == 'success') {
          this.$alert(this.EmpIs.name + '的隔离记录修改成功！', "消息", {
            confirmButtonText: "确定",
            callback: action => {
              // window.location.reload()
              this.reload();
            }
          })
        }
      })
    },
    edit(row) {
      axios.get('http://localhost:8080/empis/findById/' + row.id).then((resp) => {
        this.EmpIs = resp.data.data;
      })
    },
    handleCurrentChange(currentPage) {
      this.currentpage = currentPage;
      axios.get('http://localhost:8080/empis/findAll/' + this.currentpage + '/' + this.pagesize).then((resp) => {
        this.tableData = resp.data.data.records
        this.total = resp.data.data.total
      })
    },


    handleSizeChange(size) {
      this.pageSize = size;
      axios.get('http://localhost:8080/empis/findAll/'+ this.currentpage + '/' + this.pagesize).then((resp) => {
        this.tableData = resp.data.data.records
        this.total = resp.data.data.total
      })
    },
    remoteMethod(query) {
      if (query !== '') {
        this.loading = true;
        setTimeout(() => {
          this.loading = false;
          this.options = this.list.filter(item => {
            return item.label.toLowerCase()
              .indexOf(query.toLowerCase()) > -1;
          });
        }, 200);
      } else {
        this.options = [];
      }
    }
  },
  mounted() {
    axios.get('http://localhost:8080/empis/findAll/' + this.currentpage + '/' + this.pagesize).then((resp) => {
      this.tableData = resp.data.data.records
      /* for (var i = 0; i < this.tableData.length; i++) {
        if (this.tableData[i].begin !== null) {
          this.tableData[i].date = this.tableData[i].begin + " 至 " + this.tableData[i].end
        }
      } */
      this.total = resp.data.data.total
    });
    axios.get("http://localhost:8080/depart/findAll").then((resp) => {
      console.log(resp.data);
      this.options3 = resp.data.data;
    });
  },


}
</script>
<style>
.red {
  color: red;
}

.el-select .el-input {
  width: 130px;
}

.input-with-select {

  float: right;
}

.input-with-select .el-input-group__prepend {

  background-color: #fff;
}
</style>