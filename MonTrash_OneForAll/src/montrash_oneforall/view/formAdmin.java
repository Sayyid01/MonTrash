/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montrash_oneforall.view;

import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import montrash_oneforall.controler.Function;
import montrash_oneforall.model.HistoriTransaksi;
import montrash_oneforall.model.Pengguna;
import montrash_oneforall.model.SharedData;

/**
 *
 * @author Sayyid
 */
public class formAdmin extends javax.swing.JFrame {

    /**
     * Creates new form formAdmin
     */
    public formAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadKolomPengguna();
        tablePengguna.setModel(tabelPengguna);
        f.getUserData();
        tampilPengguna();
        statusPembayaran();
        statusAngkut();
        
        loadKolomHistori();
        jtHistoriPembayaran.setModel(tabelHistori);
        f.loadDataHistoriAll();
        tampilHistori();
    }
    
    private Function f = new Function();
    /*
    Setting Tabel Data Pengguna
    */    
    private DefaultTableModel tabelPengguna = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    private void loadKolomPengguna(){
        tabelPengguna.addColumn("Id");
        tabelPengguna.addColumn("Nama");
        tabelPengguna.addColumn("Alamat");
        tabelPengguna.addColumn("Email");
        tabelPengguna.addColumn("No HP");
        tabelPengguna.addColumn("Status");
    }
    private void tampilPengguna(){
        tabelPengguna.setRowCount(0);
        for(Pengguna p:f.arrPengguna){
            tabelPengguna.addRow(new Object[]{p.getIdPengguna(), p.getNama(), p.getAlamat(), p.getEmail(), p.getNoHp(), p.getStatus()});
        }
    }
    
    private void getNamaUser(){
        if(f.arrStatus.isEmpty()==false){
            int lastIndex = f.arrStatus.size()-1;
            String namaUser = f.arrStatus.get(lastIndex).getNama();
            namaPengguna.setText(namaUser);
        }
    }
    private void getStatusUser(){
        if(f.arrStatus.isEmpty()==false){
            int lastIndex = f.arrStatus.size()-1;
            String statusUser = f.arrStatus.get(lastIndex).getStatusPengguna();
            statusPengguna.setText(statusUser);
        }
    }
    
    private void statusPembayaran(){
        ButtonGroup group1 = new ButtonGroup();
        group1.add(sudahMembayar);
        group1.add(belumMembayar);
        if(f.arrStatus.isEmpty()==false){
            System.out.println(f.arrStatus.size());
            int lastIndex = f.arrStatus.size()-1;
            int status = f.arrStatus.get(lastIndex).getStatus_pembayaran();
            if(status==0){
                belumMembayar.setSelected(true);
            }else{
                sudahMembayar.setSelected(true);
            }
            if(f.arrHistori.isEmpty()==false){
                int lastIndexHistori = f.arrHistori.size()-1;
                String tanggalTransaksi = f.arrHistori.get(lastIndexHistori).getTanggalTransaksi();
                float jumlahBayar = f.arrHistori.get(lastIndexHistori).getJumlahBayar();
                tfJumlahBayar.setText(String.valueOf(jumlahBayar));
                tfTanggalBayar.setText(tanggalTransaksi);
            }
        }
    }
    private void statusAngkut(){
        ButtonGroup group2 = new ButtonGroup();
        group2.add(sudahDiangkut);
        group2.add(belumDiangkut);
        
        tfKeteranganUser.setEditable(false);
        if(f.arrStatus.isEmpty()==false){
            int lastIndex = f.arrStatus.size()-1;
            System.out.println(lastIndex);
            String keterangan = f.arrStatus.get(lastIndex).getKeterangan();
            tfKeteranganUser.setText(keterangan);
            tfKeteranganUser.setEditable(false);
            int status = f.arrStatus.get(lastIndex).getStatus_angkut();
            if(status==0){
                belumDiangkut.setSelected(true);
            }else{
                sudahDiangkut.setSelected(true);
            }
            
            int lastIndexStatus = f.arrStatus.size()-1;
            int idTransaksi = f.arrStatus.get(lastIndexStatus).getRealIdTransaksi();
            f.loadDataHistoriAngkut(idTransaksi);
            if(f.arrHistoriAngkut.isEmpty()==false){
                int lastIndexHistori = f.arrHistoriAngkut.size()-1;
                String tanggalAngkut = f.arrHistoriAngkut.get(lastIndexHistori).getTanggalAngkut();
                tfTanggalAngkut.setText(tanggalAngkut);
            }
        }
    }
    
    /*
    Seting Table Histori
    */
    private DefaultTableModel tabelHistori = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private void loadKolomHistori(){
        tabelHistori.addColumn("No");
        tabelHistori.addColumn("Id Transaksi");
        tabelHistori.addColumn("Tanggal");
        tabelHistori.addColumn("Jumlah Bayar");
        tabelHistori.addColumn("Status");
        tabelHistori.addColumn("Id Pelanggan");
    }
    private void tampilHistori(){
        tabelHistori.setRowCount(0);
        for(HistoriTransaksi h:f.arrHistori){
            tabelHistori.addRow(new Object[]{h.getNomorUrut(), h.getId(), h.getTanggalTransaksi(), h.getJumlahBayar(), h.getStatusPembayaran(), h.getId_pengguna()});
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

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        rbnAkunSaya = new javax.swing.JRadioButton();
        rbnStatus = new javax.swing.JRadioButton();
        rbnHistori = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jpAkunSaya = new javax.swing.JPanel();
        salam = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePengguna = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tfCari = new javax.swing.JTextField();
        btCari = new javax.swing.JButton();
        btRefresh = new javax.swing.JButton();
        jpStatus = new javax.swing.JPanel();
        tfCariId = new javax.swing.JTextField();
        btCariId = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfJumlahBayar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sudahMembayar = new javax.swing.JRadioButton();
        btUpdateTransaksi = new javax.swing.JButton();
        belumMembayar = new javax.swing.JRadioButton();
        namaPengguna = new javax.swing.JLabel();
        statusPengguna = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        sudahDiangkut = new javax.swing.JRadioButton();
        belumDiangkut = new javax.swing.JRadioButton();
        btUpdateAngkut = new javax.swing.JButton();
        tfTanggalBayar = new javax.swing.JTextField();
        tfTanggalAngkut = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tfKeteranganUser = new javax.swing.JTextArea();
        tambahDataTransaksi = new javax.swing.JButton();
        tambahDataPengangkutan = new javax.swing.JButton();
        jpHistori = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtHistoriPembayaran = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btCariPelangganById = new javax.swing.JButton();
        tfIdCariPelanggan = new javax.swing.JTextField();
        btExportToPDF = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(807, 526));
        setMinimumSize(new java.awt.Dimension(807, 526));
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(201, 246, 88));

        jPanel5.setBackground(new java.awt.Color(93, 93, 93));

        jPanel1.setBackground(new java.awt.Color(93, 93, 93));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel1);

        rbnAkunSaya.setSelected(true);
        rbnAkunSaya.setText("<html><h2><font color=\"white\">Data Pelanggan</font></h2></html>");
        rbnAkunSaya.setBorder(null);
        rbnAkunSaya.setFocusPainted(false);
        rbnAkunSaya.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbnAkunSaya.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rbnAkunSaya.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button/default.png"))); // NOI18N
        rbnAkunSaya.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button/hoverSelect.png"))); // NOI18N
        rbnAkunSaya.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button/hover.png"))); // NOI18N
        rbnAkunSaya.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button/selected.png"))); // NOI18N
        rbnAkunSaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnAkunSayaActionPerformed(evt);
            }
        });
        jPanel5.add(rbnAkunSaya);

        rbnStatus.setText("<html><h2><font color=\"white\">Status Pelanggan</font></h2></html>");
        rbnStatus.setBorder(null);
        rbnStatus.setFocusPainted(false);
        rbnStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbnStatus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rbnStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button/default.png"))); // NOI18N
        rbnStatus.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button/hoverSelect.png"))); // NOI18N
        rbnStatus.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button/hover.png"))); // NOI18N
        rbnStatus.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button/selected.png"))); // NOI18N
        rbnStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnStatusActionPerformed(evt);
            }
        });
        jPanel5.add(rbnStatus);

        rbnHistori.setBorder(null);
        rbnHistori.setFocusPainted(false);
        rbnHistori.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbnHistori.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rbnHistori.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button/default.png"))); // NOI18N
        rbnHistori.setLabel("<html><h2><font color=\"white\">Histori</font></h2></html>");
        rbnHistori.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button/hoverSelect.png"))); // NOI18N
        rbnHistori.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button/hover.png"))); // NOI18N
        rbnHistori.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button/selected.png"))); // NOI18N
        rbnHistori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnHistoriActionPerformed(evt);
            }
        });
        jPanel5.add(rbnHistori);

        jPanel2.setBackground(new java.awt.Color(201, 246, 88));
        jPanel2.setLayout(new java.awt.CardLayout());

        jpAkunSaya.setBackground(new java.awt.Color(201, 246, 88));

        salam.setText("<html><h1>Halo, Admin</h1></html>");

        tablePengguna.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nama", "Alamat", "Email", "No Hp", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePengguna.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablePengguna.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tablePengguna);

        jLabel1.setText("Berikut ini merupakan data pelanggan anda");

        jButton1.setText("Tambah Pelanggan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btCari.setText("cari");
        btCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCariActionPerformed(evt);
            }
        });

        btRefresh.setText("Refresh");
        btRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpAkunSayaLayout = new javax.swing.GroupLayout(jpAkunSaya);
        jpAkunSaya.setLayout(jpAkunSayaLayout);
        jpAkunSayaLayout.setHorizontalGroup(
            jpAkunSayaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAkunSayaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAkunSayaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jpAkunSayaLayout.createSequentialGroup()
                        .addGroup(jpAkunSayaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(salam, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAkunSayaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAkunSayaLayout.createSequentialGroup()
                        .addComponent(btRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btCari)))
                .addContainerGap())
        );
        jpAkunSayaLayout.setVerticalGroup(
            jpAkunSayaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAkunSayaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salam, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addGroup(jpAkunSayaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCari, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        jPanel2.add(jpAkunSaya, "card2");

        jpStatus.setBackground(new java.awt.Color(201, 246, 88));

        tfCariId.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btCariId.setText("Cari Id Pelanggan");
        btCariId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCariIdActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nama  :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Status :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Data Transaksi Pengguna");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Jumlah Bayar          :");

        tfJumlahBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfJumlahBayarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Tanggal Transaksi    :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Status Pembayaran :");

        sudahMembayar.setBackground(new java.awt.Color(201, 246, 88));
        sudahMembayar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sudahMembayar.setText("Sudah Membayar");

        btUpdateTransaksi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btUpdateTransaksi.setText("Update");
        btUpdateTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateTransaksiActionPerformed(evt);
            }
        });

        belumMembayar.setBackground(new java.awt.Color(201, 246, 88));
        belumMembayar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        belumMembayar.setText("Belum Membayar");

        namaPengguna.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        namaPengguna.setText("Nama");

        statusPengguna.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        statusPengguna.setText("Status");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Data Pengangkutan Sampah");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Tanggal Pengangkutan :");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Keterangan                   :");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Status Pengangkutan   :");

        sudahDiangkut.setBackground(new java.awt.Color(201, 246, 88));
        sudahDiangkut.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sudahDiangkut.setText("Sudah Diangkut");

        belumDiangkut.setBackground(new java.awt.Color(201, 246, 88));
        belumDiangkut.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        belumDiangkut.setText("Belum Diangkut");

        btUpdateAngkut.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btUpdateAngkut.setText("Update");
        btUpdateAngkut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateAngkutActionPerformed(evt);
            }
        });

        tfTanggalBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTanggalBayarActionPerformed(evt);
            }
        });

        tfTanggalAngkut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTanggalAngkutActionPerformed(evt);
            }
        });

        jLabel9.setText("YYYY-MM-DD");

        jLabel11.setText("YYYY-MM-DD");

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane4.setHorizontalScrollBar(null);
        jScrollPane4.setMaximumSize(new java.awt.Dimension(162, 92));
        jScrollPane4.setWheelScrollingEnabled(false);

        tfKeteranganUser.setColumns(20);
        tfKeteranganUser.setRows(5);
        tfKeteranganUser.setBorder(null);
        tfKeteranganUser.setMaximumSize(new java.awt.Dimension(160, 90));
        jScrollPane4.setViewportView(tfKeteranganUser);

        tambahDataTransaksi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tambahDataTransaksi.setText("+");
        tambahDataTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahDataTransaksiActionPerformed(evt);
            }
        });

        tambahDataPengangkutan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tambahDataPengangkutan.setText("+");
        tambahDataPengangkutan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahDataPengangkutanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpStatusLayout = new javax.swing.GroupLayout(jpStatus);
        jpStatus.setLayout(jpStatusLayout);
        jpStatusLayout.setHorizontalGroup(
            jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpStatusLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tambahDataTransaksi)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpStatusLayout.createSequentialGroup()
                        .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaPengguna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jpStatusLayout.createSequentialGroup()
                                .addComponent(statusPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(132, 132, 132))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpStatusLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfCariId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btCariId)
                .addGap(37, 37, 37))
            .addGroup(jpStatusLayout.createSequentialGroup()
                .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpStatusLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTanggalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(jpStatusLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpStatusLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tambahDataPengangkutan))
                            .addGroup(jpStatusLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpStatusLayout.createSequentialGroup()
                                        .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfJumlahBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(btUpdateTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jpStatusLayout.createSequentialGroup()
                                                    .addComponent(sudahMembayar)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(belumMembayar)))))
                                    .addGroup(jpStatusLayout.createSequentialGroup()
                                        .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpStatusLayout.createSequentialGroup()
                                                .addComponent(tfTanggalAngkut, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11))
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jpStatusLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sudahDiangkut)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btUpdateAngkut, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(belumDiangkut))))))))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jpStatusLayout.setVerticalGroup(
            jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpStatusLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCariId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCariId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tambahDataTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpStatusLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTanggalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfJumlahBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sudahMembayar)
                    .addComponent(belumMembayar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btUpdateTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpStatusLayout.createSequentialGroup()
                        .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tambahDataPengangkutan, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTanggalAngkut, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpStatusLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sudahDiangkut)
                    .addComponent(belumDiangkut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btUpdateAngkut, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel2.add(jpStatus, "card3");

        jpHistori.setBackground(new java.awt.Color(201, 246, 88));

        jtHistoriPembayaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Id Transaksi", "Tanggal", "Jumlah Bayar", "Status", "Id Pelanggan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtHistoriPembayaran.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jtHistoriPembayaran.setAutoscrolls(false);
        jtHistoriPembayaran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtHistoriPembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtHistoriPembayaranMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jtHistoriPembayaran);

        jLabel10.setText("<html><h2>Histori Pembayaran</h2></html>");

        btCariPelangganById.setText("Cari");
        btCariPelangganById.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCariPelangganByIdActionPerformed(evt);
            }
        });

        btExportToPDF.setText("Jadikan PDF");
        btExportToPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExportToPDFActionPerformed(evt);
            }
        });

        jLabel3.setText("Klik tabel untuk melihat histori pengangkutan");

        javax.swing.GroupLayout jpHistoriLayout = new javax.swing.GroupLayout(jpHistori);
        jpHistori.setLayout(jpHistoriLayout);
        jpHistoriLayout.setHorizontalGroup(
            jpHistoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHistoriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpHistoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpHistoriLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                    .addGroup(jpHistoriLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btExportToPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpHistoriLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfIdCariPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCariPelangganById)))
                .addContainerGap())
        );
        jpHistoriLayout.setVerticalGroup(
            jpHistoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHistoriLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpHistoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpHistoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btCariPelangganById)
                        .addComponent(tfIdCariPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExportToPDF, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jpHistori, "card4");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbnAkunSayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnAkunSayaActionPerformed
        // TODO add your handling code here:
        //removing panel
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        rbnHistori.setSelected(false);
        rbnStatus.setSelected(false);

        //adding panels
        jPanel2.add(jpAkunSaya);
        jPanel2.repaint();
        jPanel2.revalidate();
        rbnAkunSaya.setSelected(true);
    }//GEN-LAST:event_rbnAkunSayaActionPerformed

    private void rbnStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnStatusActionPerformed
        // TODO add your handling code here:
        //removing panel
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        rbnAkunSaya.setSelected(false);
        rbnHistori.setSelected(false);

        //adding panels
        jPanel2.add(jpStatus);
        jPanel2.repaint();
        jPanel2.revalidate();
        rbnStatus.setSelected(true);
    }//GEN-LAST:event_rbnStatusActionPerformed

    private void rbnHistoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnHistoriActionPerformed
        // TODO add your handling code here:
        //removing panel
        jPanel2.removeAll();
        jPanel2.repaint();
        jPanel2.revalidate();
        rbnAkunSaya.setSelected(false);
        rbnStatus.setSelected(false);

        //adding panels
        jPanel2.add(jpHistori);
        jPanel2.repaint();
        jPanel2.revalidate();
        rbnHistori.setSelected(true);
    }//GEN-LAST:event_rbnHistoriActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new formRegister().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefreshActionPerformed
        f.arrPengguna.clear();
        f.getUserData(); tampilPengguna();
    }//GEN-LAST:event_btRefreshActionPerformed

    private void btCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCariActionPerformed
        f.arrPengguna.clear();
        String keyword=tfCari.getText().trim();
        if(keyword.length()==0){
            f.getUserData(); tampilPengguna();
        }else{
            f.cariPenggunaKeyword(keyword); tampilPengguna();
        }
    }//GEN-LAST:event_btCariActionPerformed

    private void btCariIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCariIdActionPerformed
        String s = tfCariId.getText().trim();
        if(s.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Silahkan masukkan Id pengguna telebih dahulu");
        }else{
            int idPengguna = Integer.parseInt(s);
            f.getStatusUserData(idPengguna);
            f.loadDataHistori(idPengguna);
            getNamaUser();
            getStatusUser();
            tfKeteranganUser.setLineWrap(true);
            statusPembayaran();
            statusAngkut();
            f.arrStatus.clear();
        }
    }//GEN-LAST:event_btCariIdActionPerformed

    private void tfTanggalBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTanggalBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTanggalBayarActionPerformed

    private void tfTanggalAngkutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTanggalAngkutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTanggalAngkutActionPerformed

    private void btUpdateTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateTransaksiActionPerformed
        String id = tfCariId.getText().trim();
        String bayar = tfJumlahBayar.getText().trim();
        if(id.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Silahkan masukkan Id pengguna telebih dahulu");
        }else{
            float jumlahBayar=0;
            if(!bayar.equals("")){
                jumlahBayar=Float.parseFloat(bayar);
            }
            int statusBayar=0;
            if(sudahMembayar.isSelected()){
                statusBayar=1;
            }
            int idPengguna = Integer.parseInt(id);
            String tanggalBayar = tfTanggalBayar.getText();
            if(f.arrHistori.isEmpty()==false){
                int lastIndex = f.arrHistori.size()-1;
                int idTransaksi = f.arrHistori.get(lastIndex).getId();
                System.out.println(idTransaksi);
                f.updateDataTransaksi(idPengguna, statusBayar, jumlahBayar, tanggalBayar, idTransaksi);
            }else{
                JOptionPane.showMessageDialog(null, "terjadi kesalahan, arrStatus.isEmpty()");
            }
        }
    }//GEN-LAST:event_btUpdateTransaksiActionPerformed

    private void btUpdateAngkutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateAngkutActionPerformed
        String s = tfCariId.getText().trim();
        if(s.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Silahkan masukkan Id pengguna telebih dahulu");
        }else{
            int statusAngkut=0;
            if(sudahDiangkut.isSelected()){
                statusAngkut=1;
            }
            int idPengguna = Integer.parseInt(s);
            String tanggalAngkut = tfTanggalAngkut.getText();
            f.getStatusUserData(idPengguna);
            int lastIndexStatus = f.arrStatus.size()-1;
            int idTransaksi = f.arrStatus.get(lastIndexStatus).getRealIdTransaksi();
            f.loadDataHistoriAngkut(idTransaksi);
            if(f.arrHistoriAngkut.isEmpty()==false){
                int lastIndexHistori = f.arrHistoriAngkut.size()-1;
                int idAngkut = f.arrHistoriAngkut.get(lastIndexHistori).getId();
                System.out.println(idAngkut);
                f.updateDataAngkut(idPengguna, tanggalAngkut, statusAngkut, idAngkut);
            }else{
                JOptionPane.showMessageDialog(null, "terjadi kesalahan, arrStatus.isEmpty()");
            }
        }
    }//GEN-LAST:event_btUpdateAngkutActionPerformed

    private void jtHistoriPembayaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtHistoriPembayaranMouseClicked
        // Mouse Click Listener
        JTable source = (JTable)evt.getSource();
        int row = source.rowAtPoint( evt.getPoint() );
        String s=source.getModel().getValueAt(row, 1)+"";
        int id_transaksi = Integer.parseInt(s);
        SharedData.setId_transaksi(id_transaksi);
        new frameHistoriAngkut().setVisible(true);
    }//GEN-LAST:event_jtHistoriPembayaranMouseClicked

    private void btCariPelangganByIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCariPelangganByIdActionPerformed
        f.arrHistori.clear();
        String s = tfIdCariPelanggan.getText().trim();
        if(s.equalsIgnoreCase("")){
            f.loadDataHistoriAll(); tampilHistori();
        }else{
            int idPengguna = Integer.parseInt(s);
            f.loadDataHistori(idPengguna); tampilHistori();
        }
        tfIdCariPelanggan.setText("");
    }//GEN-LAST:event_btCariPelangganByIdActionPerformed

    private void tambahDataTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahDataTransaksiActionPerformed
        String id = tfCariId.getText().trim();
        if(id.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Silahkan masukkan Id pengguna telebih dahulu");
        }else{
            String message ="Setelah menambahkan data\n anda tidak bisa lagi mengedit data sebelumnya\n apakah anda yakin?";
            int confirm = JOptionPane.showConfirmDialog(null, message);
            if(confirm == 0){
                int idPengguna = Integer.parseInt(id);
                if(f.tambahDataTransaksi(idPengguna)==true){
                    f.loadDataHistori(idPengguna);
                    int lastIndex = f.arrHistori.size()-1;
                    int idTransaksi=f.arrHistori.get(lastIndex).getId();
                    f.tambahDataPengangkutan(idTransaksi);
                }
            }
        }
    }//GEN-LAST:event_tambahDataTransaksiActionPerformed

    private void tambahDataPengangkutanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahDataPengangkutanActionPerformed
        String id = tfCariId.getText().trim();
        if(id.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Silahkan masukkan Id pengguna telebih dahulu");
        }else{
            String message ="Setelah menambahkan data\n anda tidak bisa lagi mengedit data sebelumnya\n apakah anda yakin?";
            int confirm = JOptionPane.showConfirmDialog(null, message);
            if(confirm == 0){
                int idPengguna = Integer.parseInt(id);
                f.loadDataHistori(idPengguna);
                int lastIndex = f.arrHistori.size()-1;
                int idTransaksi=f.arrHistori.get(lastIndex).getId();
                f.tambahDataPengangkutan(idTransaksi);
            }
        }
    }//GEN-LAST:event_tambahDataPengangkutanActionPerformed

    private void tfJumlahBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfJumlahBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfJumlahBayarActionPerformed

    private void btExportToPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExportToPDFActionPerformed
        String judul = "Histori Pembayaran";
        MessageFormat header = new MessageFormat(judul);
        try {
            jtHistoriPembayaran.print(JTable.PrintMode.FIT_WIDTH, header, null);
        } catch (PrinterException ex) {
            Logger.getLogger(formPengguna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btExportToPDFActionPerformed

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
            java.util.logging.Logger.getLogger(formAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton belumDiangkut;
    private javax.swing.JRadioButton belumMembayar;
    private javax.swing.JButton btCari;
    private javax.swing.JButton btCariId;
    private javax.swing.JButton btCariPelangganById;
    private javax.swing.JButton btExportToPDF;
    private javax.swing.JButton btRefresh;
    private javax.swing.JButton btUpdateAngkut;
    private javax.swing.JButton btUpdateTransaksi;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel jpAkunSaya;
    private javax.swing.JPanel jpHistori;
    private javax.swing.JPanel jpStatus;
    private javax.swing.JTable jtHistoriPembayaran;
    private javax.swing.JLabel namaPengguna;
    private javax.swing.JRadioButton rbnAkunSaya;
    private javax.swing.JRadioButton rbnHistori;
    private javax.swing.JRadioButton rbnStatus;
    private javax.swing.JLabel salam;
    private javax.swing.JLabel statusPengguna;
    private javax.swing.JRadioButton sudahDiangkut;
    private javax.swing.JRadioButton sudahMembayar;
    private javax.swing.JTable tablePengguna;
    private javax.swing.JButton tambahDataPengangkutan;
    private javax.swing.JButton tambahDataTransaksi;
    private javax.swing.JTextField tfCari;
    private javax.swing.JTextField tfCariId;
    private javax.swing.JTextField tfIdCariPelanggan;
    private javax.swing.JTextField tfJumlahBayar;
    private javax.swing.JTextArea tfKeteranganUser;
    private javax.swing.JTextField tfTanggalAngkut;
    private javax.swing.JTextField tfTanggalBayar;
    // End of variables declaration//GEN-END:variables
}
