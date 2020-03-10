/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import java.util.ArrayList;
import javax.persistence.*;
import model.*;
import java.sql.Connection;

/**
 *
 * @author themhz
 */
public class Database {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ergasia3PU");   
    private static EntityManager em;
    private static Connection connection= null;    
      
    
    /**
     * 
     * Χρησιμοποιείται για να πάρει τα δεδομένα χρήσης πετρελαίου από την βάση
     * 
     * @param country Το iso code του country
     * @return επιστρέφει ένα αντικείμενο countryDataset
     */
    public static CountryDataset getOil(String country){
        //Σύνδεση με την βάση δεδομένων κάνοντας χρήση το EntityManager
        EntityManager em = emf.createEntityManager();
                
        try{
            //Δημιουργώ ένα instance χώρας για να το περάσω σαν παράμετρο στο query στην αναζήτηση
            Country c = new Country(country);
            //Δημιουργία του query στην βάση
            TypedQuery<CountryDataset> query = em.createQuery("SELECT c FROM CountryDataset c WHERE c.name like :name AND c.countryCode = :code", CountryDataset.class);
            //Ορισμός παραμέτρων
            query.setParameter("name", "%Oil Consumption%");
            query.setParameter("code", c);           
            //Επιστροφή του αντικειμένου
            return query.getSingleResult();
            
        }catch(PersistenceException ex){
            //Έλεγχος αν υπάρχει πρόβλημα με το persistance manager
            System.out.println("Problem in database operations:"+ex.getMessage());
            return null;                    
        }catch(Exception ex){
            //Οποιοδήποτε άλλο σφάλμα το τυπώνει εδώ
            System.out.println(ex.getMessage());
            return null;
        }finally {
            //Κλείσιμο του entity manager
            em.close();
        }
        
    }
    
    /**
     * 
     * @param country παίρνει ως παράμετρο το iso code της χώρας
     * @return επιστρέφει countryDataset για το ΑΕΠ της χώρας
     */
    public static CountryDataset getGdp(String country){                
        try{
            //Δημιουργώ ένα instance χώρας για να το περάσω σαν παράμετρο στο query στην αναζήτηση
            em = emf.createEntityManager();
            //Εντάξει αντί για iso code θα μπορούσα να περάσω το αντικείμενο ολόκληρο
            Country c = new Country(country);
            //Δημιουργία του query 
            TypedQuery<CountryDataset> query = em.createQuery("SELECT c FROM CountryDataset c WHERE c.name like :name AND c.countryCode = :code", CountryDataset.class);
            
            //Παράμετροι..
            query.setParameter("name", "%GDP (current LCU)%");
            query.setParameter("code", c);
            
            //Επιτροφή του αντικειμένου 
            return query.getSingleResult();            
        }catch(PersistenceException ex){
            //Handling του exception
            System.out.println("Problem in database operations:"+ex.getMessage());
            return null;                    
        }catch(Exception ex){
            return null;
        }finally {
            
            //Κλείσιμο της σύνδεσης
            em.close();
        }
    }

    /**
     * 
     * @param countryCode
     * @return 
     */
    public static long isCountryInDb(String countryCode){        
        try{               
            em = emf.createEntityManager();
            String select = "SELECT COUNT(c) FROM Country c WHERE c.isoCode = :code";
            TypedQuery<Long> query = em.createQuery(select, Long.class);                        
            long countryCount = query.setParameter("code", countryCode).getSingleResult();          
            em.clear();            
            return countryCount;
        }catch(PersistenceException ex){
            System.out.println("Problem in database operations:"+ex.getMessage());
            return 0;
        }catch(Exception ex){
            return 0;
        }finally {
            em.close();
        }
    }
    
    public static String insertCountryDataset(ArrayList<CountryDataset> countryDatasetList){        
        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            for(CountryDataset cdslist: countryDatasetList){            
                em.persist(cdslist);                        
            }
            em.getTransaction().commit();
            em.clear();
        }catch(PersistenceException ex){
            System.out.println(ex.getMessage());
            return "Error :"+ ex.getMessage();                    
        }catch(Exception ex){
            return "Error :"+ ex.getMessage();
        }finally {
            em.close();
        }
        
        return "Data Saved";
    }
   
    
    public static void deleteAll(){        
        try{
            em = emf.createEntityManager();
            System.out.println("Deleting..");            
            em.getTransaction().begin();                
            int deletedCountryDataCount = em.createQuery("DELETE FROM CountryData").executeUpdate();
            int deletedCountryDatasetCount = em.createQuery("DELETE FROM CountryDataset").executeUpdate();
            int deletedCountryCount = em.createQuery("DELETE FROM Country").executeUpdate();                
            System.out.println("Deleted rows from("+ deletedCountryCount +") countries and (" + deletedCountryDataCount + ") rows from CountryData and (" + deletedCountryDatasetCount+ ") rows from CountryDataset tables");
            em.getTransaction().commit();
            em.clear();
        }catch(PersistenceException ex){
                
        }catch(Exception ex){
            
        }finally {
            em.close();
        }
                
    }
    
    
}
