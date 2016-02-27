<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
	<div id="querySelect" class="container">
		<h1 id="selectLabel">Select Query</h1>
		<form id="theForm" onSubmit="return formManager.check()">
			<select id="querySelect" onChange="formManager.updateForm(this);">
				<option value="1" selected>Average OFW's Per Nuclear Family</option>
				<option value="2">Number of Children above a Particular Nutritional Index</option>
				<option value="3">Average Age of Death Divided by Sex and Geographical Location</option>
				<option value="4">Amount of Fish per Type Caught</option>
				<option value="5">Crop Densities</option>
				<option value="6">Amount of Aquatic Animals Caught Per Type of Aquatic Equipment</option>
				<option value="7">Number of Common Philhealth Beneficiaries</option>
			</select><br/>
			<select name="type">
				<option value="1" selected>Base</option>
				<option value="2">Heuristic Optimization</option>
				<option value="3">Indices</option>
				<option value="5">Views</option>
				<option value="4">Stored Procedures</option>
			</select>
			<div id="inputForm"></div>
			<div id="errors"></div>
			<input type="submit" value="Run Query" />
		</form>
		<script src="<c:url value="/resources/cbms.js" />" ></script>
	</div>