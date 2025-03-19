package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.entities.Employee;

import DAO.EmployeeDAO;


@WebServlet("/displayAll")
public class DisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 EmployeeDAO employeeDao = new EmployeeDAO(); // Use your DAO class
	        List<Employee> employees = employeeDao.getAllEmployees(); // Fetch all employees

	        request.setAttribute("employees", employees); // Store list in request
	        request.getRequestDispatcher("displayAll.jsp").forward(request, response);
	}

}
