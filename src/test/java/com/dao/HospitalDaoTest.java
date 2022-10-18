package com.dao;

import com.domain.Hospital;
import com.parser.HospitalParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class HospitalDaoTest {

    String case1 = "hospital1, \"A1120837\", \"서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동)\",\n" +
            "\"서울특별시 금천구\", \"C\", \"2\", \"가산기대찬의원\", \"분류 불가\"";

    @Test
    @DisplayName("Select Test")
    void select() throws SQLException, ClassNotFoundException {
        Connector connector = new Connector();
        HospitalDao hospitalDao = new HospitalDao(connector);

        Hospital hospital = hospitalDao.get("A1120837");

        assertEquals("A1120837", hospital.getId());
    }
}