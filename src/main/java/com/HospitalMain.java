package com;

import com.dao.Connector;
import com.dao.HospitalDao;
import com.domain.Hospital;
import java.sql.SQLException;

public class HospitalMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connector connector = new Connector();
        HospitalDao hospitalDao = new HospitalDao(connector);

//        hospitalDao.add(new Hospital("", "", "", "", "", "", ""));
        Hospital hospital = hospitalDao.get("A1120837");

        System.out.printf(hospital.toString());
    }
}
