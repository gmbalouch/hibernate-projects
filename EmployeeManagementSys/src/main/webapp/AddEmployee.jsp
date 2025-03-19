<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<
<%@ page isELIgnored="false" %>



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
    		String message = (String) session.getAttribute("message");
    		if (message != null) {
				%>
        		<div class="alert alert-success text-center">
            		<%= message %>
        		</div>
				<%
    	   	 		session.removeAttribute("message"); // Remove after displaying
    			}
				%>
        
            <h2 class="text-center mb-4">Add Employee</h2>                     
            
            <form action="<%= request.getContextPath() %>/saveEmployee" method="post">
                <div class="mb-3">
                    <label class="form-label">Enter Employee ID</label>
                    <input type="text" name="employeeId" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Enter Full Name</label>
                    <input type="text" name="fullName" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label d-block">Select Gender</label>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" value="Male" required>
                        <label class="form-check-label">Male</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" value="Female" required>
                        <label class="form-check-label">Female</label>
                    </div>
                </div>
                <div class="mb-3">
                    <label class="form-label">Enter Address</label>
                    <input type="text" name="address" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Enter Mobile</label>
                    <input type="text" name="mobile" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Enter Email</label>
                    <input type="email" name="email" class="form-control" required>
                </div>
                <div class="text-center">
    				<button type="submit" class="btn btn-primary w-50">Add Employee</button>
				</div>
            </form>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
