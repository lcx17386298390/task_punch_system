<template>
  <div>
    <nav>
    <div class="navbox">
      <p>介绍页面</p>
      <p @click="showAlert">开始工作</p>
    </div>
    <div class="nava">
      <!-- <a href="/#/login">登录</a> -->
      <router-link to="/login">登录</router-link>
      <router-link to="/registration">注册</router-link>
      <!-- <a href="/registration">注册</a> -->
    </div>
  </nav>

  <div class="slideshow-container">
    <div class="slide active">
      <img class="slide-image" src="../assets/lbt1.jpg" />
      <div class="slide-text"><span style="color: crimson;font-size: 60px;">欢迎来到</span>黄冈师范学院ACM实验室任务打卡系统</div>
    </div>
  </div>

  <!-- 提供服务部分 -->
  <div class="dier">
    <h1>我们提供的服务</h1>
    <div class="fuw">
      <div class="div-box">
        <img src="../assets/duigou.jpg" />
        <p class="top">发布任务</p>
        <hr>
        <p>您可以创建和发布任务，包括任务名称、描述、任务对象等详细信息</p>
      </div>

      <div class="div-box">
        <img src="../assets/duigou2.jpg" />
        <p class="top">查看任务</p>
        <hr>
        <p>您可以随时查看当前的任务列表，了解每个任务的状态、进展以及相关的详细信息</p>
      </div>

      <div class="div-box">
        <img src="../assets/duigou3.jpg" />
        <p class="top">队内消息</p>
        <hr>
        <p>通过队内消息功能，您可以与团队成员进行实时沟通和交流，分享信息、讨论问题、协调工作等。</p>
      </div>

      <div class="div-box">
        <img src="../assets/duigou4.jpg" />
        <p class="top">进度监督</p>
        <hr>
        <p>您能够监控任务的进度和完成情况，以便及时调整计划和资源分配，确保项目按时完成</p>
      </div>
    </div>
  </div>

  <!-- 中转 -->
  <div class="zzz">
    <img src="../assets/tearm.jpg" />
    <div class="zz">
      <img src="../assets/us.jpg" />
      <div class="zbox">
        <h2>使用任务打卡系统</h2>
        <p>一个用于记录和管理工作任务的网站，帮助用户高效完成任务并追踪进度，提供便捷的任务管理和统计功能。</p>
      </div>
    </div>
  </div>

  <!-- 我们 -->
  <div class="team">
    <h1>开发人员介绍</h1>
    <hr class="hr1">
    <div class="zs">
      <div class="come">
        <p>我们来自黄冈师范学院ACM实验室</p>
        <img src="../assets/acm.jpeg" />
      </div>
    </div>
    <div class="us">
      <div class="leader">
        <img src="../assets/lcx.jpg" />
        <div class="miaoshi">
          <p>开心超人</p>
          <p class="jieshao">天子临宣赐侯印，将军佩出明光</p>
        </div>
      </div>
      <div class="cy">
        <div class="buding">
          <div class="jt">
            <img src="../assets/chy.jpg" />
            <div class="miaoshi">
              <p>Vio1et27</p>
              <p class="jieshao">springboot，启动！</p>
            </div>
          </div>
        </div>
        <div class="buding">
          <div class="jt">
            <img src="../assets/dx.jpg" />
            <div class="miaoshi">
              <p>volcanovo</p>
              <p class="jieshao">vscode重度依赖</p>
            </div>
          </div>
        </div>
        <div class="buding">
          <div class="jt">
            <img src="../assets/yq.png" />
            <div class="miaoshi">
              <p>mqgs</p>
              <p class="jieshao">无话可说。</p>
            </div>
          </div>
        </div>
        <div class="buding">
          <div class="jt">
            <img src="../assets/wqw.jpg" />
            <div class="miaoshi">
              <p>王倩文</p>
              <p class="jieshao">大鹏终有直冲云天一日</p>
            </div>
          </div>
        </div>
        <div class="buding">
          <div class="jt">
            <img src="../assets/cyj.jpg" />
            <div class="miaoshi">
              <p>demure512</p>
              <p class="jieshao">你会同黄金般在我的记忆中闪耀</p>
            </div>
          </div>
        </div>
        <div class="buding">
          <div class="jt">
            <img src="../assets/gt.jpg" />
            <div class="miaoshi">
              <p>Kansan1</p>
              <p class="jieshao">年少不知生活的苟且😖</p>
            </div>
          </div>
        </div>
        <div class="buding">
          <div class="jt">
            <img src="../assets/xxj.jpg" />
            <div class="miaoshi">
              <p>alpacanosleep</p>
              <p class="jieshao">拿着最差的牌也要有一往无前的勇气</p>
            </div>
          </div>
        </div>
        <div class="buding">
          <div class="jt">
            <img src="../assets/wy.jpg" />
            <div class="miaoshi">
              <p>Wanginginging</p>
              <p class="jieshao">哈哈</p>
            </div>
          </div>
        </div>
      </div>
      <h3 class="jiewei">我们在一起，才是413</h3>
      <hr class="jwhr">
    </div>
  </div>


  </div>
</template>

<script>
export default{
  name:'index',
  methods:{
    showAlert(){
      alert('请先登录');
    }
  }
}
</script>

<style scoped>
nav {
  display: flex;
  background-color: #ffffff;
}
.navbox {
  display: flex;
  /* background-color: black; */
  height: 80px;
  width: 800px;
  margin-left: 25%;
  color: black;
}

