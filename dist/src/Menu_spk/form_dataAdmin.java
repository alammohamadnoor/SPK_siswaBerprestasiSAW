/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu_spk;

import Connection.koneksi;
import Login.regist_spk;
import java.sql.*;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class form_dataAdmin extends javax.swing.JFrame {
    private Connection conn = new koneksi().connect();
    private DefaultTableModel TabelAdmin;
    public static String nis;
    /**
     * Creates new form form_dataAdmin
     */
    public form_dataAdmin() {
        initComponents();
        txtnmlngkp.setText(regist_spk.getnama());
        String KD = UserID.getUserLogin();
        txtnmlngkp.setText(KD);
        kosong();    
        aktif();
        datatable();        
    }
    
    public void print () {
        try {
            Locale locale = new Locale( "id", "ID" );
            HashMap par = new HashMap();
            par.put(JRParameter.REPORT_LOCALE, locale);
            JasperPrint jp = JasperFillManager.fillReport
            (form_dataAdmin.class.getResourceAsStream("/Report/report_dataAdmin.jasper"), par, conn);
            JasperViewer.viewReport(jp, false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada"+ex);
        }
    }     
    
    protected void aktif (){
        txtusername.requestFocus();
        //cbprodi.setSelectedItem(null);
    }
    
    protected void kosong(){
        txtusername.setText("");
        txtpassword.setText("");
        txtnmadmin.setText("");
        txtemail.setText("");
        txtalamat.setText("");
        txtnotelp.setText("");
        txtcari.setText("");
        
    }
    protected void datatable(){
         Object [] Baris = {"Username","Password","Nama Admin","Alamat","Email","No. Telepon"};
            TabelAdmin = new DefaultTableModel(null,Baris);
            String cariitem = txtcari.getText();
            
            try{
                String sql = "SELECT * FROM tb_admin where username like '%"+cariitem+"%' or nama_admin like '%"+cariitem+"%'";
                Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
                    TabelAdmin.addRow(new Object [] {
                        hasil.getString(1),
                        hasil.getString(2),
                        hasil.getString(3),
                        hasil.getString(4),
                        hasil.getString(5),
                        hasil.getString(6)
                    });
                }
                tbadmin.setModel(TabelAdmin);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "data gagal Dipanggil"+e);
            }
    }    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtnotelp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbadmin = new javax.swing.JTable();
        bcancel = new javax.swing.JButton();
        bback = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        bprint = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtcari = new javax.swing.JTextField();
        bdelete = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        bsave = new javax.swing.JButton();
        txtusername = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        bexit = new javax.swing.JButton();
        bsiswa = new javax.swing.JButton();
        bkriteria = new javax.swing.JButton();
        bbobot = new javax.swing.JButton();
        bjurusan = new javax.swing.JButton();
        txtnmlngkp = new javax.swing.JLabel();
        badmin = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        bperhitungan = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        bhome = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtnmadmin = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtalamat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel1.setText("Masukkan Data Admin sesuai dengan identitas anda !");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Username");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 110, -1));

        txtpassword.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtpassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordKeyPressed(evt);
            }
        });
        jPanel1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 250, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Password");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 170, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Email");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 80, -1));

        txtemail.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtemail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 400, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("No. Telepon");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 80, -1));

        txtnotelp.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtnotelp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtnotelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 400, 30));

        tbadmin.setModel(new javax.swing.table.DefaultTableModel(
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
        tbadmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbadmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbadminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbadmin);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 650, 430));

        bcancel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        bcancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/clear_symbol_20px.png"))); // NOI18N
        bcancel.setText("Batal");
        bcancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcancelActionPerformed(evt);
            }
        });
        jPanel1.add(bcancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(533, 470, 90, -1));

        bback.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        bback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back_arrow_20px.png"))); // NOI18N
        bback.setText("Kembali");
        bback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbackActionPerformed(evt);
            }
        });
        jPanel1.add(bback, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        bedit.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        bedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/edit_20px.png"))); // NOI18N
        bedit.setText("Ubah");
        bedit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });
        jPanel1.add(bedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 470, -1, -1));

        bprint.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        bprint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/print_20px.png"))); // NOI18N
        bprint.setText("Cetak");
        bprint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bprintActionPerformed(evt);
            }
        });
        jPanel1.add(bprint, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 40, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Username");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 140, -1));

        txtcari.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtcari.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariKeyPressed(evt);
            }
        });
        jPanel1.add(txtcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 240, 30));

        bdelete.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        bdelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete_bin_20px.png"))); // NOI18N
        bdelete.setText("Hapus");
        bdelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeleteActionPerformed(evt);
            }
        });
        jPanel1.add(bdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 470, -1, -1));

        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search_in_list_20px.png"))); // NOI18N
        jButton10.setText("Cari");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 40, 80, -1));

        bsave.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        bsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save_20px.png"))); // NOI18N
        bsave.setText("Simpan");
        bsave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsaveActionPerformed(evt);
            }
        });
        jPanel1.add(bsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 100, -1));

        txtusername.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtusername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtusername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtusernameKeyPressed(evt);
            }
        });
        jPanel1.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 250, 30));

        jPanel2.setBackground(new java.awt.Color(240, 189, 108));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(34, 105, 54));
        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 20, 50));

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
        jPanel2.add(bexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 170, 50));

        bsiswa.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        bsiswa.setText("  Data Siswa");
        bsiswa.setBorder(null);
        bsiswa.setBorderPainted(false);
        bsiswa.setContentAreaFilled(false);
        bsiswa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bsiswa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bsiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsiswaActionPerformed(evt);
            }
        });
        jPanel2.add(bsiswa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 170, 50));

        bkriteria.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        bkriteria.setText("  Data Kriteria");
        bkriteria.setBorder(null);
        bkriteria.setBorderPainted(false);
        bkriteria.setContentAreaFilled(false);
        bkriteria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bkriteria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bkriteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkriteriaActionPerformed(evt);
            }
        });
        jPanel2.add(bkriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 170, 50));

        bbobot.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        bbobot.setText("  Data Bobot");
        bbobot.setBorder(null);
        bbobot.setBorderPainted(false);
        bbobot.setContentAreaFilled(false);
        bbobot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bbobot.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bbobot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbobotActionPerformed(evt);
            }
        });
        jPanel2.add(bbobot, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 170, 50));

        bjurusan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        bjurusan.setText("  Data Jurusan");
        bjurusan.setBorder(null);
        bjurusan.setBorderPainted(false);
        bjurusan.setContentAreaFilled(false);
        bjurusan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bjurusan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bjurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bjurusanActionPerformed(evt);
            }
        });
        jPanel2.add(bjurusan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 170, 50));

        txtnmlngkp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtnmlngkp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtnmlngkp.setText("Nama Lengkap User");
        jPanel2.add(txtnmlngkp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 190, -1));

        badmin.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        badmin.setText("  Data Admin");
        badmin.setBorder(null);
        badmin.setBorderPainted(false);
        badmin.setContentAreaFilled(false);
        badmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        badmin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        badmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                badminActionPerformed(evt);
            }
        });
        jPanel2.add(badmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 170, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 170, 50));

        bperhitungan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        bperhitungan.setText("  Perhitungan");
        bperhitungan.setBorder(null);
        bperhitungan.setBorderPainted(false);
        bperhitungan.setContentAreaFilled(false);
        bperhitungan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bperhitungan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bperhitungan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bperhitunganActionPerformed(evt);
            }
        });
        jPanel2.add(bperhitungan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 170, 50));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/PGRI.CLR. (2).png"))); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        bhome.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        bhome.setText("  Beranda");
        bhome.setBorder(null);
        bhome.setBorderPainted(false);
        bhome.setContentAreaFilled(false);
        bhome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bhome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhomeActionPerformed(evt);
            }
        });
        jPanel2.add(bhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 170, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 530));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Nama Admin");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 170, -1));

        txtnmadmin.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtnmadmin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtnmadmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnmadminKeyPressed(evt);
            }
        });
        jPanel1.add(txtnmadmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 400, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Alamat");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 170, -1));

        txtalamat.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtalamat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtalamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtalamatKeyPressed(evt);
            }
        });
        jPanel1.add(txtalamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 400, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 530));

        setSize(new java.awt.Dimension(1325, 568));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyPressed

    }//GEN-LAST:event_txtpasswordKeyPressed

    private void tbadminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbadminMouseClicked
        int bar = tbadmin.getSelectedRow();
        String a = TabelAdmin.getValueAt(bar, 0). toString();
        String b = TabelAdmin.getValueAt(bar, 1). toString();
        String c = TabelAdmin.getValueAt(bar, 2). toString();
        String d = TabelAdmin.getValueAt(bar, 3). toString();
        String e = TabelAdmin.getValueAt(bar, 4). toString();
        String f = TabelAdmin.getValueAt(bar, 5). toString();

        txtusername.setText(a);
        txtpassword.setText(b);
        txtnmadmin.setText(c);
        txtalamat.setText(d);
        txtemail.setText(e);
        txtnotelp.setText(f);
    }//GEN-LAST:event_tbadminMouseClicked

    private void bcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcancelActionPerformed
        kosong();
    }//GEN-LAST:event_bcancelActionPerformed

    private void bbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbackActionPerformed

        main_menu menu;
        menu = new main_menu();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_bbackActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        try {
            String sql = "update tb_admin set password=?,nama_admin=?,alamat=?,email=?,no_telp=?  where username='"+txtusername.getText()+"'";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtpassword.getText());
            stat.setString(2, txtnmadmin.getText());
            stat.setString(3, txtalamat.getText());
            stat.setString(4, txtemail.getText());
            stat.setString(5, txtnotelp.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil Diubah");
            kosong();
            txtusername.requestFocus();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah" +e);
        }
        datatable();
    }//GEN-LAST:event_beditActionPerformed

    private void bprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprintActionPerformed
        print();
    }//GEN-LAST:event_bprintActionPerformed

    private void txtcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcariKeyPressed

    private void bdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdeleteActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "hapus", "konfirmasi dialog",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String sql = "delete from tb_admin where username = '"+txtusername.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                kosong();
                txtusername.requestFocus();
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null,"Data Gagal Dihapus"+e);
            }
            datatable();
        }
    }//GEN-LAST:event_bdeleteActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        datatable();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void bsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsaveActionPerformed
        String sql = "insert into tb_admin values (?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtusername.getText());
            stat.setString(2, txtpassword.getText());
            stat.setString(3, txtnmadmin.getText());
            stat.setString(4, txtalamat.getText());
            stat.setString(5, txtemail.getText());
            stat.setString(6, txtnotelp.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil Disimpan");
            kosong();
            txtusername.requestFocus();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal disimpan"+e);
        }
        datatable();
    }//GEN-LAST:event_bsaveActionPerformed

    private void txtusernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusernameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameKeyPressed

    private void bexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bexitActionPerformed
        int tny = JOptionPane.showConfirmDialog(null, "Yakin Ingin Keluar ?","Tanya",JOptionPane.YES_NO_OPTION);
        if (tny==0) {
            try {
                dispose();

            } catch (Exception e) {
            }
        }
        new Login.login_spk().setVisible(true);
    }//GEN-LAST:event_bexitActionPerformed

    private void bsiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsiswaActionPerformed
        form_dataSiswa siswa;
        siswa = new form_dataSiswa();
        siswa.setVisible(true);
        dispose();        
    }//GEN-LAST:event_bsiswaActionPerformed

    private void bkriteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkriteriaActionPerformed
        form_dataKriteria kriteria;
        kriteria = new form_dataKriteria();
        kriteria.setVisible(true);
        dispose();
    }//GEN-LAST:event_bkriteriaActionPerformed

    private void bbobotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbobotActionPerformed
        form_dataBobot bobot;
        bobot = new form_dataBobot();
        bobot.setVisible(true);
        dispose();
    }//GEN-LAST:event_bbobotActionPerformed

    private void bjurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bjurusanActionPerformed
        form_dataJurusan jurusan;
        jurusan = new form_dataJurusan();
        jurusan.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_bjurusanActionPerformed

    private void bperhitunganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bperhitunganActionPerformed
        form_perhitungan perhitungan;
        perhitungan = new form_perhitungan();
        perhitungan.setVisible(true);
        dispose();
    }//GEN-LAST:event_bperhitunganActionPerformed

    private void badminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badminActionPerformed
        form_dataAdmin admin;
        admin = new form_dataAdmin();
        admin.setVisible(true);
        dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_badminActionPerformed

    private void bhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhomeActionPerformed
        main_menu menu;
        menu = new main_menu();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_bhomeActionPerformed

    private void txtnmadminKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnmadminKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnmadminKeyPressed

    private void txtalamatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtalamatKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtalamatKeyPressed

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
            java.util.logging.Logger.getLogger(form_dataAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_dataAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_dataAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_dataAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_dataAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton badmin;
    private javax.swing.JButton bback;
    private javax.swing.JButton bbobot;
    private javax.swing.JButton bcancel;
    private javax.swing.JButton bdelete;
    private javax.swing.JButton bedit;
    private javax.swing.JButton bexit;
    private javax.swing.JButton bhome;
    private javax.swing.JButton bjurusan;
    private javax.swing.JButton bkriteria;
    private javax.swing.JButton bperhitungan;
    private javax.swing.JButton bprint;
    private javax.swing.JButton bsave;
    private javax.swing.JButton bsiswa;
    private javax.swing.JButton jButton10;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbadmin;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnmadmin;
    private javax.swing.JLabel txtnmlngkp;
    private javax.swing.JTextField txtnotelp;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
