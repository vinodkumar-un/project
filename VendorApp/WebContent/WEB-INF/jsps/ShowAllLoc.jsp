<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>showing all location variables</title>
</head>
<body>
	<h1>LocationData...</h1>
	<a href="locExcelExport">DownloadExcel</a> |
	<a href="locPdfExport">DownloadPDF</a>
	<table border="1">
		<tr>
			<th>locationId</th>
			<th>locationName</th>
			<th>locationType</th>
		</tr>
		<C:forEach items="${listLoc }" var="loc">
			<tr>
				<td><C:out value="${loc.locId }" /></td>
				<td><C:out value="${loc.locName }" /></td>
				<td><C:out value="${loc.locType }" /></td>
				<td><a href="editLocById?locId=<C:out value='${loc.locId }'/>">Update</a></td>
				<td><a href="deleteLoc?locId=<C:out value='${loc.locId }'/>">Delete</a></td>
			</tr>
		</C:forEach>
	</table>
</body>
</html>