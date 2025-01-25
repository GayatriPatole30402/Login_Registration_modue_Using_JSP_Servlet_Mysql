package com.sit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sit.Dao.StudentDao;
import com.sit.Model.Student;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private StudentDao studentDao = new StudentDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

        Student existingStudent = studentDao.getStudentByUsername(username);
        if (existingStudent != null) {
            request.setAttribute("error", "Username already exists. Please choose another.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            Student student = new Student();
            student.setName(name);
            student.setEmail(email);
            student.setAddress(address);
            student.setUsername(username);
            student.setPassword(password);

            studentDao.saveStudent(student);
            response.sendRedirect("login.jsp");
        }
	}

}
