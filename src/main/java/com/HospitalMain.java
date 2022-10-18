package com;

import com.dao.Connector;
import com.dao.HospitalDao;
import com.domain.Hospital;
import java.sql.SQLException;

public class HospitalMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connector connector = new Connector();
        HospitalDao hospitalDao = new HospitalDao(connector);
//            hospital.add();
        Hospital hospital = hospitalDao.get("A1120837");

        System.out.printf("#id: %s\n#address: %s\n#district: %s\n#category: %s\n#emergency_room: %s\n#name: %s\n#subdivision: %s\n",
                hospital.getId(), hospital.getAddress(), hospital.getDistrict(),
                hospital.getCategory(), hospital.getEmergencyRoom(), hospital.getName(),
                hospital.getSubdivision());
    }
}
