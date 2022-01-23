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


public class form_dataKriteria extends javax.swing.JFrame {
    private Connection conn = new koneksi().connect();
    private DefaultTableModel TabelKriteria;
    public static double ipk;
    public static float organisasi, project;
    public String a1,a2,a5;
    public popUp_siswa pnjm1 = null;
    /**
     * Creates new form form_dataKriteria
     */
    public form_dataKriteria() {
        initComponents();
        txtnmlngkp.setText(regist_spk.getnama());
        String KD = UserID.getUserLogin();
        txtnmlngkp.setText(KD);
        kosong();
        aktif();
        datatable();
        auto();
    }
    
    
    public void print () {
        try {
            Locale locale = new Locale( "id", "ID" );
            HashMap par = new HashMap();
            par.put(JRParameter.REPORT_LOCALE, locale);
            JasperPrint jp = JasperFillManager.fillReport
            (form_dataKriteria.class.getResourceAsStream("/Report/report_dataKriteria.jasper"), par, conn);
            JasperViewer.viewReport(jp, false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada"+ex);
        }
    }     
    
    protected void aktif () {
        txtnm.requestFocus();
    }
    
    protected void kosong() {
        txtidkrit.setText("");
        txtnis.setText("");
        txtnm.setText("");
        txtujiansklh.setText("");
        txtujikom.setText("");
        txtnilaisklh.setText("");
        //txtun.setText("");
        //txtnilaitotal.setText("");
        txtcari.setText("");
        //cbnim.setSelectedIndex(0);
    }
    
    protected void datatable(){
         Object [] Baris = {"ID Kriteria","C1","C2","C3","NIS"};
            TabelKriteria = new DefaultTableModel(null,Baris);
            String cariitem = txtcari.getText();
            
            try{
                String sql = "SELECT * FROM tb_kriteria where id_kriteria like '%"+cariitem+"%'";
                Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while (hasil.next()){
                    TabelKriteria.addRow(new Object [] {
                        hasil.getString(1),
                        hasil.getFloat(2),
                        hasil.getFloat(3),
                        hasil.getFloat(4),
                        //hasil.getFloat(5),
                        //hasil.getFloat(6)
                        hasil.getString(5)
                    });
                }
                tbkriteria.setModel(TabelKriteria);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "data gagal Dipanggil"+e);
            }
    }
    
    public void konversi_ipk(){
        
            if(ipk>=3.50){
                ipk = 100;
            }else if(ipk>=3.00&&ipk<3.50){
                ipk = 75;
            }else if(ipk>=2.50&&ipk<3.00){
                ipk = 50;
            }else if(ipk>=2.00&&ipk<2.50){
                ipk = 25;
            }else if(ipk>=2.00){
                ipk = 0;
            }
    }
    
    public void konversi_project(){
        
            if(project>=90){
                ipk = 100;
            }else if(project>=80&&project<90){
                ipk = 75;
            }else if(project>=70&&ipk<80){
                ipk = 50;
            }else if(project>=60&&project<70){
                ipk = 25;
            }else if(project>=50&&project<60){
                ipk = 0;
            }
    }
    
    public void konversi_organisasi(){
        
            if(project>=90){
                ipk = 100;
            }else if(project>=80&&project<90){
                ipk = 75;
            }else if(project>=70&&ipk<80){
                ipk = 50;
            }else if(project>=60&&project<70){
                ipk = 25;
            }else if(project>=50&&project<60){
                ipk = 0;
            }
    }
    
    public void anggotaterpilih() {
    popUp_siswa pilsis = new popUp_siswa();
         pilsis.pnjm1 = this;
            txtnis.setText(a1);
            txtnm.setText(a2);
    }
    
