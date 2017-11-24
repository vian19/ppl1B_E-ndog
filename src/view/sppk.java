/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;

/**
 *
 * @author Vian
 */
public class sppk extends javax.swing.JFrame {

    /**
     * Creates new form kuning
     */
    public sppk() {
        initComponents();
        this.tindakan.setLineWrap(true);
        this.tindakan.setWrapStyleWord(true);
    }
       public void addKembaliListener(ActionListener listener) {
        kembali.addActionListener(listener);
    }
//    public int getKolam(){
//        return .getSelectedIndex();
//    }
    public String getberat() {
        return W.getText();
    }

    public String getukuran() {
        return H.getText();
    }



    public void setTindakan(String volum) {
        tindakan.setText(volum);
    }

    public void hasilListener(ActionListener hasil) {
        btn_hasil.addActionListener(hasil);
    }
    
    public int getPilihanGambar() {
        int pilihan = -1;
        if (a.isSelected()) {
            pilihan = 1;
        } else if (b.isSelected()) {
            pilihan = 2;
        } else if (c.isSelected()) {
            pilihan = 3;
        } 
        return pilihan;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gambar = new javax.swing.ButtonGroup();
        jColorChooser1 = new javax.swing.JColorChooser();
        a = new javax.swing.JRadioButton();
        b = new javax.swing.JRadioButton();
        c = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        W = new javax.swing.JTextField();
        H = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_hasil = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tindakan = new javax.swing.JTextArea();
        kembali = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gambar.add(a);
        a.setText("A");
        getContentPane().add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, -1, -1));

        gambar.add(b);
        b.setText("B");
        b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActionPerformed(evt);
            }
        });
        getContentPane().add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, -1, -1));

        gambar.add(c);
        c.setText("C");
        getContentPane().add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Manakah yang mirip dengan gambar?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 310, 33));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/kualitas 1.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 170, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/kualitas 2.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 220, 110));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/kualitas 3.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 180, 120));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Berat");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, -1, -1));

        W.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WActionPerformed(evt);
            }
        });
        getContentPane().add(W, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 220, -1));
        getContentPane().add(H, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 220, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Tinggi");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, -1, -1));

        btn_hasil.setText("SUBMIT");
        getContentPane().add(btn_hasil, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, -1, -1));

        tindakan.setColumns(20);
        tindakan.setRows(5);
        jScrollPane1.setViewportView(tindakan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 240, 80));

        kembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/kembali.png"))); // NOI18N
        kembali.setContentAreaFilled(false);
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/Uji Telur.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void WActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WActionPerformed

    private void bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bActionPerformed

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
            java.util.logging.Logger.getLogger(sppk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sppk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sppk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sppk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sppk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField H;
    private javax.swing.JTextField W;
    private javax.swing.JRadioButton a;
    private javax.swing.JRadioButton b;
    private javax.swing.JButton btn_hasil;
    private javax.swing.JRadioButton c;
    private javax.swing.ButtonGroup gambar;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    private javax.swing.JTextArea tindakan;
    // End of variables declaration//GEN-END:variables
}