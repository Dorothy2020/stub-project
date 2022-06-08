/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apistub;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;


/**
 *
 * @author dorothy
 */
public class stub {
    public static void main(String[] args){
//        Vertx vertx=Vertx.vertx();
//         vertx.createHttpServer().requestHandler(req->{
//                  req.response().end("FirstName");
//              }).listen(300);
//    }
//    
//}

              Vertx vertx= Vertx.vertx();
               HttpServer ovHttpServer = vertx.createHttpServer();
                ovHttpServer.requestHandler(request -> {
		
		HttpServerResponse response = request.response();
            response.headers()
                    .add("Content-Type", "application/json")
                    .add("Access-Control-Allow-Origin", "*")
                    .add("Access-Control-Allow-Headers", "*")
                    .add("Access-Control-Allow-Methods", "*")
                    .add("Access-Control-Allow-Credentials", "true");
                response.end("FirstName","Wendy");
                
            String method = request.rawMethod();
            String path = request.path();
                
		
            
                request.bodyHandler(bodyHandler -> {
                String body = bodyHandler.toString();
                JsonObject responseOBJ = new JsonObject();
                if ("POST".equalsIgnoreCase(method)) {
                    JsonObject data = new JsonObject(body);
                    data.put("timestamp",Long.toHexString(System.currentTimeMillis()));
                    JsonObject dataLog = data;
             

//                    logger.applicationLog(logger.logPreString() + "Channel Request  - " + dataLog + "\n\n", "", 2);
                    if (path.endsWith("/ApiStub/req")) {
	            JsonObject resobject = new JsonObject();
                   
                                //send response
//                       logger.applicationLog(logger.logPreString() + "Response to channel - " + resobject + "\n\n", "", 3);
                         response.end(resobject.toString());

					}
                        
                } else {
                    // wrong request method
                    responseOBJ.put("response", "999")
                            .put("responseDescription", "Bad Request");

                    response.end(responseOBJ.toString());
                }
                });
                
            
                ovHttpServer.listen(1011,resp->{
                    if(resp.succeeded()){
                        System.out.println("System listening at"  +":" );
                        
                    }
                     else {
                        System.out.println("System failed to start !!" + resp.failed
                        ());
                    }
                });
                
            
            
	});
     
        
                }
                        }

    

