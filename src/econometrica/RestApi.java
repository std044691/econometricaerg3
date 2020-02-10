/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package econometrica;

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
}
