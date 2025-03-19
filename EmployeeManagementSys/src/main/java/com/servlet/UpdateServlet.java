package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.entities.Employee;

import DAO.EmployeeDAO;


@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	
    	try {	
			Employee emp=new Employee();
			
			int emp_id=Integer.parseInt(request.getParameter("employeeId"));
			emp.setEmp_id(emp_id);
			emp.setName(request.getParameter("fullName"));
			emp.setGender(request.getParameter("gender"));
			emp.setAddress(request.getParameter("address"));
			emp.setMobile_no(request.getParameter("mobile")) ;
			emp.setEmail(request.getParameter("email")); 
			
			EmployeeDAO dao=new EmployeeDAO();
			boolean isupdated=dao.updateEmp(emp_id, emp);
			
			if (isupdated) {
	               session.setAttribute("message", "Employee updated successfully!");
	                session.setAttribute("messageType", "success");
	                response.sendRedirect("displayAll");
	        } else {
	                session.setAttribute("message", "Error updating employee. Try again!");
	                session.setAttribute("messageType", "danger");
	                response.sendRedirect("updateEmploye.jsp?id=" + emp_id);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        session.setAttribute("message", "Something went wrong!");
	        session.setAttribute("messageType", "danger");
	        response.sendRedirect("updateEmploye.jsp?id=" + request.getParameter("employeeId"));
	    }
	}

}


