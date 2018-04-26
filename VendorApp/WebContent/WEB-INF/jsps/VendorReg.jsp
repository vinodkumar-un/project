<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="master.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to vendor page</h2>
	<form name="venform" action="insertVen" method="post"
		enctype="multipart/form-data" onsubmit="return doValidateLoc();">
		<pre>
	Id	  	:<input type="text" name="venId" />
	Name	:<input type="text" name="venName" />
			 <span id="venNameErr" class="ab"></span>
	Mail	:<input type="text" name="venMail" />
			 <span id="venMailErr" class="ab"></span>
	Location:<select name="loc.locId">
       			<C:forEach items="${locData}" var="loc">
        			<C:out value="${loc.locId }" />
					<C:out value="${loc.locName}" />
					<C:out value="${loc.locType }" />
       			</C:forEach>
			</select>
			 <input type="file" name="file" />
			 <input type="submit" value="Insert" />
			 <input type="reset" value="Clear" />
		</pre>
	</form>
	${venData }
	<a href="allVen">view all vendors</a>
</body>
</html>