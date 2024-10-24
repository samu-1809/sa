package com.bikerental;

public class NotificationService {

    public void sendrentalnotificacion(String email, String bikeModel) {
        if (email == null) {
            throw new IllegalArgumentException("Email no puede ser nulo.");
    }
  System.out.println("Enviando notificación de alquiler para la bicicleta " + bikeModel + " a " + email);
       }

    public void sendadminnot(String adminEmail, String customerName, String bikeModel) {
        System.out.println("Notificación al administrador: " + customerName + " ha alquilado/devolvido la bicicleta: " + bikeModel + ". Enviando a: " + adminEmail);
    }
}  