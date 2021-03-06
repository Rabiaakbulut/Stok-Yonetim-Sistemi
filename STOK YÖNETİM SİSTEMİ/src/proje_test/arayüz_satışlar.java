/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class arayüz_satışlar extends javax.swing.JFrame {

    /**
     * Creates new form arayüz_satışlar
     */
    public arayüz_satışlar() {
        initComponents();
        satışlistesi(); //Frame açılır açılmaz satışlar listesi tabloda gözüksün
        comboboxseçenekleri1(); //comboboxlarda görünecek seçenekler
        comboboxseçenekleri2();
    }
    DefaultTableModel df;
    
    public void satışlistesi() //ürünlerdeki tüm kayıtları jtabelde listeleyen fonksiyon
    {
        try{
        String host="jdbc:derby://localhost:1527/proje";
        String uName="rabia";
        String uPass="123456789";        
        Connection con=DriverManager.getConnection(host,uName,uPass);
        
        Statement stmt1=con.createStatement();
        int a;
        String SQL1="SELECT *FROM Satışlar";
        ResultSet rs = stmt1.executeQuery( SQL1 );
        
        ResultSetMetaData rd=rs.getMetaData();
        a=rd.getColumnCount();
        df=(DefaultTableModel)jTable1.getModel();
        df.setRowCount(0);
        while(rs.next())
        {
            Vector v2 =new Vector();
            for(int i=1; i<=a; i++)
            {
                v2.add(rs.getString("satışId"));
                v2.add(rs.getString("miktar"));
                v2.add(rs.getString("ürünId"));
                v2.add(rs.getString("MüşteriId"));
            }
            df.addRow(v2);
        }
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }
    
    public void comboboxseçenekleri1() //comboboxta gösterilecek olan müşteriidleri ayarlayan fonksiyon
    {
        try{
        String host="jdbc:derby://localhost:1527/proje";
        String uName="rabia";
        String uPass="123456789";        
        Connection con=DriverManager.getConnection(host,uName,uPass);
        
        String query = "SELECT distinct müşteriId from Satışlar";
        //Satışlarda kayıtlı olan müşteriidleri comboboxa ekle
        PreparedStatement pstmt = con.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        jComboBox1.removeAllItems();
        while(rs.next()) {
            jComboBox1.addItem(rs.getString("müşteriId"));
        }
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }
    
    public void comboboxseçenekleri2() //comboboxta gösterilecek olan müşteriidleri ayarlayan fonksiyon
    {
        try{
        String host="jdbc:derby://localhost:1527/proje";
        String uName="rabia";
        String uPass="123456789";        
        Connection con=DriverManager.getConnection(host,uName,uPass);
        
        String query = "SELECT distinct ürünId from Satışlar";
        //Satışlarda kayıtlı olan ürünIdl'leri comboboxa ekle
        PreparedStatement pstmt = con.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        jComboBox2.removeAllItems();
        while(rs.next()) {
            jComboBox2.addItem(rs.getString("ürünId"));
        }
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Satış Id", "Satılan Miktar", "Ürün Id", "Müşteri Id"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Listele");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Tümünü Listele");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Kapat");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Müşteri Id");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Ürün Id");

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Listele");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Dosyaya Yazdır");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("Dosyadan Oku");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(0, 34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jButton1)
                                .addComponent(jButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4)
                            .addComponent(jButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //comboboxtan seçilen müşteriId'nin yapmış olduğu satın alma işlemlerini listeleyen fonksiyon
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
        String host="jdbc:derby://localhost:1527/proje";
        String uName="rabia";
        String uPass="123456789";        
        Connection con=DriverManager.getConnection(host,uName,uPass);
        
        int a;
        
        Statement stmt = con.createStatement();
        String query = "SELECT *FROM Satışlar where müşteriId="+jComboBox1.getSelectedItem().toString()+"";
        ResultSet rs =  stmt.executeQuery(query);
        
        ResultSetMetaData rd=rs.getMetaData();
        a=rd.getColumnCount();
        df=(DefaultTableModel)jTable1.getModel();
        df.setRowCount(0);
        while(rs.next())
        {
            Vector v2 =new Vector();
            for(int i=1; i<=a; i++)
            {
                v2.add(rs.getString("satışId"));
                v2.add(rs.getString("miktar"));
                v2.add(rs.getString("ürünId"));
                v2.add(rs.getString("müşteriId"));
            }
            df.addRow(v2);
        }
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //tüm satışları listele
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        satışlistesi();
    }//GEN-LAST:event_jButton2ActionPerformed

    //kapatma tuşu
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    //comboboxtan seçilen ürünId nin satışının yapıldığı kayıtlar
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{
        String host="jdbc:derby://localhost:1527/proje";
        String uName="rabia";
        String uPass="123456789";        
        Connection con=DriverManager.getConnection(host,uName,uPass);
        
        int a;
        Statement stmt = con.createStatement();
        String query = "SELECT *FROM Satışlar where ürünId="+jComboBox2.getSelectedItem().toString()+"";
        ResultSet rs =  stmt.executeQuery(query);
        
        ResultSetMetaData rd=rs.getMetaData();
        a=rd.getColumnCount();
        df=(DefaultTableModel)jTable1.getModel();
        df.setRowCount(0);
        while(rs.next())
        {
            Vector v2 =new Vector();
            for(int i=1; i<=a; i++)
            {
                v2.add(rs.getString("satışId"));
                v2.add(rs.getString("miktar"));
                v2.add(rs.getString("ürünId"));
                v2.add(rs.getString("müşteriId"));
            }
            df.addRow(v2);
        }
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    //satış kayıtlarını dosyaya yazdırma
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       String filePath = "C:\\Users\\LENOVO\\Desktop\\PROJE_TEST\\src\\proje_test\\satışlar.txt";
        File file = new File(filePath);
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("SATIŞLAR LİSTESİ\n\n");
            bw.write("satış id"+"\tmiktar"+"\t\türün id"+"\t\tmüşteri id\n");
            for(int i = 0; i < jTable1.getRowCount(); i++){//rows
                for(int j = 0; j < jTable1.getColumnCount(); j++){//columns
                    bw.write(jTable1.getValueAt(i, j).toString()+"\t\t");
                }
                bw.newLine();
            }
            JOptionPane.showMessageDialog(this, "Veriler dosyaya kaydedildi");
            bw.close();
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(arayüz_satışlar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    //dosyadan alınan değerleri textAreada görüntüleme
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try
                {
                    FileReader reader = new FileReader( "C:\\Users\\LENOVO\\Desktop\\PROJE_TEST\\src\\proje_test\\satışlar.txt" );
                    BufferedReader br = new BufferedReader(reader);
                    jTextArea1.read(br, null);
                    br.close();
                    jTextArea1.requestFocus();
                    reader.close();
                    br.close();
                }
                catch(Exception e) 
                { JOptionPane.showMessageDialog(null, e); }
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(arayüz_satışlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(arayüz_satışlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(arayüz_satışlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(arayüz_satışlar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new arayüz_satışlar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
