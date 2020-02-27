/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package econometrica;
import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;  
import java.util.ArrayList;
/**
 *
 * @author themhz
 */
public class GsonTester {
    
    public void testOil(String jsonValue) { 
        //String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";      
        //String jsonString = "{\"id\":22163003,\"dataset_code\":\"GRC_NY_GDP_MKTP_CN\",\"database_code\":\"WWDI\",\"name\":\"GDP (current LCU) - Greece\",\"description\":\"GDP (current LCU) - Greece. \",\"refreshed_at\":\"2019-06-25T21:19:10.949Z\",\"newest_available_date\":\"2017-12-31\",\"oldest_available_date\":\"1960-12-31\",\"column_names\":[\"Date\",\"Value\"],\"frequency\":\"annual\",\"type\":\"Time Series\",\"premium\":false,\"limit\":null, \"transform\":null,\"column_index\":null,\"start_date\":\"1960-12-31\",\"end_date\":\"2017-12-31\",\"data\":[[\"2017-12-31\",180217594600.0],[\"2016-12-31\",176487946700.0]]}"; 
        String jsonString = jsonValue; 
        //System.out.println(jsonValue);
        System.out.println("-----------");
        GsonBuilder builder = new GsonBuilder(); 
        builder.setPrettyPrinting(); 

        Gson gson = builder.create(); 
        OilDataset oild = gson.fromJson(jsonString, OilDataset.class); 
        Oil oil = oild.getDataset();
        jsonString = gson.toJson(oil); 
        //System.out.println(gdp.getId());

        Gdp gp = gson.fromJson(jsonString, Gdp.class); 
        System.out.println(gp);
      
        jsonString = gson.toJson(gp); 
        System.out.println(jsonString);  
   }     
    
    public void testGDB(String jsonValue) {         
        String jsonString = jsonValue;         
        GsonBuilder builder = new GsonBuilder(); 
        builder.setPrettyPrinting(); 

        Gson gson = builder.create(); 
        GdpDataset gdpd = gson.fromJson(jsonString, GdpDataset.class); 
        Gdp gdp = gdpd.getDataset();
        
        jsonString = gson.toJson(gdp);         

        Gdp gp = gson.fromJson(jsonString, Gdp.class); 
        System.out.println(gp);
      
        jsonString = gson.toJson(gp); 
        System.out.println(jsonString);
   }
     
}
