<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Average Age of Death</title>
<link rel="stylesheet" href="<c:url value="/resources/cbms.css" />" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="selectQuery.jsp" />
	<script>
		document.getElementById("querySel").value = 3;
		formManager.updateForm({value : 3});
		document.getElementById("queryType").value = ${type };
		document.getElementById("val").value = ${val };
		document.getElementById("mdeady").value = ${mdeady };
	</script>
	<div class="container">
		<h1>Average Age of Death</h1>
		<h5>Total Row Count: ${fn:length(avgdeaths) }</h5>
		<h5>Query Execution Time: ${time }</h5>
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
					<td><fmt:formatNumber 
							value="${death.avg_death_age }"
							pattern="###.0000" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>