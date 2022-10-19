package com.dao;

public class UserDaoFactory {
    //조립 역할
    public UserDao awsUserDao() {   //날개 5개 선풍기
        UserDao userDao = new UserDao(new AWSConnectionMaker());
        return userDao;
    }

    public UserDao localUserDao() { //날개 4개 선풍기
        UserDao userDao = new UserDao(new LocalConnectionMaker());
        return userDao;
    }


}
