<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Average Age of Death</title>
</head>
<body>
	<table>
		<tr>
			<th>Municipality</th>
			<th>Zone</th>
			<th>Barangay</th>
			<th>Gender</th>
			<th>Average Age of Death</th>
		</tr>
		<c:forEach var="death" items="${avgdeaths }">
			<tr>
				<td>${death.mun }</td>
				<td>${death.zone }</td>
				<td>${death.brgy }</td>
				<td>${death.mdeadsx }</td>
				<td>${death.avg_death_age }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>