/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSetMetaData;
import java.util.Vector;

/**
 *
 * @author LENOVO
 */
public class arayüz_müşteriler extends javax.swing.JFrame {

    /**
     * Creates new form arayüz_müşteriler
     */
    public arayüz_müşteriler() {
        initComponents();
        müşterilistesi();        //Frame açıldığı anda listeyi göster
    }
    DefaultTableModel df;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtmüştel = new javax.swing.JTextField();
        txtmüşadres = new javax.swing.JTextField();
        txtmüşad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Müşteri Ad");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Telefon");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Adres");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Güncelle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Yeni Müşteri Ekle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(49, 49, 49))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(94, 94, 94)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmüşadres, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmüştel, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmüşad, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtmüşad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtmüştel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtmüşadres))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(26, 26, 26))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Müşteri Id", "Müşteri Ad", "Müşteri Telefon", "Müşteri Adres"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Kapat");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jButton3)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void müşterilistesi()  //müşterilerdeki tüm kayıtları jtabelde listeleyen fonksiyon
    {        
        try{
        String host="jdbc:derby://localhost:1527/proje";
        String uName="rabia";
        String uPass="123456789";        
        Connection con=DriverManager.getConnection(host,uName,uPass);
        
        Statement stmt1=con.createStatement();
        int a;
        String SQL1="SELECT *FROM MÜŞTERILER";         
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
                v2.add(rs.getString("müşteriId"));
                v2.add(rs.getString("müşteriAd"));
                v2.add(rs.getString("müşteriTel"));
                v2.add(rs.getString("müşteriAdres"));
            }
            df.addRow(v2);
        }
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
        
    }
    
    //yeni müşteri ekle butonuna basınca
    //textboxlardaki değerleri alıp yeni kayıt ekleyen fonksiyon
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        try{
        String host="jdbc:derby://localhost:1527/proje";
        String uName="rabia";
        String uPass="123456789";        
        Connection con=DriverManager.getConnection(host,uName,uPass);
                                   //default -> otomatik artan olduğu için
        String sql = "INSERT INTO Müşteriler VALUES (DEFAULT, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, txtmüşad.getText());
        stmt.setString(2, txtmüştel.getText());
        stmt.setString(3, txtmüşadres.getText());
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Yeni müşteri sisteme eklendi.");
        txtmüşad.setText("");   //kayıt eklenince textboxlar temizlensin
        txtmüştel.setText("");
        txtmüşadres.setText("");
        txtmüşad.requestFocus();   //???
        müşterilistesi(); //her yeni kayıt eklendiğininde liste güncellensin
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    //jtable'den bir kayıta tıklanınca o değerler textboxara gelsin
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        df=(DefaultTableModel)jTable1.getModel();
        int selected=jTable1.getSelectedRow();
        txtmüşad.setText(df.getValueAt(selected, 1).toString());
        txtmüştel.setText(df.getValueAt(selected, 2).toString());
        txtmüşadres.setText(df.getValueAt(selected, 3).toString());
        //jButton2 yeni müşteri ekleme butonu
        //tablodan seçilen kayıdın tekrar tabloya eklenmemesi için butona basılmasını engelledik
        jButton2.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    //kayıt güncelleme butonu
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        df=(DefaultTableModel)jTable1.getModel();
        int selected=jTable1.getSelectedRow(); 
        int id=Integer.parseInt(df.getValueAt(selected,0).toString());
        //tabloda seçtiğimiz değeri selected değişkenine atadık
        //seçilen değerin 0. elemanını (müşteriId) id değişkenine atadık
        try{
        String host="jdbc:derby://localhost:1527/proje";
        String uName="rabia";
        String uPass="123456789";        
        Connection con=DriverManager.getConnection(host,uName,uPass);
        
        //textboxlardaki bilgiler alınarak kayıt güncelensin
        String sql = "UPDATE Müşteriler set müşteriAd=? ,müşteriTel=?, müşteriAdres=? where müşteriId=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, txtmüşad.getText());
        stmt.setString(2, txtmüştel.getText());
        stmt.setString(3, txtmüşadres.getText());
        stmt.setInt(4, id); //seçilen değer sayesinde elde ettiğimiz id
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Müşteri bilgileri güncellendi.");
        txtmüşad.setText("");
        txtmüştel.setText("");
        txtmüşadres.setText("");
        txtmüşad.requestFocus();   //???
        müşterilistesi(); //her yeni kayıt eklendiğininde liste güncellensin
        jButton2.setEnabled(true);
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        } 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);  //Müşteriler sayfasını kapatıp(görünmez yapma) ana ekrana dönme
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(arayüz_müşteriler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(arayüz_müşteriler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(arayüz_müşteriler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(arayüz_müşteriler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new arayüz_müşteriler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtmüşad;
    private javax.swing.JTextField txtmüşadres;
    private javax.swing.JTextField txtmüştel;
    // End of variables declaration//GEN-END:variables
}
