/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.complaintsclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import entities.Complaint;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.ClientConfig;

/**
 *
 * @author filip
 */
public class ComplaintsClient {

    public static void main(String[] args) {
        ClientConfig config = new ClientConfig();
        config.register(new ObjectMapper().registerModule(new JavaTimeModule()));
        Client client = ClientBuilder.newClient(config);
        
        String count = client.target("http://localhost:8080/Complaints/" + "resources/complaints/count")
            .request(MediaType.TEXT_PLAIN)
            .get(String.class);

        System.out.println("Count: " + count);

        Complaint[] complaints = client.target("http://localhost:8080/Complaints/" + "resources/complaints")
            .request(MediaType.APPLICATION_JSON)
            .get(Complaint[].class);
        System.out.println("Response: " + Arrays.toString(complaints));

        Complaint complaint = client.target("http://localhost:8080/Complaints/" + "resources/complaints/" + "2")
            .request(MediaType.APPLICATION_JSON)
            .get(Complaint.class);
        System.out.println("Response: " + complaint);
        
        complaint.setStatus("closed");
        client.target("http://localhost:8080/Complaints/" + "resources/complaints")
            .request(MediaType.APPLICATION_JSON)
            .put(Entity.json(complaint));
        
        List<Complaint> openedComplaintList = client.target("http://localhost:8080/Complaints/" + "resources/complaints")
            .queryParam("status", "open")
            .request(MediaType.APPLICATION_JSON)
            .get(List.class);
        System.out.println("Response: " + openedComplaintList);

        client.close();     
    }
}
