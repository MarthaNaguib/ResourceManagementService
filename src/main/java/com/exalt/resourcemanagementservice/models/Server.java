package com.exalt.resourcemanagementservice.models;

public class Server {
    int capacity;
    int requestedAmounts;
    int id;

    public Server(int id,int capacity) {
        this.id=id;
        this.capacity = capacity;
        this.requestedAmounts=0;
    }

    public synchronized int getCapacity() {
        return capacity;
    }

    public synchronized void setCapacity(int capacity) {
        this.capacity = capacity;
        System.out.println("s"+this.id+" amount is "+this.capacity +" requested "+this.getRequestedAmounts());
    }

    public int getRequestedAmounts() {
        return requestedAmounts;
    }

    public void setRequestedAmounts(int requestedAmounts) {
        this.requestedAmounts = requestedAmounts;
    }
}
