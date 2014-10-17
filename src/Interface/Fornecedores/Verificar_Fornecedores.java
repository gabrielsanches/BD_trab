/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface.Fornecedores;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author seven
 */
public class Verificar_Fornecedores extends javax.swing.JFrame {

    /**
     * Creates new form Verificar_Fornecedores
     */
    public Verificar_Fornecedores() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Fornecedores");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        
        //listar os fornecedores
        
                //Teste
        ArrayList<Integer> listTeste = new ArrayList<>();
        listTeste.add(1);
        listTeste.add(3);
        listTeste.add(5);
        listTeste.add(2);
        listTeste.add(2);
        listTeste.add(2);
        listTeste.add(2);
        listTeste.add(2);
        listTeste.add(2);
        listTeste.add(2);
        listTeste.add(2);
        DefaultTableModel tabela = (DefaultTableModel) jTable_tabela.getModel();
        if(!listTeste.isEmpty()){
            for(Integer a: listTeste){
                Object[] linha = {a,a,a,a};
                tabela.addRow(linha);
            }
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_tabela = new javax.swing.JTable();
        jButton_visualizar = new javax.swing.JButton();
        jButton_fechar = new javax.swing.JButton();
        jButton_cadastrar = new javax.swing.JButton();
        jButton_excluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Fornecedores");

        jTable_tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Sobrenome", "Telefone", "Email", "Fabricante"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_tabela);

        jButton_visualizar.setText("Visualizar");
        jButton_visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_visualizarActionPerformed(evt);
            }
        });

        jButton_fechar.setText("Fechar");
        jButton_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_fecharActionPerformed(evt);
            }
        });

        jButton_cadastrar.setText("Cadastrar");
        jButton_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cadastrarActionPerformed(evt);
            }
        });

        jButton_excluir.setText("Excluir");
        jButton_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jButton_visualizar)
                .addGap(18, 18, 18)
                .addComponent(jButton_cadastrar)
                .addGap(18, 18, 18)
                .addComponent(jButton_excluir)
                .addGap(18, 18, 18)
                .addComponent(jButton_fechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_visualizar)
                    .addComponent(jButton_fechar)
                    .addComponent(jButton_cadastrar)
                    .addComponent(jButton_excluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_fecharActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_fecharActionPerformed

    private void jButton_visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_visualizarActionPerformed
        // TODO add your handling code here:
        Visualizar_Fornecedor Ver = new Visualizar_Fornecedor();
        Ver.setVisible(true);
    }//GEN-LAST:event_jButton_visualizarActionPerformed

    private void jButton_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cadastrarActionPerformed
        // TODO add your handling code here:
        Cadastrar_fornecedor Ver = new Cadastrar_fornecedor();
        Ver.setVisible(true);
    }//GEN-LAST:event_jButton_cadastrarActionPerformed

    private void jButton_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_excluirActionPerformed
        // TODO add your handling code here:
        Excluir_fornecedor ex = new Excluir_fornecedor();
        ex.setVisible(true);
    }//GEN-LAST:event_jButton_excluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_cadastrar;
    private javax.swing.JButton jButton_excluir;
    private javax.swing.JButton jButton_fechar;
    private javax.swing.JButton jButton_visualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_tabela;
    // End of variables declaration//GEN-END:variables
}