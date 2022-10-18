package com.dao;

import com.domain.Hospital;

import java.sql.*;

public class HospitalDao {

    private AWSConnectionMaker AWSConnectionMaker;

    public HospitalDao(AWSConnectionMaker AWSConnectionMaker) {
        this.AWSConnectionMaker = AWSConnectionMaker;
    }

    public void add(Hospital hospital) throws SQLException, ClassNotFoundException {
        Connection conn = AWSConnectionMaker.getConnection();  //db연결

        PreparedStatement ps = conn.prepareStatement("INSERT INTO users(id, address, district, category, " +
                "emergency_room, name, subdivision VALUES (?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, hospital.getId());
        ps.setString(2, hospital.getAddress());
        ps.setString(3, hospital.getDistrict());
        ps.setString(4, hospital.getCategory());
        ps.setString(5, hospital.getEmergencyRoom());
        ps.setString(6, hospital.getName());
        ps.setString(7, hospital.getSubdivision());

        ps.executeUpdate(); //ctrl + enter
        ps.close();
        conn.close();
    }

    public Hospital get(String id) throws ClassNotFoundException, SQLException {
        Connection conn = AWSConnectionMaker.getConnection();  //db연결

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
