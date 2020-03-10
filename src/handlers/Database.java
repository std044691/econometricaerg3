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
     * Η συνάρτηση απλά επιστρέφει αν η χώρα είναι μέσα στην βάση. Η τιμή είναι τύπος Long
     * Θα μπορούσε να ήταν σε μορφή bool αλλά το αφήνω έτσι.
     *
     * @param countryCode παίρνει ως παράμετρο το iso code της χώρας
     * @return επιστροφή αρηθμού σε long πόσες χώρες είναι στην βάση
     */
    public static long isCountryInDb(String countryCode){
        try{
            //Δημιουργώ ένα instance χώρας για να το περάσω σαν παράμετρο στο query στην αναζήτηση
            em = emf.createEntityManager();
            //Δημιουργία του query. Εδώ δεν περνάω την τιμή του country ως αντικείμενο αλλά ως string γιατί δεν υπάρχει αναφορά σε αυτο
            // Είναι το προτεύον κληδή μας εδώ
            String select = "SELECT COUNT(c) FROM Country c WHERE c.isoCode = :code";
            //Ορισμός παραμέτρου
            TypedQuery<Long> query = em.createQuery(select, Long.class);

            //Επιστροφή της τιμής
            long countryCount = query.setParameter("code", countryCode).getSingleResult();
            //καθαρισμίος του entity manager
            em.clear();
            return countryCount;
        }catch(PersistenceException ex){
            System.out.println("Problem in database operations:"+ex.getMessage());
            return 0;
        }catch(Exception ex){
            return 0;
        }finally {
            //Κλείσιμο του entity manager
            em.close();
        }
    }

    /**
     * Καταχώρηση του εντικειμένου country στην βάση.
     * Περνάω το countryDataset ως παράμετρο και για κάθε dataset
     * Θα μπορούσα να καταχωρώ μόνο το country και ο persistance manager να τα περάσει μόνος του
     * Αλλά το κάνω ανάποδα για να δω αν γίνετε. Α
     *
     * @param countryDatasetList
     * @return
     */
    public static String insertCountryDataset(ArrayList<CountryDataset> countryDatasetList){        
        try{
            //Δημιουργώ ένα instance χώρας για να το περάσω σαν παράμετρο στο query στην αναζήτηση
            em = emf.createEntityManager();
            
            //Έναρξη transaction
            em.getTransaction().begin();
            
            //Για κάθε CountryDataset παω και εκτελώ το persist για να σωθεί στην βαση
            for(CountryDataset cdslist: countryDatasetList){
                em.persist(cdslist);
            }
            //Εδώ γίνετε το commit, που σώζει στην βάση
            em.getTransaction().commit();
            
            //Καθαρίζουμε τον manager
            em.clear();
        }catch(PersistenceException ex){
            System.out.println(ex.getMessage());
            return "Error :"+ ex.getMessage();
        }catch(Exception ex){
            return "Error :"+ ex.getMessage();
        }finally {
            //Κλείνουμε 
            em.close();
        }

        return "Data Saved";
    }


    /**
     * Διαγράφει όλα τα δεδομένα από την βάση
     */
    public static void deleteAll(){
        try{
            //Σύνδεση στην βάση
            em = emf.createEntityManager();
            //Ενημέρωση στον χρήστη ότι γίνετε διαγραφή
            System.out.println("Deleting..");
            //Έναρξη transaction
            em.getTransaction().begin();
            //Διαγραφή των δεδομένων από τον CountryData
            int deletedCountryDataCount = em.createQuery("DELETE FROM CountryData").executeUpdate();
            //Διαγραφή των δεδομένων από τον CountryDataset
            int deletedCountryDatasetCount = em.createQuery("DELETE FROM CountryDataset").executeUpdate();
            //Διαγραφή των δεδομένων από το Country
            int deletedCountryCount = em.createQuery("DELETE FROM Country").executeUpdate();
            //Απλή Ενημέρωση
            System.out.println("Deleted rows from("+ deletedCountryCount +") table countries and (" + deletedCountryDataCount + ") rows from CountryData and (" + deletedCountryDatasetCount+ ") rows from CountryDataset tables");
            //Commit της διαγραφής
            em.getTransaction().commit();
            //Καθαρισμός persistance
            em.clear();
        }catch(PersistenceException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally {            
            //Κλείσιμο του Entity manager
            em.close();
        }

    }


}
