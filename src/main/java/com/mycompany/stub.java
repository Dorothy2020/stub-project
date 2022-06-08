/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;



/**
 *
 * @author dorothy
 */



    public class stub extends AbstractVerticle {
   

     public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(stub.class.getName());
        

       
    }

    @Override
    public void start(Future<Void> start_application) {

        HttpServer ovHttpServer;
        ovHttpServer = vertx.createHttpServer();
            ovHttpServer.requestHandler(request -> {
            HttpServerResponse response = request.response();
            response.headers()
                    .add("Content-Type", "application/json")
                    .add("Access-Control-Allow-Origin", "*")
                    .add("Access-Control-Allow-Headers", "*")
                    .add("Access-Control-Allow-Methods", "*")
                    .add("Access-Control-Allow-Credentials", "true");
            
            String method = request.rawMethod();
            String path = request.path();

            request.bodyHandler(bodyHandler -> {
                String body = bodyHandler.toString();
                JsonObject responseOBJ = new JsonObject();
                if ("POST".equalsIgnoreCase(method)) {
                    JsonObject data = new JsonObject(body);
                         
//                     System.out.println("DATA :::::: " + data);
                    if (path.endsWith("/ApiStub/req")) {
                        String processingCode = data.getString("processingCode");
                         
                        try {
                            switch (processingCode) 
                            {
                                case "920000":
                                    
                                Data login = new Data(data); 
                                responseOBJ = login.doLogins();
                                response.end(responseOBJ.toString());
                            }
                            // check validity

                        } catch (Exception ex) {
                            responseOBJ.put("response_code", "901")
                                       
                                    .put("response", ex.getLocalizedMessage());
                                    
                            response.end(responseOBJ.toString());
                        }
                    } else {
                        // Unknown path
                        responseOBJ.put("response_code", "404")
                                .put("response", "Invalid path");
                                
                        response.end(responseOBJ.toString());
                         
                    }
                } else {
                    // wrong request method
                    responseOBJ.put("response_code", "901")
                            .put("response", "Bad Request");
                    response.end(responseOBJ.toString());
                }
                
            });
                    });
            
       
       
        
    
    
        ovHttpServer.listen(1011, resp -> {
            if (resp.succeeded()) {
                System.out.println("System listening at " + "0.0.0.0" + ":" + 1011);
            } else {
                System.out.println("System failed to start !!" + resp.failed());
            }
        });

    }
    }
    
   
        
        
         
    
 



    

