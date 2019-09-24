
package GUI;

/**
 *
 * @author Carlos Andrés Cuervo 1625639.
 * @author Juan David Tello 1628950.
 * @author Christian David Millan 1628953.
 */
public class InitialInterface extends javax.swing.JFrame {


    public InitialInterface() {
        initComponents();
        this.setLocationRelativeTo(null);        

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jButtonFormatoColumnas = new javax.swing.JButton();
        jButtonFormatoCoordenado = new javax.swing.JButton();
        jButtonFormatoFilas = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitle.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setText("MATRIZ DISPERSA");
        jLabelTitle.setToolTipText("");
        getContentPane().add(jLabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButtonFormatoColumnas.setBackground(new java.awt.Color(0, 51, 102));
        jButtonFormatoColumnas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonFormatoColumnas.setForeground(new java.awt.Color(255, 102, 0));
        jButtonFormatoColumnas.setText("C. COLUMNAS");
        jButtonFormatoColumnas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFormatoColumnasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFormatoColumnas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 180, -1));

        jButtonFormatoCoordenado.setBackground(new java.awt.Color(0, 51, 102));
        jButtonFormatoCoordenado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonFormatoCoordenado.setForeground(new java.awt.Color(255, 102, 0));
        jButtonFormatoCoordenado.setText("COORDENADO");
        jButtonFormatoCoordenado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFormatoCoordenadoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFormatoCoordenado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 180, -1));

        jButtonFormatoFilas.setBackground(new java.awt.Color(0, 51, 102));
        jButtonFormatoFilas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonFormatoFilas.setForeground(new java.awt.Color(255, 102, 0));
        jButtonFormatoFilas.setText("C. FILAS");
        jButtonFormatoFilas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFormatoFilasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFormatoFilas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 180, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/compsc.png"))); // NOI18N
        jLabelFondo.setText("jLabel1");
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFormatoCoordenadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFormatoCoordenadoActionPerformed
        CoordenateInterface objVentana = new CoordenateInterface();
        objVentana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonFormatoCoordenadoActionPerformed

    private void jButtonFormatoColumnasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFormatoColumnasActionPerformed
        CColumnInterface objVentana = new CColumnInterface();
        objVentana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonFormatoColumnasActionPerformed

    private void jButtonFormatoFilasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFormatoFilasActionPerformed
        CRowInterface objVentana = new CRowInterface();
        objVentana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonFormatoFilasActionPerformed

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
            java.util.logging.Logger.getLogger(InitialInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InitialInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InitialInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InitialInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InitialInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFormatoColumnas;
    private javax.swing.JButton jButtonFormatoCoordenado;
    private javax.swing.JButton jButtonFormatoFilas;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelTitle;
    // End of variables declaration//GEN-END:variables
}
