<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>上诠注册</title>

  <!-- CSS -->
  <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/form-elements.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Favicon and touch icons -->
  <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/ico/favicon.png">
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=request.getContextPath()%>/resources/ico/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=request.getContextPath()%>/resources/ico/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=request.getContextPath()%>/resources/ico/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath()%>/resources/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>

<!-- Top menu -->
<nav class="navbar navbar-inverse navbar-no-bg" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/login/index.html">首页</a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="top-navbar-1">
      <ul class="nav navbar-nav navbar-right">
        <li>
							<span class="li-social">
								<a href="#"><i class="fa fa-facebook"></i></a> 
								<a href="#"><i class="fa fa-twitter"></i></a> 
								<a href="#"><i class="fa fa-envelope"></i></a> 
								<a href="#"><i class="fa fa-skype"></i></a>
							</span>
        </li>
      </ul>
    </div>
  </div>
</nav>

<!-- Top content -->
<div class="top-content">

  <div class="inner-bg">
    <div class="container">
      <div class="row">
        <div class="col-sm-8 col-sm-offset-2 text">
          <h1><strong>上诠</strong> 注册表单 </h1>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-6 col-sm-offset-3 form-box">

          <form role="form" id="FF" action="doRegister" onsubmit="return check()" method="post" class="registration-form">

            <fieldset>
              <div class="form-top">
                <div class="form-top-left">
                  <h3>步 1 / 2</h3>
                  <p>告诉我们你是谁:</p>
                </div>
                <div class="form-top-right">
                  <i class="fa fa-user"></i>
                </div>
              </div>
              <div class="form-bottom">
                <div class="form-group">
                  <label class="sr-only" for="form-first-name">First name</label>
                  <input type="text" name="firstName" placeholder="姓什..." class="form-first-name form-control" id="form-first-name">
                </div>
                <div class="form-group">
                  <label class="sr-only" for="form-last-name">Last name</label>
                  <input type="text" name="lastName" placeholder="名谁..." class="form-last-name form-control" id="form-last-name">
                </div>
                <div class="form-group">
                  <label class="sr-only" for="form-about-yourself">About yourself</label>
				                        	<textarea name="aboutYourself" placeholder="关于你自已..."
                                                      class="form-about-yourself form-control" id="form-about-yourself"></textarea>
                </div>
                <button type="button" class="btn btn-next">下一步</button>
              </div>
            </fieldset>

            <fieldset>
              <div class="form-top">
                <div class="form-top-left">
                  <h3>步二 2 / 2</h3>
                  <p>设 定 你 的 帐 号:</p>
                </div>
                <div class="form-top-right">
                  <i class="fa fa-key"></i>
                </div>
              </div>
              <div class="form-bottom">
                <div class="form-group">
                  <label class="sr-only" for="form-email">Email</label>
                  <input type="text" name="account" placeholder="帐号" class="form-email form-control" id="form-email">
                </div>
                <div class="form-group">
                  <label class="sr-only" for="form-password">Password</label>
                  <input type="password" name="passwd" placeholder="密码..." class="form-password form-control" id="form-password">
                </div>
                <div class="form-group">
                  <label class="sr-only" for="form-repeat-password">确认密码</label>
                  <input type="password" name="form-repeat-password" placeholder="确认密码..."
                         class="form-repeat-password form-control" id="form-repeat-password">
                </div>
                <button type="button" class="btn btn-previous">上一步</button>
                <button type="button" class="btn" onclick="register()">注册</button>
              </div>
            </fieldset>
          </form>

        </div>
      </div>
    </div>
  </div>

</div>


<!-- Javascript -->
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.11.1.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.backstretch.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/retina-1.1.0.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/scripts.js"></script>


<!--[if lt IE 10]>
<script src="<%=request.getContextPath()%>/resources/js/placeholder.js"></script>
<![endif]-->
<script>
  //注册
  function register(){
    check();
    $.post("doRegister",
            $("#FF").serialize(),
            function(data){
              if(data == "SUCCESS"){
                alert("注册成功");
                // window.top.location.href =
              } else if(data == "FAILsss") {
                alert("登陆失败");
                changeValidateCode();
              }else{
                alert("渲染失败")
              }
            }, "text");

  }
  //表单提交前验证
  function check(){
    var passwd = $("#form-password").val();
    var repasswd = $("#form-repeat-password").val();
    if(passwd !== repasswd){
      alert("密码与确认密码不一致，请重新输入！");
      $("#form-password").val("");
      $("#form-repeat-password").val("");
      $("#form-password").focus;
    }
  }
</script>

</body>

</html>