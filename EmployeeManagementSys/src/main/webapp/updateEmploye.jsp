<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ page import="DAO.EmployeeDAO, com.entities.Employee" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<%@include file="allComponents/allCss.jsp"%>
</head>
<body>
<%@include file="allComponents/navbar.jsp"%>
    <div class="container mt-5">
        <div class="card shadow-lg p-4">
     	   <%
     	   
			int id=Integer.parseInt(request.getParameter("id"));
			EmployeeDAO dao=new EmployeeDAO();
			Employee emp=dao.getById(id);
			String errorMessage = (String) request.getAttribute("errorMessage");
            String successMessage = (String) request.getAttribute("successMessage");
			%>
        
            <h2 class="text-center mb-4">Edit Employee</h2>                     
            <% if (errorMessage != null) { %>
            	<div class="alert alert-danger"><%= errorMessage %></div>
        	<% } %>

        	<% if (successMessage != null) { %>
            	<div class="alert alert-success"><%= successMessage %></div>
        	<% } %>
        	
            <form action="<%= request.getContextPath() %>/updateServlet" method="post">
                <div class="mb-3">
        			<label class="form-label">Enter Employee ID</label>
        			<input type="text" name="employeeId" class="form-control" value="<%= (emp != null) ? emp.getEmp_id() : "" %>" readonly required>
    			</div>
    			<div class="mb-3">
        			<label class="form-label">Enter Full Name</label>
        			<input type="text" name="fullName" class="form-control" value="<%= (emp != null) ? emp.getName() : "" %>" required>
    			</div>
    			<div class="mb-3">
        			<label class="form-label d-block">Select Gender</label>
        			<div class="form-check form-check-inline">
        	    		<input class="form-check-input" type="radio" name="gender" value="Male" <%= (emp != null && "Male".equals(emp.getGender())) ? "checked" : "" %> required>
        	    		<label class="form-check-label">Male</label>
        			</div>
       	 			<div class="form-check form-check-inline">
           				<input class="form-check-input" type="radio" name="gender" value="Female" <%= (emp != null && "Female".equals(emp.getGender())) ? "checked" : "" %> required>
            			<label class="form-check-label">Female</label>
        			</div>
  	  			</div>
    			<div class="mb-3">
        			<label class="form-label">Enter Address</label>
        			<input type="text" name="address" class="form-control" value="<%= (emp != null) ? emp.getAddress() : "" %>" required>
    			</div>
    			<div class="mb-3">
        			<label class="form-label">Enter Mobile</label>
        			<input type="text" name="mobile" class="form-control" value="<%= (emp != null) ? emp.getMobile_no() : "" %>" required>
    			</div>
    			<div class="mb-3">
        			<label class="form-label">Enter Email</label>
        			<input type="email" name="email" class="form-control" value="<%= (emp != null) ? emp.getEmail() : "" %>" required>
    			</div>
    			<div class="text-center">
        			<button type="submit" class="btn btn-primary w-50">Update Employee</button>
    			</div>
     	 	</form>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
