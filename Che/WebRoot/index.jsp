<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<% String code = request.getParameter("source");
	out.print(code);
	%>
<<<<<<< .mine
<form action="http://localhost:8080/che/mac/party/IF00051" method="post">
=======
<form action="http://www.ycombo.com/che/mac/party/IF00051" method="post">
>>>>>>> .r1099
创建用户id<input type="text" name="uuid"><br>
活动id<input type="text" name="c_id"><br>
派对类型<input type="text" name="p_type"><br>
派对名称<input type="text" name="p_title"><br>
派对地点<input type="text" name="p_local"><br>
精度<input type="text" name="lng"><br>
纬度<input type="text" name="lat"><br>
派对城市<input type="text" name="p_city"><br>
派对时间<input type="text" name="p_stime"><br>
派对信息<input type="text" name="p_info"><br>
电话<input type="text" name="p_phone"><br>
联合创建人<input type="text" name="users"><br>
碰头地点<input type="text" name="p_invite"><br>
<input type="submit"value="确定">
<input type="reset" name="重置"><br>
</form>
</body>
</html>