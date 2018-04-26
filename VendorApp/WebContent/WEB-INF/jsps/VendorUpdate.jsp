<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to location udpate page...</h2>
	<form action="updateVen" method="post">
		<table>
			<tr>
				<td>Id</td>
				<td><input type="text" name="venId" value="${venData.venId }"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="venName"
					value="${venData.venName }" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="text" name="venMail"
					value="${venData.venMail }" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form>
</body>
</html>