    public void auto() {
    txtidkrit.setText("");
        try {
            String sql1 = "select max(right(id_kriteria,3)) from tb_kriteria";
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql1);
            while(hasil.next()) {
                if(hasil.first()==false) {
                    txtidkrit.setText("001");
                    
                } else {
                    hasil.last();
                    int code = hasil.getInt(1)+1;
                    String Nomor = String.valueOf(code);
                    int noLong = Nomor.length();
                    
                    for (int a=0; a<3-noLong;a++) {
                        Nomor = "0" + Nomor;
                    }
                    txtidkrit.setText(Nomor);
                    
                }
            }            
            } catch (Exception e) {
        }
                   txtidkrit.setEnabled(false);
                   //txtangg.requestFocus();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnm = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        bback = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bcarisiswa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbkriteria = new javax.swing.JTable();
        bprint = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtcari = new javax.swing.JTextField();
        bcari = new javax.swing.JButton();
        bcancel = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        bdelete = new javax.swing.JButton();
        bsave = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtidkrit = new javax.swing.JTextField();
        txtnis = new javax.swing.JTextField();
        txtujiansklh = new javax.swing.JTextField();
        txtujikom = new javax.swing.JTextField();
        txtnilaisklh = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        bexit = new javax.swing.JButton();
        bsiswa = new javax.swing.JButton();
        bkriteria = new javax.swing.JButton();
        bbobot = new javax.swing.JButton();
        txtnmlngkp = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        bperhitungan = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        bjurusan = new javax.swing.JButton();
        badmin = new javax.swing.JButton();
        bhome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel1.setText("Masukkan Data Nilai Kriteria dengan benar !");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("ID Kriteria");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        txtnm.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtnm.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtnm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnmKeyPressed(evt);
            }
        });
        jPanel1.add(txtnm, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 400, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("NIS");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 60, -1));

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

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Nilai Ujian Sekolah");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 120, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Nilai Uji Kompetensi");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 130, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Nilai Raport");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 120, -1));

        bcarisiswa.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        bcarisiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search_in_list_20px.png"))); // NOI18N
        bcarisiswa.setText("Cari");
        bcarisiswa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bcarisiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcarisiswaActionPerformed(evt);
            }
        });
        jPanel1.add(bcarisiswa, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 80, -1));

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
        tbkriteria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbkriteriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbkriteria);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 650, 430));

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

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("ID Kriteria");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, -1, -1));

        txtcari.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtcari.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcariKeyPressed(evt);
            }
        });
        jPanel1.add(txtcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 240, 30));

        bcari.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        bcari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search_in_list_20px.png"))); // NOI18N
        bcari.setText("Cari");
        bcari.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });
        jPanel1.add(bcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 40, 80, -1));

        bcancel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        bcancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/clear_symbol_20px.png"))); // NOI18N
        bcancel.setText("Batal");
        bcancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcancelActionPerformed(evt);
            }
        });
        jPanel1.add(bcancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 480, -1, -1));

        bedit.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        bedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/edit_20px.png"))); // NOI18N
        bedit.setText("Ubah");
        bedit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });
        jPanel1.add(bedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, -1, -1));

        bdelete.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        bdelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete_bin_20px.png"))); // NOI18N
        bdelete.setText("Hapus");
        bdelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeleteActionPerformed(evt);
            }
        });
        jPanel1.add(bdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 480, -1, -1));

        bsave.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        bsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save_20px.png"))); // NOI18N
        bsave.setText("Simpan");
        bsave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsaveActionPerformed(evt);
            }
        });
        jPanel1.add(bsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Nama Siswa");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 80, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 400, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 272, 20, 0));

        txtidkrit.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtidkrit.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtidkrit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidkritKeyPressed(evt);
            }
        });
        jPanel1.add(txtidkrit, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 190, 30));

        txtnis.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtnis.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtnis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnisKeyPressed(evt);
            }
        });
        jPanel1.add(txtnis, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 190, 30));

        txtujiansklh.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtujiansklh.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtujiansklh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtujiansklhKeyPressed(evt);
            }
        });
        jPanel1.add(txtujiansklh, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 400, 30));

        txtujikom.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtujikom.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtujikom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtujikomKeyPressed(evt);
            }
        });
        jPanel1.add(txtujikom, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 400, 30));

        txtnilaisklh.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtnilaisklh.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtnilaisklh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnilaisklhKeyPressed(evt);
            }
        });
        jPanel1.add(txtnilaisklh, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 400, 30));

        jPanel2.setBackground(new java.awt.Color(240, 189, 108));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(34, 105, 54));
        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 20, 50));

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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 170, 50));

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

        setSize(new java.awt.Dimension(1328, 570));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtnmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnmKeyPressed

    }//GEN-LAST:event_txtnmKeyPressed

    private void txtcariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcariKeyPressed

    private void bcarisiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcarisiswaActionPerformed
        popUp_siswa pilsis =new popUp_siswa();
        pilsis.pnjm1=this;
        pilsis.setVisible(true);
        pilsis.setResizable(false);    
    }//GEN-LAST:event_bcarisiswaActionPerformed

    private void bsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsaveActionPerformed
        String sql = "insert into tb_kriteria values (?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            
            stat.setString(1, txtidkrit.getText());
            stat.setString(2, txtujiansklh.getText());
            stat.setString(3, txtujikom.getText());
            stat.setString(4, txtnilaisklh.getText());
            //stat.setString(5, txtun.getText());
            //stat.setString(6, txtnilaitotal.getText());
            stat.setString(5, txtnis.getText());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil Disimpan");
            kosong();
            auto();
            
            txtidkrit.requestFocus();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal disimpan"+e);
        }
        datatable();
    }//GEN-LAST:event_bsaveActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        try {
            String sql = "update tb_kriteria  set C1=?,C2=?,C3=? where id_kriteria ='"+txtidkrit.getText()+"'";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtujiansklh.getText());
            stat.setString(2, txtujikom.getText());
            stat.setString(3, txtnilaisklh.getText());
            //stat.setString(4, txtun.getText());
            //stat.setString(5, txtnilaitotal.getText());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil Diubah");
            kosong();
            auto();
            txtidkrit.requestFocus();
            
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah" +e);
        }
        datatable();
    }//GEN-LAST:event_beditActionPerformed

    private void bdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdeleteActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "hapus", "konfirmasi dialog",JOptionPane.YES_NO_OPTION);
            if (ok==0){
                String sql = "delete from tb_kriteria where id_kriteria = '"+txtidkrit.getText()+"'";
                try {
                    PreparedStatement stat = conn.prepareStatement(sql);
                    stat.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                    kosong();
                    
                    txtnm.requestFocus();
                } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Data Gagal Dihapus"+e);
            }
        datatable();
        }
    }//GEN-LAST:event_bdeleteActionPerformed

    private void bcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcancelActionPerformed
        kosong();
    }//GEN-LAST:event_bcancelActionPerformed

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        datatable();
    }//GEN-LAST:event_bcariActionPerformed

    private void tbkriteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbkriteriaMouseClicked
        int bar = tbkriteria.getSelectedRow();
        String a = TabelKriteria.getValueAt(bar, 0). toString();
        String b = TabelKriteria.getValueAt(bar, 1). toString();
        String c = TabelKriteria.getValueAt(bar, 2). toString();
        String d = TabelKriteria.getValueAt(bar, 3). toString();
        String e = TabelKriteria.getValueAt(bar, 4). toString();
        //String f = TabelKriteria.getValueAt(bar, 5). toString();
        //String g = TabelKriteria.getValueAt(bar, 6). toString();
        
        
        txtidkrit.setText(a);
        txtujiansklh.setText(b);
        txtujikom.setText(c);
        txtnilaisklh.setText(d);
        //txtun.setText(e);
        //txtnilaitotal.setText(f);
        txtnis.setText(e);
    }//GEN-LAST:event_tbkriteriaMouseClicked

    private void txtidkritKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidkritKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidkritKeyPressed

    private void txtnisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnisKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnisKeyPressed

    private void txtujiansklhKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtujiansklhKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtujiansklhKeyPressed

    private void txtujikomKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtujikomKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtujikomKeyPressed

    private void txtnilaisklhKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnilaisklhKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnilaisklhKeyPressed

    private void bbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbackActionPerformed
        main_menu menu;
        menu = new main_menu();
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_bbackActionPerformed

    private void bprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprintActionPerformed
        print();
    }//GEN-LAST:event_bprintActionPerformed

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

    }//GEN-LAST:event_bkriteriaActionPerformed

    private void bbobotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbobotActionPerformed
        form_dataBobot bobot;
        bobot = new form_dataBobot();
        bobot.setVisible(true);
        dispose();
    }//GEN-LAST:event_bbobotActionPerformed

    private void bperhitunganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bperhitunganActionPerformed
        form_perhitungan perhitungan;
        perhitungan = new form_perhitungan();
        perhitungan.setVisible(true);
        dispose();
    }//GEN-LAST:event_bperhitunganActionPerformed

    private void bjurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bjurusanActionPerformed
        form_dataJurusan jurusan;
        jurusan = new form_dataJurusan();
        jurusan.setVisible(true);
        dispose();          // TODO add your handling code here:
    }//GEN-LAST:event_bjurusanActionPerformed

    private void badminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badminActionPerformed
        form_dataAdmin admin;
        admin = new form_dataAdmin();
        admin.setVisible(true);
        dispose();        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(form_dataKriteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_dataKriteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_dataKriteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_dataKriteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_dataKriteria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton badmin;
    private javax.swing.JButton bback;
    private javax.swing.JButton bbobot;
    private javax.swing.JButton bcancel;
    private javax.swing.JButton bcari;
    private javax.swing.JButton bcarisiswa;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbkriteria;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtidkrit;
    private javax.swing.JTextField txtnilaisklh;
    private javax.swing.JTextField txtnis;
    private javax.swing.JTextField txtnm;
    private javax.swing.JLabel txtnmlngkp;
    private javax.swing.JTextField txtujiansklh;
    private javax.swing.JTextField txtujikom;
    // End of variables declaration//GEN-END:variables
}
