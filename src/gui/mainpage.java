/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import econometrica.Gdp;
import econometrica.Oil;
import econometrica.Quandle;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;
import model.Country;
import model.CountryData;
import model.CountryDataset;


/**
 *
 * @author themhz
 */
public class mainpage extends javax.swing.JFrame {

    /**
     * Creates new form mainpage
     */
    private HashMap<String, String> hmCountries = new HashMap<String, String>();
    
    private ArrayList<CountryDataset> countryDatasetList = new ArrayList<CountryDataset>();
    private ArrayList<CountryData> countryDataList = new ArrayList<CountryData>();    
    
    private String countryCode;
    public mainpage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbCountries = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblOil = new javax.swing.JLabel();
        lblGdp = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblOilStartDate = new javax.swing.JLabel();
        lblOilEndDate = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblGdpStartDate = new javax.swing.JLabel();
        lblGdpEndDate = new javax.swing.JLabel();
        btnApiCall = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGDP = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblselectedCountry = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOil = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Econometrica");
        setPreferredSize(new java.awt.Dimension(1000, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setLayout(null);

        cbCountries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCountriesActionPerformed(evt);
            }
        });
        jPanel1.add(cbCountries);
        cbCountries.setBounds(30, 40, 240, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Oil Data");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 70, 70, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Dataset Name:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(300, 100, 83, 14);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("GDP Data");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(300, 80, 53, 14);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Dataset Name:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 100, 83, 14);

        lblOil.setText("-");
        jPanel1.add(lblOil);
        lblOil.setBounds(30, 120, 240, 14);

        lblGdp.setText("-");
        jPanel1.add(lblGdp);
        lblGdp.setBounds(300, 120, 240, 14);

        jLabel6.setText("Start Date:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 160, 60, 14);

        jLabel7.setText("End Date:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 180, 60, 14);

        lblOilStartDate.setText("-");
        jPanel1.add(lblOilStartDate);
        lblOilStartDate.setBounds(110, 160, 160, 14);

        lblOilEndDate.setText("-");
        jPanel1.add(lblOilEndDate);
        lblOilEndDate.setBounds(110, 180, 160, 14);

        jLabel10.setText("Start Date:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(300, 160, 70, 14);

        jLabel11.setText("End Date:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(300, 180, 60, 14);

        lblGdpStartDate.setText("-");
        jPanel1.add(lblGdpStartDate);
        lblGdpStartDate.setBounds(370, 160, 160, 14);
        lblGdpStartDate.getAccessibleContext().setAccessibleName("");

        lblGdpEndDate.setText("-");
        jPanel1.add(lblGdpEndDate);
        lblGdpEndDate.setBounds(370, 180, 170, 14);

        btnApiCall.setText("Fetch Data");
        btnApiCall.setToolTipText("");
        btnApiCall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApiCallActionPerformed(evt);
            }
        });
        jPanel1.add(btnApiCall);
        btnApiCall.setBounds(300, 40, 90, 23);

        tblGDP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Year", "Value"
            }
        ));
        tblGDP.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblGDP.setPreferredSize(null);
        jScrollPane3.setViewportView(tblGDP);
        if (tblGDP.getColumnModel().getColumnCount() > 0) {
            tblGDP.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(300, 210, 250, 240);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Select a country:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 20, 95, 14);

        lblselectedCountry.setText("-");
        jPanel1.add(lblselectedCountry);
        lblselectedCountry.setBounds(696, 239, 4, 14);

        tblOil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Year", "Value"
            }
        ));
        tblOil.setPreferredSize(null);
        jScrollPane2.setViewportView(tblOil);
        if (tblOil.getColumnModel().getColumnCount() > 0) {
            tblOil.getColumnModel().getColumn(0).setResizable(false);
            tblOil.getColumnModel().getColumn(0).setHeaderValue("Year");
            tblOil.getColumnModel().getColumn(1).setHeaderValue("Value");
        }

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(30, 210, 240, 240);

        btnSave.setText("Save");
        btnSave.setToolTipText("");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);
        btnSave.setBounds(30, 480, 57, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(615, 580));
    }// </editor-fold>//GEN-END:initComponents

    private void btnApiCallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApiCallActionPerformed
        // TODO add your handling code here:
        Quandle quandle = new Quandle();
        this.countryDataList.clear();
        
        populateOil(quandle);
        //populateGdp(quandle);
    }//GEN-LAST:event_btnApiCallActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
                
        try {
            BufferedReader fileReader = null;
            String line = "";
            //Ανάγνωση του csv και ποπουλάρει το ντροπντουν
            fileReader = new BufferedReader(new FileReader("src/gui/iso-countries.csv"));
            try {
                cbCountries.removeAllItems();
                fileReader.readLine();
                while ((line = fileReader.readLine()) != null) {
                    //Get all tokens available in line                 
                    String[] tokens = line.split(";");
                    hmCountries.put(tokens[0], tokens[2]);
                    if (tokens.length > 0) {
                        cbCountries.addItem(tokens[0]);
                    }
                }                
                //cbCountries.setSelectedIndex(84);
                cbCountries.setSelectedItem("GREECE");
                
            } catch (IOException ex) {
                Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
            }                        

        } catch (FileNotFoundException ex) {
            Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_formWindowOpened

    private void cbCountriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCountriesActionPerformed
        this.countryCode = hmCountries.get(cbCountries.getSelectedItem().toString()).toString();
        lblselectedCountry.setText(this.countryCode);
    }//GEN-LAST:event_cbCountriesActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        System.out.println("Saving data..");
        //saveCountries();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ergasia3PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        saveCountryDataset(em);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void saveCountryDataset(EntityManager em){
        
         //System.out.println(this.cdsl.toString());
        for(CountryDataset cdslist: this.countryDatasetList){            
            em.persist(cdslist);            
            em.getTransaction().commit();
        }
        //em.getTransaction().commit();
        //em.clear();
        
        //cdsl.add(cds);
        
    }
    
    
    
    
    private void saveCountries(){
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("ergasia3PU");
         EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();         
             
         hmCountries.forEach((Cname,Ccode)->{
            Country country = new Country();
            country.setIsoCode(Ccode);
            country.setName(Cname);
            em.persist(country);
            
             System.out.println("Inserting " + country.getName());
         });             
         
         em.getTransaction().commit();    
         
         em.clear();
    }
    private void populateOil(Quandle ra){        
        
        Oil oil = ra.getOil(this.countryCode);
        DefaultTableModel model = new DefaultTableModel();
        String header[] = new String[] { "Year", "value" };
        model.setColumnIdentifiers(header);

        lblOil.setText(oil.getName());
        
        
        Country country = new Country();
        CountryDataset countryDataset = new CountryDataset();
        //CountryData countryData = new CountryData();

        countryDataset.setName(oil.getName());
        countryDataset.setDescription(oil.getDescription());        
        String pattern = "yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);  

        String getStart_date = simpleDateFormat.format(oil.getStart_date());
        String getEnd_date = simpleDateFormat.format(oil.getEnd_date());

        countryDataset.setStartYear(getStart_date);
        countryDataset.setEndYear(getEnd_date);
        lblOilStartDate.setText(getStart_date);
        lblOilEndDate.setText(getEnd_date);

        country.setName(cbCountries.getSelectedItem().toString());
        country.setIsoCode(this.countryCode);
        
        countryDataset.setCountryCode(country);
        
        List<CountryData> list = new ArrayList<CountryData>();
        
        for(ArrayList<String> oildata: oil.getData()){
            CountryData cd = new CountryData();
            
            String[] gdpYear = oildata.get(0).split("-");
            
            cd.setDataYear(gdpYear[0]);
            cd.setValue(oildata.get(1));     
            cd.setDataset(countryDataset);
            list.add(cd);
            
            System.out.println(oildata.get(0)+" - " + oildata.get(1));            
        }
        
        countryDataset.setCountryDataList(list);
                
        this.countryDatasetList.add(countryDataset);
        
        
         for(int i=0;i<oil.getData().size();i++){
            
            String[] oilYear = oil.getData().get(i).get(0).split("-");
            model.addRow(new Object[]{oilYear[0], oil.getData().get(i).get(1)});
            tblOil.setModel(model);      
            //cd.setDataset(cds);
            //cd.setValue(gdp.getData().get(i).get(1));
            //cd.setDataYear(gdpYear[0]);
            //cdl.add(cd);
        }
                
    }    
    private void populateGdp(Quandle ra){
                
        Gdp gdp = ra.getGdp(this.countryCode);
        DefaultTableModel model = new DefaultTableModel();
        String header[] = new String[] { "Year", "value" };
        model.setColumnIdentifiers(header);
        lblGdp.setText(gdp.getName());
        
        //String pattern = "yyyy-MM-dd";
        String pattern = "yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);  
        
        String getStart_date = simpleDateFormat.format(gdp.getStart_date());
        String getEnd_date = simpleDateFormat.format(gdp.getEnd_date());
        
        lblGdpStartDate.setText(getStart_date);
        lblGdpEndDate.setText(getEnd_date);
        //Extra code
        
        Country c = new Country();
        CountryDataset cds = new CountryDataset();        
        CountryData cd = new CountryData();
        
        cds.setName(gdp.getName());
        cds.setDescription(gdp.getDescription());
        cds.setStartYear(getStart_date);
        cds.setEndYear(getEnd_date);
        
        c.setName(cbCountries.getSelectedItem().toString());
        c.setIsoCode(this.countryCode);
        cds.setCountryCode(c);
         
        //cds.setCountryDataCollection(cdl);
        this.countryDatasetList.add(cds);
        
        //Extra code        
        
        for(int i=0;i<gdp.getData().size();i++){
            
            String[] gdpYear = gdp.getData().get(i).get(0).split("-");
            model.addRow(new Object[]{gdpYear[0], gdp.getData().get(i).get(1)});
            tblGDP.setModel(model);      
            //cd.setDataset(cds);
            //cd.setValue(gdp.getData().get(i).get(1));
            //cd.setDataYear(gdpYear[0]);
            //cdl.add(cd);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApiCall;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbCountries;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblGdp;
    private javax.swing.JLabel lblGdpEndDate;
    private javax.swing.JLabel lblGdpStartDate;
    private javax.swing.JLabel lblOil;
    private javax.swing.JLabel lblOilEndDate;
    private javax.swing.JLabel lblOilStartDate;
    private javax.swing.JLabel lblselectedCountry;
    private javax.swing.JTable tblGDP;
    private javax.swing.JTable tblOil;
    // End of variables declaration//GEN-END:variables
}
