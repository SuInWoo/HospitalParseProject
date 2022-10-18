package com.dao;

import com.domain.Hospital;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class HospitalDaoTest {

    String case1 = "\"A1120837\", \"서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동)\",\n" +
            "\"서울특별시 금천구\", \"C\", \"2\", \"가산기대찬의원\", \"분류 불가\"";

    @Test
    @DisplayName("Select Test")
    void select() throws SQLException, ClassNotFoundException {
        AWSConnectionMaker AWSConnectionMaker = new AWSConnectionMaker();
        HospitalDao hospitalDao = new HospitalDao(AWSConnectionMaker);

        Hospital hospital = hospitalDao.get("A1120837");

        assertEquals("가산기대찬의원", hospital.getName());
    }
}