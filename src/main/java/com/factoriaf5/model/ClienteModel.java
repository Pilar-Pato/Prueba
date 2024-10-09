package com.factoriaf5.model;

public class ClienteModel extends UserModel {
    private int id_cliente;
    private String direccion;
    private int telefono;

    public ClienteModel(int id_user, String nombre_user, int password, int id_cliente, String direccion, int telefono){
    super(id_user, nombre_user, password);
    this.id_cliente = id_cliente;
    this.direccion = direccion;
    this.telefono = telefono;
}

public int getId_cliente() {
    return id_cliente;
}

public void setId_cliente(int id_cliente) {
    this.id_cliente = id_cliente;
}

public String getDireccion() {
    return direccion;
}

public void setDireccion(String direccion) {
    this.direccion = direccion;
}

public int getTelefono() {
    return telefono;
}

public void setTelefono(int telefono) {
    this.telefono = telefono;
}

}



    //public static void createClientesTable() {
        //String sqlCreateTableClientes = "CREATE TABLE IF NOT EXISTS Clientes ("
          //      + "id_cliente INT PRIMARY KEY AUTO_INCREMENT, "
          //      + "direccion VARCHAR(255), "
          //      + "telefono VARCHAR(20), "
          //      + "id_user INT, "
          //      + "FOREIGN KEY (id_user) REFERENCES users(id_user) ON DELETE CASCADE)";