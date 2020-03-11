/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import econometrica.Gdp;
import econometrica.GdpDataset;
import econometrica.Oil;
import econometrica.OilDataset;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Η κλάση χρησιμοποιείται για να καλούμε από την quandle τα endpoints
 * που αφορούν την χρήση πετρελαίου και Αεπ. Ενσωματώνει το api key καθώς και τα url των διευθύνσεων.
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
        //Το api key
        this.key = "YF9riQwEK95f-FXBm8Z3";
        //το url για το Gdp
        this.gdpUrl = "https://www.quandl.com/api/v3/datasets/WWDI/";        
        //Το url για την χρήση πετρελαίου
        this.oilUrl = "https://www.quandl.com/api/v3/datasets/BP/";       
    }
    
    /**
     * Χρησιμοποιείται για να καλέσει το endpoint της Quandle κάνοντας χρήση του Link .
     * Μετά την κλήση θα επιστρέψει ένα GDP object
     * 
     * @param countryCode
     * @return 
     */
    public Gdp getGdp(String countryCode){                            
        String result = this.get(this.gdpUrl+countryCode+"_NY_GDP_MKTP_CN.json?api_key="+this.key);
        if (result!= null){
            return this.GDPToObject(result);
        }else{
            return null;
        }
    }
    
    /**
     * 
     * Χρησιμοποιείται για να καλέσει το endpoint της quandle και να επιστρέψει την χρήση πετρελαίου
     * σε μορφή Oil object
     * 
     * @param countryCode
     * @return 
     */
    public Oil getOil(String countryCode){      
        String result = this.get(this.oilUrl+"OIL_CONSUM_"+countryCode+".json?api_key="+this.key);
        if (result!= null){
            return this.OilToObject(result);
        }else{
            return null;
        }
        
    }
      
    /**
     * Χρησιμοποιταί το okHttp για να καλέσουμε το endpoint της quandle. 
     * Βέβαια μπορεί να χρησιμοποιηθεί για οποιαδήποτε κλήση
     * 
     * @param url
     * @return 
     */
    private String get(String url){
        System.out.println(url);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        
        try(Response response = client.newCall(request).execute()){
            if(response.isSuccessful() && response.body() != null){
                String responseString = response.body().string();
                
                return responseString;
            }
        }catch(IOException e){
            return null;
            
        }
        
        return null;
    }
    
    /**
     * Μετασχηματισμός του Json String σε αντικείμενο OIL
     * 
     * @param jsonValue
     * @return 
     */
    private Oil OilToObject(String jsonValue) {   
        if(!jsonValue.equals(null)){        
            String jsonString = jsonValue;                 
            GsonBuilder builder = new GsonBuilder(); 
            builder.setPrettyPrinting(); 

            Gson gson = builder.create(); 
            OilDataset oild = gson.fromJson(jsonString, OilDataset.class);         

            Oil oil = oild.getDataset();

            jsonString = gson.toJson(oil);         

            return gson.fromJson(jsonString, Oil.class); 
        }else{
            return null;
        }
                
   }     
    
    /**
     * Μετασχηματισμός του Json String σε αντικείμενο GDP
     * 
     * @param jsonValue
     * @return 
     */
    private Gdp GDPToObject(String jsonValue) {         
        if(!jsonValue.equals(null)){   
            String jsonString = jsonValue;         
            GsonBuilder builder = new GsonBuilder(); 
            builder.setPrettyPrinting(); 

            Gson gson = builder.create(); 
            GdpDataset gdpd = gson.fromJson(jsonString, GdpDataset.class); 
            Gdp gdp = gdpd.getDataset();

            jsonString = gson.toJson(gdp);         

            return gson.fromJson(jsonString, Gdp.class); 
        }else{
            return null;
        }
                      
   }
}