nav p {
  flex: 1;
  width: 100px;
  text-align: center;
  line-height: 80px;
  margin: 0;
  padding: 0;
  font-size: 20px;
  font-weight: 600;
}

nav p:nth-child(1) {
  background-color: #1adfe6;
}
nav p:hover {
  background-color: #1adfe6;
  color: white;
  font-size: 20px;
  font-weight: 600;
}

nav .nava {
  display: flex;
  margin-top: 20px;
  margin-left: 60px;
}
nav a {
  display: block;
  color: black;
  text-decoration: none;
  width: 80px;
  height: 40px;
  background-color: bisque;
  margin-right: 20px;
  text-align: center;
  line-height: 40px;
}

/* 轮播图 */
.slideshow-container {
  position: relative;
  width: 100%;
  height: 500px;
  margin: 0 auto;
}

.slide-image {
  width: 100%;
  height: 500px;
}

.slide-text {
  position: absolute;
  top: 0px;
  left: 0;
  right: 0;
  text-align: center;
  color: white;
  font-size: 40px;
  font-weight: bold;
  transition: top 0.5s;
}

.active .slide-text {
  top: 40%;
}

.dier {
  margin-top: 50px;
  justify-content: space-between;
  width: 100%;
}

.dier h1 {
  margin-left: 35%;
  line-height: 60px;
  margin-bottom: 50px;
  letter-spacing: 0.8em;
  font-size: 40px;
}

.fuw {
  display: flex;
  margin-left: 40px;
}
.div-box {
  flex: 1;
  width: 25%;
  text-align: center;
  padding: 10px;
  box-sizing: border-box;
}

.div-box img {
  width: 30%;
  height: 80px;
  padding-right: 80px;
}

.div-box hr {
  width: 60%;
  margin-right: 100px;
  margin-bottom: 10px;
}

.div-box p {
  width: 80%;
  font-size: 18px;
  letter-spacing: 0.3em;
  line-height: 30px;
}

.div-box .top {
  margin-top: 20px;
  font-weight: 600;
  font-size: 20px;
  letter-spacing: 0.5em;
}

/* 中转 */
.zzz {
  margin-top: 50px;
  display: flex;
}

.zzz img {
  float: left;
  width: 800px;
  height: 450px;
}

.zzz .zz {
  position: relative;
}

.zzz .zz h2 {
  position: absolute;
  top: 10%;
  font-size: 50px;
  margin-top: 100px;
  letter-spacing: 0.2em;
  font-family: inherit;
  color: wheat;
}

.zzz .zz p {
  position: absolute;
  top: 49%;
  font-size: 20px;
  letter-spacing: 0.3em;
  font-family: serif;
  color: wheat;
}

.zzz .zz img {
  object-fit: cover;
  z-index: -999;
}

/* 开发人员介绍 */
.team {
  margin-top: 50px;
}

.team h1 {
  text-align: center;
  letter-spacing: 0.3em;
  font-size: 50px;
  font-family: system-ui;
  font-weight: 600;
  margin: 0;
  padding: 0;
  font-style: inherit;
}

.team .hr1 {
  width: 400px;
  height: 2px;
  background-color: gainsboro;
}

.team .zs {
  margin-top: 30px;
  width: 1200px;
  margin-left: auto;
  margin-right: auto;
  border: 5px solid #bda3a3;
  padding: 4px;
}
.team .come {
  height: 260px;
  display: flex;
  border: 3px solid #bda3a3;
}

.team .come p {
  color: #000;
  font-size: 34px;
  line-height: 260px;
  letter-spacing: 0.2em;
  margin-left: 40px;
  font-weight: 600;
  font-family: initial;
  font-style: inherit;
}

.team .come img {
  width: 250px;
  height: 250px;
  border: 2px solid #000;
  box-shadow: 8px 8px 4px rgba(0, 0, 0, 0.2);
  margin-left: 120px;
}

.team .us {
  position: absolute;
  height: 400px;
  margin-top: 40px;
}

.team .us .leader {
  display: flex;
  position: relative;
  top: 30px;
  left: 500px;
  width: 600px;
}
.team .us .leader img {
  width: 200px;
  height: 200px;
  z-index: 999;
}

.miaoshi {
  width: 350px;
  height: 130px;
  background: linear-gradient(to left, #282424aa, #212020);
  transform: skewX(-20deg);
  transform-origin: 0;
  margin-top: 70px;
  margin-left: -40px;
  padding-left: 60px;
}

.miaoshi p {
  color: wheat;
  transform: skew(20deg);
  font-size: 25px;
  font-family: inherit;
  font-weight: 600px;
  margin-top: 20px;
}

.miaoshi .jieshao {
  font-family: serif;
  color: rgb(189, 170, 135);
  font-size: 20px;
}
.us .cy {
  width: 1500px;
  margin-top: 80px;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  margin-left: 5px;
}

.us .cy .buding {
  width: 45%;
  height: 200px;
  padding: 15px;
  margin-bottom: 20px;
  margin-left: 10px;
}

.cy .buding .jt {
  display: flex;
  margin-left: 40px;
}

.cy .buding .jt img {
  width: 200px;
  height: 200px;
  z-index: 999;
}

.jiewei {
  width: 400px;
  position: relative;
  left: 39%;
  padding: 0;
  margin: 0;
  margin-top: 10px;
  font-style: italic;
  font-family: serif;
  font-size: 20px;
  letter-spacing: 0.4em;
  color: grey;
}

.jwhr {
  width: 1000px;
  color: gray;
}

</style>