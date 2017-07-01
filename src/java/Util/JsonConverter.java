/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import com.google.gson.Gson;

/**
 *
 * @author ASUS
 */
public class JsonConverter {
    
    public static String stringify(Object o){
        Gson gson = new Gson();
        return gson.toJson(o);
    }
}
