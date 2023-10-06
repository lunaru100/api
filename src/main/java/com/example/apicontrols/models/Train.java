package com.example.apicontrols.models;

import com.example.apicontrols.repositories.TrainRepository;

public class Train {
    public Train(){

    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;
    int number;
    String destination;
    int ticketPrice;

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                "number=" + number +
                ", destination='" + destination + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }

    public Train(int number, String destination, int ticketPrice) {
        this.number = number;
        this.destination = destination;
        this.ticketPrice = ticketPrice;
    }
}
