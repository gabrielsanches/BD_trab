/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.memoria;

import conexão.DAOconf;
import controle.VendasDAO;
import entidades.Vendas;
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
class MemoriaVendasDAO implements VendasDAO {

    List<Vendas> vendas;

    public MemoriaVendasDAO() {
        vendas = new ArrayList<Vendas>();
    }

    @Override
    public Vendas buscar(long codigo) {
        String consulta = "select * from venda where id = " + codigo;
        try {
            ResultSet rs = DAOconf.Consulta(consulta);
            rs.next();
            Vendas c = new Vendas(rs.getLong(1), rs.getString(2), rs.getDate(3), rs.getFloat(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
            c.setAtivo(rs.getBoolean(8));
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean inserir(Vendas t) {
        String insert = "INSERT INTO venda (forma,data,multa,n_parcela,valor_total, fk_cliente)"
                + " VALUES (\'" + t.getForma() + "\',\'" + t.getData() + "\',"
                + t.getMulta() + "," + t.getN_parcela() + "," + t.getValor_total() + "," + t.getFk_cliente() + ")";
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
        String delete = "Select ativo from venda where id = " + codigo;
        try {
            ResultSet rs = DAOconf.Consulta(delete);
            rs.next();
            if (rs.getBoolean(1) == true) {
                String update = "update venda set ativo = false where id=" + codigo;
                DAOconf.execute(update);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean atualizar(long codigo, Vendas t) {
        String insert = "update venda set"
                + " forma=\'" + t.getForma() + "\',data=\'" + t.getData() + "\',multa="
                + t.getMulta() + ",n_parcela=" + t.getN_parcela() + ",valor_total=" 
                + t.getValor_total() + ",fk_cliente=" + t.getFk_cliente() + " where id = "+ codigo;
        try {
            DAOconf.execute(insert);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Vendas> listarTodos() {
        List<Vendas> cliente2 = new ArrayList<Vendas>();
        try {
            ResultSet rs = DAOconf.Consulta("Select * from venda where ativo = true");
            while (rs.next()) {
                Vendas c = new Vendas(rs.getLong(1), rs.getString(2), rs.getDate(3), rs.getFloat(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                c.setAtivo(rs.getBoolean(8));
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
