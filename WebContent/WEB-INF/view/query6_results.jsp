<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catch Ratios</title>
<link rel="stylesheet" href="<c:url value="/resources/cbms.css" />" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="selectQuery.jsp" />
	<script>
		formManager.updateForm({value:2});
		document.getElementById("queryType").value = ${type };
		document.getElementById("val").value = ${val };
		document.getElementById("aquanitype").value = ${aquanitype };
		document.getElementById("aquaequiptype").value = ${aquaequiptype };
	</script>
	<div class="container">
		<h1>Catch Ratios</h1>
		<h5>Total Row Count: ${fn:length(catchratios) }</h5>
		<h5>Query Execution Time: ${time }</h5>
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
					<td><fmt:formatNumber 
							value="${curcatch.catchPerEquip}"
							pattern="###.0000" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>