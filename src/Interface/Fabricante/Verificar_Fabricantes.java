/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface.Fabricante;

import controle.FabricanteDAO;
import entidades.Fabricante;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author seven
 */
public class Verificar_Fabricantes extends javax.swing.JFrame {

    FabricanteDAO manufacturer;
    
    public Verificar_Fabricantes(FabricanteDAO fabricantedao) {
        manufacturer = fabricantedao;
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Fabricantes");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                atualizar();
            }
        });
        
    }
    
    public void atualizar() {
        DefaultTableModel tabela_aux = (DefaultTableModel) tabela.getModel();
        int max = tabela_aux.getRowCount();
        for (int i = 0; i < max; i++) {
            tabela_aux.removeRow(0);
        }

        List<Fabricante> listTeste = manufacturer.listarTodos();
        for (Fabricante a : listTeste) {
            Object[] linha = {a.getId(), a.getNome(), a.getTelefone(), a.getEmail()};
            tabela_aux.addRow(linha);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cadastrar = new javax.swing.JButton();
        fechar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        visualizar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Telefone", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);

        jLabel1.setText("Fabricantes");

        cadastrar.setText("Cadastrar");
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        fechar.setText("Fechar");
        fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharActionPerformed(evt);
            }
        });

        excluir.setText("Excluir");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        visualizar.setText("Visualizar");
        visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(247, 247, 247))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(visualizar)
                .addGap(33, 33, 33)
                .addComponent(cadastrar)
                .addGap(37, 37, 37)
                .addComponent(excluir)
                .addGap(32, 32, 32)
                .addComponent(fechar)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrar)
                    .addComponent(fechar)
                    .addComponent(excluir)
                    .addComponent(visualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_fecharActionPerformed

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        // TODO add your handling code here:
        Cadastrar_Fabricante Edit = new Cadastrar_Fabricante();
        Edit.setVisible(true);
//        while(!Edit.isActive());
//        
//            //relistar Fabricantes
//        System.out.println("Teste");
    }//GEN-LAST:event_cadastrarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        // TODO add your handling code here:
        int linha = tabela.getSelectedRow();
        if (linha != -1) {
            DefaultTableModel tabela1 = (DefaultTableModel) tabela.getModel();
            Long codigo = (Long) tabela1.getValueAt(linha, 0);
            System.out.println("Excluiu? "+manufacturer.remover(codigo));
        }else{
            JOptionPane.showMessageDialog(this.getContentPane(),"Selecione uma linha.");
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarActionPerformed
        int linha = tabela.getSelectedRow();
        if (linha != -1) {
            DefaultTableModel tabela1 = (DefaultTableModel) tabela.getModel();
            Long codigo = (Long) tabela1.getValueAt(linha, 0);
            Fabricante fab = manufacturer.buscar(codigo);
            Visualizar_Fab Ver = new Visualizar_Fab(fab, manufacturer);
            Ver.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this.getContentPane(),"Selecione uma linha.");
        }
    }//GEN-LAST:event_visualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrar;
    private javax.swing.JButton excluir;
    private javax.swing.JButton fechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JToggleButton visualizar;
    // End of variables declaration//GEN-END:variables
}
