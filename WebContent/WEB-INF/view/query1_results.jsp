<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Average OFWs Per Nuclear Family</title>
<link rel="stylesheet" href="<c:url value="/resources/cbms.css" />" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="selectQuery.jsp" />
	<script>
		document.getElementById("querySel").value = 1
		formManager.updateForm({value : 1});
		document.getElementById("queryType").value = ${type };
		document.getElementById("val").value = ${val };
	</script>
	<div class="container">
		<h1>Average OFWs Per Nuclear Family</h1>
		<h5>Total Row Count: ${fn:length(avgofws) }</h5>
		<h5>Query Execution Time: ${time }</h5>
		<table>
			<tr>
				<th>Municipality</th>
				<th>Zone</th>
				<th>Barangay</th>
				<th>Purok</th>
				<th>Nuclear Families</th>
				<th>OFWs</th>
				<th>Average OFWs per Nuclear Family</th>
			</tr>
			<c:forEach var="ofw" items="${avgofws }">
				<tr>
					<td>${ofw.mun }</td>
					<td>${ofw.zone }</td>
					<td>${ofw.brgy }</td>
					<td>${ofw.purok }</td>
					<td>${ofw.sumNuclearFamilies }</td>
					<td>${ofw.sumOFWs }</td>
					<td><fmt:formatNumber 
							value="${ofw.avgOFWsPerNuclearFamily}"
							pattern="###.0000" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>