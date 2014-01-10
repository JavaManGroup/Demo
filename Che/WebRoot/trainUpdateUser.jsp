<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="http://localhost:8080/che/mac/user/IF00011" method="post">
创建用户id<input type="text" name="uuid"><br>
用户昵称<input type="text" name="user_nick"><br>
用户图片<input type="text" name="user_pic"><br>
用户性别<input type="text" name="user_sex"><br>
用户年龄<input type="text" name="user_age"><br>
地点<input type="text" name="user_local"><br>
个人介绍<input type="text" name="user_des"><br>
<input type="submit"value="确定">
<input type="reset" name="重置"><br>
</form>
</body>
</html>