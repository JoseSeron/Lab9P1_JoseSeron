package lab9p1_joseseron;

import javax.swing.JOptionPane;

/**
 *
 * @author Jose Seron
 */
public class JFrame extends javax.swing.JFrame {

    /**
     * Creates new form JFrame
     */
    public JFrame() {
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

        jLabel1 = new javax.swing.JLabel();
        gusanito = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Lab 9 - Q4 2023");

        gusanito.setText("Gusanito");
        gusanito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gusanitoActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gusanito, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(gusanito)
                .addGap(55, 55, 55)
                .addComponent(salir)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gusanitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gusanitoActionPerformed
        // TODO add your handling code here:

        String dimension = JOptionPane.showInputDialog("Ingrese las dimensiones del tablero en el formato ancho,alto: ");
        String[] split = dimension.split(",");
        String ancho = split[0];
        String alto = split[1];

        int anchoInt = Integer.parseInt(ancho);
        int altoInt = Integer.parseInt(alto);

        while ((anchoInt < 4 || anchoInt > 10) || (altoInt < 4 || altoInt > 10)) {
            dimension = JOptionPane.showInputDialog("Ingrese las dimensiones del tablero en el formato ancho,alto: ");
            split = dimension.split(",");
            ancho = split[0];
            alto = split[1];

            anchoInt = Integer.parseInt(ancho);
            altoInt = Integer.parseInt(alto);
        }

        Gusanito gusanito = new Gusanito(anchoInt, altoInt);

        char[][] matriz = gusanito.tablero;


        boolean bandera = true;

        while (bandera) {
            System.out.println(gusanito.instrucciones);
            String opcion = JOptionPane.showInputDialog(null, "Mapa\n" + gusanito.printCadena(matriz) + "\n1. Ingresar Instruccion \n2. Ejecutar Instruccion\n");

            if (opcion.equals("1")) {
                String elemento = JOptionPane.showInputDialog(null, "Mapa\n" + gusanito.printCadena(matriz) + "\nIngrese la instruccion de la forma magnitudDIRECCION (ej. 2UP)");
                gusanito.instrucciones.add(elemento);
                

            } else if (opcion.equals("2")) {
                // ejecutar instrucciones
                String paso = JOptionPane.showInputDialog("Ingrese el Paso");
                int paso2 = Integer.parseInt(paso);
                mostrarPaso(paso2);
                
                JOptionPane.showMessageDialog(null, "Fortin no he dormido en 3 dias, esto es lo mas puedo hacer antes de morirme. Love You Carlitos");
                
                bandera=false;
               
            }
        }


    }//GEN-LAST:event_gusanitoActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_salirActionPerformed

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
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gusanito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables

    private void mostrarPaso(int paso2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
