package com;

import com.dao.ConnectorImpl;
import com.dao.HospitalDao;
import com.domain.Hospital;
import java.sql.SQLException;

public class HospitalMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectorImpl connectorImpl = new ConnectorImpl();
        HospitalDao hospitalDao = new HospitalDao(connectorImpl);

//        hospitalDao.add(new Hospital("", "", "", "", "", "", ""));
        Hospital hospital = hospitalDao.get("A1120837");

        System.out.printf(hospital.toString());
    }
}
