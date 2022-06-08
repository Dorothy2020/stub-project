/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;


import com.sun.javafx.binding.Logging;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;





/**
 *
 * @author dorothy
 */
public class Data extends AbstractVerticle {
    private Logging logger;
    static int TIMEOUT_TIME = 25000;
    JsonObject request = new JsonObject();
    JsonObject result = new JsonObject();
    EventBus eventBus;
    
    public Data(JsonObject request) {
        this.result = result;
        this.request = request;
        logger = new Logging();
    }

    public static void main(String[]args){
        Vertx vertx=Vertx.vertx();
       
    }

    public JsonObject doLogins() {
        
        JsonObject data = request;
//        System.out.println("DATA :::::: " + data);
        JsonObject result = new JsonObject();
        result.put("response", "000");
        result.put("responseDescription", "Login Successful");
        result.put("FirstName", data.getString("FirstName"));
        result.put("LastName",data.getString("LastName"));
        result.put("BranchName",data.getString("BranchName"));
        result.put("Id",data.getString("1"));
        return result;
    
      
    }
      
}
          
          
           
