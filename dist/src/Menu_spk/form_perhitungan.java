/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu_spk;

import Connection.koneksi;
import Login.regist_spk;
import java.sql.*;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class form_perhitungan extends javax.swing.JFrame {
    private Connection conn = new koneksi().connect();
    private DefaultTableModel TabelDataMahasiswa;
    private DefaultTableModel TabelKriteria;
    private DefaultTableModel TabelNormalisasi;
    private DefaultTableModel TabelPeringkat;
    /**
     * Creates new form form_perhitungan
     */
    public form_perhitungan() {
        initComponents();
        txtnmlngkp.setText(regist_spk.getnama());
        String KD = UserID.getUserLogin();
        txtnmlngkp.setText(KD);
        TabelDataSiswa();
        TabelKriteria();
    }
    
    protected void TabelDataSiswa(){
         Object [] Baris = {"NIS","Nama","Kelas","Jurusan","Alamat","No. Telepon"};
            TabelDataMahasiswa = new DefaultTableModel(null,Baris);
            
            
            try{
                String sql = "SELECT * FROM tb_siswa";
                Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
                    TabelDataMahasiswa.addRow(new Object [] {
                        hasil.getString(1),
                        hasil.getString(2),
                        hasil.getString(3),
                        hasil.getString(4),
                        hasil.getString(5),
                        hasil.getString(6)
                    });
                }
                tbsiswa.setModel(TabelDataMahasiswa);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "data gagal Dipanggil"+e);
            }
    }
    
    protected void TabelKriteria(){
         Object [] Baris = {"ID Kriteria","Ujian Sekolah","Uji Kompetensi","Nilai Sekolah","NIS"};
            TabelKriteria = new DefaultTableModel(null,Baris);
            
            
            try{
                String sql = "SELECT * FROM tb_kriteria";
                Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
                    TabelKriteria.addRow(new Object [] {
                        hasil.getString(1),
                        hasil.getFloat(2),
                        hasil.getFloat(3),
                        hasil.getFloat(4),
                        //hasil.getFloat(5),
                        //hasil.getFloat(6),
                        hasil.getString(5)
                        
                    });
                }
                tbkriteria.setModel(TabelKriteria);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "data gagal Dipanggil"+e);
            }
    }
    
    protected void TabelPeringkat(){
        try {
            TabelPeringkat = new DefaultTableModel();
            TabelPeringkat.addColumn("NIS");
            TabelPeringkat.addColumn("Grade");
            tbperingkat.setModel(TabelPeringkat);
            
            String sql = "SELECT * FROM tb_peringkat order by grade desc";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                    TabelPeringkat.addRow(new Object[]{
                        hasil.getString(1),
                        hasil.getFloat(2)}); 
                     }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    protected void TabelNormalisasi(){
        LinkedList maximum = new LinkedList();
        //LinkedList mm = new LinkedList();
        Object [] Baris ={"C1","C2","C3"};
        TabelNormalisasi = new DefaultTableModel(null, Baris);
        try{
            String SQL = "select max(C1),"
                    + " max(C2), "
                    + "max(C3) "
                    //+ "max(C4) "
                    //+ "max(C5) "
                    + "from "
                    + "tb_kriteria";
            Statement State = conn.createStatement();
            ResultSet hasil = State.executeQuery(SQL);
            while(hasil.next()){
               
                    maximum.add(hasil.getInt(1)); 
                    maximum.add(hasil.getInt(2));
                    maximum.add(hasil.getInt(3)); 
                    //maximum.add(hasil.getInt(4));
                    //maximum.add(hasil.getInt(5));
            }     

                String sql = "select C1,C2,C3 from tb_kriteria";
                Statement Stet = conn.createStatement();
                ResultSet hasil2 = Stet.executeQuery(sql);
            
            while (hasil2.next()){
                TabelNormalisasi.addRow(new Object[]{
                    (hasil2.getFloat(1)/Float.valueOf(maximum.get(0).toString())),
                    (hasil2.getFloat(2)/Float.valueOf(maximum.get(1).toString())),
                    (hasil2.getFloat(3)/Float.valueOf(maximum.get(2).toString())),
                    //(hasil2.getFloat(4)/Float.valueOf(maximum.get(3).toString())),
                    //(hasil2.getFloat(5)/Float.valueOf(maximum.get(4).toString())),
                    //(Float.valueOf(maximum.get(3).toString())/hasil2.getFloat(5))
                });
                
            }tbnormalisasi.setModel(TabelNormalisasi);
            }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil "+e);
        }
    }
    
    
    protected void peringkat (){ 
        try{
            LinkedList mm = new LinkedList();
            
            String SQL = "SELECT b1,b2,b3 from tb_bobot";
            Statement State = conn.createStatement();
            ResultSet hasil = State.executeQuery(SQL);
            TabelPeringkat();
            while (hasil.next()){
                 mm.add(hasil.getString(1));
                 mm.add(hasil.getString(2));
                 mm.add(hasil.getString(3));
                 //mm.add(hasil.getString(4));
                 //mm.add(hasil.getString(5));
            }
			
                for (int t = 0; t < tbnormalisasi.getRowCount(); t++) {
                    String sql = "DELETE FROM tb_peringkat WHERE nis = nis";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.executeUpdate();
                }
                for (int x = 0; x < tbnormalisasi.getRowCount(); x++){
                    float krit1;
                    float krit2;
                    float krit3;
                    //float krit4;
                    //float krit5;
                    float W;
                        krit1 = (Float.valueOf(tbnormalisasi.getValueAt(x, 0).toString())*Float.valueOf(mm.get(0).toString()));
                        krit2 = (Float.valueOf(tbnormalisasi.getValueAt(x, 1).toString())*Float.valueOf(mm.get(1).toString()));
                        krit3 = (Float.valueOf(tbnormalisasi.getValueAt(x, 2).toString())*Float.valueOf(mm.get(2).toString()));
                        //krit4 = (Float.valueOf(tbnormalisasi.getValueAt(x, 3).toString())*Float.valueOf(mm.get(3).toString()));
                        //krit5 = (Float.valueOf(tbnormalisasi.getValueAt(x, 4).toString())*Float.valueOf(mm.get(4).toString()));
                        
                        W=krit1+krit2+krit3;
                
                        String sql1 = "insert into tb_peringkat values(?,?)";
                        PreparedStatement St1 = conn.prepareStatement(sql1);
                        St1.setString(1, (String)tbkriteria.getValueAt(x, 4));
                        St1.setFloat(2, W);
                        St1.executeUpdate();
                }TabelPeringkat();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(this, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbkriteria = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbsiswa = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbnormalisasi = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbperingkat = new javax.swing.JTable();
        bview = new javax.swing.JButton();
        bnormalisasi = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        branking = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        bexit = new javax.swing.JButton();
        bsiswa = new javax.swing.JButton();
        bkriteria = new javax.swing.JButton();
        bbobot = new javax.swing.JButton();
        txtnmlngkp = new javax.swing.JLabel();
        bperhitungan = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        bjurusan = new javax.swing.JButton();
        badmin = new javax.swing.JButton();
        bhome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbkriteria.setModel(new javax.swing.table.DefaultTableModel(
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
        tbkriteria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(tbkriteria);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, 520, 190));

        tbsiswa.setModel(new javax.swing.table.DefaultTableModel(
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
        tbsiswa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(tbsiswa);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 520, 190));

        tbnormalisasi.setModel(new javax.swing.table.DefaultTableModel(
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
        tbnormalisasi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane3.setViewportView(tbnormalisasi);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 520, 190));

        tbperingkat.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tbperingkat);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 290, 520, 190));

        bview.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        bview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/view_more_20px.png"))); // NOI18N
        bview.setText("Tampil");
        bview.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bviewActionPerformed(evt);
            }
        });
        jPanel1.add(bview, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 490, -1, -1));

        bnormalisasi.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        bnormalisasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/gear_20px.png"))); // NOI18N
        bnormalisasi.setText("Hitung");
        bnormalisasi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bnormalisasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnormalisasiActionPerformed(evt);
            }
        });
        jPanel1.add(bnormalisasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 490, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 1070, 10));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Kriteria");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 520, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Peringkat");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, 520, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Data Siswa");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 10, 520, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Normalisasi");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 520, -1));

        branking.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        branking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/gear_20px.png"))); // NOI18N
        branking.setText("Hitung");
        branking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        branking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brankingActionPerformed(evt);
            }
        });
        jPanel1.add(branking, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 490, -1, -1));

        jPanel2.setBackground(new java.awt.Color(240, 189, 108));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(34, 105, 54));
        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 20, 50));

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

        txtnmlngkp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtnmlngkp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtnmlngkp.setText("Nama Lengkap User");
        jPanel2.add(txtnmlngkp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 190, -1));

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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 170, 50));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/PGRI.CLR. (2).png"))); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 530));

        setSize(new java.awt.Dimension(1327, 569));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bviewActionPerformed
        new Menu_spk.popUp_hasilPerhitungan().setVisible(true);
    }//GEN-LAST:event_bviewActionPerformed

    private void brankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brankingActionPerformed
        peringkat();
    }//GEN-LAST:event_brankingActionPerformed

    private void bnormalisasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnormalisasiActionPerformed
        TabelNormalisasi();
    }//GEN-LAST:event_bnormalisasiActionPerformed

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

    private void bperhitunganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bperhitunganActionPerformed

    }//GEN-LAST:event_bperhitunganActionPerformed

    private void bjurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bjurusanActionPerformed
        form_dataJurusan jurusan;
        jurusan = new form_dataJurusan();
        jurusan.setVisible(true);
        dispose();           // TODO add your handling code here:
    }//GEN-LAST:event_bjurusanActionPerformed

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
            java.util.logging.Logger.getLogger(form_perhitungan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_perhitungan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_perhitungan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_perhitungan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_perhitungan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton badmin;
    private javax.swing.JButton bbobot;
    private javax.swing.JButton bexit;
    private javax.swing.JButton bhome;
    private javax.swing.JButton bjurusan;
    private javax.swing.JButton bkriteria;
    private javax.swing.JButton bnormalisasi;
    private javax.swing.JButton bperhitungan;
    private javax.swing.JButton branking;
    private javax.swing.JButton bsiswa;
    private javax.swing.JButton bview;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbkriteria;
    private javax.swing.JTable tbnormalisasi;
    private javax.swing.JTable tbperingkat;
    private javax.swing.JTable tbsiswa;
    private javax.swing.JLabel txtnmlngkp;
    // End of variables declaration//GEN-END:variables
}
