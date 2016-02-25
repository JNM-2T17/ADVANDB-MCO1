<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fish Count</title>
</head>
<body>
	<table>
		<tr>
			<th>Municipality</th>
			<th>Zone</th>
			<th>Barangay</th>
			<th>Equipment ID</th>
			<th>Fish Count</th>
		</tr>
		<c:forEach var="fish" items="${fishcount }">
			<tr>
				<td>${fish.mun }</td>
				<td>${fish.zone }</td>
				<td>${fish.brgy }</td>
				<td>${fish.aquanitype }</td>
				<td>${fish.fishcount }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>