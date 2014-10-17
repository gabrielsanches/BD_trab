/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.memoria;

import conexão.DAOconf;
import controle.DespesaDAO;
import entidades.Despesa;
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
class MemoriaDespesaDAO implements DespesaDAO {

    @Override
    public Despesa buscar(long codigo) {
        String consulta = "select * from despesas where id = " + codigo;
        try {
            ResultSet rs = DAOconf.Consulta(consulta);
            rs.next();
            Despesa c = new Despesa(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getBoolean(5), rs.getString(6), rs.getDate(7), rs.getDate(8), rs.getFloat(9), rs.getInt(10));
            c.setAtivo(rs.getBoolean(11));
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean inserir(Despesa t) {
        String insert = "INSERT INTO despesas (descricao,multa,taxas,fixa,forma,data_venc,data_pagamento,valor_pagar,n_parcelas)"
                + " VALUES (\'" + t.getDescricao() + "\'," + t.getMulta() + ","
                + t.getTaxas() + "," + t.isFixa() + ",\'" + t.getForma() + "\',\'" 
                + t.getData_venc() + "\',\'" + t.getData_pagamento() + "\',"+t.getValor_pagar() + ","+t.getN_parcelas() +")";
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
        String delete = "Select ativo from despesas where id = " + codigo;
        try {
            ResultSet rs = DAOconf.Consulta(delete);
            rs.next();
            if (rs.getBoolean(1) == true) {
                String update = "update despesas set ativo = false where id=" + codigo;
                DAOconf.execute(update);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean atualizar(long codigo, Despesa t) {
        String insert = "update despesas set"
                +  " descricao=\'" + t.getDescricao() + "\',multa=" + t.getMulta() + ",taxas="
                + t.getTaxas() + ",fixa=" + t.isFixa() + ",forma=\'" + t.getForma() + "\',data_venc=\'" 
                + t.getData_venc() + "\',data_pagamento=\'" + t.getData_pagamento() + "\',valor_pagar="+t.getValor_pagar() + ",n_parcelas="+t.getN_parcelas() +" where id = "+ codigo;
        try {
            DAOconf.execute(insert);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Despesa> listarTodos() {
        List<Despesa> produto2 = new ArrayList<Despesa>();
        try {
            ResultSet rs = DAOconf.Consulta("Select * from despesas where ativo = true");
            while (rs.next()) {
                Despesa c = new Despesa(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getFloat(4), rs.getBoolean(5), rs.getString(6), rs.getDate(7), rs.getDate(8), rs.getFloat(9), rs.getInt(10));
                c.setAtivo(rs.getBoolean(11));
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
