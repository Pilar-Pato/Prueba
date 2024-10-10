package com.factoriaf5.model;

import java.util.Date;

public class IncidenciasModel {

    private int idIncidencia;
    private Date fechaCreacion;
    private String descripcion;
    private String titulo;
    private Date fechaCierre;
    private String estado;

    public IncidenciasModel(int idIncidencia, Date fechaCreacion, String descripcion, String titulo, Date fechaCierre, String estado) {
        this.idIncidencia = idIncidencia;
        this.fechaCreacion = fechaCreacion;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
    }


    public int getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ID: " + idIncidencia
                + ", Fecha de Creación: " + (fechaCreacion != null ? fechaCreacion.toString() : "N/A")
                + ", Descripción: '" + descripcion + '\''
                + ", Título: '" + titulo + '\''
                + ", Fecha de Cierre: " + (fechaCierre != null ? fechaCierre.toString() : "N/A")
                + ", Estado: '" + estado + '\'';
    }

}

