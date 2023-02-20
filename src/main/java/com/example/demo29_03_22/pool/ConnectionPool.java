package com.example.demo29_03_22.pool;

import java.sql.*;

import java.util.Properties;
import java.util.concurrent.BlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private static ConnectionPool instance;
    private BlockingQueue<ProxyConnection> free = new LinkedBlockingQueue<>(8);
    private BlockingQueue<ProxyConnection> used = new LinkedBlockingQueue<>(8);
    static {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); // 1
            // Class.forName("com.mysql.cj.jdbc.Driver"); //2
      //    } catch (SQLException e) {
      //      throw new ExceptionInInitializerError(e);
        } catch (SQLException e) {
           // throw new RuntimeException(e.getMessage());

        }
    }

    private ConnectionPool() {
        String url = "jdbc:mysql://localhost:3306/phonestest2";
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "Root_123");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
        prop.put("useSSL", "true");
        prop.put("useJDBCCompliantTimezoneShift", "true");
        prop.put("useLegacyDatetimeCode", "false");
        prop.put("serverTimezone", "UTC");
        prop.put("serverSslCert", "classpath:server.crt");
        for (int i = 0; i < 8; i++) {
            Connection connection = createConnection(url, prop);
            free.add((ProxyConnection) connection);
        }
    }

    public static ConnectionPool getInstance() {
        // lock
        instance = new ConnectionPool();
        // unlock
        return instance;
    }
    public Connection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = free.take();
            used.put(connection);
        } catch (InterruptedException e) {
            //log
            Thread.currentThread().interrupt();
        }
        return connection;
    }
    public boolean releaseConnection(Connection connection) {
        boolean match = true;
        try {
            match = used.remove(connection); // todo
            if(match) {
                free.put((ProxyConnection) connection);
            }
        } catch (InterruptedException e) {
            //log
            Thread.currentThread().interrupt();
        }
        return match;
    }
    // deregisterDriver
    public void destroyPool() {
        for (int i = 0; i < 8; i++) {
            try {
                free.take().reallyClose();
            } catch (InterruptedException e) {
                /// log e.printStackTrace();
            }
        }
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }
    private Connection createConnection(String url, Properties properties) {

        Connection proxyConnection;
        try {
          // proxyConnection = DriverManager.getConnection(url, properties);
          proxyConnection = new ProxyConnection(DriverManager.getConnection(url, properties));
        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        }
        return proxyConnection;

    }
}
