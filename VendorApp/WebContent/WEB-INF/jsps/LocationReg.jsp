<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="master.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location Registration data into database</title>
</head>
<body>
	<form name="locationform" action="insertLoc" method="post"
		onsubmit="return doValidateLoc();">
		<table border="1px" style="color: blue;">
			<!-- <tr>
				<td>locId</td>
				<td><input type="text" name="locId" /></td>
				<td><span id="locIdErr" class="ab"></span></td>
			</tr> -->
			<tr>
				<td>locName</td>
				<td><input type="text" name="locName" /></td>
				<td><span id="locNameErr" class="ab"></span></td>
			</tr>
			<tr>
				<td>locType</td>
				<td><input type="radio" name="locType" value="Urban" />Urban</td>
				<td><input type="radio" name="locType" value="Rural" />Rural</td>
				<td><span id="locTypeErr"></span></td>
			</tr>
			<tr>
				<td><input type="submit" value="Insert" /></td>
				<td><input type="reset" value="Clear" /></td>
			</tr>
		</table>
	</form>
	${modelData }
	<a href="searchAllLoc">showAllLocations</a>
</html>