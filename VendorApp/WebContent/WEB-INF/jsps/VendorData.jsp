<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>displaying vendor data</title>
</head>
<body>
	<h2>vendor data</h2>
	<table border="1">
		<tr>
			<th>Vender_Id</th>
			<th>Vendor_Name</th>
			<th>Vendor_Mail</th>
			<th>Location_Name</th>
			<th>Location_Type</th>
		</tr>
		<C:forEach items="${allVenData }" var="ven">
			<tr>
				<td><C:out value="${ven.venId }" /></td>
				<td><C:out value="${ven.venName }" /></td>
				<td><C:out value="${ven.venMail }" /></td>
				<td><C:out value="${ven.loc.locName }" /></td>
				<td><C:out value="${ven.loc.locType }" /></td>
				<td><a href='deleteVen?venId=<C:out value="${ven.venId }"/>'>Delete</a></td>
				<td><a href="fetchById?venId=<C:out value='${ven.venId }'/>">update</a></td>
				<%-- <td><a href="fetchById?venId=<C:out value='${ven.venId }'/>"><C:out
							value="${ven.venId }" /></a></td>
 --%>
			</tr>
		</C:forEach>
	</table>
</body>
</html>