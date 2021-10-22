package de.hsos.swa.ssa.suchen.dal;

import java.sql.Connection;
import java.util.List;

public interface ConnectionPool {
    Connection getConnection();

    boolean releaseConnection(Connection connection);

    String getUrl();
}
