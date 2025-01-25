package com.sit.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sit.Model.Student;
import com.sit.Util.JDBCConnection;
import java.sql.SQLException;

public class StudentDao {
	public void saveStudent(Student student) {
        String query = "INSERT INTO student (name, email, address, username, password) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = JDBCConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getAddress());
            ps.setString(4, student.getUsername());
            ps.setString(5, student.getPassword());
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Student getStudentByUsername(String username) {
        String query = "SELECT * FROM student WHERE username = ?";
        Student student = null;

        try (Connection con = JDBCConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setAddress(rs.getString("address"));
                student.setUsername(rs.getString("username"));
                student.setPassword(rs.getString("password"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return student;
    }

}
