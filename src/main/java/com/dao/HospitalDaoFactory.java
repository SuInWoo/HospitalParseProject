package com.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HospitalDaoFactory {
    //조립 역할

    @Bean
    public HospitalDao awsHospitalDao() {   //날개 5개 선풍기
        HospitalDao hospitalDao = new HospitalDao(new AWSConnectionMaker());
        return hospitalDao;
    }

    @Bean
    public HospitalDao localHospitalDao() { //날개 4개 선풍기
        HospitalDao hospitalDao = new HospitalDao(new LocalConnectionMaker());
        return hospitalDao;
    }


}
