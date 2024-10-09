package com.factoriaf5;

import java.util.List;

import com.factoriaf5.database.CreateDataBase;
import com.factoriaf5.database.DataBaseConnection;
import com.factoriaf5.database.DataOperationsUtils;
import com.factoriaf5.model.IncidenciasModel;

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

// Get and display all incidencias
getAllIncidencias();
}

private static void getAllIncidencias() {
    List<IncidenciasModel> incidencias = DataOperationsUtils.getAllIncidencias();
    System.out.println("Lista de incidencias:");
    
    for (IncidenciasModel incidencia : incidencias) {
        System.out.println("ID: " + incidencia.getIdIncidencia() + 
                           ", Fecha Creacion: " + incidencia.getFechaCreacion() + 
                           ", Descripcion: " + incidencia.getDescripcion() + 
                           ", Titulo: " + incidencia.getTitulo() + 
                           ", Fecha Cierre: " + incidencia.getFechaCierre() + 
                           ", Estado: " + incidencia.getEstado());
    }
}
}   

        
    //   incidencias = DataOperationsUtils.getAllIncidencias();
    //   System.out.println("Lista de incidencias después de la actualización:");
    //   for (IncidenciasModel incidencia : incidencias) {
    //   System.out.println("ID: " + incidencia.getIdIncidencia() + ", Fecha Creacion: " + incidencia.getFechaCreacion() + ", Descripcion : " + incidencia.getDescripcion() + ", Titulo : " + incidencia.getTitulo() + ", Fecha Cierre : " + incidencia.getFechaCierre() + ", Estado : " + incidencia.getEstado()) ;
    
    


    //  this.idIncidencia = idIncidencia;this.fechaCreacion = fechaCreacion;this.descripcion = descripcion;this.titulo = titulo; this.fechaCierre = fechaCierre; this.estado = estado;
    //createIncidenciasTable.insertIncidencia("");

