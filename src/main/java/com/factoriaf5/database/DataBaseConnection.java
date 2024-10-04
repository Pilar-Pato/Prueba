package com.factoriaf5.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.h2.tools.Server;

public class DataBaseConnection {
    private static final String URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    // Método para iniciar el servidor H2
    public static void startServer() {
        try {
            Server.createTcpServer().start();
            System.out.println("Servidor H2 iniciado en el puerto 8080.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para conectarse a la base de datos
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

