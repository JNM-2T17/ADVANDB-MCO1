<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Healthy Kids</title>
<link rel="stylesheet" href="<c:url value="/resources/cbms.css" />" />
<link rel="shortcut icon" href="<c:url value="/resources/logo.png" />" /> 
</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="selectQuery.jsp" />
	<script>
		document.getElementById("querySel").value = 2;
		formManager.updateForm({value : 2});
		document.getElementById("queryType").value = ${type };
		document.getElementById("val").value = ${val };
		document.getElementById("minNutIndex").value = ${minNutIndex };
	</script>
	<div class="container">
		<h1>Healthy Kids</h1>
		<h5>Total Row Count: ${fn:length(healthykids) }</h5>
		<h5>Query Execution Time: ${time }</h5>
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
	</div>
</body>
</html>