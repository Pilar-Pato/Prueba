package com.factoriaf5.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDataBase {

    public static void createUsersTable() {
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS users ("
                + "id_user INT PRIMARY KEY AUTO_INCREMENT, "
                + // Cambié IDENTITY por AUTO_INCREMENT
                "nombre_user VARCHAR(255) NOT NULL, "
                + "password VARCHAR(255) NOT NULL, "
                + "es_tecnico BOOLEAN NOT NULL)";

        executeUpdate(sqlCreateTable, "Users");
    }

    public static void createTecnicosTable() {
        String sqlCreateTableTecnicos = "CREATE TABLE IF NOT EXISTS Tecnicos ("
                + "id_tecnico INT PRIMARY KEY AUTO_INCREMENT, "
                + // Cambié IDENTITY por AUTO_INCREMENT
                "cargo VARCHAR(255), "
                + "correo VARCHAR(255) NOT NULL UNIQUE, "
                + "id_user INT, "
                + "FOREIGN KEY (id_user) REFERENCES users(id_user) ON DELETE CASCADE)";

        executeUpdate(sqlCreateTableTecnicos, "Tecnicos");
    }

    public static void createClientesTable() {
        String sqlCreateTableClientes = "CREATE TABLE IF NOT EXISTS Clientes ("
                + "id_cliente INT PRIMARY KEY AUTO_INCREMENT, "
                + // Cambié IDENTITY por AUTO_INCREMENT
                "direccion VARCHAR(255), "
                + "telefono VARCHAR(20), "
                + "id_user INT, "
                + "FOREIGN KEY (id_user) REFERENCES users(id_user) ON DELETE CASCADE)";

        executeUpdate(sqlCreateTableClientes, "Clientes");
    }

    public static void createIncidenciasTable() {
        String sqlCreateTableIncidencias = "CREATE TABLE IF NOT EXISTS Incidencias ("
                + "id_incidencia INT PRIMARY KEY AUTO_INCREMENT, "
                + // Cambié IDENTITY por AUTO_INCREMENT
                "id_cliente INT NOT NULL, "
                + "id_tecnico INT, "
                + "fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
                + "titulo VARCHAR(255) NOT NULL, "
                + "descripcion TEXT NOT NULL, "
                + "estado VARCHAR(50) DEFAULT 'Pendiente', "
                + "fecha_cierre TIMESTAMP NULL, "
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

   /* public static void main(String[] args) {
        createUsersTable();
        createTecnicosTable();
        createClientesTable();
        createIncidenciasTable();

        insertInitialData();
    }*/ 

    public static void insertInitialData() {
        DataOperationsUtils.insertUser("Cristina", "1234", true);
        DataOperationsUtils.insertUser("Erika", "3456", false);
        DataOperationsUtils.insertUser("Travis", "4321", false);
        DataOperationsUtils.insertUser("Taylor", "1313", true);

        DataOperationsUtils.insertTecnico("Soporte Técnico", "cris.pf@soptec.com", 1);
        DataOperationsUtils.insertTecnico("Soporte Técnico", "erika.gg@soptec.com", 2);

        DataOperationsUtils.insertCliente("Calle Alegría 25", "555098766", 1);
        DataOperationsUtils.insertCliente("Paseo del Pato 1", "555012243", 2);

        DataOperationsUtils.insertIncidencia(1, 1, "Ayuda, se me rompió el ratón", "Ratón averiado");
        DataOperationsUtils.insertIncidencia(2, null, "Problema WiFi", "Poca señal WiFi");
        DataOperationsUtils.insertIncidencia(3, 2, "Batería rota", "Me explotó la batería del móvil");

    }
}
