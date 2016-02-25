<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crop Volume</title>
</head>
<body>
	<h1>Crop Volume</h1>
	<h5>Total Row Count: ${fn:length(cropvolume) }</h5>
	<h5>Query Execution Time: ${time }</h5>
	<table>
		<tr>
			<th>Municipality</th>
			<th>Zone</th>
			<th>Barangay</th>
			<th>Total Crops</th>
			<th>Crop Area</th>
			<th>Crop Density</th>
		</tr>
		<c:forEach var="crop" items="${cropvolume }">
			<tr>
				<td>${crop.mun }</td>
				<td>${crop.zone }</td>
				<td>${crop.brgy }</td>
				<td>${crop.totalcrop }</td>
				<td>${crop.totalArea }</td>
				<td>${crop.cropDensity }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>