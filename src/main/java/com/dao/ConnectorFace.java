package com.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectorFace {
    public Connection getConnection() throws ClassNotFoundException, SQLException;
}
