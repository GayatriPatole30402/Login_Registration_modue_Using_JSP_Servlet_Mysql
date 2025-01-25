package com.sit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sit.Dao.StudentDao;
import com.sit.Model.Student;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
    private StudentDao studentDao = new StudentDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");

        Student student = studentDao.getStudentByUsername(username);

        if (student != null && student.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("student", student);
            response.sendRedirect("welcome.jsp");
        } else {
            request.setAttribute("error", "Invalid username or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
	}

}
