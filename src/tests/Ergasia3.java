/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import econometrica.Chart;
import econometrica.Gdp;
import econometrica.GsonTester;
import econometrica.Oil;
import econometrica.OilDataset;
import econometrica.Quandle;
import econometrica.QuandleDataset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Country;
import model.CountryData;
import model.CountryDataset;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author themhz
 */
public class Ergasia3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        //OkHTTPTest();
        //GsonTeste2();
        //GsonTester();
        //GdpTest();
        //OilTest();
        //ChartTest();
        //asdsadsaa        
            
        //InsertDBTest();
        testInsert();
    }
    
    public static void InsertDBTest() throws ParseException{
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("ergasia3PU");
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
         Country country = new Country();
         country.setIsoCode("CHA");
         country.setName("CCHOU");
         em.persist(country);
         em.getTransaction().commit();    
         em.clear();

    }
    
    
    public static void ChartTest(){
        final Chart demo = new Chart("Dual Axis Demo 2");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
    
    public static void OilTest(){
        GsonTester gt= new GsonTester();
        Quandle quandle = new Quandle();
        String jsonString = quandle.getJsonData("GRC");
        GsonBuilder builder = new GsonBuilder(); 
        builder.setPrettyPrinting(); 
        Gson gson = builder.create(); 
        CountryDataset cd = gson.fromJson(jsonString, CountryDataset.class);         

        //System.out.println(cd);
        //Oil result = ra.getOil("GRC");
        //System.out.println(result);
        //gt.testOil(result.toString());
    }
    
    
    public static void GdpTest(){
        GsonTester gt= new GsonTester();
        Quandle ra = new Quandle();
        //String result = ra.getGdp("GRC");
        //System.out.println(result);
        //gt.testGDB(result);
    }
    
    public static void testInsert(){        
        Quandle quandle = new Quandle();
        Oil oil = quandle.getOil("GRC");
        
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting(); 
        Gson gson = builder.create(); 
        
        CountryDataset countrydataset = new CountryDataset();
        //Name
        countrydataset.setName(oil.getName());
        //Description
        countrydataset.setDescription(oil.getDescription());
        
        //Star & End Date
        String pattern = "yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        
        String getStart_date = simpleDateFormat.format(oil.getStart_date());
        countrydataset.setStartYear(getStart_date);
        
        String getEnd_date = simpleDateFormat.format(oil.getEnd_date());
        countrydataset.setEndYear(getEnd_date);
                        
        
        List<CountryData> list = new ArrayList<CountryData>();
        
        for(ArrayList<String> oildata: oil.getData()){
            CountryData cd = new CountryData();
            
            String[] gdpYear = oildata.get(0).split("-");
            
            cd.setDataYear(gdpYear[0]);
            cd.setValue(oildata.get(1));     
            cd.setDataset(countrydataset);
            list.add(cd);
            
            System.out.println(oildata.get(0)+" - " + oildata.get(1));            
        }
        
        //cds.setCountryDataCollection(list);
        
        countrydataset.setCountryDataList(list);
        //From
        //ArrayList<ArrayList<String>>
        //To 
        //Collection<CountryData>
       // cds.setCountryDataCollection();
                                
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ergasia3PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(countrydataset);
        em.flush();
        em.getTransaction().commit();
        em.clear();
        
        System.out.println("ok");
        
    }      
    
}
