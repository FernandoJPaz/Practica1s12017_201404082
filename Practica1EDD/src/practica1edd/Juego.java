/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1edd;
import javax.swing.JOptionPane;
/**
 *
 * @author Fernando
 */
public class Juego extends javax.swing.JFrame {

     ListaCircular Lc = new ListaCircular();
     ListaSimpleDPalabras LS = new ListaSimpleDPalabras();
     Cola c = new Cola(5);

   
    public Juego() {
        initComponents();
        setLocationRelativeTo(null);
         
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("AREA DE REPORTES ");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("PALABRAS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Matriz");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenu3.setText("File");
        jMenu1.add(jMenu3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu4.setText("Usuarios");

        jMenuItem1.setText("Agregar Usuario");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(506, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(52, 52, 52)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addComponent(jButton1))
                .addContainerGap(373, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(76, 76, 76)
                .addComponent(jButton1)
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(288, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        String nombre ;
        nombre= JOptionPane.showInputDialog("Nombre de usuario");
        
        System.out.println("Hola "+nombre);
        
      
        Lc.agregarAlFinal(nombre);
        Lc.listar();
      
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  
        Lc.Graficar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        LS.listar();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Matriz mat= new Matriz();
      /*  mat.addNodo("DATO1", 1, 1);
        mat.addNodo("DATO2", 1, 2);
        mat.addNodo("DATO3", 1, 3);
        
        
        
        mat.addNodo("DATO4", 2, 1);
        mat.addNodo("DATO5", 2, 2);
        mat.addNodo("DATO6", 2, 3);
        
        mat.addNodo("DATO7", 3, 1);
        mat.addNodo("DATO8", 3, 2);
        mat.addNodo("DATO9", 3, 3);
        */
        
        //mat.addNodo("DATO1", 1, 1);
        //mat.addNodo("DATO2", 1, 2);
        
        //mat.addNodo("DATO3", 2, 2);
       // mat.addNodo("DATO3", 2, 2);
       
       
        
     

        mat.addNodo("fila1",1, 0);
        mat.addNodo("fila1",1, 1);
        mat.addNodo("fila1",1, 2);
        
        mat.addNodo("fila2",2, 0);
        mat.addNodo("fila2",2, 1);
        mat.addNodo("fila2",2, 2);
              
        mat.addNodo("fila3",3, 0);
        mat.addNodo("fila3",3, 1);
        mat.addNodo("fila3",3, 2);
        
        
        
        
        /*
        mat.addNodo(1, 1, 2);
        mat.addNodo(2, 2, 2);
        mat.addNodo(3, 3, 2);
        mat.addNodo(4, 4, 2);
        mat.addNodo(5, 5, 2);*/
        
//        mat.addNodo(1, 3, 1);
//        mat.addNodo(2, 3, 2);
//        mat.addNodo(3, 3, 3);
//        mat.addNodo(4, 3, 4);
//        mat.addNodo(5, 3, 5);
//        
//        mat.addNodo(1, 4, 1);
//        mat.addNodo(2, 4, 2);
//        mat.addNodo(3, 4, 3);
//        mat.addNodo(4, 4, 4);
//        mat.addNodo(5, 4, 5);
//        
//        mat.addNodo(1, 5, 1);
//        mat.addNodo(2, 5, 2);
//        mat.addNodo(3, 5, 3);
//        mat.addNodo(4, 5, 4);
//        mat.addNodo(5, 5, 5);

        
        
        mat.graphMat2();
       // mat.GraficarMatriz();
        mat.linealizarColumnas();
        mat.linealizarFilas();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        c.insert("a");
        c.insert("b");
        c.insert("c");
        c.insert("d");
        c.insert("e");
        c.insert("f");
        
        c.Desencolar();
        c.Desencolar();
        
        c.print();

    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
