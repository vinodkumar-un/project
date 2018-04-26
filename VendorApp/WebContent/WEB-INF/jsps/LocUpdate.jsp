<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update location</title>
</head>
<body>
	<h1>updating the location page</h1>
	<form action="updateLoc" method="post">
		<table>
			<tr>
			</tr>
			<tr>
				<td>locId</td>
				<td><input type="text" name="locId" value="${locData.locId }"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td>locName</td>
				<td><input type="text" name="locName"
					value="${locData.locName }" /></td>
			</tr>
			<tr>
				<td>locType</td>
				<td><C:choose>
						<C:when test="${locData.locType eq 'Urban' }">
							<input type="radio" name="locType" value="Urban"
								checked="checked" />Urban
						<input type="radio" name="locType" value="Rural" />Rural
						</C:when>
						<C:otherwise>
							<input type="radio" name="locType" value="Urban" />Urban
						<input type="radio" name="locType" value="Rural" checked="checked" />Rural
						</C:otherwise>
					</C:choose></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
				<td><input type="reset" value="Clear" /></td>
			</tr>
		</table>
	</form>
</body>
</html>