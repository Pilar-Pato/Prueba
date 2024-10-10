package com.factoriaf5;



import com.factoriaf5.database.CreateDataBase;
import com.factoriaf5.database.DataBaseConnection;
import com.factoriaf5.database.DataOperationsUtils;


<<<<<<< HEAD

public class App {

   
=======
public class App {

    
>>>>>>> cb2aacdf3fc6b0848ab78ac4ef94e0a40e6f276f
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
<<<<<<< HEAD

=======
>>>>>>> cb2aacdf3fc6b0848ab78ac4ef94e0a40e6f276f
