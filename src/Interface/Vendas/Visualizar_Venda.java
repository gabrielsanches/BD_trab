/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Vendas;

import conexão.DAOconf;
import controle.ClienteDAO;
import controle.ProdutoDAO;
import controle.VendasDAO;
import entidades.Cliente;
import entidades.Produto;
import entidades.Vendas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel
 */
public class Visualizar_Venda extends javax.swing.JFrame {
    
    Vendas v;
    ClienteDAO clientes;
    VendasDAO vendas;

    /**
     * Creates new form Visualizar_Venda
     */
    public Visualizar_Venda(Vendas venda, ClienteDAO clientedao, VendasDAO vendasdao) {
        v = venda;
        clientes = clientedao;
        vendas = vendasdao;
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Vendas");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        nome_cliente.setEditable(false);
        data.setEditable(false);
        n_parcelas.setEditable(false);
        multa.setEditable(false);

        DefaultTableModel tabela_aux = (DefaultTableModel) tabela_produto.getModel();
        int max = tabela_aux.getRowCount();
        for (int i = 0; i < max; i++) {
            tabela_aux.removeRow(0);
        }
        Cliente cli = clientedao.buscar(venda.getFk_cliente());
        nome_cliente.setText(cli.getNome());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data2 = null;
        data2 = sdf.format(venda.getData());
        data.setText(data2);
        String forma = venda.getForma();
        if (forma.equals("À Vista")) {
            forma_pag.setSelectedIndex(0);
        } else if (forma.equals("Cheque")) {
            forma_pag.setSelectedIndex(1);
        } else if (forma.equals("À Prazo")) {
            forma_pag.setSelectedIndex(2);
        } else if (forma.equals("Cartão Débito")) {
            forma_pag.setSelectedIndex(3);
        } else if (forma.equals("Cartão Crédito")) {
            forma_pag.setSelectedIndex(4);
        }
        n_parcelas.setText("" + venda.getN_parcela());
        multa.setText("" + venda.getMulta());

        String select = "select produto.id as prod,nome,valor_venda,produto_venda.quantidade as quant from venda "
                + "inner join produto_venda on venda.id=produto_venda.id_venda "
                + "inner join produto on produto_venda.id_produto = produto.id where venda.id = " + venda.getId();

        ResultSet rs = null;
        try {
            rs = DAOconf.Consulta(select);
            while (rs.next()) {
                Object[] linha = {rs.getLong("prod"), rs.getString("nome"), rs.getFloat("valor_venda"), rs.getInt("quant")};
                tabela_aux.addRow(linha);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Visualizar_Venda.class.getName()).log(Level.SEVERE, null, ex);
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
        tabela_produto = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        multa = new javax.swing.JTextField();
        n_parcelas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        forma_pag = new javax.swing.JComboBox();
        data = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        nome_cliente = new javax.swing.JTextField();
        edit = new javax.swing.JCheckBox();
        alterar = new javax.swing.JToggleButton();
        fechar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabela_produto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Produto", "Valor(uni)", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela_produto);

        jLabel3.setText("Multa:");

        n_parcelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n_parcelasActionPerformed(evt);
            }
        });

        jLabel6.setText("Forma de Pagamento:");

        jLabel9.setText("Número de Parcelas:");

        forma_pag.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "À vista", "Cheque", "À Prazo", "Cartão Débito", "Cartão Crédito" }));
        forma_pag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forma_pagActionPerformed(evt);
            }
        });

        try {
            data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setText("Data:");

        jLabel1.setText("Visualizar Venda");

        jLabel8.setText("Nome do Cliente:");

        edit.setText("Editar");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        alterar.setText("Alterar");
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });

        fechar.setText("Fechar");
        fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(data))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(forma_pag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addGap(4, 4, 4)
                        .addComponent(n_parcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(multa, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(edit)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(fechar))
                    .addComponent(alterar))
                .addGap(184, 184, 184))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(forma_pag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(n_parcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(multa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alterar)
                    .addComponent(fechar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void n_parcelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n_parcelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n_parcelasActionPerformed

    private void forma_pagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forma_pagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forma_pagActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        if (edit.isSelected()) {
            nome_cliente.setEditable(true);
            data.setEditable(true);
            n_parcelas.setEditable(true);
            multa.setEditable(true);

        } else {
            nome_cliente.setEditable(false);
            data.setEditable(false);
            n_parcelas.setEditable(false);
            multa.setEditable(false);
        }
    }//GEN-LAST:event_editActionPerformed

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data2= null;

        try {
            data2 = sdf.parse(data.getText());
        } catch (ParseException ex) {
            Logger.getLogger(Visualizar_Venda.class.getName()).log(Level.SEVERE, null, ex);
        }

        Vendas v2 = new Vendas(0, (String) forma_pag.getSelectedItem(), data2, Float.parseFloat(multa.getText()),Integer.parseInt(n_parcelas.getText()), v.getValor_total(), v.getFk_cliente());

        System.out.println("Alterou Despesas? " + vendas.atualizar(v.getId(), v2));
        dispose();
    }//GEN-LAST:event_alterarActionPerformed

    private void fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_fecharActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton alterar;
    private javax.swing.JFormattedTextField data;
    private javax.swing.JCheckBox edit;
    private javax.swing.JToggleButton fechar;
    private javax.swing.JComboBox forma_pag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField multa;
    private javax.swing.JTextField n_parcelas;
    private javax.swing.JTextField nome_cliente;
    private javax.swing.JTable tabela_produto;
    // End of variables declaration//GEN-END:variables
}
