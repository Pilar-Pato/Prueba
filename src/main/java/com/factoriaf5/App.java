package com.factoriaf5;

import com.factoriaf5.database.DataBaseConnection;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        DataBaseConnection.startServer();
        
       /*  CreateDataBase.createClientesTable();
        CreateDataBase.createIncidenciasTable();
        CreateDataBase.createTecnicosTable();
        CreateDataBase.createUsersTable();

        CreateDataBase.insertInitialData();*/
    }
}
