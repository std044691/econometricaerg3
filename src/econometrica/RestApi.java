/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package econometrica;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author themhz
 */

public class RestApi {
    private String key;

    public RestApi(String key) {      
        this.key = key;
    }
    
    public String get(String url){
        //String urlToCall = "https://www.quandl.com/api/v3/datasets/WWDI/GRC_NY_GDP_MKTP_CN.json?api_key="+this.key;
        String urlToCall = url+"?api_key="+this.key;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(urlToCall).build();
        
        try(Response response = client.newCall(request).execute()){
            if(response.isSuccessful() && response.body() != null){
                String responseString = response.body().string();
                
                return responseString;
            }
        }catch(IOException e){
            e.printStackTrace();
            
        }
        
        return null;
    }
    
    
    public Oil OilToObject(String jsonValue) {         
        String jsonString = jsonValue;                 
        GsonBuilder builder = new GsonBuilder(); 
        builder.setPrettyPrinting(); 

        Gson gson = builder.create(); 
        OilDataset oild = gson.fromJson(jsonString, OilDataset.class); 
        Oil oil = oild.getDataset();
        
        jsonString = gson.toJson(oil);         

        return gson.fromJson(jsonString, Oil.class); 
                
   }     
    
    public Gdp GDBToObject(String jsonValue) {         
        String jsonString = jsonValue;         
        GsonBuilder builder = new GsonBuilder(); 
        builder.setPrettyPrinting(); 

        Gson gson = builder.create(); 
        GdpDataset gdpd = gson.fromJson(jsonString, GdpDataset.class); 
        Gdp gdp = gdpd.getDataset();
        
        jsonString = gson.toJson(gdp);         

        return gson.fromJson(jsonString, Gdp.class); 
                      
   }
}
