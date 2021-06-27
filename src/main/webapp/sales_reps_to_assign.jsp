<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body style="background-color:LightGray;">
<div align="center">
    <h2>Select a sales representative for Vin Number ${car.vin} ${car.make}</h2>
    <div class="container">
    <table class="table table-striped table-bordered table-hover box-shadow--16dp">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th></th>
        </tr>
        <c:forEach items="${listSalesRep}" var="salesRep">
        <tr>
            <td>${salesRep.id}</td>
            <td>${salesRep.name}</td>
            <td>
                <a href="assign_rep_to_car?carVin=${car.vin}&repId=${salesRep.id}">Assign</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>
</div>
</body>
</html>