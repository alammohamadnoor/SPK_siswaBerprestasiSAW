/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.sql.*;
import Connection.koneksi;
import Menu_spk.UserID;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class login_spk extends javax.swing.JFrame {
    private Connection conn = new koneksi().connect();
    public static String user;
    ResultSet rs = null;
    PreparedStatement pst = null;

    
    public login_spk() {
        initComponents();
        aktif();
    }
    
    public static String getusername(){
        return user;
    }
    
    protected void aktif (){
        txtusername.requestFocus();
        //cbprodi.setSelectedItem(null);
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        bdaftar_buku2 = new javax.swing.JButton();
        bexit = new javax.swing.JButton();
        bregis = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        blogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(240, 189, 108));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bdaftar_buku2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        bdaftar_buku2.setText("  Login");
        bdaftar_buku2.setBorder(null);
        bdaftar_buku2.setBorderPainted(false);
        bdaftar_buku2.setContentAreaFilled(false);
        bdaftar_buku2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bdaftar_buku2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bdaftar_buku2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdaftar_buku2ActionPerformed(evt);
            }
        });
        jPanel3.add(bdaftar_buku2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 50));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 170, 50));

        bexit.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        bexit.setText("  Keluar");
        bexit.setBorder(null);
        bexit.setBorderPainted(false);
        bexit.setContentAreaFilled(false);
        bexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bexit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bexitActionPerformed(evt);
            }
        });
        jPanel2.add(bexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 170, 50));

        bregis.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        bregis.setText("  Daftar Admin");
        bregis.setBorder(null);
        bregis.setBorderPainted(false);
        bregis.setContentAreaFilled(false);
        bregis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bregis.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bregis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bregisActionPerformed(evt);
            }
        });
        jPanel2.add(bregis, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 170, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/PGRI.CLR. (2).png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jPanel4.setBackground(new java.awt.Color(34, 105, 54));
        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 20, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SMK PGRI 28 Jakarta");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 190, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 400));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setText("SELAMAT DATANG");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, -1, -1));

        txtusername.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtusername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 340, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Username");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Password");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, -1, -1));

        txtpass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 340, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user_30px.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/password_30px.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

        blogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        blogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/login_35px.png"))); // NOI18N
        blogin.setText("  Login");
        blogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        blogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloginActionPerformed(evt);
            }
        });
        jPanel1.add(blogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        setSize(new java.awt.Dimension(717, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bdaftar_buku2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdaftar_buku2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bdaftar_buku2ActionPerformed

    private void bregisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bregisActionPerformed
        confirm_admin confirm;
        confirm = new confirm_admin();
        confirm.setVisible(true);
        dispose();
    }//GEN-LAST:event_bregisActionPerformed

    private void bloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloginActionPerformed
        try{
            String username = txtusername.getText();
            String pass= String.valueOf(txtpass.getPassword());
            String SQL = "Select * from tb_admin where username ='" +username+"' and password='"+pass+"'";
            PreparedStatement state = conn.prepareStatement(SQL);
            ResultSet Result = state.executeQuery(SQL);
            if(Result.next()){
                UserID.setUserLogin(Result.getString("nama_admin"));
                if(txtusername.getText().equals(Result.getString("username"))&&
                        String.valueOf(txtpass.getPassword()).equals(Result.getString("password"))){
                    user = Result.getString("username");
                    JOptionPane.showMessageDialog(this, "Selamat Datang \nSistem Penunjang Keputusan\nSMK PGRI 28 Jakarta");
                    
                }
                dispose();
                new Menu_spk.main_menu().setVisible(true);
            }else{
                    JOptionPane.showMessageDialog(null, "Login Gagal");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Username/Password Salah "+e);
        }
    }//GEN-LAST:event_bloginActionPerformed

    private void bexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bexitActionPerformed
       int tny = JOptionPane.showConfirmDialog(null, "Yakin Ingin Keluar ?","Tanya",JOptionPane.YES_NO_OPTION);
        if (tny==0) {     
            try {
                System.exit(0);
            } catch (Exception e) {
            }
        }     
    }//GEN-LAST:event_bexitActionPerformed

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
            java.util.logging.Logger.getLogger(login_spk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_spk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_spk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_spk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_spk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bdaftar_buku2;
    private javax.swing.JButton bexit;
    private javax.swing.JButton blogin;
    private javax.swing.JButton bregis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
