/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montrash_oneforall;

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
        jLabel2 = new javax.swing.JLabel();
        jpHistori = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        salam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jpAkunSayaLayout = new javax.swing.GroupLayout(jpAkunSaya);
        jpAkunSaya.setLayout(jpAkunSayaLayout);
        jpAkunSayaLayout.setHorizontalGroup(
            jpAkunSayaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAkunSayaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salam, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpAkunSayaLayout.setVerticalGroup(
            jpAkunSayaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAkunSayaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salam, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(422, Short.MAX_VALUE))
        );

        jPanel2.add(jpAkunSaya, "card2");

        jpStatus.setBackground(new java.awt.Color(201, 246, 88));

        jLabel2.setText("Status");

        javax.swing.GroupLayout jpStatusLayout = new javax.swing.GroupLayout(jpStatus);
        jpStatus.setLayout(jpStatusLayout);
        jpStatusLayout.setHorizontalGroup(
            jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(409, Short.MAX_VALUE))
        );
        jpStatusLayout.setVerticalGroup(
            jpStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(467, Short.MAX_VALUE))
        );

        jPanel2.add(jpStatus, "card3");

        jpHistori.setBackground(new java.awt.Color(201, 246, 88));

        jLabel3.setText("Histori");

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

        javax.swing.GroupLayout jpHistoriLayout = new javax.swing.GroupLayout(jpHistori);
        jpHistori.setLayout(jpHistoriLayout);
        jpHistoriLayout.setHorizontalGroup(
            jpHistoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHistoriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpHistoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpHistoriLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpHistoriLayout.setVerticalGroup(
            jpHistoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHistoriLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel jpAkunSaya;
    private javax.swing.JPanel jpHistori;
    private javax.swing.JPanel jpStatus;
    private javax.swing.JRadioButton rbnAkunSaya;
    private javax.swing.JRadioButton rbnHistori;
    private javax.swing.JRadioButton rbnStatus;
    private javax.swing.JLabel salam;
    // End of variables declaration//GEN-END:variables
}
