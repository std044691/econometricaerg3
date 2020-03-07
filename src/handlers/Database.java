/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import econometrica.Oil;
import java.util.ArrayList;
import java.util.HashMap;
import javax.persistence.*;
import model.*;

/**
 *
 * @author themhz
 */
public class Database {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ergasia3PU");
    private static EntityManager em = emf.createEntityManager();        
    
    
    public static CountryDataset getOil(String country){
        Country c = new Country(country);
                
        TypedQuery<CountryDataset> query = em.createQuery("SELECT c FROM CountryDataset c WHERE c.name like :name AND c.countryCode = :code", CountryDataset.class);
        query.setParameter("name", "%Oil Consumption%");
        query.setParameter("code", c);           
        return query.getSingleResult();
    }
    
    public static CountryDataset getGdp(String country){
        Country c = new Country(country);
        
        TypedQuery<CountryDataset> query = em.createQuery("SELECT c FROM CountryDataset c WHERE c.name like :name AND c.countryCode = :code", CountryDataset.class);
        query.setParameter("name", "%GDP (current LCU)%");
        query.setParameter("code", c);
        return query.getSingleResult();
    }

    public static long isCountryInDb(String countryCode){
                
        String select = "SELECT COUNT(c) FROM Country c WHERE c.isoCode = :code";
        TypedQuery<Long> query = em.createQuery(select, Long.class);                
        
        long countryCount = query.setParameter("code", countryCode).getSingleResult();  
        
        em.clear();
        
        return countryCount;
    }
    
    public static String insertCountryDataset(ArrayList<CountryDataset> countryDatasetList){
        
        try{
            em.getTransaction().begin();
            for(CountryDataset cdslist: countryDatasetList){            
                em.persist(cdslist);                        
            }
            em.getTransaction().commit();
            em.clear();
        }catch(Exception ex){
            return "Error :"+ ex.getMessage();
        }                
        return "Data Saved";
    }
   
    
    public static void deleteAll(){
        
        System.out.println("Deleting..");
        
        em.getTransaction().begin();                
        int deletedCountryDataCount = em.createQuery("DELETE FROM CountryData").executeUpdate();
        int deletedCountryDatasetCount = em.createQuery("DELETE FROM CountryDataset").executeUpdate();
        int deletedCountryCount = em.createQuery("DELETE FROM Country").executeUpdate();                
        System.out.println("Deleted (" + deletedCountryDataCount + ") rows from CountryData and (" + deletedCountryDatasetCount+ ") rows from CountryDataset tables");
        em.getTransaction().commit();
        em.clear();
                
    }
    
    
}
