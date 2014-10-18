/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Estoque;

import Interface.Estoque.Cadastrar_Produto;
import controle.FabricanteDAO;
import controle.ProdutoDAO;
import entidades.Fabricante;
import entidades.Produto;
import java.awt.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author seven
 */
public class Verificar_Estoque extends javax.swing.JFrame {

    /**
     * Creates new form Verificar_Estoque
     */
    ProdutoDAO produtos;
    FabricanteDAO fabricantes;

    public void atualizar() {
        DefaultTableModel tabela_aux = (DefaultTableModel) tabela_produtos.getModel();
        int max = tabela_aux.getRowCount();
        for (int i = 0; i < max; i++) {
            tabela_aux.removeRow(0);
        }

        java.util.List<Produto> listTeste = produtos.listarTodos();
        for (Produto a : listTeste) {
            Object[] linha = {a.getId(), a.getNome(),a.getQuantidade(),a.getValor_venda(),a.getFk_fabricante()};
            tabela_aux.addRow(linha);
        }
    }

    public Verificar_Estoque(ProdutoDAO produtodao, FabricanteDAO fabricantedao) {
        produtos = produtodao;
        fabricantes = fabricantedao;
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Estoque");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        DefaultTableModel tabela_aux = (DefaultTableModel) tabela_fabricante.getModel();
        int max = tabela_aux.getRowCount();
        for (int i = 0; i < max; i++) {
            tabela_aux.removeRow(0);
        }

        java.util.List<Fabricante> listTeste = fabricantes.listarTodos();
        for (Fabricante a : listTeste) {
            Object[] linha = {a.getId(), a.getNome()};
            tabela_aux.addRow(linha);
        }

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                atualizar();
            }
        });
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
        tabela_produtos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        visualizar = new javax.swing.JButton();
        cadastrar = new javax.swing.JButton();
        fechar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_fabricante = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabela_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Quantidade", "Valor", "Fabricante"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela_produtos);

        jLabel1.setText("Estoque");

        visualizar.setText("Visualizar");
        visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarActionPerformed(evt);
            }
        });

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

        tabela_fabricante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabela_fabricante);

        jLabel2.setText("Fabricante");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(visualizar)
                        .addGap(18, 18, 18)
                        .addComponent(cadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(excluir)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechar))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(141, 141, 141))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(visualizar)
                    .addComponent(cadastrar)
                    .addComponent(fechar)
                    .addComponent(excluir))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharActionPerformed
        dispose();
    }//GEN-LAST:event_fecharActionPerformed

    private void visualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarActionPerformed
        int linha = tabela_produtos.getSelectedRow();
        if (linha != -1) {
            DefaultTableModel tabela1 = (DefaultTableModel) tabela_produtos.getModel();
            Long codigo = (Long) tabela1.getValueAt(linha, 0);
            Produto produto = produtos.buscar(codigo);
            Visualizar_Produto editar = new Visualizar_Produto(produto,produtos,fabricantes);
            editar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this.getContentPane(), "Selecione uma linha.");
        }
    }//GEN-LAST:event_visualizarActionPerformed

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed

        int linha = tabela_fabricante.getSelectedRow();
        if (linha != -1) {
            DefaultTableModel tabela1 = (DefaultTableModel) tabela_fabricante.getModel();
            long codigo = (long) tabela1.getValueAt(linha, 0);
            Cadastrar_Produto cadastrar = new Cadastrar_Produto(codigo,produtos);
            cadastrar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this.getContentPane(), "Selecione uma linha em fabricante.");
        }


    }//GEN-LAST:event_cadastrarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        int linha = tabela_produtos.getSelectedRow();
        if (linha != -1) {
            DefaultTableModel tabela1 = (DefaultTableModel) tabela_produtos.getModel();
            Long codigo = (Long) tabela1.getValueAt(linha, 0);
            System.out.println("Excluiu Produto? "+produtos.remover(codigo));
            atualizar();
        }else{
            JOptionPane.showMessageDialog(this.getContentPane(),"Selecione uma linha.");
        }
    }//GEN-LAST:event_excluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrar;
    private javax.swing.JButton excluir;
    private javax.swing.JButton fechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabela_fabricante;
    private javax.swing.JTable tabela_produtos;
    private javax.swing.JButton visualizar;
    // End of variables declaration//GEN-END:variables
}
