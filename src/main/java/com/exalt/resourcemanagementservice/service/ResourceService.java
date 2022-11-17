package com.exalt.resourcemanagementservice.service;

import com.exalt.resourcemanagementservice.models.Request;
import com.exalt.resourcemanagementservice.models.Server;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ResourceService {
    ArrayList<Server> servers=new ArrayList<Server>();
    private final AtomicInteger counter = new AtomicInteger();

    public Server addServer(int requestedAmount) throws InterruptedException {
        //Server server=new Server(servers.size(),100);
        Server server=new Server(counter.incrementAndGet(),100);
       // server.setRequestedAmounts(requestedAmount);
        //synchronized (server){
        server.setRequestedAmounts(requestedAmount);
        servers.add(server);
        //server.setRequestedAmounts(requestedAmount);
        Thread.sleep(5000);
        server.setCapacity(100- server.getRequestedAmounts());
        server.setRequestedAmounts(0);
        //    }
        //System.out.println("Server used is newest one"+ " amount left in server "+server.getCapacity());

        return server;
    }
    public void handleRequest(Request request) throws InterruptedException {
        request.start();
        int requested=request.getValue();
        System.out.println(request.getId() +" value "+requested);
        for(int i=0;i<servers.size();i++){
            if(servers.get(i).getCapacity()>=requested && (servers.get(i).getCapacity()-servers.get(i).getRequestedAmounts())>=requested){
                synchronized (servers.get(i)){
                if(servers.get(i).getRequestedAmounts()!=0){
                    servers.get(i).setRequestedAmounts(servers.get(i).getRequestedAmounts()+requested);
                }else{
                servers.get(i).setCapacity(servers.get(i).getCapacity()-requested);}}
                //System.out.println(servers.get(i).getCapacity());
                //System.out.println("Server used "+i+ " amount left in server "+servers.get(i).getCapacity());
                return;
            }
        }
        addServer(requested);


    }

}
