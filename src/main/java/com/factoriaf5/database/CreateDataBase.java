package com.factoriaf5.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDataBase {

    public static void createUsersTable() {
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS users ("
                + "id_user INT PRIMARY KEY AUTO_INCREMENT, "
                + "nombre_user VARCHAR(255) NOT NULL, "
                + "password VARCHAR(255) NOT NULL, "
                + "es_tecnico BOOLEAN NOT NULL)";

        executeUpdate(sqlCreateTable, "Users");
    }

    public static void createTecnicosTable() {
        String sqlCreateTableTecnicos = "CREATE TABLE IF NOT EXISTS Tecnicos ("
                + "id_tecnico INT PRIMARY KEY AUTO_INCREMENT, "
                + "cargo VARCHAR(255), "
                + "correo VARCHAR(255) NOT NULL UNIQUE, "
                + "id_user INT, "
                + "FOREIGN KEY (id_user) REFERENCES users(id_user) ON DELETE CASCADE)";

        executeUpdate(sqlCreateTableTecnicos, "Tecnicos");
    }

    public static void createClientesTable() {
        String sqlCreateTableClientes = "CREATE TABLE IF NOT EXISTS Clientes ("
                + "id_cliente INT PRIMARY KEY AUTO_INCREMENT, "
                + "direccion VARCHAR(255), "
                + "telefono VARCHAR(20), "
                + "id_user INT, "
                + "FOREIGN KEY (id_user) REFERENCES users(id_user) ON DELETE CASCADE)";

        executeUpdate(sqlCreateTableClientes, "Clientes");
    }

    public static void createIncidenciasTable() {
        String sqlCreateTableIncidencias = "CREATE TABLE IF NOT EXISTS Incidencias ("
                + "id_incidencia INT PRIMARY KEY AUTO_INCREMENT, "
                + "id_cliente INT NOT NULL, "
                + "id_tecnico INT, "
                + "fechaCreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
                + "titulo VARCHAR(255) NOT NULL, "
                + "descripcion TEXT NOT NULL, "
                + "estado VARCHAR(50) DEFAULT 'Pendiente', "
                + "fechaCierre TIMESTAMP NULL, "
                + "FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente) ON DELETE CASCADE, "
                + "FOREIGN KEY (id_tecnico) REFERENCES Tecnicos(id_tecnico) ON DELETE SET NULL)";

        executeUpdate(sqlCreateTableIncidencias, "Incidencias");
    }

    private static void executeUpdate(String sql, String tableName) {
        try (
                Connection connection = DataBaseConnection.getConnection(); Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table '" + tableName + "' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating table '" + tableName + "': " + e.getMessage());
        }
    }

    public static void insertInitialData() {
        DataOperationsUtils.insertUser("Cristina", "1234", true);
        System.out.println("Usuario Cristina insertado correctamente y su password ");
        DataOperationsUtils.insertUser("Erika", "3456", false);
        System.out.println("Usuario Erika insertado correctamente y su password ");
        DataOperationsUtils.insertUser("Travis", "4321", false);
        System.out.println("Usuario Travis insertado correctamente y su password ");
        DataOperationsUtils.insertUser("Taylor", "1313", true);
        System.out.println("Usuario insertado correctamente y su password ");
        DataOperationsUtils.insertTecnico("Soporte Técnico", "cris.pf@soptec.com", 1);
        System.out.println("Tecnico insertado correctamente con email ");
        DataOperationsUtils.insertTecnico("Soporte Técnico", "erika.gg@soptec.com", 2);
        System.out.println("Tecnico insertado correctamente con email " + 2);
        DataOperationsUtils.insertCliente("Calle Alegría 25", "555098766", 1);
        System.out.println("Cliente insertado con su dirección : Calle Alegría 25- tfno 555098766"+  1);
        DataOperationsUtils.insertCliente("Paseo del Pato 1", "555012243", 2);
        System.out.println("Cliente Erika insertado con su dirección : Calle Alegría 25- tfno 555098766"+  1);
        DataOperationsUtils.insertIncidencia(1, 1, "Ayuda, se me rompio el raton", "Raton averiado");
        System.out.println("Incidencia creada con Cliente 1, id_tecnico 1, con su titulo e descripción ");
        DataOperationsUtils.insertIncidencia(2, 2, "Problema WiFi", "Poca señal WiFi");
        System.out.println("Incidencia creada con Cliente 2, id_tecnico 2, con su titulo e descripción ");
        DataOperationsUtils.insertIncidencia(2, 2, "Bateria rota", "Me exploto la bateria del movil");
        System.out.println("Incidencia creada con Cliente 2, id_tecnico 2, con su titulo e descripción ");
    }
}
