<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String id = "";
	try {
		id = (String) session.getAttribute("id");

		if (id == null | id.equals("")) {
			response.sendRedirect("Main.jsp");
		}
	} finally {
	}
	
	/* String balance =  */
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AOB Menu Page</title>
</head>
<!-- <script type="text/javascript">
	function submit(index){
		var input = document.getElementById("submitType");
		if(action==1) {
			alert("1");
			input.value = "deposit";
		}else if(action==2) {
			input.value = "withdrawal";
		}
		
		document.func.submit();
	}
	
</script> -->
<body>
	<div align="center">Welcome	<%=id%><hr/></div>
	<div align="center">
		<form name="func" action="Menu" method="post">
			
			Deposit
			<input type="text" name="deposit" size="10">
			<input type="button" value="Submit" onclick="submit(1)"><br /><br /> 
			
			
			Withdrawal
			<input type="text" name="withdrawal" size="10">
			<input type="button" value="Submit" onclick="submit(2)"><br /><br />
			
			<!-- <input type="hidden" name="submitType" id="submitType"/>  -->
			<input type="submit" value="제출"><br/>	
			Balance	: <input type="text" name="balance" size="10">
			
		</form>
	</div>
</body>
</html>