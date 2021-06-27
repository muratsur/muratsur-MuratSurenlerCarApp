<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Create an account</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body style="background-color: LightGray;">
	
	<div class="container">
		<div class="row">
			<div class="col">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>

					<h2>
						Welcome ${pageContext.request.userPrincipal.name} | <a
							onclick="document.forms['logoutForm'].submit()">Logout</a>
					</h2>
				</c:if>
				
				<h3>
					<a href="salesRep">Manage Sales Representatives</a>
				</h3>
			</div>
			<div class="col">
				
			</div>

		</div>
	</div>
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

	<div align="center">
		<h2>Car Manager Murat</h2>
		<form method="get" action="search">
			<input type="text" name="keyword" /> &nbsp; <input type="submit"
				value="Search" />
		</form>
		<h3>
			<a href="new">Add New Car</a>
		</h3>
		<div class="container">

			<table class="table table-striped table-bordered table-hover box-shadow--16dp">
				<tr>
					<th>Vin</th>
					<th>make</th>
					<th>Model</th>
					<th>Color</th>
					<th>Year</th>
					<th>salesRep id</th>
					<th>salesRep name</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${listCar}" var="car">
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
						 <a href="assign?vin=${car.vin}">Assign</a>
						&nbsp;
						<a href="delete?vin=${car.vin}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>



</body>
</html>
