<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/root/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Index</title>
<link href="${base}/front/css/not_login.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="main">
	<div class="rite">
	<div class="login_area">
	<form action="index.do">
    	<input type="text" id="email" class="login_username" placeholder="用户名"/>
        <input type="password" id="password" class="login_username" placeholder="密码"/>
        <input type="submit" id="submit" value="登录" class="login_btn"/>
    </form>
    </div>
    <div class="logon_area">
    <form action="register.do" method="post">
    	<div class="title">欢迎加入</div>
        <ul>
    	<li><input type="text" name="nick" class="logon_username" placeholder="昵称"/></li>        
        <li><input type="email" name="email" class="logon_username" placeholder="电子邮件地址"/></li>
        <li><input type="password" name="password" class="logon_username" placeholder="密码"/></li>
        <li><input type="submit" id="submit" value="立即注册>>" class="logon_btn"/></li>
        </form>
        </ul>
    </div>    
    </div>
</div>
</body>
</html>

