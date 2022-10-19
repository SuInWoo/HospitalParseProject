package com.dao;

public class HospitalDaoFactory {
    //조립 역할
    public HospitalDao awsUserDao() {   //날개 5개 선풍기
        HospitalDao hospitalDao = new HospitalDao(new AWSConnectionMaker());
        return hospitalDao;
    }

    public HospitalDao localUserDao() { //날개 4개 선풍기
        HospitalDao hospitalDao = new HospitalDao(new LocalConnectionMaker());
        return hospitalDao;
    }


}
