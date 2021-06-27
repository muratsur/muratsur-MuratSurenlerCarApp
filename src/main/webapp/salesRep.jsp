<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sales Representative</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body style="background-color: LightGray;">


	<div align="center">
	
		<h2>Sales Representative</h2>
		<form method="get" action="lookUp">
			<input type="text" name="keyword" /> &nbsp; <input type="submit"
				value="Search" />
		</form>
		<h3>
			<a href="newSal">New Representative</a>
		</h3>
		<div class="container">
			<table
				class="table table-striped table-bordered table-hover box-shadow--16dp">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Office Code</th>
					<th>Action</th>
				</tr>
				<s:forEach items="${listSalesRep }" var="salesRep">
					<tr>
						<td>${salesRep.id}</td>
						<td>${salesRep.name}</td>
						<td>${salesRep.officeCode}</td>

						<td><a href="sedit?id=${salesRep.id}">Edit</a> &nbsp; <a
							href="remove?id=${salesRep.id}">Delete</a></td>
					</tr>
				</s:forEach>
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