<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert the customer</title>
</head>
<body>
	<h1>Welcome to Customer Registration page</h1>
	<form action="insertCust" method="post">
		<pre>
			CustName	:<input type="text" name="custName" /> 
			CustEmail	:<input type="text" name="custEmail" />
			CustRegNum	:<input type="text" name="custRegNum" />
			CustAddress	:<textarea rows="3" cols="15" name="custAddrss"></textarea>
			CustType	:<select name="custType">
							<option value="-1">--select--</option>
							<option>Seller</option>
							<option>Consumer</option>
						</select> 
						<input type="submit" value="Insert" /> 
						<input type="reset" value="Clear" />
				</pre>
	</form>
	${msg }
</body>
</html>