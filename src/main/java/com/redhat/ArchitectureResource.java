package com.redhat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/arch")
public class ArchitectureResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getArch() {
        try {
            Process p = Runtime.getRuntime().exec("uname -a");
            String uname = new BufferedReader(new InputStreamReader(p.getInputStream())).readLine();
            String[] array = uname.split(" ");
            String arch = array[array.length-2];
            return Response.status(200).entity(arch).build();
        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(500).entity(e.getMessage()).build();
        }        
    }
}