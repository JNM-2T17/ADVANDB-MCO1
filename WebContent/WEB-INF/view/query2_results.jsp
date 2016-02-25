<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Country ID</th>
			<th>Province ID</th>
			<th>Nutritional Status</th>
			<th>Count</th>
		</tr>
		<c:forEach var="kid" items="${healthykids }">
			<tr>
				<td>${kid.country_resid }</td>
				<td>${kid.prov_resid_code }</td>
				<td>${kid.nutStatus }</td>
				<td>${kid.nutCount }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>