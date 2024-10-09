package com.factoriaf5.model;

public class TecnicoModel extends UserModel{
    private int id_tecnico;
    private String cargo;
    private String correo;
// private int id_user : no estamos seguras de declarar los atributos que ya están en la clase madre.
    
        public TecnicoModel(int id_user, String nombre_user, int password, int id_tecnico, String cargo, String correo) {
            super(id_user, nombre_user, password);
            this.id_tecnico = id_tecnico;
            this.cargo = cargo;
            this.correo = correo;
        }

        public int getId_tecnico() {
            return id_tecnico;
        }
    
        public void setId_tecnico(int id_tecnico) {
            this.id_tecnico = id_tecnico;
        }

        public String getCargo() {
            return cargo;
        }
    
        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        public String getCorreo() {
            return correo;
        }
    
        public void setCorreo(String correo) {
            this.correo = correo;
        }
}
