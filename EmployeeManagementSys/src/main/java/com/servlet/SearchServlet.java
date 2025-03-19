package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.entities.Employee;

import DAO.EmployeeDAO;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int emp_id=Integer.parseInt(request.getParameter("id"));
			
			EmployeeDAO dao=new EmployeeDAO();
			Employee employee=dao.getById(emp_id);
			
			request.setAttribute("employee", employee); 
	        request.getRequestDispatcher("EmployeeById.jsp").forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
