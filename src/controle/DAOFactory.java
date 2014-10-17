/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

/**
 *
 * @author Gabriel
 */
public abstract class DAOFactory  {
    public abstract CaixaDAO getCaixaDAO();
    public abstract ClienteDAO getClienteDAO();
    public abstract DespesaDAO getDespesaDAO();
    public abstract FabricanteDAO getFabricanteDAO();
    public abstract FornecedorDAO getFornecedorDAO();
    public abstract Par_despesaDAO getPar_despesaDAO();
    public abstract Par_vendaDAO getPar_vendaDAO();
    public abstract ProdutoDAO getProdutoDAO();
    public abstract SolicitacaoDAO getSolicitacaoDAO();
    public abstract VendasDAO getVendasDAO();
}
