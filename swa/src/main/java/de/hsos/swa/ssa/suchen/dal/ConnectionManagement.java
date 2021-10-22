package de.hsos.swa.ssa.suchen.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionManagement implements ConnectionPool {
    private String url = "jdbc:derby:simpleShoppingAppDB;create=true";
    private List<Connection> connectionPool;
    private List<Connection> usedConnection = new ArrayList<>();
    private static int INITIAL_POOL_SIZE = 1;

    public ConnectionManagement(String url, List<Connection> connectionPool) {
        this.url = url;
        this.connectionPool = connectionPool;
    }

    public static ConnectionManagement create(String url) throws SQLException {
        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            pool.add(createConnection(url));
        }
        return new ConnectionManagement(url, pool);
    }

    @Override
    public Connection getConnection() {
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnection.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnection.remove(connection);
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    private static Connection createConnection(String url) throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        connection.setAutoCommit(false);
        return connection;
    }

}
