/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.memoria;

import controle.CaixaDAO;
import controle.ClienteDAO;
import controle.DAOFactory;
import controle.DespesaDAO;
import controle.FabricanteDAO;
import controle.FornecedorDAO;
import controle.Par_despesaDAO;
import controle.Par_vendaDAO;
import controle.ProdutoDAO;
import controle.SolicitacaoDAO;
import controle.VendasDAO;

/**
 *
 * @author Gabriel
 */
public class MemoriaDAOFactory extends DAOFactory{

    @Override
    public CaixaDAO getCaixaDAO() {
        return new MemoriaCaixaDAO();
    }

    @Override
    public ClienteDAO getClienteDAO() {
        return new MemoriaClienteDAO();
    }

    @Override
    public DespesaDAO getDespesaDAO() {
        return new MemoriaDespesaDAO();
    }

    @Override
    public FabricanteDAO getFabricanteDAO() {
        return new MemoriaFabricanteDAO();
    }

    @Override
    public FornecedorDAO getFornecedorDAO() {
        return new MemoriaFornecedorDAO();
    }

    @Override
    public Par_despesaDAO getPar_despesaDAO() {
        return new MemoriaPar_despesaDAO();
    }

    @Override
    public Par_vendaDAO getPar_vendaDAO() {
        return new MemoriaPar_vendaDAO();
    }

    @Override
    public ProdutoDAO getProdutoDAO() {
        return new MemoriaProdutoDAO();
    }

    @Override
    public SolicitacaoDAO getSolicitacaoDAO() {
        return new MemoriaSolicitacaoDAO();
    }

    @Override
    public VendasDAO getVendasDAO() {
        return new MemoriaVendasDAO();
    }
    
}
