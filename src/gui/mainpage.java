/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import econometrica.RestApi;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;


/**
 *
 * @author themhz
 */
public class mainpage extends javax.swing.JFrame {

    /**
     * Creates new form mainpage
     */
    private HashMap<String, String> hmCountries = new HashMap<String, String>();
    
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnApiCall = new javax.swing.JButton();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOil = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGDP = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblselectedCountry = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 541));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnApiCall.setText("Fetch Data");
        btnApiCall.setToolTipText("");
        btnApiCall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApiCallActionPerformed(evt);
            }
        });
        getContentPane().add(btnApiCall, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 140, -1));

        cbCountries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCountriesActionPerformed(evt);
            }
        });
        getContentPane().add(cbCountries, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 271, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Oil Data");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Dataset Name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("GDP Data");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Dataset Name:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        lblOil.setText("-");
        getContentPane().add(lblOil, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 451, 207, -1));

        lblGdp.setText("-");
        getContentPane().add(lblGdp, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 451, 223, -1));

        jLabel6.setText("Start Date:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel7.setText("End Date:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        lblOilStartDate.setText("-");
        getContentPane().add(lblOilStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        lblOilEndDate.setText("-");
        getContentPane().add(lblOilEndDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jLabel10.setText("Start Date:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        jLabel11.setText("End Date:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        lblGdpStartDate.setText("-");
        getContentPane().add(lblGdpStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));

        lblGdpEndDate.setText("-");
        getContentPane().add(lblGdpEndDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

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
        jScrollPane2.setViewportView(tblOil);
        if (tblOil.getColumnModel().getColumnCount() > 0) {
            tblOil.getColumnModel().getColumn(0).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 271, 260));

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
        jScrollPane3.setViewportView(tblGDP);
        if (tblGDP.getColumnModel().getColumnCount() > 0) {
            tblGDP.getColumnModel().getColumn(0).setResizable(false);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 271, 260));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Select a country:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblselectedCountry.setText("-");
        getContentPane().add(lblselectedCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnApiCallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApiCallActionPerformed
        // TODO add your handling code here:
        RestApi ra = new RestApi("YF9riQwEK95f-FXBm8Z3");
        //https://www.quandl.com/api/v3/datasets/WWDI/GRC_NY_GDP_MKTP_CN.json?api_key=YF9riQwEK95f-FXBm8Z3
        System.out.println(ra.get("https://www.quandl.com/api/v3/datasets/WWDI/GRC_NY_GDP_MKTP_CN.json"));
        System.out.println(ra.get("https://www.quandl.com/api/v3/datasets/BP/OIL_CONSUM_GRC.json"));        
    }//GEN-LAST:event_btnApiCallActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            BufferedReader fileReader = null;
            String line = "";
        
            //File file = new File("C:\\Users\\themhz\\Documents\\NetBeansProjects\\ergasia3\\src\\gui\\iso-countries.csv");            
            //fileReader = new BufferedReader(new FileReader("C:\\Users\\themhz\\Documents\\NetBeansProjects\\ergasia3\\src\\gui\\iso-countries.csv"));
            fileReader = new BufferedReader(new FileReader("src/gui/iso-countries.csv"));
            try {
                cbCountries.removeAllItems();
                fileReader.readLine();
                while ((line = fileReader.readLine()) != null) {
                    //Get all tokens available in line
                    System.out.println(line);
                    String[] tokens = line.split(";");
                    hmCountries.put(tokens[0], tokens[2]);
                    if (tokens.length > 0) {
                        cbCountries.addItem(tokens[0]);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            

        } catch (FileNotFoundException ex) {
            Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_formWindowOpened

    private void cbCountriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCountriesActionPerformed
        // TODO add your handling code here:
    
        System.out.println(cbCountries.getSelectedItem());
        //lblselectedCountry.setText(cbCountries.getSelectedItem().toString());        
        lblselectedCountry.setText(hmCountries.get(cbCountries.getSelectedItem().toString()).toString());
    }//GEN-LAST:event_cbCountriesActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
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
