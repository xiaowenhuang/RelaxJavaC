<%--
  Created by IntelliJ IDEA.
  User: sven
  Date: 2016/11/3
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form id="my_question" action="/setAQuestion/add" method="post" >
<div class="container">
  <div class="row clearfix">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title">
          请出题：
        </h3>
      </div>
      <div class="panel-body">
        难度：
      <select id="difficulty" name="difficulty">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
      </select>

        答题时间:
        <select id="answerTime" name="answerTime">
          <option value="30">30秒</option>
          <option value="60">1分钟</option>
          <option value="120">2分钟</option>
          <option value="300">5分钟</option>
          <option value="600">10分钟</option>
        </select><br/>
        <hr/>
        <div class="col-md-14 column">
          <div class="row clearfix">
            <div class="input-group">
              <div class="col-md-5 column">
              <textarea type="text" style="width:400px;height: 180px" class="form-control" name="question"
                    placeholder="请输入题目内容，输入完成后，请先校验再作操作"></textarea>
              </div>
              <div class="col-md-2 column center-align">
              <button type="button" class="btn btn-warning">校验</button>
              </div>
              <div class="col-md-5 column">
                <textarea type="text"  style="width:400px;height: 180px"
                          readonly="readonly" class="form-control" id="dbAnswer" name="dbAnswer">111</textarea>
              </div>

            </div>
          </div>
        </div>


      </div>
      <div class="panel-heading">
        <h3 class="panel-title">
          请给出您的答案：
        </h3>
      </div>
      <div class="panel-body">
        <div class="input-group">
          <textarea type="text" style="width:700px;height: 180px" class="form-control" name="result"
                    placeholder="答案"></textarea>
        </div>
      </div>
      <div class="panel-footer">
        <button type="submit" class="btn btn-default"  >提交</button>
      </div>
    </div>
  </div>
</div>

</form>
</body>
</html>
