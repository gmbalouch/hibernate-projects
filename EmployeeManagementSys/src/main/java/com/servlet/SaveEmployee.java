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


@WebServlet("/saveEmployee")
public class SaveEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Employee emp=new Employee();
			
			emp.setEmp_id(Integer.parseInt(request.getParameter("employeeId")));
			emp.setName(request.getParameter("fullName"));
			emp.setGender(request.getParameter("gender"));;
			emp.setAddress(request.getParameter("address"));;
			emp.setMobile_no(request.getParameter("mobile")); ;
			emp.setEmail(request.getParameter("email")); ;
			
			EmployeeDAO dao=new EmployeeDAO();
			boolean isSave=dao.saveEmp(emp);
			
			if (isSave) {
			    HttpSession session = request.getSession();
			    System.out.println("Employe saved successfully");
			    session.setAttribute("message", "Employee added successfully!");
			    
			    response.sendRedirect("AddEmployee.jsp");
			    
			} else {
			    HttpSession session = request.getSession();
			    session.setAttribute("errorMessage", "Error adding employee.");
			    response.sendRedirect("AddEmployee.jsp");
			}

			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
