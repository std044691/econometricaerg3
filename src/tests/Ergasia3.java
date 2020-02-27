/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import econometrica.Chart;
import econometrica.GsonTester;
import econometrica.RestApi;
import java.text.ParseException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Country;
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
        RestApi ra = new RestApi("YF9riQwEK95f-FXBm8Z3");
        String result = ra.get("https://www.quandl.com/api/v3/datasets/BP/OIL_CONSUM_GRC.json");
        System.out.println(result);
        gt.testOil(result);
    }
    
    
    public static void GdpTest(){
        GsonTester gt= new GsonTester();
        RestApi ra = new RestApi("YF9riQwEK95f-FXBm8Z3");
        String result = ra.get("https://www.quandl.com/api/v3/datasets/WWDI/GRC_NY_GDP_MKTP_CN.json");
        System.out.println(result);
        gt.testGDB(result);
    }
    
    public static void GsonTester(){
        GsonTester gt= new GsonTester();
        RestApi ra = new RestApi("YF9riQwEK95f-FXBm8Z3");
        String result = ra.get("https://www.quandl.com/api/v3/datasets/WWDI/GRC_NY_GDP_MKTP_CN.json");
        System.out.println(result);
        gt.testGDB(result);
    }
    
    public static void OkHTTPTest(){
        RestApi ra = new RestApi("YF9riQwEK95f-FXBm8Z3");
        System.out.println(ra.get("https://www.quandl.com/api/v3/datasets/WWDI/GRC_NY_GDP_MKTP_CN.json"));
        System.out.println(ra.get("https://www.quandl.com/api/v3/datasets/BP/OIL_CONSUM_GRC.json"));
    }
 
    
}
