<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
out.println("<base href=\"" + basePath + "\">");
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link href="static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="static/h-ui/css/Person_login.css" rel="stylesheet" type="text/css" />
<link href="static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>会员后台登录</title>
<meta name="keywords" content="此网站主要为本公司用户服务,请勿使用其他违法行为">
<meta name="description" content="本公司主要业务为人工智能化!">
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header"></div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="manage/login" method="post">
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input id="u_Name" name="userName" type="text" placeholder="账户" class="input-text size-L" maxlength="15">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input id="u_pwd" name="userPassword" type="password" placeholder="密码" class="input-text size-L" maxlength="15">
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input class="input-text size-L" id="PickCodeInfo" name="regCode" type="text" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:" style="width:150px;">
          <%--<input type="text" readonly id="in_msg"/>--%>
          <img style="height:22px;" id="codeImg" alt="对不起,发生错误!"
               title="验证码" src="" />
          <a id="ch" href="login.jsp">看不清，换一张</a>
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input id="sub" type="button" onclick="return checkSubinfo()" style="margin-top: 3px; margin-left: 2px;" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer"> &copy; Copyright XY信息</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script>
      $(document).ready(function() {
          changeCode();
          $("#sub").click(function () {
              $("form").ajaxForm({
                  success:function (msg) {
                      if (msg=="正确"){
                          window.location.href="/index.html" //成功后跳转
                      }else{
                          layer.open({
                              type: 1,
                              area: ['300px','200px'],
                              fix: true, //不固定
                              maxmin: false,
                              shade:0.4,
                              title: '重要提示',
                              content: '<p style="text-align: center;font-size: 18px;font-family:楷体;">'+msg+'</p>'
                          });
                      }
                  },//回调函数
                  resetForm:true, //是否清除表单
                  timeout:3000,  //超时时间
              })
              $("form").submit();//提交
          })

          var m=${loginMsg};
          if(m!=''){
              layer.open({
                  type: 1,
                  area: ['300px','200px'],
                  fix: true, //不固定
                  maxmin: false,
                  shade:0.4,
                  title: '重要提示',
                  content: '<p style="text-align: center;font-size: 18px;font-family:楷体; color: red;">'+m+'</p>'
              });
          }

      });
      function changeCode() {
          $("#codeImg").attr("src", '<%=basePath.concat("code")%>');
      }

      function checkSubinfo() {
          var _uname=$("#u_Name").val();
          var _upwd=$("#u_pwd").val();
          var _code=$("#PickCodeInfo").val();
          if (_uname==''||_uname==null){
              layer.open({
                  type: 1,
                  area: ['300px','200px'],
                  fix: false, //不固定
                  maxmin: true,
                  shade:0.4,
                  title: '重要提示',
                  content: '<p style="text-align: center;font-size: 24px;font-family:楷体;">您的账户名不能为空!</p>'
              });
              changeCode();
          }else if (_upwd==''||_upwd==null){
              layer.open({
                  type: 1,
                  area: ['300px','200px'],
                  fix: false, //不固定
                  maxmin: true,
                  shade:0.4,
                  title: '重要提示',
                  content: '<p style="text-align: center;font-size: 24px;font-family:楷体;">您的密码不能为空!</p>'
              });
          }else if (_code==null||_code==''||_code=="验证码:"){
              layer.open({
                  type: 1,
                  area: ['300px','200px'],
                  fix: false, //不固定
                  maxmin: true,
                  shade:0.4,
                  title: '重要提示',
                  content: '<p style="text-align: center;font-size: 24px;font-family:楷体; color: red;">您的验证码不能为空!</p>'
              });
          }
      }
</script>
</body>
</html>