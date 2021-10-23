package de.hsos.swa.ssa.suchen.dal;

import java.sql.Statement;
import java.sql.Types;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransaktionManagement implements TransaktionPool {
    ConnectionPool connectionPool;

    public TransaktionManagement(String url) throws SQLException {
        this.connectionPool = ConnectionManagement.create(url);
    }

    @Override
    public boolean create(String sql) {
        Connection conn = connectionPool.getConnection();
        try {

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.commit();
            connectionPool.releaseConnection(conn);
            return true;
        } catch (SQLException e) {
            connectionPool.releaseConnection(conn);
            return false;
        }

    }

    @Override
    public List<String> read(String sql) {
        Connection conn = connectionPool.getConnection();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<String> result = new ArrayList<>();
            if (rs != null) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    result.add(rs.getMetaData().getColumnLabel(i));
                }
                result.add("\n");
                while (rs.next()) {
                    ResultSetMetaData rsmd = rs.getMetaData();

                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        int type = rsmd.getColumnType(i);
                        if (type == Types.VARCHAR || type == Types.CHAR) {
                            result.add(rs.getString(i));
                        } else {
                            result.add(String.valueOf(rs.getLong(i)));
                        }
                    }
                    result.add("\n");
                }
            } else {
                System.out.println("Kein Result??");
            }
            connectionPool.releaseConnection(conn);
            return result;
        } catch (SQLException e) {
            // e.printStackTrace();
            connectionPool.releaseConnection(conn);
            return null;
        }
    }

    @Override
    public boolean update(String sql) {
        Connection conn = connectionPool.getConnection();
        try {
            Statement stmt = conn.createStatement();
            int rows = stmt.executeUpdate(sql);
            if (rows > 0) {
                conn.commit();
                connectionPool.releaseConnection(conn);
                return true;
            } else {
                connectionPool.releaseConnection(conn);
                return false;
            }

        } catch (SQLException e) {
            // e.printStackTrace();
            connectionPool.releaseConnection(conn);
            return false;
        }

    }

    @Override
    public boolean delete(String sql) {
        Connection conn = connectionPool.getConnection();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            conn.commit();
            connectionPool.releaseConnection(conn);
            return true;
        } catch (Exception e) {
            connectionPool.releaseConnection(conn);
        }
        return false;
    }

}
