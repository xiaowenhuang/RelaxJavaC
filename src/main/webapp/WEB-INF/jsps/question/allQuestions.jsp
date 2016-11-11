<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/3
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table class="table table-bordered">
  <thead>
  <tr>
    <th><input type="checkbox" id="all" onclick="selectAll()"/></th>
    <th>序号</th>
    <th>题目</th>
    <th>操作</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${questionList}" var="list" varStatus="status">
  <tr <c:if test="${status.index%2!=0}">style='background-color:#ECF6EE;'</c:if>>
    <td><input type="checkbox" name="id" value=${list.id} /></td>
    <td>${status.index+1}</td>
    <td>${list.question}</td>
    <td>edit</td>
  </tr>

  </c:forEach>
  </tbody>


</table>

</body>
</html>
