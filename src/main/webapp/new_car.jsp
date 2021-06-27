<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Car</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body style="background-color:LightGray;">
    <div align="center">
        <h2>New Car</h2>
        <form:form action="save" method="post" modelAttribute="car">
            <table border="0" cellpadding="5">
            	<tr>
                    <td>vin: </td>
                    <td><form:input path="vin" /></td>
                </tr>
                <tr>
                    <td>make: </td>
                    <td><form:input path="make" /></td>
                </tr>
                <tr>
                    <td>model: </td>
                    <td><form:input path="model" /></td>
                </tr>
                <tr>
                    <td>color: </td>
                    <td><form:input path="color" /></td>
                </tr>  
                <tr>
                    <td>year: </td>
                    <td><form:input path="year" /></td>
                </tr>   
                <tr>
                    <td colspan="2"><input type="submit" value="Save"></td>
                </tr>                    
            </table>
        </form:form>
        <form action="${pageContext.request.contextPath}"><input type="Submit" value="Cancel"></form>
    </div> 
    <button onclick="goBack()">Go Back</button>

<script>
function goBack() {
  window.history.back();
}
</script>
</body>
</html>