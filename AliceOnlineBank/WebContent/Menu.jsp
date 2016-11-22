<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

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
	<div align="center">
		Welcome
		<%=id%><hr />
	</div>
	<div align="center">
		<!-- <input type="hidden" name="submitType" id="submitType"/>   -->
		<form id="func" action="Menu" method="post">
			<div>
				<div style="margin: 0 auto;">
					deposit<input type="radio" name="select" value="deop" checked="checked"><input type="text" id="deposit" size="10"> 
				</div>
			</div>

			<div>
				<div>
					Withdrawal<input type="radio" name="select" value="with"><input type="text" id="withdrawal" size="10">
				</div>
			</div>
			<div>
				<div>
					Balance : <input type="text" id="balance" size="10">
				</div>
			</div>
			<div><input type="submit" value="입금/인출"></div>
		</form>
	</div>
</body>
</html>