package com.bikerental;

import java.util.List;

public class BikeRentalService {
    private List<Bike> bikes; 

    public BikeRentalService(List<Bike> bikes) {
        this.bikes = bikes;
    }

    public void rentBike(Customer c, Bike b) { 
        if (c != null) {
            if (b != null) {
                if (bikes.contains(b)) {
                    // Procesar pago
                    processPayment(c, b);

                    // Alquilar la bicicleta
                    bikes.remove(b);
                    System.out.println(c.getName() + " ha alquilado la bicicleta: " + b.getModel());

                    // Enviar notificaciones
                    sendNotifications(c, b.getModel());
                } else {
                    System.out.println("La bicicleta no está disponible.");
                }
            } else {
                System.out.println("Bicicleta no puede ser nula.");
            }
        } else {
            System.out.println("Cliente no puede ser nulo.");
        }
    }

    public void returnBike(Customer c, Bike b) {
        if (c != null) {
            if (b != null) {
                if (!bikes.contains(b)) {
                    // Devolver la bicicleta
                    bikes.add(b);
                    System.out.println(c.getName() + " ha devuelto la bicicleta: " + b.getModel());

                    // Enviar notificaciones
                    sendNotifications(c, b.getModel());
                } else {
                    System.out.println("La bicicleta ya ha sido devuelta.");
                }
            } else {
                System.out.println("Bicicleta no puede ser nula.");
            }
        } else {
            System.out.println("Cliente no puede ser nulo.");
        }
    }


    private void processPayment(Customer c, Bike b) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment(c, b.getRentalPrice());
    }

    private void sendNotifications(Customer c, String bikeModel) {
        NotificationService notificationService = new NotificationService();
        notificationService.sendrentalnotificacion(c.getEmail(), bikeModel);
        notificationService.sendadminnot("admin@bikerentals.com", c.getName(), bikeModel);
    }
}