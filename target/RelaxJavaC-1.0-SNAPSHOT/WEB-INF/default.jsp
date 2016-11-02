
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="${ctx }/resources/bootstrap/css/bootstrap.min.css" />
  <link rel="stylesheet" href="${ctx }/resources/font-awesome/css/font-awesome.css"/>
  <script src="${ctx }/resources/js/jquery-1.11.3.min.js"></script>
  <script src="${ctx }/resources/bootstrap/js/bootstrap.min.js"></script>
  <sitemesh:write property="head" />

  <!-- 放置于此处，以便覆盖每个页面中datatable.css中的样式 -->
  <link rel="stylesheet" href="${ctx }/resources/css/matrix-style.css" />
  <link rel="stylesheet" href="${ctx }/resources/css/matrix-media.css" />
  <title><sitemesh:write property="title" default="Aspic"/></title>
</head>
<body>

<!--Header-part-->
<div id="header">
  <h1><a href="#">Aspic</a></h1>
</div>
<!--close-Header-part-->


<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
    <li  class="dropdown" id="profile-messages" >
      <a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle">
        <i class="icon icon-user"></i>
        <span class="text">我</span><b class="caret"></b>
      </a>
      <ul class="dropdown-menu">
        <li><a href="${ctx}/userinfo/edit"><i class="icon-user"></i> 个人信息</a></li>
        <li class="divider"></li>
        <li><a href="${ctx}/userinfo/showPassword"><i class="icon-check"></i>修改密码</a></li>
        <li class="divider"></li>
        <li><a href="${ctx }/logout"><i class="icon-key"></i> 退出</a></li>
      </ul>
    </li>

  </ul>
</div>

<div id="sidebar">
  <ul>
    <li><a href="${ctx }/relax/index"><i class="icon iconfont">&#xe604;</i> <span>答题</span></a></li>
    <li><a href="${ctx }/setAQuestion/list"><i class="icon iconfont">&#xe60b;</i> <span>出题</span></a></li>
    <li><a href="${ctx }/setAQuestion/list"><i class="icon iconfont">&#xe60b;</i> <span>我的题库</span></a></li>
  </ul>
</div>
<!--sidebar-menu-->

<!--main-container-part-->
<div id="content">
  <sitemesh:write property="body" />
</div>

<div class="row-fluid">
  <div id="footer" class="span12"> 2016 &copy; Copyright. Aspic</div>
</div>
<!--end-Footer-part-->
</body>
</html>