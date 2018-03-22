<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/useradd.do" method = "post">
		name:<input type = "text" name = "name"></br>
		password<input type = "text" name = "password"></br>
		age<input type = "text" name = "age"></br>
		email<input type = "text" name = "email"></br>
		adress<input type = "text" name = "adress"></br>
		<input type="submit" value = "提交"> 
	
	</form>
</body>
</html>