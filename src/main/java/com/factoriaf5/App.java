package com.factoriaf5;

import com.factoriaf5.database.CreateDataBase;
import com.factoriaf5.database.DataBaseConnection;

/**
 * Hello world!
 *
 */
public class App {

    //Solo funciona dandole a Debug main no se porqué
    public static void main(String[] args) {
        DataBaseConnection.startServer();

        CreateDataBase.createUsersTable();
        CreateDataBase.createClientesTable();
        CreateDataBase.createTecnicosTable();
        CreateDataBase.createIncidenciasTable();

        CreateDataBase.insertInitialData();
    }

    //createIncidenciasTable.insertIncidencia("");
}
