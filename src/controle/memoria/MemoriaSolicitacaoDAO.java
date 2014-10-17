/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.memoria;

import conexão.DAOconf;
import controle.SolicitacaoDAO;
import entidades.Solicitacao;
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
class MemoriaSolicitacaoDAO implements SolicitacaoDAO {

    List<Solicitacao> solicitacao;

    public MemoriaSolicitacaoDAO() {
        solicitacao = new ArrayList<Solicitacao>();
    }

    @Override
    public Solicitacao buscar(long codigo) {
        String consulta = "select * from solicitacao where id = " + codigo;
        try {
            ResultSet rs = DAOconf.Consulta(consulta);
            rs.next();
            Solicitacao c = new Solicitacao(rs.getLong(1), rs.getDate(2), rs.getFloat(3), rs.getFloat(4), rs.getInt(5));
            c.setAtivo(rs.getBoolean(6));
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean inserir(Solicitacao t) {
        String insert = "INSERT INTO solicitacao (data,multa,valor_total,fk_fornecedor)"
                + " VALUES (\'" + t.getData()+ "\'," + t.getMulta() + ","
                + t.getValor_total() + "," + t.getFk_fornecedor() + ")";
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
        String delete = "Select ativo from solicitacao where id = " + codigo;
        try {
            ResultSet rs = DAOconf.Consulta(delete);
            rs.next();
            if (rs.getBoolean(1) == true) {
                String update = "update solicitacao set ativo = false where id=" + codigo;
                DAOconf.execute(update);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean atualizar(long codigo, Solicitacao t) {
        String insert = "update solicitacao set"
                + " data=\'" + t.getData()+ "\',multa=" + t.getMulta() + ",valor_total="
                + t.getValor_total() + ",fk_fornecedor=" + t.getFk_fornecedor() + " where id = "+ codigo;
        try {
            DAOconf.execute(insert);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Solicitacao> listarTodos() {
        List<Solicitacao> cliente2 = new ArrayList<Solicitacao>();
        try {
            ResultSet rs = DAOconf.Consulta("Select * from solicitacao where ativo = true");
            while (rs.next()) {
                Solicitacao c = new Solicitacao(rs.getLong(1), rs.getDate(2), rs.getFloat(3), rs.getFloat(4), rs.getInt(5));
                c.setAtivo(rs.getBoolean(6));
                cliente2.add(c);
            }
            Collections.sort(cliente2);
            return cliente2;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
