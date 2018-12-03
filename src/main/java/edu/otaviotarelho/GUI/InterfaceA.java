/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.otaviotarelho.GUI;

import edu.otaviotarelho.manager.Management;
import edu.otaviotarelho.staticMessages.Error;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 *
 * @author papagaiored
 */
public class InterfaceA extends javax.swing.JFrame {

    private static Management management;
     /**
     * Creates new form InterfaceA
     */
    public InterfaceA() {
        initComponents();
    }


    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbLista = new javax.swing.JTable();
        BtnOpen = new javax.swing.JButton();
        BtnSaveAs = new javax.swing.JButton();
        BtnRemove = new javax.swing.JButton();
        BtnExtractSource = new javax.swing.JButton();
        BtnAdd = new javax.swing.JButton();
        BtnExtract = new javax.swing.JButton();

        jButton4.setText("Remove");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TbLista.setModel(new javax.swing.table.DefaultTableModel(
            null,
            new String [] {
                "id", "name", "type", "path origem", "size in bytes", "size of the original block", "criation date", "modified date"
            }
        ));
        TbLista.setColumnSelectionAllowed(false);
        TbLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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

        BtnExtractSource.setText("Extract at source");
        BtnExtractSource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExtractSourceActionPerformed(evt);
            }
        });

        BtnAdd.setText("Add");
        BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddActionPerformed(evt);
            }
        });

        BtnExtract.setText("Extract");
        BtnExtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExtractActionPerformed(evt);
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
                .addGap(4, 4, 4)
                .addComponent(BtnExtract, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnExtractSource)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
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
                    .addComponent(BtnExtractSource, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnExtract, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );

        pack();
    }

    private void BtnExtractSourceActionPerformed(java.awt.event.ActionEvent evt) {
        int idOption = TbLista.getSelectedRow();

        if(idOption == -1){
            JOptionPane.showMessageDialog(getParent(), "É necessário selecionar um arquivo");
            return;
        }

        try {
            String path = management.saveToOrigem(idOption);
            JOptionPane.showMessageDialog(getParent(), "Arquivo salvo em:" + path);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(getParent(), "Não foi possível salvar o arquivo: " + e.getMessage());
        }
    }//GEN-LAST:event_BtnExtractSourceActionPerformed

    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        int result = fileChooser.showOpenDialog(getParent());

        if(result == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            try{
                management.addFile(Paths.get(file.getPath()));
                TbLista.setModel(management.listFiles());
            } catch (Exception e){
                JOptionPane.showMessageDialog(getParent(), Error.ADD_ERROR);
            }
        }
    }

    private void BtnOpenActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setAcceptAllFileFilterUsed(false);

        int result = fileChooser.showOpenDialog(getParent());

        if(result == JFileChooser.APPROVE_OPTION){
            try{
                File file = fileChooser.getSelectedFile();
                management.readFile(Paths.get(file.getPath()));
                TbLista.setModel(management.listFiles());
                TbLista.updateUI();
            } catch (Exception e ){
                JOptionPane.showMessageDialog(getParent(), Error.OPEN_ERROR);
            }
        }
    }

    private void BtnSaveAsActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = fileChooser.showOpenDialog(getParent());

        if(result == JFileChooser.APPROVE_OPTION){
            String fileName = JOptionPane.showInputDialog("Digite o nome do arquivo");
            try{
                management.defrag();
                management.saveFileInDisc(fileChooser.getCurrentDirectory().toString() + "/"+ fileName);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(getParent(), "Não foi possível salvar o arquivo: " + e.getMessage());
            }
        }
    }

    private void BtnRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        int idOption = TbLista.getSelectedRow();

        if(idOption == -1){
            JOptionPane.showMessageDialog(getParent(), "É necessário selecionar um arquivo");
            return;
        }

        int option = JOptionPane.showConfirmDialog(getParent(), "Deseja remover o arquivo?" , "Aviso", JOptionPane.YES_NO_OPTION);

        if(option == JOptionPane.YES_OPTION){
            management.removeFiles(idOption);
            TbLista.setModel(management.listFiles());
        }

    }

    private void BtnExtractActionPerformed(java.awt.event.ActionEvent evt) {
        int idOption = TbLista.getSelectedRow();

        if(idOption == -1){
            JOptionPane.showMessageDialog(getParent(), "É necessário selecionar um arquivo");
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = fileChooser.showOpenDialog(getParent());

        if(result == JFileChooser.APPROVE_OPTION){
            try{
                management.extractFile(idOption, fileChooser.getCurrentDirectory().toString());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(getParent(), "Não foi possível salvar o arquivo: " + e.getMessage());
            }
        }

    }


    public static void main(String args[]) {

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

        management = new Management();


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceA().setVisible(true);
            }
        });
    }

    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton BtnExtract;
    private javax.swing.JButton BtnExtractSource;
    private javax.swing.JButton BtnOpen;
    private javax.swing.JButton BtnRemove;
    private javax.swing.JButton BtnSaveAs;
    private javax.swing.JTable TbLista;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;

}
