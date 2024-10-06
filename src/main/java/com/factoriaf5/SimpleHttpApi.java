package com.factoriaf5;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class SimpleHttpApi {

    private static List solicitudes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new java.net.InetSocketAddress(8080), 0);
        server.createContext("/login", new LoginHandler());
        server.createContext("/solicitudes", new SolicitudesHandler());
        server.createContext("/solicitudes/", new SolicitudesIdHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server started on port 8080");


}

static class SolicitudesHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response;
        int statusCode = 201;

        switch (exchange.getRequestMethod()) {
            case "POST":
                // Crear una solicitud
                Solicitud newSolicitud = readSolicitudFromRequest(exchange);
                solicitudes.add(newSolicitud);
                response = "Created";
                break;

            case "GET":
                // Listar solicitudes
                response = Solicitudes.toString();
                statusCode = 200;
                break;

            case "PUT":
                // Editar una solicitud existente
                int idToUpdate = Integer.parseInt(exchange.getRequestURI().getPath().split("/")[3]);
                Solicitud updatedSolicitud = readSolicitudFromRequest(exchange);
                if (idToUpdate < Solicitudes.size()) {
                    solicitudes.set(idToUpdate, updatedSolicitud);
                    response = "OK";
                } else {
                    response = "Solicitud no encontrada.";
                    statusCode = 404;
                }
                break;

            case "DELETE":
                // Delete a person
                int idToDelete = Integer.parseInt(exchange.getRequestURI().getPath().split("/")[3]);
                if (idToDelete < solicitudes.size()) {
                    solicitudes.remove(idToDelete);
                    response = "Solicitud eliminada";
                } else {
                    response = "Solicitud no encontrada..";
                    statusCode = 404;
                }
                break;

            default:
                response = "Unsupported method";
                statusCode = 405;
                break;
static class LoginHandler implements HttpHandler {
      @Override
       public void handle(HttpExchange exchange) throws IOException {
            String response;
            int statusCode = 200;
                
            if ("POST".equals(exchange.getRequestMethod())) {
                //leer el cuerpo de la solicitud
               InputStreamReader isr = new InputStreamReader(exchange.getRequestBody());
               BufferedReader reader = new BufferedReader(isr);
               StringBuilder requestBody = new StringBuilder();
               String line;
               while ((line = reader.readLine()) != null) {
               requestBody.append(line);
}
                
 // Suponiendo que el cuerpo es un JSON con "username" y "password"
            String json = requestBody.toString();
            String username = ""; // Extraer el username del JSON
            String password = ""; // Extraer el password del JSON
                
            // Aquí deberías usar una librería como Gson o Jackson para parsear el JSON
            // Autenticación
            if ("usuario".equals(username) && "contraseña".equals(password)) {
            response = "Login exitoso";
                } else {
                response = "Unauthorized";
                statusCode = 401; // Código de estado para no autorizado
 }
}               else {
                response = "Método no permitido";
                statusCode = 405; // Método no permitido
                        }
        }

        exchange.sendResponseHeaders(statusCode, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

