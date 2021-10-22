package de.hsos.swa.ssa.suchen.dal;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TransaktionManagement implements TransaktionPool {
    ConnectionPool connectionPool;

    public TransaktionManagement(String url) throws SQLException {
        this.connectionPool = ConnectionManagement.create(url);
    }

    @Override
    public boolean create(String sql) {
        try {
            Connection conn = connectionPool.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.commit();
            connectionPool.releaseConnection(conn);
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    @Override
    public List<Object> read(String sql) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(String sql) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(String sql) {
        // TODO Auto-generated method stub
        return false;
    }

}
