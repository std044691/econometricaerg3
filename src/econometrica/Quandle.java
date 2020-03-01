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

public class Quandle {
    private String key;
    private String oilUrl;
    private String gdpUrl;

    public Quandle(String key, String oilUrl, String gdpUrl) {      
        this.key = key;
        this.oilUrl = oilUrl;
        this.gdpUrl = gdpUrl;
    }
    
    public Quandle(){
        this.key = "YF9riQwEK95f-FXBm8Z3";
        this.gdpUrl = "https://www.quandl.com/api/v3/datasets/WWDI/";        
        this.oilUrl = "https://www.quandl.com/api/v3/datasets/BP/";       
    }
    
    public Gdp getGdp(String countryCode){            
        return this.GDBToObject(this.get(this.gdpUrl+countryCode+"_NY_GDP_MKTP_CN.json?api_key="+this.key));
    }
    
    public Oil getOil(String countryCode){            
        return this.OilToObject(this.get(this.oilUrl+"OIL_CONSUM_"+countryCode+".json?api_key="+this.key));
    }
    
    public String getJsonData(String countryCode){
        return this.get(this.oilUrl+"OIL_CONSUM_"+countryCode+".json?api_key="+this.key);
    }
        
    
    private String get(String url){
        
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        
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
    
    
    private Oil OilToObject(String jsonValue) {         
        String jsonString = jsonValue;                 
        GsonBuilder builder = new GsonBuilder(); 
        builder.setPrettyPrinting(); 

        Gson gson = builder.create(); 
        OilDataset oild = gson.fromJson(jsonString, OilDataset.class);         
        
        Oil oil = oild.getDataset();
        
        jsonString = gson.toJson(oil);         

        return gson.fromJson(jsonString, Oil.class); 
                
   }     
    
    private Gdp GDBToObject(String jsonValue) {         
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
