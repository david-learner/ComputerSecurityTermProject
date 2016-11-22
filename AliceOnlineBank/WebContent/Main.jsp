<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alice's Online Bank</title>
</head>
<body>
	
	<div align="center"><img src="images/bank-and-security.jpg" width="400px" height="300px"></div>
	<div align="center">
		<form action="Login" method="post">
			ID  : <input type="text" name="id" size="10"><br/>
			PWD : <input type="password" name="pwd" size="10"><br/>
			<input type="button" value="회원가입" onClick="location.href='Register.jsp';">
			<input type="submit" value="로그인"><br/>	
		</form>
	</div>
</body>
</html>