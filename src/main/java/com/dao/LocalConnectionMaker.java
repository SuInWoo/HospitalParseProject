package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class LocalConnectionMaker implements Connector {

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/likelion-db",
                "root", "root");  //db연결    -> 사용시 root 비밀번호 변경 후 사용

        return conn;
    }

}
