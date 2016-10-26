<%--
  Created by IntelliJ IDEA.
  User: Sven
  Date: 2016/10/19
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
  <title>登陆首页</title>
  <link rel="stylesheet" type="text/css" href="/resources/Public/H-/static/h-ui/css/H-ui.min.css" />
  <link rel="stylesheet" type="text/css" href="/resources/Public/H-/static/h-ui.admin/css/H-ui.admin.css" />
  <link rel="stylesheet" type="text/css" href="/resources/Public/H-/lib/Hui-iconfont/1.0.7/iconfont.css" />
  <link rel="stylesheet" type="text/css" href="/resources/Public/H-/static/h-ui.admin/skin/default/skin.css" id="skin" />
  <link rel="stylesheet" type="text/css" href="/resources/Public/H-/static/h-ui.admin/css/style.css" />
  <link rel="stylesheet" type="text/css" href="/resources/Public/H-/static/h-ui.admin/css/H-ui.login.css" />

</head>
<body>
<article class="page-container">
  <div class="header"><span style="margin-left:20px;">上诠Java休闲学习系统</span></div>
  <div class="loginWraper">
    <div id="loginform" class="loginBox">
      <form class="form form-horizontal" id="FF" method="post">
        <div class="row cl">
          <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
          <div class="formControls col-xs-8">
            <input id="userNum" name="account" type="text" placeholder="账户" class="input-text size-L">
          </div>
        </div>
        <div class="row cl">
          <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
          <div class="formControls col-xs-8">
            <input id="passwd" name="passwd" type="password" placeholder="密码" class="input-text size-L">
          </div>
        </div>
        <div class="row cl">
          <div class="formControls col-xs-8 col-xs-offset-3">
            <input class="input-text size-L" type="text" placeholder="验证码"
                   name="validateCode" id="validateCode"
                   onblur="if(this.value==''){this.value='验证码:'}"
                   onclick="if(this.value=='验证码:'){this.value='';}"
                   value="验证码:" style="width:150px;">
            <img src="/login/captcha" id="validateCodeImg" onclick="changeValidateCode()">
            <a id="kanbuq" href="javascript:changeValidateCode();">看不清，换一张</a> </div>
        </div>
        <div class="row cl">
          <div class="formControls col-xs-8 col-xs-offset-3">
            <input type="button" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;"
                   onclick="loginPost()">&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
            <input type="button" class="btn btn-success radius size-L" value="&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp;"
                   onclick="registerPost()">
          </div>
        </div>
      </form>
    </div>
  </div>
  <div class="footer"><a href='http://www.aspic.com.cn' target='_blank'>ASPIC</a></div>

</article>
<script type="text/javascript" src="/resources/js/jquery-1.11.1.js"></script>
<script>
  $(document).ready(function(){
    var tips = "<%=request.getParameter("tips")%>";
    console.log(tips);
    if(tips != "" && tips != null && tips != "null"){
      alert("请先登陆！");
      tips = "";
    }
  });
  //更换校验码
  function changeValidateCode(){
    $("#validateCodeImg").attr("src","/login/captcha?_="+Math.random());
  }
  //登陆
  function loginPost(){
    $.post("/login/loginPost",
            $("#FF").serialize(),
            function(data){
              console.log(data);
              if(data == "SUCCESS"){
                alert("<%=basePath%>");
                window.location.href = "<%=basePath%>relax/index";
              } else {
                alert("登陆失败"+data);
                changeValidateCode();
              }
            }, "text");
  }
  //按回车登陆
  $(function(){
    $("#FF").keypress(function(e){
      if (event.keyCode==13) {
        loginPost();
      }
    });
  });

  //注册
  function registerPost(){
    //window.open（<%=request.getContextPath()%>）
    alert("<%=basePath%>register");
    window.location.href="<%=basePath%>register/index";
  }
</script>
</body>
</html>
