package com.dao;

import com.domain.Hospital;

import java.sql.*;

public class HospitalDao {

    private Connector connector;

    public HospitalDao(Connector connector) {
        this.connector = connector;
    }

    public void add() throws SQLException, ClassNotFoundException {
        Connection conn = connector.getConnection();  //db연결

        PreparedStatement ps = conn.prepareStatement("INSERT INTO users(id, address, district, category, " +
                "emergency_room, name, subdivision VALUES (?, ?, ?, ?, ?, ?, ?)");
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
        Connection conn = connector.getConnection();  //db연결

        PreparedStatement ps = conn.prepareStatement("SELECT id, address, district, category, emergency_room," +
                " name, subdivision FROM `seoul_hospital` WHERE id = ?");

        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Hospital hospital = new Hospital(rs.getString("id"), rs.getString("address"),
                rs.getString("district"), rs.getString("category"),
                rs.getString("emergency_room"), rs.getString("name"),
                rs.getString("subdivision"));

        rs.close();
        ps.close();
        conn.close();

        return hospital;
    }
}
