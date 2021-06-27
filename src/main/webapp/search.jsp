<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Result</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body style="background-color: LightGray;">

<div class="container">
	<div align="center">
		<h2>Search Result</h2>
		<table class="table table-striped table-bordered table-hover box-shadow--16dp">
			<tr>
				<th>Vin</th>
				<th>Make</th>
				<th>Model</th>
				<th>Color</th>
				<th>Year</th>
				<th>salesRep id</th>
				<th>salesRep name</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${result}" var="car">
				<tr>
					<td>${car.vin}</td>
					<td>${car.make}</td>
					<td>${car.model}</td>
					<td>${car.color}</td>
					<td>${car.year}</td>
					<td>${car.salesRep.id}</td>
					<td>${car.salesRep.name}</td>
					<td>
					<a href="edit?vin=${car.vin}">Edit</a>
				    &nbsp;				    
				    <a href="delete?vin=${car.vin}">Delete</a></td>
					</tr>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>	
<button onclick="goBack()">Go Back</button>
<script>
function goBack() {
  window.history.back();
}
</script>
</body>
</html>