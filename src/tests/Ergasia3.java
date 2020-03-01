/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import econometrica.Chart;
import econometrica.Gdp;
import econometrica.GsonTester;
import econometrica.Oil;
import econometrica.Quandle;
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
        GsonTester();
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
        Quandle ra = new Quandle();
        Oil result = ra.getOil("GRC");
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
    
    public static void GsonTester(){
        GsonTester gt= new GsonTester();
        Quandle ra = new Quandle();
        Gdp result = ra.getGdp("GDP");
        System.out.println(result);
        //gt.testGDB(result);
    }      
    
}
