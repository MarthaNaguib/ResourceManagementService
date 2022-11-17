package com.exalt.resourcemanagementservice.models;

import com.exalt.resourcemanagementservice.service.ResourceService;

public class Request extends Thread{
//    int id;
    int value;
    public Request(int value){
        this.value=value;
    }
//    public Request(int id, int value) {
//        this.id = id;
//        this.value = value;
//    }

//    public int getId() {
//        return id;
//    }

    public int getValue() {
        return value;
    }
    public void run(){
        //System.out.println("Request "+this.getId()+" is running");
    }
}
