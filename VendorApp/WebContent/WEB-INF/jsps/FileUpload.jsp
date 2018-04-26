<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Document Page</title>
</head>

<body>
	<%@include file="master.jsp"%>
	<h1>Welcome to Document Page!!</h1>
	<form action="uploadDoc" method="post" enctype="multipart/form-data">
		<pre>
		Id:<input type="text" name="fileId" />
		Select:<input type="file" name="filessobj" />
		<input type="submit" value="Upload" />
		</pre>
	</form>
	<table border="1">
		<tr>
			<th>FileId</th>
			<th>FileName</th>
			<th>downloadlink</th>
		</tr>
		<C:forEach items="${obList }" var="fob">
			<tr>
				<td><C:out value="${fob[0] }" /></td>
				<td><C:out value="${fob[1] }" /></td>
				<td><a href="downloadFile?fileId=<C:out value='${fob[0] }'/>">download</a></td>
			</tr>
		</C:forEach>
	</table>
	** click on file name to download

</body>
</html>