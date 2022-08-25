<template>
  <div style="width: 100%;height: 100%">
    <loading v-if="load"></loading>
    <div class="header">
      <h1>{{ blog.title }}</h1>
      <vue-particles
        style="z-index: 0"
        color="#fff"
        :particleOpacity="0.7"
        :particlesNumber="100"
        shapeType="star"
        :particleSize="4"
        linesColor="#fff"
        :linesWidth="0"
        :lineLinked="true"
        :lineOpacity="0.4"
        :linesDistance="150"
        :moveSpeed="2"
        :hoverEffect="true"
        hoverMode="grab"
        :clickEffect="true"
        clickMode="push"
      >
      </vue-particles>
    </div>
    <div>
      <div style="margin-bottom: 10px">
        <el-row>
          <div style="color: darkgray;font-size: 70%">
            <el-col :xs="{span:8,offset:5}" :sm="{span:4,offset:5}" :md="{span:4,offset:5}" :lg="{span:4,offset:5}"
                    :xl="6">
              {{ blog.createTime.substr(0, 11) }}
            </el-col>
            <el-col :xs="8" :sm="4" :md="4" :lg="4" :xl="4">
              作者：繁华落幕
            </el-col>
            <el-col :xs="{span:8,offset:5}" :sm="4" :md="4" :lg="4" :xl="4">
              {{ blog.typeName }}
            </el-col>
            <el-col :xs="8" :sm="4" :md="4" :lg="4" :xl="4">
              浏览量:{{ blog.clickNum }}
            </el-col>
          </div>
        </el-row>
      </div>
      <div>
        <el-row type="flex" justify="center">
          <el-col :xs="22" :sm="20" :md="20" :lg="15" :xl="18">
            <div>
              <el-card class="box-card-content">
                <div>
                  <mavon-editor
                    :ishljs="true"
                    class="md"
                    :value="blog.content"
                    :subfield="prop.subfield"
                    :defaultOpen="prop.defaultOpen"
                    :toolbarsFlag="prop.toolbarsFlag"
                    :editable="prop.editable"
                    :scrollStyle="prop.scrollStyle"
                    codeStyle="atelier-savanna-light"
                    :toolbars="toolbars"
                  />
                </div>
              </el-card>
            </div>
          </el-col>
        </el-row>
      </div>
      <div>
        <el-row type="flex" justify="center">
          <el-col :xs="22" :sm="20" :md="20" :lg="15" :xl="18">
            <el-card class="box-card-msg">
              <div class="text">
                <div>
                  标签：
                  <el-tag v-for="(item,index) in tagList" size="small" type="success" :key="index">{{ item.name }}
                  </el-tag>
                </div>
                <div>标题： <span class="msg">{{ blog.title }}</span></div>
                <div>作者：
                  <span class="msg">繁华落幕</span>
                </div>
                <div>地址：
                  <span class="msg">{{ location() }}</span>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>
        <br>
        <el-row type="flex" justify="center" style="flex-wrap: wrap">
          <el-col :xs="22" :sm="11" :md="9" :lg="7" :xl="8">
            <el-card class="box-card tuijian">
              <div slot="header" class="clearfix">
                <h3>随机阅读</h3>
              </div>
              <div class="text item">
                <ul style="width: 80%">
                  <li v-for="(item,index) in BlogListRandom" :key="index" @click="toRead(item.id)">
                    <span>{{ item.title }}</span>
                    <el-divider></el-divider>
                  </li>
                </ul>
              </div>
            </el-card>
          </el-col>
          <el-col :xs="22" :sm="11" :md="{offset:1,span:9}" :lg="{offset:1,span:7}" :xl="{offset:1,span:8}">
            <el-card class="box-card tuijian">
              <div slot="header" class="clearfix">
                <h3>相关阅读</h3>
              </div>
              <div class="text item">
                <ul style="width: 80%">
                  <li v-for="(item,index) in BlogListRandomByKey" :key="index" @click="toRead(item.id)">
                    <span>{{ item.title }}</span>
                    <el-divider></el-divider>
                  </li>
                </ul>
              </div>
            </el-card>
          </el-col>
        </el-row>
        <!--        <el-form :model="replyContent" :rules="rules" ref="form">-->
        <!--          <el-row type="flex" justify="center">-->
        <!--            <el-col :xs="22" :sm="20" :md="20" :lg="15" :xl="18">-->
        <!--              <el-card class="box-card-msg">-->
        <!--                <div slot="header" class="commentHeader">-->
        <!--                  <h3>评论</h3>-->
        <!--                </div>-->
        <!--                <div class="commentBody">-->
        <!--                  <el-row>-->
        <!--                    <el-col :xs="{span:22,offset:1}" :sm="12">-->
        <!--                      <el-form-item prop="nick">-->
        <!--                        <el-input v-model="replyContent.nick" placeholder="你的昵称"></el-input>-->
        <!--                      </el-form-item>-->
        <!--                    </el-col>-->
        <!--                    <el-col :xs="{span:22,offset:1}" :sm="12">-->
        <!--                      <el-form-item prop="email">-->
        <!--                        <el-input v-model="replyContent.email" placeholder="你的邮箱"></el-input>-->
        <!--                      </el-form-item>-->
        <!--                    </el-col>-->
        <!--                  </el-row>-->
        <!--                  <el-row>-->
        <!--                    <el-col :xs="{span:22,offset:1}" :sm="{span:24,offset:0}">-->
        <!--                      <div @click="showComment">-->
        <!--                        <el-input :disabled="true" resize="none" rows type="textarea"-->
        <!--                                  placeholder="评论"></el-input>-->
        <!--                      </div>-->
        <!--                    </el-col>-->
        <!--                  </el-row>-->
        <!--                </div>-->
        <!--              </el-card>-->
        <!--            </el-col>-->
        <!--          </el-row>-->
        <!--          <el-row type="flex" justify="center" v-for="(item,index) in commentList" :key="index">-->
        <!--            <el-col :xs="22" :sm="20" :md="20" :lg="15" :xl="18">-->
        <!--              <div @mouseover="item.replyBtn=false" @mouseout="item.replyBtn=true">-->
        <!--                <el-card class="box-card-msg">-->
        <!--                  <div slot="header">-->
        <!--                    {{ item.nickname }}-->
        <!--                    <span class="msg" v-if="item.replyId!=null">-->
        <!--                      @{{ replyName(item.replyId) }}-->
        <!--                    </span>-->
        <!--                  </div>-->
        <!--                  <div>-->
        <!--                    <p v-html="item.content"></p>-->
        <!--                  </div>-->
        <!--                  <span :hidden="item.replyBtn" class="replyBtn" @click="rePly(item.id,item.nickname)">回复</span>-->
        <!--                </el-card>-->
        <!--              </div>-->
        <!--            </el-col>-->
        <!--          </el-row>-->
        <!--          <div :hidden="showCommentMD">-->
        <!--            <div class="commentMD">-->
        <!--              <el-form-item prop="contentText">-->
        <!--                <mavon-editor-->
        <!--                  v-model="replyContent.contentText"-->
        <!--                  :toolbars="markdownOption"-->
        <!--                  :subfield="false"-->
        <!--                  :editable="true"-->
        <!--                  codeStyle="atelier-savanna-light"-->
        <!--                  :ishljs="true"-->
        <!--                />-->
        <!--              </el-form-item>-->
        <!--              <span style="color: #97CBFF;" :hidden="replyContent.reply">@{{ replyContent.replyName }}</span>-->
        <!--              <el-button @click="submit" size="mini" type="success" style="float: right">提交</el-button>-->
        <!--              <el-button @click="showCommentMD=true" size="mini" style="float: right">取消</el-button>-->
        <!--              <span class="replyLength">还可以输入{{ 200 - replyContent.replyContentLength }}字</span>-->
        <!--            </div>-->
        <!--          </div>-->
        <!--        </el-form>-->
      </div>
      <br>
    </div>
    <home-footer></home-footer>
  </div>
