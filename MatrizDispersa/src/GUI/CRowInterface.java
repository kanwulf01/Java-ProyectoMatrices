
package GUI;

import Logic.CSR;
import Logic.GestionDeArchivos;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Andrés Cuervo 1625639.
 * @author Juan David Tello 1628950.
 * @author Christian David Millan 1628953.
 */
public class CRowInterface extends javax.swing.JFrame {
    private boolean stateMatriz=false;
    private GestionDeArchivos objGestion;
    private CSR objCsr;
    
    public CRowInterface() {
        initComponents();
        this.setLocationRelativeTo(null);        

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle1 = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();
        jButtonSumMatrices = new javax.swing.JButton();
        jButtonTranspose = new javax.swing.JButton();
        jButtonSquare = new javax.swing.JButton();
        jButtonSetPosicion = new javax.swing.JButton();
        jButtonGetColumn = new javax.swing.JButton();
        jButtonGetRow = new javax.swing.JButton();
        jButtonGetElement = new javax.swing.JButton();
        jButtonGetMatriz = new javax.swing.JButton();
        jButtonGetRepresentation = new javax.swing.JButton();
        jButtonFormatoCoordenado = new javax.swing.JButton();
        jLabelStateMatriz = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitle1.setBackground(new java.awt.Color(0, 0, 153));
        jLabelTitle1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelTitle1.setForeground(new java.awt.Color(0, 51, 153));
        jLabelTitle1.setText("OPERACIONES");
        jLabelTitle1.setToolTipText("");
        getContentPane().add(jLabelTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, -1));

