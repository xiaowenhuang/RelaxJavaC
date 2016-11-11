<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>答题</title>

</head>
<body>
<form action="#" method="post">
<div class="container">
  <div class="row clearfix">
    <div class="col-md-12 column">
      <h1 class="text-center">
        基础真的很重要
      </h1>
      <hr/>
    </div>
  </div>
  <div class="row clearfix">
    <div class="col-md-6 column">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">
            亲爱的主人，您的题目是：
          </h3>
        </div>
        <div class="panel-body" id="questionLocation" >
          <label>${questionBank.question}</label>
        </div>
      </div>
    </div>
    <div class="col-md-6 column">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">
            请输入您的答案：
          </h3>
        </div>

        <textarea  class="panel-body" style="width:530px;" type="text" id="answer" name="result" ></textarea>

        <div class="panel-footer">
          <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal">
            提交答案
          </button>
        </div>
      </div>
    </div>
    <!-- 模态框（Modal） -->
    <div class="modal fade" style="display: block; padding-left: 300px;padding-right: 700px;top: 350px"
         id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="myModalLabel">标准答案</h4>
          </div>
          <div class="modal-body">
            <textarea type="text" style="height: 100px" class="form-control" id="correctAnswer"
                      name="result" readonly="readonly" >${questionBank.result}
            </textarea>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            <button type="button" class="btn btn-primary">确定</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div><!-- modal end-->

  </div>
</div>

</form>
</body>
</html>
