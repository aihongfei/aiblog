<template>
  <div class="content">
    <div>
      <!--      <img class="back" src="../assets/img/2.jpg" alt="">-->
      <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
        <div ref="footer1" class="footer1" style="  background-position: 0 50%;">
          <el-row type="flex" justify="center" align="middle" style="height: 100%">
            <el-col :xs="8" :sm="8" :md="8" :lg="3" :xl="8">
              <div class="btn BtnBorder animate__animated" :class="{'animate__lightSpeedInLeft':show1}">
                <div ref="about" class="Btn " @click="onAbout">
                  关于
                </div>
              </div>
            </el-col>
            <el-col :xs="{span:8,offset:2}" :sm="{span:8,offset:2}" :md="{span:8,offset:2}" :lg="{span:3,offset:2}"
                    :xl="{span:8,offset:2}">
              <div class="btn BtnBorder animate__animated" :class="{'animate__lightSpeedInRight':show1}">
                <div class="Btn" @click="onLink">+友情链接</div>
              </div>
            </el-col>
          </el-row>
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
        <div class="footer2">
          <div>
            <div class="animate__animated" ref="msg" style="text-align: center;font-size: 200%"
                 :class="{'animate__lightSpeedInLeft':show2}">次元使者
            </div>
            <div class="animate__animated" style="padding: 20px;text-align: center"
                 :class="{'animate__lightSpeedInRight':show2}">爱好游戏，动漫。闲来无事喜欢在一些不健康的场所虚度光阴，撸起代码就会废寝忘食。
            </div>
          </div>
        </div>
      </el-col>

      <el-col :xs="24" :sm="24" :md="24" :lg="24" :xl="24">
        <div class="footer4">
          <div class="footer4c">
            <div style="text-align: center">©️2021 AiBlog</div>
            <div style="text-align: center"><a class="beian" target="_blank"
                    href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=12011402001303"
                    style="display:inline-block;text-decoration:none;height:20px;line-height:20px;">
              <img src="../assets/img/备案图标.png" style="float:left;"/>
              <p style="float:left;height:20px;line-height:20px;margin: 0px 0px 0px 5px; color:#939393;">
                津公网安备 12011402001303号</p></a></div>
            <div style="text-align: center"><p id="htmer_time" style="margin: 0"></p></div>
            <div style="text-align: center;margin-top: 5px"><span class="heart"></span></div>
          </div>
        </div>
      </el-col>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeFooter",
  data() {
    return {
      height: 0,
      show1: false, //关于动画
      show2: false, //次元使者动画
    }
  },
  mounted() {//可以在这里面直接进行滚动条的获取
    window.addEventListener('scroll', this.handleScroll, true);

    function secondToDate(second) {
      if (!second) {
        return 0;
      }
      var time = new Array(0, 0, 0, 0, 0);
      if (second >= 365 * 24 * 3600) {
        time[0] = parseInt(second / (365 * 24 * 3600));
        second %= 365 * 24 * 3600;
      }
      if (second >= 24 * 3600) {
        time[1] = parseInt(second / (24 * 3600));
        second %= 24 * 3600;
      }
      if (second >= 3600) {
        time[2] = parseInt(second / 3600);
        second %= 3600;
      }
      if (second >= 60) {
        time[3] = parseInt(second / 60);
        second %= 60;
      }
      if (second > 0) {
        time[4] = second;
      }
      return time;
    }

    function setTime() {
      //mouth要少一个月不然会出问题
      var create_time = Math.round(new Date(Date.UTC(2021, 9, 4, 0, 0, 0)).getTime() / 1000);
      var timestamp = Math.round((new Date().getTime() + 8 * 60 * 60 * 1000) / 1000);
      var currentTime = secondToDate((timestamp - create_time));
      var currentTimeHtml = currentTime[0] + '年' + currentTime[1] + '天'
        + currentTime[2] + '时' + currentTime[3] + '分' + currentTime[4]
        + '秒';
      if (document.getElementById("htmer_time") != null)
        document.getElementById("htmer_time").innerHTML = "AiBlog已经运行" + currentTimeHtml;
    }

    //即时刷新
    setInterval(setTime, 1000);
  },
  destroyed() {
    window.removeEventListener('scroll', this.handleScroll, true);
  },
  methods: {
    onAbout() {
      console.log('about')
    },
    onLink() {
      console.log('onlink')
    },
    handleScroll() {
      let about = this.$refs.about;
      let msg = this.$refs.msg;
      let aboutHeight = this.getTop(about)
      let msgHeight = this.getTop(msg);
      this.height = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop;
      this.$refs.footer1.style.backgroundPosition = "0 " + ((this.height - window.innerHeight / 2) / document.body.scrollHeight) * 100 + "%"
      if (this.height > aboutHeight - window.innerHeight) {
        this.show1 = true;
      }
      if (this.height > msgHeight - window.innerHeight) {
        this.show2 = true;
      }
    },
    getTop(e) {
      var offset = e.offsetTop;
      if (e.offsetParent != null)
        offset += this.getTop(e.offsetParent);
      return offset;
    }
  }
}
</script>

<style scoped>


@import "../assets/css/HomeFooter.css";
</style>
