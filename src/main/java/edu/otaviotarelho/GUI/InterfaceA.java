/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.otaviotarelho.GUI;

/**
 *
 * @author papagaiored
 */
public class InterfaceA extends javax.swing.JFrame {

    /**
     * Creates new form InterfaceA
     */
    public InterfaceA() {
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

        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbLista = new javax.swing.JTable();
        BtnOpen = new javax.swing.JButton();
        BtnSaveAs = new javax.swing.JButton();
        BtnRemove = new javax.swing.JButton();
        BtnExtract = new javax.swing.JButton();
        BtnAdd = new javax.swing.JButton();

        jButton4.setText("Remove");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TbLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "teste", ".DOC", "C://", "1024", "1024 mb", "11/29/2018", "11/29/2018", "yes"},
                {"2", "teste", ".DOC", "C://", "1024", "1024 mb", "11/29/2018", "11/29/2018", "yes"},
                {"3", "teste", ".DOC", "C://", "1024", "1024 mb", "11/29/2018", "11/29/2018", "yes"},
                {"4", "teste", ".DOC", "C://", "1024", "1024 mb", "11/29/2018", "11/29/2018", "yes"}
            },
            new String [] {
                "id", "name", "type", "path Origem", "byteSize", "blockSize", "criation Date", "modified Date", "activated"
            }
        ));
        TbLista.setColumnSelectionAllowed(true);
        TbLista.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                TbListaComponentAdded(evt);
            }
        });
        TbLista.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TbListaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        TbLista.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                TbListaComponentMoved(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                TbListaComponentShown(evt);
            }
        });
        TbLista.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TbListaPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(TbLista);
        TbLista.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        BtnOpen.setText("Open");
        BtnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOpenActionPerformed(evt);
            }
        });

        BtnSaveAs.setText("Save As");
        BtnSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveAsActionPerformed(evt);
            }
        });

        BtnRemove.setText("Remove");
        BtnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRemoveActionPerformed(evt);
            }
        });

        BtnExtract.setText("Extract");
        BtnExtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExtractActionPerformed(evt);
            }
        });

        BtnAdd.setText("Add");
        BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(BtnOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnSaveAs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnExtract, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnSaveAs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnExtract, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TbListaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TbListaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_TbListaPropertyChange

    private void TbListaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_TbListaComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_TbListaComponentShown

    private void TbListaComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_TbListaComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_TbListaComponentMoved

    private void TbListaComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_TbListaComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_TbListaComponentAdded

    private void BtnExtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExtractActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnExtractActionPerformed

    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed

    }//GEN-LAST:event_BtnAddActionPerformed

    private void BtnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnOpenActionPerformed

    private void BtnSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveAsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnSaveAsActionPerformed

    private void BtnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRemoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnRemoveActionPerformed

    private void TbListaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TbListaAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_TbListaAncestorAdded

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
            java.util.logging.Logger.getLogger(InterfaceA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton BtnExtract;
    private javax.swing.JButton BtnOpen;
    private javax.swing.JButton BtnRemove;
    private javax.swing.JButton BtnSaveAs;
    private javax.swing.JTable TbLista;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
