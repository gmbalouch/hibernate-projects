package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import DAO.EmployeeDAO;


@WebServlet("/deleteEmployee")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		try {
			int emp_id=Integer.parseInt(request.getParameter("id"));
			
			EmployeeDAO dao=new EmployeeDAO();
			boolean isdeleted=dao.deleteEmp(emp_id);
			if (isdeleted) {
	               session.setAttribute("message", "Employee deleted successfully!");
	                session.setAttribute("messageType", "success");
	                response.sendRedirect("displayAll");
	        } else {
	                session.setAttribute("message", "Error deleting employee. Try again!");
	                session.setAttribute("messageType", "danger");
	                response.sendRedirect("updateEmploye.jsp?id=" + emp_id);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        
	    }
	}

}