        jLabelTitle.setBackground(new java.awt.Color(0, 0, 153));
        jLabelTitle.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(0, 51, 153));
        jLabelTitle.setText("FORMATO CSR");
        jLabelTitle.setToolTipText("");
        getContentPane().add(jLabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        jButtonSumMatrices.setBackground(new java.awt.Color(0, 0, 102));
        jButtonSumMatrices.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonSumMatrices.setForeground(new java.awt.Color(255, 102, 0));
        jButtonSumMatrices.setText("SUMAR MATRICES");
        jButtonSumMatrices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSumMatricesActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSumMatrices, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, 220, -1));

        jButtonTranspose.setBackground(new java.awt.Color(0, 0, 102));
        jButtonTranspose.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonTranspose.setForeground(new java.awt.Color(255, 102, 0));
        jButtonTranspose.setText("MATRIZ TRANSPUESTA");
        jButtonTranspose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransposeActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTranspose, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 220, -1));

        jButtonSquare.setBackground(new java.awt.Color(0, 0, 102));
        jButtonSquare.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonSquare.setForeground(new java.awt.Color(255, 102, 0));
        jButtonSquare.setText("MATRIZ AL CUADRADO");
        jButtonSquare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSquareActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSquare, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 220, -1));

        jButtonSetPosicion.setBackground(new java.awt.Color(0, 0, 102));
        jButtonSetPosicion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonSetPosicion.setForeground(new java.awt.Color(255, 102, 0));
        jButtonSetPosicion.setText("MODIFICAR POSICION");
        jButtonSetPosicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSetPosicionActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSetPosicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 220, -1));

        jButtonGetColumn.setBackground(new java.awt.Color(0, 0, 102));
        jButtonGetColumn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonGetColumn.setForeground(new java.awt.Color(255, 102, 0));
        jButtonGetColumn.setText("OBTENER COLUMNA");
        jButtonGetColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetColumnActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGetColumn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 220, -1));

        jButtonGetRow.setBackground(new java.awt.Color(0, 0, 102));
        jButtonGetRow.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonGetRow.setForeground(new java.awt.Color(255, 102, 0));
        jButtonGetRow.setText("OBTENER FILA");
        jButtonGetRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetRowActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGetRow, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 220, -1));

        jButtonGetElement.setBackground(new java.awt.Color(0, 0, 102));
        jButtonGetElement.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonGetElement.setForeground(new java.awt.Color(255, 102, 0));
        jButtonGetElement.setText("OBTENER ELEMENTO");
        jButtonGetElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetElementActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGetElement, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 220, -1));

        jButtonGetMatriz.setBackground(new java.awt.Color(0, 0, 102));
        jButtonGetMatriz.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonGetMatriz.setForeground(new java.awt.Color(255, 102, 0));
        jButtonGetMatriz.setText("OBTENER MATRIZ");
        jButtonGetMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetMatrizActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGetMatriz, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 220, -1));

        jButtonGetRepresentation.setBackground(new java.awt.Color(0, 0, 102));
        jButtonGetRepresentation.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonGetRepresentation.setForeground(new java.awt.Color(255, 102, 0));
        jButtonGetRepresentation.setText("REPRESETACION");
        jButtonGetRepresentation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetRepresentationActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGetRepresentation, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 220, -1));

        jButtonFormatoCoordenado.setBackground(new java.awt.Color(0, 0, 102));
        jButtonFormatoCoordenado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonFormatoCoordenado.setForeground(new java.awt.Color(255, 102, 0));
        jButtonFormatoCoordenado.setText("CARGAR MATRIZ");
        jButtonFormatoCoordenado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFormatoCoordenadoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFormatoCoordenado, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        jLabelStateMatriz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/noMatriz.png"))); // NOI18N
        jLabelStateMatriz.setText("jLabel1");
        getContentPane().add(jLabelStateMatriz, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 170, 150));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backIcon.png"))); // NOI18N
        jButton1.setText("ATRÁS");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login.jpg"))); // NOI18N
        jLabelFondo.setText("jLabel1");
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFormatoCoordenadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFormatoCoordenadoActionPerformed
            stateMatriz=true;
            objGestion = new GestionDeArchivos();
            objCsr = new CSR();
            String route=objGestion.getRoute();
            try {
                objGestion.loadMatriz(route);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CRowInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stateMatriz=true;
                objCsr.loadMatriz(objGestion.getMatriz(),objGestion.getFilas(),objGestion.getColumnas());
                objCsr.csrFormat();
                jLabelStateMatriz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/siMatriz.png")));

            } catch (FileNotFoundException ex) {
                Logger.getLogger(CRowInterface.class.getName()).log(Level.SEVERE, null, ex);
            }

    }//GEN-LAST:event_jButtonFormatoCoordenadoActionPerformed

    private void jButtonGetRepresentationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGetRepresentationActionPerformed
        objCsr.csrFormat();
        objCsr.createFileRepresentation(objGestion.getRoute());
    }//GEN-LAST:event_jButtonGetRepresentationActionPerformed

    private void jButtonGetMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGetMatrizActionPerformed
        objCsr.csrFormat();
        try {
            objCsr.createFileMatriz(objGestion.getRoute());
        } catch (IOException ex) {
            Logger.getLogger(CRowInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonGetMatrizActionPerformed

    private void jButtonGetElementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGetElementActionPerformed

            JFrame frame1 = new JFrame("Seleccion de fila");
            String fila = JOptionPane.showInputDialog(frame1, "Digite el numero de la fila del elemento a obtener ");

            JFrame frame2 = new JFrame("Seleccion de columna");
            String columna = JOptionPane.showInputDialog(frame2, "Digite el numero de la columna del elemento a obtener ");
            try {
                objCsr.csrFormat();
                objCsr.getElement(Integer.parseInt(fila),Integer.parseInt(columna));
            } catch (IOException ex) {
                Logger.getLogger(CRowInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
  


    }//GEN-LAST:event_jButtonGetElementActionPerformed

    private void jButtonGetRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGetRowActionPerformed

            JFrame frame1 = new JFrame("Seleccion de fila");
            String fila = JOptionPane.showInputDialog(frame1, "Digite el numero de la fila para obtener los elementos de esta ");
            objCsr.csrFormat();
            objCsr.getRow(Integer.parseInt(fila));


    }//GEN-LAST:event_jButtonGetRowActionPerformed

    private void jButtonGetColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGetColumnActionPerformed
        
        JFrame frame1 = new JFrame("Seleccion de columna");
        String columna = JOptionPane.showInputDialog(frame1, "Digite el numero de la columna para obtener los elementos de esta ");
        objCsr.csrFormat();
        objCsr.getColumn(Integer.parseInt(columna));
        
    }//GEN-LAST:event_jButtonGetColumnActionPerformed

    private void jButtonSetPosicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSetPosicionActionPerformed

            JFrame frame1 = new JFrame("Seleccion de fila");
            String fila = JOptionPane.showInputDialog(frame1, "Digite el numero de la fila del elemento a modificar ");

            JFrame frame2 = new JFrame("Seleccion de columna");
            String columna = JOptionPane.showInputDialog(frame2, "Digite el numero de la columna del elemento a modificar ");

            JFrame frame3 = new JFrame("Ingreso Numero");
            String numero = JOptionPane.showInputDialog(frame3, "Digite el que desea insertar ");
            objCsr.csrFormat();
            try {
                objCsr.setPosition(objGestion.getRoute(),Integer.parseInt(fila),Integer.parseInt(columna),Integer.parseInt(numero));
            } catch (IOException ex) {
                Logger.getLogger(CRowInterface.class.getName()).log(Level.SEVERE, null, ex);
            }

    }//GEN-LAST:event_jButtonSetPosicionActionPerformed

    private void jButtonSquareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSquareActionPerformed
        try {
            objCsr.csrFormat();
            objCsr.squareMatriz(objGestion.getRoute());
        } catch (IOException ex) {
            Logger.getLogger(CRowInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonSquareActionPerformed

    private void jButtonTransposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransposeActionPerformed
        objCsr.csrFormat();
        try {
            objCsr.transposedMatriz(objGestion.getRoute());
        } catch (IOException ex) {
            Logger.getLogger(CRowInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonTransposeActionPerformed

    private void jButtonSumMatricesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSumMatricesActionPerformed
            String route=objGestion.getRoute();
            try {
                objGestion.loadMatriz(route);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CoordenateInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stateMatriz=true;
                objCsr.loadMatrizSum(objGestion.getMatriz(),objGestion.getFilas(),objGestion.getColumnas());
                objCsr.sumMatrices(objGestion.getRoute());

            } catch (FileNotFoundException ex) {
                Logger.getLogger(CoordenateInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CRowInterface.class.getName()).log(Level.SEVERE, null, ex);
            }

    }//GEN-LAST:event_jButtonSumMatricesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        InitialInterface objVentana = new InitialInterface();
        objVentana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(CRowInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRowInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRowInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRowInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRowInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonFormatoCoordenado;
    private javax.swing.JButton jButtonGetColumn;
    private javax.swing.JButton jButtonGetElement;
    private javax.swing.JButton jButtonGetMatriz;
    private javax.swing.JButton jButtonGetRepresentation;
    private javax.swing.JButton jButtonGetRow;
    private javax.swing.JButton jButtonSetPosicion;
    private javax.swing.JButton jButtonSquare;
    private javax.swing.JButton jButtonSumMatrices;
    private javax.swing.JButton jButtonTranspose;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelStateMatriz;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelTitle1;
    // End of variables declaration//GEN-END:variables
}
