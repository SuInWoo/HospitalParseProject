package com;

import com.dao.AWSConnectionMaker;
import com.dao.HospitalDao;
import com.domain.Hospital;
import java.sql.SQLException;

public class HospitalMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AWSConnectionMaker AWSConnectionMaker = new AWSConnectionMaker();
        HospitalDao hospitalDao = new HospitalDao(AWSConnectionMaker);

//        hospitalDao.add(new Hospital("", "", "", "", "", "", ""));
        Hospital hospital = hospitalDao.get("A1120837");

        System.out.printf(hospital.toString());
    }
}
