<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catch Ratios</title>
</head>
<body>
	<table>
		<tr>
			<th>Municipality</th>
			<th>Zone</th>
			<th>Barangay</th>
			<th>Equipment Count</th>
			<th>Catch Volume</th>
			<th>Catch-per-Equipment Ratio</th>
		</tr>
		<c:forEach var="curcatch" items="${catchratios }">
			<tr>
				<td>${curcatch.mun }</td>
				<td>${curcatch.zone }</td>
				<td>${curcatch.brgy }</td>
				<td>${curcatch.totalequip }</td>
				<td>${curcatch.totalvol }</td>
				<td>${curcatch.catchPerEquip }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>