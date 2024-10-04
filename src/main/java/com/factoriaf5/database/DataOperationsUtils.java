package com.factoriaf5.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataOperationsUtils {

    public static void insertUser(String nombre, String password, boolean esTecnico) {
        String sqlInsert = "INSERT INTO users (nombre_user, password, es_tecnico) VALUES (?, ?, ?)";
        executeInsert(sqlInsert, nombre, password, esTecnico);
    }

    public static void insertTecnico(String cargo, String correo, int id_user) {
        String sqlInsert = "INSERT INTO Tecnicos (cargo, correo, id_user) VALUES (?, ?, ?)";
        executeInsert(sqlInsert, cargo, correo, id_user);
    }

    public static void insertCliente(String direccion, String telefono, int id_user) {
        String sqlInsert = "INSERT INTO Clientes (direccion, telefono, id_user) VALUES (?, ?, ?)";
        executeInsert(sqlInsert, direccion, telefono, id_user);
    }

    public static void insertIncidencia(int id_cliente, Integer id_tecnico, String titulo, String descripcion) {
        String sqlInsert = "INSERT INTO Incidencias (id_cliente, id_tecnico, titulo, descripcion) VALUES (?, ?, ?, ?)";
        try (
            Connection connection = DataBaseConnection.getConnection(); 
            PreparedStatement pstmt = connection.prepareStatement(sqlInsert)) {
            pstmt.setInt(1, id_cliente);
            pstmt.setObject(2, id_tecnico); 
            pstmt.setString(3, titulo);
            pstmt.setString(4, descripcion);
            pstmt.executeUpdate();
            System.out.println("Incidencia insertada exitosamente: " + titulo);
        } catch (SQLException e) {
            System.err.println("Error insertando incidencia: " + e.getMessage());
        }
    }

    private static void executeInsert(String sqlInsert, Object... params) {
        try (
            Connection connection = DataBaseConnection.getConnection(); 
            PreparedStatement pstmt = connection.prepareStatement(sqlInsert)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            pstmt.executeUpdate();
            System.out.println("Datos insertados exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error insertando datos: " + e.getMessage());
        }
    }
}

