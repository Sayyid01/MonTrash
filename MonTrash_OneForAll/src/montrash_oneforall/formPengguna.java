/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montrash_oneforall;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author Sayyid
 */
public class formPengguna extends javax.swing.JFrame {

    /**
     * Creates new form formPengguna
     */
    public formPengguna() {
        initComponents();
        this.setLocationRelativeTo(null);
        conn = Koneksi.bukaKoneksi();
        sudahDiangkut.setSelected(false);
        userData(email);
        statusSampah();
        statusPembayaran();
    }
    
    private Connection conn;
    private ArrayList<Pengguna> arrPengguna;
    private String email = SharedData.getEmail();
          
    private void userData(String email){
      if(conn!=null){
          arrPengguna=new ArrayList<>();
          String query="SELECT nama, status_sampah, status_pembayaran FROM pengguna, transaksi WHERE pengguna.email=? AND transaksi.email=?";
          try{
              PreparedStatement ps = conn.prepareStatement(query);
              ps.setString(1, email);
              ps.setString(2, email);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String nama = rs.getString("nama");
                    int status_sampah = rs.getInt("status_sampah");
                    int status_pembayaran = rs.getInt("status_pembayaran");
                    Pengguna pengguna = new Pengguna(nama, status_sampah, status_pembayaran);
                    arrPengguna.add(pengguna);
                    salam.setText("<html><h1>Halo, "+nama+"</h1></html>");
                }
                rs.close();
                ps.close();
          }catch(SQLException e){
              Logger.getLogger(formPengguna.class.getName()).log(Level.SEVERE, null, e);
          }
      }
    }
    
    private void kirimKeterangan(String keterangan, String email){
        if(conn!=null){
            String query = "UPDATE transaksi SET keterangan=? WHERE email=?";
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, keterangan);
                ps.setString(2, email);
                int hasil = ps.executeUpdate();
                if(hasil==1){
                    JOptionPane.showMessageDialog(this, "Berhasil menambahkan keterangan");
                }
            }catch(SQLException e){
                Logger.getLogger(formPengguna.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    private void statusSampah(){
        ButtonGroup group = new ButtonGroup();
        group.add(sudahDiangkut);
        group.add(belumDiangkut);
        int status = arrPengguna.get(0).isStatus_sampah();
        if(status==0){
            belumDiangkut.setSelected(true);
            sudahDiangkut.setEnabled(false);
            tfKeterangan.setEditable(true);
        }else{
            sudahDiangkut.setSelected(true);
            belumDiangkut.setEnabled(false);
            tfKeterangan.setEditable(false);
        }
    }
    
    private void statusPembayaran(){
        ButtonGroup group = new ButtonGroup();
        group.add(sudahMembayar);
        group.add(belumMembayar);
        int status = arrPengguna.get(0).isStatus_pembayaran();
        if(status==0){
            belumMembayar.setSelected(true);
            sudahMembayar.setEnabled(false);
        }else{
            sudahMembayar.setSelected(true);
            belumMembayar.setEnabled(false);
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
        jpStatus = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        belumDiangkut = new javax.swing.JRadioButton();
        sudahDiangkut = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tfKeterangan = new javax.swing.JTextArea();
        sudahMembayar = new javax.swing.JRadioButton();
        belumMembayar = new javax.swing.JRadioButton();
        btKirimKeterangan = new javax.swing.JButton();
        jpHistori = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

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
        rbnAkunSaya.setBorder(null);
        rbnAkunSaya.setFocusPainted(false);
        rbnAkunSaya.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbnAkunSaya.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rbnAkunSaya.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button/default.png"))); // NOI18N
        rbnAkunSaya.setLabel("<html><h2><font color=\"white\">Akun Saya</font></h2></html>");
        rbnAkunSaya.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button/hoverSelect.png"))); // NOI18N
        rbnAkunSaya.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button/hover.png"))); // NOI18N
        rbnAkunSaya.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button/selected.png"))); // NOI18N
        rbnAkunSaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnAkunSayaActionPerformed(evt);
            }
        });
        jPanel5.add(rbnAkunSaya);

        rbnStatus.setBorder(null);
        rbnStatus.setFocusPainted(false);
        rbnStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbnStatus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rbnStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button/default.png"))); // NOI18N
        rbnStatus.setLabel("<html><h2><font color=\"white\">Status</font></h2></html>");
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

        salam.setText("<html><h1>Halo, </h1></html>");

        javax.swing.GroupLayout jpAkunSayaLayout = new javax.swing.GroupLayout(jpAkunSaya);
        jpAkunSaya.setLayout(jpAkunSayaLayout);
        jpAkunSayaLayout.setHorizontalGroup(
            jpAkunSayaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAkunSayaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salam, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );
        jpAkunSayaLayout.setVerticalGroup(
            jpAkunSayaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAkunSayaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salam, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(456, Short.MAX_VALUE))
        );

        jPanel2.add(jpAkunSaya, "card2");

        jpStatus.setBackground(new java.awt.Color(201, 246, 88));

        jLabel1.setText("<html><h1>Status sampah : </h1></html>");
        jLabel1.setPreferredSize(new java.awt.Dimension(64, 64));

        jLabel4.setText("<html><h1>Status pembayaran bulanan : </h1></html>");
        jLabel4.setPreferredSize(new java.awt.Dimension(64, 64));

        belumDiangkut.setText("<html><h2>Belum diangkut </h2></html>");
        belumDiangkut.setPreferredSize(new java.awt.Dimension(183, 51));
        belumDiangkut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                belumDiangkutActionPerformed(evt);
            }
        });

        sudahDiangkut.setText("<html><h2>Sudah diangkut </h2></html>");
        sudahDiangkut.setPreferredSize(new java.awt.Dimension(183, 51));
        sudahDiangkut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sudahDiangkutActionPerformed(evt);
            }
        });

        jLabel2.setText("<html><h3>Keterangan : </h3></html>");

        jScrollPane3.setHorizontalScrollBar(null);
        jScrollPane3.setMaximumSize(new java.awt.Dimension(162, 92));
        jScrollPane3.setWheelScrollingEnabled(false);

        tfKeterangan.setColumns(20);
        tfKeterangan.setRows(5);
        tfKeterangan.setBorder(null);
        tfKeterangan.setMaximumSize(new java.awt.Dimension(160, 90));
        jScrollPane3.setViewportView(tfKeterangan);
        tfKeterangan.getAccessibleContext().setAccessibleParent(jScrollPane1);

        sudahMembayar.setText("<html><h2>Sudah membayar </h2></html>");
        sudahMembayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sudahMembayarActionPerformed(evt);
            }
        });

        belumMembayar.setText("<html><h2>Belum membayar </h2></html>");
        belumMembayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                belumMembayarActionPerformed(evt);
            }
        });

        btKirimKeterangan.setText("Kirim pesan");
        btKirimKeterangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKirimKeteranganActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpStatusLayout = new javax.swing.GroupLayout(jpStatus);
        jpStatus.setLayout(jpStatusLayout);
        jpStatusLayout.setHorizontalGroup(
            jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpStatusLayout.createSequentialGroup()
                .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpStatusLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpStatusLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(sudahMembayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(belumMembayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpStatusLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpStatusLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btKirimKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpStatusLayout.createSequentialGroup()
                                    .addComponent(sudahDiangkut, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(belumDiangkut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpStatusLayout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jpStatusLayout.setVerticalGroup(
            jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sudahDiangkut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(belumDiangkut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btKirimKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sudahMembayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(belumMembayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jPanel2.add(jpStatus, "card3");

        jpHistori.setBackground(new java.awt.Color(201, 246, 88));

        jLabel3.setText("<html><h3>Histori Pembayaran Sampah</h3></html>");

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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jLabel5.setText("<html><h3>Histori Pengangkutan Sampah</h3></html>");

        javax.swing.GroupLayout jpHistoriLayout = new javax.swing.GroupLayout(jpHistori);
        jpHistori.setLayout(jpHistoriLayout);
        jpHistoriLayout.setHorizontalGroup(
            jpHistoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHistoriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpHistoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                    .addGroup(jpHistoriLayout.createSequentialGroup()
                        .addGroup(jpHistoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpHistoriLayout.setVerticalGroup(
            jpHistoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHistoriLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jPanel2.add(jpHistori, "card4");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void belumDiangkutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_belumDiangkutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_belumDiangkutActionPerformed

    private void sudahDiangkutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sudahDiangkutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sudahDiangkutActionPerformed

    private void sudahMembayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sudahMembayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sudahMembayarActionPerformed

    private void belumMembayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_belumMembayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_belumMembayarActionPerformed

    private void btKirimKeteranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKirimKeteranganActionPerformed
        // TODO add your handling code here:
        if(tfKeterangan.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Tidak bisa mengirim pesan kosong");
        }else{
            String keterangan = tfKeterangan.getText();
            kirimKeterangan(keterangan, email);
        }
    }//GEN-LAST:event_btKirimKeteranganActionPerformed

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
            java.util.logging.Logger.getLogger(formPengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formPengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formPengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formPengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new formPengguna().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton belumDiangkut;
    private javax.swing.JRadioButton belumMembayar;
    private javax.swing.JButton btKirimKeterangan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel jpAkunSaya;
    private javax.swing.JPanel jpHistori;
    private javax.swing.JPanel jpStatus;
    private javax.swing.JRadioButton rbnAkunSaya;
    private javax.swing.JRadioButton rbnHistori;
    private javax.swing.JRadioButton rbnStatus;
    private javax.swing.JLabel salam;
    private javax.swing.JRadioButton sudahDiangkut;
    private javax.swing.JRadioButton sudahMembayar;
    private javax.swing.JTextArea tfKeterangan;
    // End of variables declaration//GEN-END:variables
}
