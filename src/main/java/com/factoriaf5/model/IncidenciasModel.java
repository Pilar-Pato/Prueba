package com.factoriaf5.model;

import java.util.Date;

public class IncidenciasModel {
private String idIncidencia;
private Date fechaCreacion;
private String descripcion;
private String titulo;
private Date fechaCierre;
private String estado;

public IncidenciasModel(String idIncidencia, Date fechaCreacion, String descripcion, String titulo, Date fechaCierre, String estado){
    this.idIncidencia = idIncidencia;
    this.fechaCreacion = fechaCreacion;
    this.descripcion = descripcion;
    this.titulo = titulo;
    this.fechaCierre = fechaCierre;
    this.estado = estado;
}


public String getIdIncidencia(){
    return idIncidencia;
}

public void setIdIncidencia(String idIncidencia){
    this.idIncidencia = idIncidencia;
}


public Date getFechaCreacion(){
    return fechaCreacion;
}
public void setFechaCreacion(Date fechaCreacion){
    this.fechaCreacion = fechaCreacion;
}


public String getDescripcion(){
    return descripcion;
}
public void setDescripcion(String descripcion){
    this.descripcion = descripcion;
}


public String getTitulo(){
    return titulo;
}
public void setTitulo(String titulo){
    this.titulo = titulo;
}


public Date getFechaCierre(){
    return fechaCierre;
}
public void setFechaCierre(Date fechaCierre){
    this.fechaCierre = fechaCierre;
}


public String getEstado(){
    return estado;
}
public void setEstado(String estado){
    this.estado = estado;
}


@Override
public String toString() {
    return "Incidencias{" +
            "idIncidencia=" + idIncidencia +
            ", fechaCreacion='" + fechaCreacion + '\'' +
            ", descripcion='" + descripcion + '\'' +
            ", titulo='" + titulo + '\'' +
            ", fechaCierre='" + fechaCierre + '\'' +
            ", estado='" + estado + '\'' +
            '}';
}


public void setIdIncidencia(int int1) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setIdIncidencia'");
}


public void setId_incidencia(int int1) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setId_incidencia'");
}

}
