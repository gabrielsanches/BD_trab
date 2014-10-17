/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.memoria;

import conexão.DAOconf;
import controle.ProdutoDAO;
import entidades.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
class MemoriaProdutoDAO implements ProdutoDAO {

    List<Produto> produto;

    public MemoriaProdutoDAO() {
        produto = new ArrayList<Produto>();
    }

    @Override
    public Produto buscar(long codigo) {
        String consulta = "select * from produto where id = " + codigo;
        try {
            ResultSet rs = DAOconf.Consulta(consulta);
            rs.next();
            Produto c = new Produto(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getFloat(6), rs.getInt(7));
            c.setAtivo(rs.getBoolean(8));
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean inserir(Produto t) {
        String insert = "INSERT INTO produto (nome,descricao,quantidade,valor_venda,valor_compra,fk_fabricante)"
                + "VALUES (\'" + t.getNome() + "\',\'" + t.getDescricao() + "\',"
                + t.getQuantidade() + "," + t.getValor_venda() + "," + t.getValor_compra() + "," + t.getFk_fabricante() + ")";
        try {
            DAOconf.execute(insert);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean remover(long codigo) {
        String delete = "Select ativo from produto where id = " + codigo;
        try {
            ResultSet rs = DAOconf.Consulta(delete);
            rs.next();
            if (rs.getBoolean(1) == true) {
                String update = "update produto set ativo = false where id=" + codigo;
                DAOconf.execute(update);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean atualizar(long codigo, Produto t) {
        String insert = "update produto set"
                + " nome = \'" + t.getNome() + "\',descricao = \'" + t.getDescricao() + "\', quantidade = "
                + t.getQuantidade() + ",valor_venda = " + t.getValor_venda() + ",valor_compra = " 
                + t.getValor_compra() + ",fk_fabricante = " + t.getFk_fabricante() + " where id = "+ codigo;
        try {
            DAOconf.execute(insert);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Produto> listarTodos() {
        List<Produto> produto2 = new ArrayList<Produto>();
        try {
            ResultSet rs = DAOconf.Consulta("Select * from produto where ativo = true");
            while (rs.next()) {
                Produto c = new Produto(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getFloat(6), rs.getInt(7));
                c.setAtivo(rs.getBoolean(8));
                produto2.add(c);
            }
            Collections.sort(produto2);
            return produto2;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
