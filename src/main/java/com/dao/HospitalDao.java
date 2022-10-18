package com.dao;

import com.domain.Hospital;

import java.sql.*;
import java.util.Map;

public class HospitalDao {

    public void add() throws SQLException, ClassNotFoundException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);  //db연결
        PreparedStatement ps = conn.prepareStatement("INSERT INTO users(id, address, district, category, emergency_room, name, subdivision) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, "");
        ps.setString(2, "");
        ps.setString(3, "");
        ps.setString(4, "");
        ps.setString(5, "");
        ps.setString(6, "");
        ps.setString(7, "");

        ps.executeUpdate(); //ctrl + enter
        ps.close();
        conn.close();
    }

    public Hospital get(String id) throws ClassNotFoundException, SQLException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);  //db연결
        PreparedStatement ps = conn.prepareStatement("SELECT id, address, district, category, emergency_room," +
                " name, subdivision FROM `seoul_hospital` WHERE id = ?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Hospital hospital = new Hospital(rs.getString("id"), rs.getString("address"), rs.getString("district"),
                rs.getString("category"), rs.getString("emergency_room"), rs.getString("name"), rs.getString("subdivision"));

        rs.close();
        ps.close();
        conn.close();

        return hospital;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        HospitalDao hospitalDao = new HospitalDao();
//            userDao.add();
        Hospital hospital = hospitalDao.get("A1120837");
        System.out.printf("#id: %s\n#address: %s\n#district: %s\n#category: %s\n#emergency_room: %s\n#name: %s\n#subdivision: %s\n",
                hospital.getId(), hospital.getAddress(), hospital.getDistrict(), hospital.getCategory(), hospital.getEmergencyRoom(),
                hospital.getName(), hospital.getSubdivision());
    }
}
