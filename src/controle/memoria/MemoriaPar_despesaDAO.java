/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.memoria;

import conexão.DAOconf;
import controle.Par_despesaDAO;
import entidades.Par_despesa;
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
class MemoriaPar_despesaDAO implements Par_despesaDAO {

    @Override
    public Par_despesa buscar(long codigo) {
        String consulta = "select * from par_despesa where id = " + codigo;
        try {
            ResultSet rs = DAOconf.Consulta(consulta);
            rs.next();
            Par_despesa c = new Par_despesa(rs.getLong(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getString(5), rs.getFloat(6), rs.getInt(7));
            c.setAtivo(rs.getBoolean(8));
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean inserir(Par_despesa t) {
        String insert = "Insert into par_despesa (data_venc,data_pag,n_parcela,status,valor_parce,fk_despesa)"
                + " VALUES (\'" + t.getData_venc() + "\',\'" + t.getData_pag() + "\',"
                + t.getN_parcela() + ",\'" + t.getStatus() + "\'," + t.getValor_parce() + ","
                + t.getFk_despesa() + ")";
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
        String delete = "Select ativo from par_despesa where id = " + codigo;
        try {
            ResultSet rs = DAOconf.Consulta(delete);
            rs.next();
            if (rs.getBoolean(1) == true) {
                String update = "update par_despesa set ativo = false where id=" + codigo;
                DAOconf.execute(update);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean atualizar(long codigo, Par_despesa t) {
        String insert = "update par_despesa set"
                + " data_venc=\'" + t.getData_venc() + "\',data_pag=\'" + t.getData_pag() + "\',n_parcela="
                + t.getN_parcela() + ",status=\'" + t.getStatus() + "\',valor_parce=" + t.getValor_parce() + ",fk_despesa="
                + t.getFk_despesa() + " where id = "+ codigo;
        try {
            DAOconf.execute(insert);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Par_despesa> listarTodos() {
        List<Par_despesa> produto2 = new ArrayList<Par_despesa>();
        try {
            ResultSet rs = DAOconf.Consulta("Select * from par_despesa where ativo = true");
            while (rs.next()) {
                Par_despesa c = new Par_despesa(rs.getLong(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getString(5), rs.getFloat(6), rs.getInt(7));
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
