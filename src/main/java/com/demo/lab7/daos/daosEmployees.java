package com.demo.lab7.daos;

import com.demo.lab7.bean.Employees;

import java.sql.*;
import java.util.ArrayList;

public class daosEmployees{

    public void asignarTrabajo(int job_id, String job_title,int min_salary,int max_salary){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";

        String sql = "insert into Job (job_id, job_title, min_salary, max_salary) values (?,?,?,?)";

        try(Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1,job_id);
            pstmt.setString(2,job_title);
            pstmt.setString(3,min_salary);
            pstmt.setString(4,max_salary);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
