{% extends "base.html" %}

{% block  title %}
用户注册
{% endblock %}

{% block css %}
<link href="/static/css/register.css" rel="stylesheet">{% endblock %}
{% block content %}
{#    <body class = "cs-body">#}
<!--注册表单-->
<div class="container-fluid login_form">
  <div class = "col-md-offset-2 col-md-8">
    <form action="." method="post" accept-charset="utf-8" enctype="multipart/form-data">
      {% if form.errors  %}
      {% include "users/partials/errors.html" %}
      {% endif %}
      {% csrf_token %}
      {% for field in form %}
      <div class="form-group" textalign="left">
        {% include "users/partials/field.html" %}
      </div>
      {% endfor %}
      <button type="submit" class="btn btn-primary">提交</button>
    </form>
  </div>
</div>
{#    </body>#}
{% endblock %}

{% block js %}
<script src = "/static/js/register.js"></script>
<script src = "/static/js/field.js"></script>
{% endblock %}