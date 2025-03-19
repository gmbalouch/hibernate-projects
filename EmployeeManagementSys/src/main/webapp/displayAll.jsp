<%@ page import="java.util.List" %>
<%@ page import="com.entities.Employee" %>  
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    
    <title>Employee Management System</title>
   <%@include file="allComponents/allCss.jsp"%>
</head>
<body>

<%@include file="allComponents/navbar.jsp"%>

<div class="container mt-4">

	<%
    String message = (String) session.getAttribute("message");
    String messageType = (String) session.getAttribute("messageType");
    if (message != null) {
	%>
    	<div class="alert alert-<%= messageType %> alert-dismissible fade show text-center" role="alert">
        	<%= message %>
        	<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
    	</div>
	<%
    	session.removeAttribute("message");
    	session.removeAttribute("messageType");
    	}
	%>
    <h2 class="text-center">All Employees</h2>

    <div class="row justify-content-center">
        <%
            List<Employee> employees = (List<Employee>) request.getAttribute("employees");
            if (employees != null && !employees.isEmpty()) {
                for (Employee emp : employees) {
        %>
        <div class="col-md-10">
            <div class="card mb-3 shadow">
                <div class="card-body">
                    <h5 class="card-title"><b>Emp ID:</b> <%= emp.getEmp_id() %></h5>
                    <p><b>Name:</b> <%= emp.getName() %></p>
                    <p><b>Gender:</b> <%= emp.getGender() %></p>
                    <p><b>Address:</b> <%= emp.getAddress() %></p>
                    <p><b>Mobile:</b> <%= emp.getMobile_no() %></p>
                    <p><b>Email:</b> <%= emp.getEmail() %></p>
                    <a href="deleteEmployee?id=<%= emp.getEmp_id() %>" class="btn btn-danger">Delete</a>
                    <a href="<%= request.getContextPath() %>/updateEmploye.jsp?id=<%= emp.getEmp_id()%>" class="btn btn-primary">Update</a>
                </div>
            </div>
        </div>
        <%
                }
            } else {
        %>
        <p class="text-center text-danger">No employees found.</p>
        <%
            }
        %>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