</template>

<script>
import {blog, comment} from "../assets/data/blog";
import loading from "../components/load/loading";
import HomeFooter from "../components/HomeFooter";
import {mavonEditor} from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import {
  addBlogClickNum,
  addComment,
  getBlogContent,
  getBlogListRandom,
  getBlogListRandomByKey,
  getComment,
  getTagByBlogId
} from "../api";

export default {
  name: "BlogContent",
  data() {
    return {
      rules: {
        nick: [
          {required: true, message: "必填"},
          {min: 1, max: 10, message: '长度在 1 到 10 个字符', trigger: 'blur'}
        ],
        email: [
          {required: true, message: "必填"},
          {type: 'email', message: '请输入正确的邮箱地址', trigger: 'blur'}],
        contentText: [
          {required: true, message: "必填"},
          {min: 1, max: 200, message: '长度在 1 到 200 个字符', trigger: 'blur'}],
      },
      commentList: [], //评论列表
      tagList: [],
      BlogListRandom: [],
      BlogListRandomByKey: [],
      blogId: '',
      load: true,
      blog: {},
      time: null,
      // showCommentMD: true, //是否展开评论
      // replyContent: {
      //   nick: '', //评论昵称
      //   replyId: null, //被回复者id
      //   email: '', //评论邮箱
      //   contentText: '', //评论编辑内容
      //   replyContentLength: '', //评论字数
      //   reply: true,     //是否展示回复某人
      //   replyName: '',
      // },
      toolbars: {
        fullscreen: true, // 全屏编辑
        navigation: true, // 导航目录
      },
      // markdownOption: {
      //   undo: true, // 上一步
      //   redo: true, // 下一步
      //   trash: true, // 清空
      // }
    }
  },
  computed: {
    // 解析器配置
    prop() {
      let data = {
        subfield: false,// 单双栏模式
        defaultOpen: 'preview',//edit： 默认展示编辑区域 ， preview： 默认展示预览区域
        editable: false,	// 是否允许编辑
        toolbarsFlag: true,
        scrollStyle: true
      }
      return data
    }
  },
  components: {
    mavonEditor,
    HomeFooter,
    loading
  },
  watch: {
    // 'replyContent.contentText': function (e) { //监控评论输入内容
    //   if (e.length > 200) {
    //     this.replyContent.replyContentLength = 200;
    //   } else {
    //     this.replyContent.replyContentLength = e.length
    //   }
    // }
  },
  created() {
    this.blogId = this.$route.query.id;
    this.getBlog(this.blogId);
    this.getTag(this.blogId)
    this.getBlogListRandom();
    // this.getComment(this.blogId);
  },
  mounted() {
    this.time = setTimeout(() => {
      this.addClick();
    }, 10000)
  },
  destroyed() {
    clearTimeout(this.time);
    this.time = null;
  },
  methods: {
    // showComment() { //点击评论框
    //   this.replyContent.replyId = null; //被回复id置-1
    //   this.replyContent.contentText = ''; //被回复昵称清空
    //   this.replyContent.reply = true;  //关闭@
    //   this.showCommentMD = !this.showCommentMD;
    // },
    // rePly(id, name) { //点击回复显示
    //   this.replyContent.replyName = name;
    //   this.replyContent.replyId = id;
    //   this.replyContent.reply = false;
    //   this.showCommentMD = false;
    // },
    // submit() { //提交评论
    //   console.log(this.replyContent.replyId)
    //   if (!this.checkForm()) {
    //     this.$message.error('请完善相关信息！');
    //     return;
    //   }
    //   let params = new URLSearchParams();
    //   params.append("blogId", this.blogId);
    //   params.append("nickname", this.replyContent.nick);
    //   params.append("content", this.replyContent.contentText);
    //   params.append("email", this.replyContent.email);
    //   if (this.replyContent.replyId != null) {
    //     params.append("replyId", this.replyContent.replyId);
    //   }
    //   //提交后台
    //   addComment(params)
    //     .then(res => {
    //       if (res.status == 1) {
    //         this.$notify({
    //           title: res.msg,
    //           type: "success"
    //         })
    //         this.getComment(this.blogId);
    //         this.replyContent.contentText = '';
    //         this.showCommentMD = true;
    //       } else {
    //         this.$notify({
    //           title: res.msg,
    //           type: "error"
    //         })
    //       }
    //     })
    //     .catch(err => {
    //       console.log(err)
    //     })
    // },
    // // 表单校验
    // checkForm() {
    //   // 1.校验必填项
    //   let validForm = false;
    //   this.$refs.form.validate(valid => {
    //     validForm = valid
    //   })
    //   if (!validForm) {
    //     return false;
    //   }
    //   return true;
    // },
    // replyName(replyId) {
    //   for (let i = 0; i < this.commentList.length; i++) {
    //     if (this.commentList[i].id == replyId)
    //       return this.commentList[i].nickname
    //   }
    // },
    getBlog(id) {
      getBlogContent({id: id})
        .then(res => {
          this.blog = res.blog;
          this.load = false;
          this.getBlogListRandomByKey(this.blog.title.slice(2, 6));
        })
    },
    getTag(id) {
      getTagByBlogId({blogId: id})
        .then(res => {
          this.tagList = res.tagList;
        })
    },
    // getComment(id) {
    //   getComment({blogId: id})
    //     .then(res => {
    //       this.commentList = res.commentList.map(item => {
    //         return {
    //           id: item.id,
    //           nickname: item.nickname,
    //           content: item.content,
    //           replyId: item.replyId,
    //           replyBtn: true
    //         }
    //       })
    //     })
    // },
    addClick() {
      let param = new URLSearchParams();
      param.append("blogId", this.blogId);
      addBlogClickNum(param)
        .then(res => {
          console.log(res)
        })
    },
    location() {
      return window.location.href;
    },
    getBlogListRandom() {
      getBlogListRandom()
        .then(res => {
          this.BlogListRandom = res.blogListRandom;
        })
    },
    getBlogListRandomByKey(key) {
      getBlogListRandomByKey({keyword: key})
        .then(res => {
          this.BlogListRandomByKey = res.blogListRandomByKey;
        })
    },
    toRead(id) {
      let routeData = this.$router.resolve({path: '/blog', query: {id: id}});
      window.open(routeData.href, '_blank');
    }

  },
}
</script>

<style scoped>
@import "../assets/css/BlogContent.css";
</style>
