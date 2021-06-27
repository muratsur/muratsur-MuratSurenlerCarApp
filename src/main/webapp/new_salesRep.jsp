<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Sales Representative</title>
<link href="${contextPath}/resources/css/common.css"
	rel="stylesheet">
</head>
<body style="background-color:LightGray;">
    <div align="center">
        <h2>New Sales Representative</h2>
        <form:form action="add" method="post" modelAttribute="salesRep">
            <table class="table table-striped table-bordered table-hover box-shadow--16dp">
                <tr>
                    <td>Name: </td>
                    <td><form:input path="name" /></td>
                </tr>
                <tr>
                    <td>Office Code: </td>
                    <td><form:input path="officeCode" /></td>
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