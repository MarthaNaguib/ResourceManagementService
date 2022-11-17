package com.exalt.resourcemanagementservice.controllers;
//import java.util.concurrent.atomic.AtomicInteger;

import com.exalt.resourcemanagementservice.models.Request;
import com.exalt.resourcemanagementservice.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RequestController {
    @Autowired
    ResourceService resourceService;
    //private final AtomicInteger counter = new AtomicInteger();
    @PostMapping("/request")
    public void addRequest(@RequestParam(value = "amount", defaultValue = "10") String amount) throws InterruptedException {
//        Request r= new Request(Integer.parseInt(amount));
//        r.start();
        //resourceService.handleRequest(new Request(counter.incrementAndGet(),Integer.parseInt(amount)));
        resourceService.handleRequest(new Request(Integer.parseInt(amount)));
        //return new Request(counter.incrementAndGet(),Integer.parseInt(amount));
    }
}
