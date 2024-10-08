package com.factoriaf5.model;

public class TecModel extends UserModel{
    private String idTec;
    private String cargo;
    private String email;

    
        public TecModel(String userName, int password, String idTec, String cargo, String email) {
            super(userName, password);
            this.idTec = idTec;
            this.cargo = cargo;
            this.email = email;
        }

        public String getIdTec() {
            return idTec;
        }
    
        public void setIdTec(String idTec) {
            this.idTec = idTec;
        }

        public String getCargo() {
            return cargo;
        }
    
        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        public String getEmail() {
            return email;
        }
    
        public void setEmail(String email) {
            this.email = email;
        }
}
