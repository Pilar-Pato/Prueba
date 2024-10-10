package com.factoriaf5;



import com.factoriaf5.database.CreateDataBase;
import com.factoriaf5.database.DataBaseConnection;
import com.factoriaf5.database.DataOperationsUtils;



public class App {

   
    public static void main(String[] args) {
        DataBaseConnection.startServer();

        CreateDataBase.createUsersTable();
        CreateDataBase.createClientesTable();
        CreateDataBase.createTecnicosTable();
        CreateDataBase.createIncidenciasTable();

        CreateDataBase.insertInitialData();


DataOperationsUtils.getAllIncidencias();
}
}
