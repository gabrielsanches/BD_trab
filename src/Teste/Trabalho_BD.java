/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import conexão.DAOconf;
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
import controle.memoria.MemoriaDAOFactory;
import entidades.Caixa;
import entidades.Cliente;
import entidades.Despesa;
import entidades.Fabricante;
import entidades.Fornecedor;
import entidades.Par_despesa;
import entidades.Par_venda;
import entidades.Produto;
import entidades.Solicitacao;
import entidades.Vendas;
import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class Trabalho_BD {

    /**
     * @param args the command line arguments
     */  
    
    public static void a(String[] args) {
        System.out.println("Banco está funcionando? "+DAOconf.Conecta());
        DAOFactory dao = new MemoriaDAOFactory();
        CaixaDAO caixadao = dao.getCaixaDAO();
        ClienteDAO clientedao = dao.getClienteDAO();
        DespesaDAO depesadao = dao.getDespesaDAO();
        FabricanteDAO fabricantedao = dao.getFabricanteDAO();
        FornecedorDAO fornecedordao = dao.getFornecedorDAO();
        Par_despesaDAO par_despesadao = dao.getPar_despesaDAO();
        Par_vendaDAO par_vendadao = dao.getPar_vendaDAO();
        ProdutoDAO produtodao = dao.getProdutoDAO();
        SolicitacaoDAO solicitacaodao = dao.getSolicitacaoDAO();
        VendasDAO vendasdao = dao.getVendasDAO();
        
        System.out.println("Inseriu? "+caixadao.inserir(new Caixa(2,110, new Date(2005 - 1900,12-1,12), 120, 200, new Date(2005 - 1900, 05-1, 05))));
        System.out.println(caixadao.listarTodos());
        System.out.println("Alterou Caixa?"+ caixadao.atualizar(0, new Caixa(2, 250, new Date(2005 - 1900,12-1,12), 200, 200, new Date(2005 - 1900, 05-1, 05))));      
        System.out.println("Removeu Caixa? "+ caixadao.remover(1));
        System.out.println(caixadao.listarTodos());        
        System.out.println("Buscar 0 - "+caixadao.buscar(1));
        System.out.println("");
        
        System.out.println("Inseriu Cliente? "+clientedao.inserir(new Cliente(0, "a", "a", new Date(2005 - 1900,12-1,12), "a", "a", "a", "a", 2, "a", "a", "2", "2", "a")));
        System.out.println(clientedao.listarTodos());
        System.out.println("Alterou Cliente?"+clientedao.atualizar(1, new Cliente(1, "Nigga", "a", new Date(2005 - 1900,12-1,12), "a", "a", "a", "a", 3, "a", "a","3", "3", "a")));
        System.out.println("Removeu? "+ clientedao.remover(1));
        System.out.println(clientedao.listarTodos());  
        System.out.println("Buscar "+clientedao.buscar(1));       
        System.out.println("");
        
        System.out.println("Inseriu Vendas? "+vendasdao.inserir(new Vendas(1, "A", new Date(2007 - 1900,12-1,12), 1, 1, 1, 3)));
        System.out.println(vendasdao.listarTodos());
        System.out.println("Alterou Vendas?"+vendasdao.atualizar(1, new Vendas(1, "A", new Date(2007 - 1900,12-1,12), 2, 2, 2, 1)));
        System.out.println(vendasdao.listarTodos());
        System.out.println("Removeu? "+ vendasdao.remover(1));
        System.out.println(vendasdao.listarTodos());
        System.out.println("Buscar "+vendasdao.buscar(1));
        System.out.println("");       
        
        System.out.println("Inseriu Despesa? "+depesadao.inserir(new Despesa(1, "a", 4, 4, true, "b", new Date(2005 - 1900,12-1,12), new Date(2005 - 1900,12-1,12), 1, 1)));
        System.out.println(depesadao.listarTodos());
        System.out.println("Alterou Despesa?"+depesadao.atualizar(1, new Despesa(1, "a", 1, 1, true, "b", new Date(2005 - 1900,12-1,12), new Date(2005 - 1900,12-1,12), 1, 1)));
        System.out.println(depesadao.listarTodos());
        System.out.println("Removeu? "+ depesadao.remover(1));
        System.out.println(depesadao.listarTodos());
        System.out.println("Buscar "+depesadao.buscar(1));
        System.out.println("");
        
        System.out.println("Inseriu Despesa? "+depesadao.inserir(new Despesa(1, "a", 4, 4, true, "b", new Date(2005 - 1900,12-1,12), new Date(2005 - 1900,12-1,12), 1, 1)));
        System.out.println(depesadao.listarTodos());
        System.out.println("Alterou Despesa?"+depesadao.atualizar(1, new Despesa(1, "a", 1, 1, true, "b", new Date(2005 - 1900,12-1,12), new Date(2005 - 1900,12-1,12), 1, 1)));
        System.out.println(depesadao.listarTodos());
        System.out.println("Removeu? "+ depesadao.remover(1));
        System.out.println(depesadao.listarTodos());
        System.out.println("Buscar "+depesadao.buscar(1));
        System.out.println("");
        
        System.out.println("Inseriu Fabricante? "+fabricantedao.inserir(new Fabricante(1, "B", "B", "B")));
        System.out.println(fabricantedao.listarTodos());
        System.out.println("Alterou Fabricante?"+fabricantedao.atualizar(1, new Fabricante(1, "C", "C", "C")));
        System.out.println(fabricantedao.listarTodos());
        System.out.println("Removeu? "+ fabricantedao.remover(1));
        System.out.println(fabricantedao.listarTodos());
        System.out.println("Buscar "+fabricantedao.buscar(1));
        System.out.println("");
             
        System.out.println("Inseriu Produto? "+produtodao.inserir(new Produto(1, "A", "A", 1, 1, 1, 1)));
        System.out.println(produtodao.listarTodos());
        System.out.println("Alterou Produto?"+produtodao.atualizar(1, new Produto(1, "A", "A", 2, 2, 2, 1)));
        System.out.println(produtodao.listarTodos());
        System.out.println("Removeu? "+ produtodao.remover(1));
        System.out.println(produtodao.listarTodos());
        System.out.println("Buscar "+produtodao.buscar(1));
        System.out.println("");          
        
        System.out.println("Inseriu Fornecedor? "+fornecedordao.inserir(new Fornecedor(1, "B", "B", "B", "B", "1", "1", 1)));
        System.out.println(fornecedordao.listarTodos());
        System.out.println("Alterou Fornecedor?"+fornecedordao.atualizar(1, new Fornecedor(1, "C", "C", "C", "C", "1", "1", 1)));
        System.out.println(fornecedordao.listarTodos());
        System.out.println("Removeu? "+ fornecedordao.remover(1));
        System.out.println(fornecedordao.listarTodos());
        System.out.println("Buscar "+fornecedordao.buscar(1));
        System.out.println("");
        
        System.out.println("Inseriu Parcela despesa? "+par_despesadao.inserir(new Par_despesa(1, new Date(2005 - 1900,12-1,12), new Date(2005 - 1900,12-1,12), 1, "A", 1, 1)));
        System.out.println(par_despesadao.listarTodos());
        System.out.println("Alterou Par_despesa?"+par_despesadao.atualizar(1, new Par_despesa(1, new Date(2007 - 1900,12-1,12), new Date(2005 - 1900,12-1,12), 1, "A", 1, 1)));
        System.out.println(par_despesadao.listarTodos());
        System.out.println("Removeu? "+ par_despesadao.remover(1));
        System.out.println(par_despesadao.listarTodos());
        System.out.println("Buscar "+par_despesadao.buscar(1));
        System.out.println("");
        
        System.out.println("Inseriu Parcela venda? "+par_vendadao.inserir(new Par_venda(1, new Date(2005 - 1900,12-1,12), new Date(2005 - 1900,12-1,12), 1, "A", 1, 1)));
        System.out.println(par_vendadao.listarTodos());
        System.out.println("Alterou Par venda?"+par_vendadao.atualizar(1, new Par_venda(1, new Date(2007 - 1900,12-1,12), new Date(2005 - 1900,12-1,12), 1, "A", 1, 1)));
        System.out.println(par_vendadao.listarTodos());
        System.out.println("Removeu? "+ par_vendadao.remover(1));
        System.out.println(par_vendadao.listarTodos());
        System.out.println("Buscar "+par_vendadao.buscar(1));
        System.out.println("");
        
        System.out.println("Inseriu Solicitacao? "+solicitacaodao.inserir(new Solicitacao(1, new Date(2007 - 1900,12-1,12), 1, 1, 1)));
        System.out.println(solicitacaodao.listarTodos());
        System.out.println("Alterou Solicitacao?"+solicitacaodao.atualizar(1, new Solicitacao(1, new Date(2007 - 1900,12-1,12), 2, 2, 1)));
        System.out.println(solicitacaodao.listarTodos());
        System.out.println("Removeu? "+ solicitacaodao.remover(1));
        System.out.println(solicitacaodao.listarTodos());
        System.out.println("Buscar "+solicitacaodao.buscar(1));
        System.out.println("");
       
        
              
        
    }
    
}

