package com;

import com.dao.AWSConnectionMaker;
import com.dao.LocalConnectionMaker;
import com.dao.UserDao;
import com.domain.User;

import java.sql.SQLException;

public class UserMain {
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDao(new AWSConnectionMaker());

//        hospitalDao.add(new Hospital("", "", "", "", "", "", ""));
        User user = userDao.get("1");

        System.out.printf(user.toString());
    }
}
