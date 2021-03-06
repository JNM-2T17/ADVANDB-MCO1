<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Common Beneficiaries</title>
<link rel="stylesheet" href="<c:url value="/resources/cbms.css" />" />
<link rel="shortcut icon" href="<c:url value="/resources/logo.png" />" /> 
</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="selectQuery.jsp" />
	<script>
		document.getElementById("querySel").value = 7;
		formManager.updateForm({value : 7});
		document.getElementById("queryType").value = ${type };
		document.getElementById("val").value = ${val };
	</script>
	<div class="container">
		<h1>Common Beneficiaries</h1>
		<h5>Total Row Count: ${fn:length(commonbeneficiaries) }</h5>
		<h5>Query Execution Time: ${time }</h5>
		<table>
			<tr>
				<th>Municipality</th>
				<th>Zone</th>
				<th>Barangay</th>
				<th>Common Beneficiary Count</th>
			</tr>
			<c:forEach var="bene" items="${commonbeneficiaries }">
				<tr>
					<td>${bene.mun }</td>
					<td>${bene.zone }</td>
					<td>${bene.brgy }</td>
					<td>${bene.benefCount }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>