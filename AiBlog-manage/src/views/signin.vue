<template>
  <div class="bg">
    <div class="login-wrap animated fadeIn">
      <h3>AiBlog后台管理系统</h3>
      <el-form ref="form" :model="form" :rules="rules" label-width="0px">
        <el-form-item prop="name">
          <el-input v-model="form.name" clearable></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="form.password" type="password" clearable></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="Login">登陆</el-button>
        </el-form-item>
      </el-form>
    </div>

    <!-- 粒子漂浮物 -->
    <vue-particles color="#fff" :particleOpacity="0.7" :particlesNumber="30" shapeType="star" :particleSize="5"
                   linesColor="#fff" :linesWidth="2" :lineLinked="true" :lineOpacity="0.4" :linesDistance="150"
                   :moveSpeed="3" :hoverEffect="true" hoverMode="grab" :clickEffect="true"
                   clickMode="push"></vue-particles>
  </div>
</template>
<script>
// 引入粒子特效插件并注册
import Vue from "vue";
import VueParticles from "vue-particles";
import {login} from "../api";
import {mapGetters, mapMutations} from "vuex";

Vue.use(VueParticles);
export default {
  name: "signin",
  data() {

    return {
      form: {
        name: "",
        password: ""
      },
      rules: {
        name: [
          {
            required: true,
            trigger: "blur"
          }
        ],
        password: [
          {
            required: true,
            trigger: "blur"
          }
        ]
      }
    };
  },
  computed: {
    ...mapGetters([
      'token'
    ])
  },
  methods: {
    Login() {
      let _this = this;
      this.$refs.form.validate(valid => {
        if (valid) {
          let params = new URLSearchParams();
          params.append("username", this.form.name);
          params.append("password", this.form.password);
          login(params)
            .then(res => {
              if (res.status == 1) {
                // _this.$store.commit('setToken', res.token);
                _this.$notify({
                  type: "success",
                  title: res.msg
                });
                _this.$router.push({path: '/info'})
              }else {
                _this.$notify({
                  type: "error",
                  title: res.msg
                });
              }
            })
            .catch(res=>{
              console.log(res)
          })
        } else {
          this.$message.error('请完善相关信息！');
          return false;
        }
      });
    },
  },

};
</script>
<style scoped lang="scss">
.bg {
  position: relative;
  overflow: hidden;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background-image: url("../../static/img/bg.jpg");
  background-position: -20% 10%;
  background-size: contain;

  #particles-js {
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
  }
}

.login-wrap {
  width: 310px;
  padding: 30px;
  z-index: 3;
  margin-right: -40%;
  position: relative;
  background: rgba(50, 50, 50, 0.5);

  .el-form-item {
    margin-bottom: 25px !important;
  }

  h3 {
    text-align: center;
    color: #ebedef;
    margin-top: 0px;
    margin-bottom: 5px;
    font-size: 22px;

    span {
      color: #20a0ff;
    }
  }

  p {
    text-align: center;
    color: #fff;
    margin: 0;
  }

  form {
    margin-top: 25px;

    .el-form-item {
      margin-bottom: 15px;
    }

  }

  a {
    text-decoration: none;
    color: #1f2d3d;
  }

  button {
    width: 100%;
    font-weight: 600;
    border: none;
    border-radius: 0;
    background-color: #34495e;
  }
}
</style>
