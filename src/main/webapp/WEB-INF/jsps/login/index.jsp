<%--
  Created by IntelliJ IDEA.
  User: Sven
  Date: 2016/10/19
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆首页</title>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Public/H-/static/h-ui/css/H-ui.min.css" />
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Public/H-/static/h-ui.admin/css/H-ui.admin.css" />
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Public/H-/lib/Hui-iconfont/1.0.7/iconfont.css" />
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Public/H-/static/h-ui.admin/skin/default/skin.css" id="skin" />
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Public/H-/static/h-ui.admin/css/style.css" />
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Public/H-/static/h-ui.admin/css/H-ui.login.css" />

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
            <input id="userNum" name="userNum" type="text" placeholder="账户" class="input-text size-L">
          </div>
        </div>
        <div class="row cl">
          <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
          <div class="formControls col-xs-8">
            <input id="userPsw" name="userPsw" type="password" placeholder="密码" class="input-text size-L">
          </div>
        </div>
        <div class="row cl">
          <div class="formControls col-xs-8 col-xs-offset-3">
            <input class="input-text size-L" type="text" placeholder="验证码"
                   name="validateCode" id="validateCode"
                   onblur="if(this.value==''){this.value='验证码:'}"
                   onclick="if(this.value=='验证码:'){this.value='';}"
                   value="验证码:" style="width:150px;">
            <img src="captcha" id="validateCodeImg" onclick="changeValidateCode()">
            <a id="kanbuq" href="javascript:changeValidateCode();">看不清，换一张</a> </div>
        </div>
        <div class="row cl">
          <div class="formControls col-xs-8 col-xs-offset-3">
            <input type="button" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;"
                   onclick="loginPost()">
          </div>
        </div>
      </form>
    </div>
  </div>
  <div class="footer"><a href='http://www.aspic.com.cn' target='_blank'>ASPIC</a></div>

</article>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/Public/H-/lib/jquery/1.9.1/jquery.min.js"></script>
<script>
  //更换校验码
  function changeValidateCode(){
    $("#validateCodeImg").attr("src","captcha?_="+Math.random());
  }
  //登陆
  function loginPost(){
    $.post("loginPost",
            $("#FF").serialize(),
            function(data){
              if(data == "SUCCESS"){
                alert("<%=basePath%>");
                window.top.location.href = "<%=basePath%>";
              } else {
                alert("登陆失败");
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
</script>
</body>
</html>
