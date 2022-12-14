package com.dao;

import com.domain.Hospital;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HospitalDaoFactory.class)
class HospitalDaoTest {

    @Autowired
    ApplicationContext context;

    @Test
    @DisplayName("Select Test")
    void select() throws SQLException {

        HospitalDao hospitalDao = context.getBean("awsHospitalDao", HospitalDao.class);
        String case1 = "\"A1120837\", \"서울특별시 금천구 벚꽃로 286 삼성리더스타워 111~114호 (가산동)\",\n" +
                "\"서울특별시 금천구\", \"C\", \"2\", \"가산기대찬의원\", \"분류 불가\"";

        Hospital hospital = hospitalDao.get("A1120837");
        Assertions.assertEquals("가산기대찬의원", hospital.getName());
    }
}