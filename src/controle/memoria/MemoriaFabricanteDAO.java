/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.memoria;

import conexão.DAOconf;
import controle.FabricanteDAO;
import entidades.Fabricante;
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
class MemoriaFabricanteDAO implements FabricanteDAO {

    @Override
    public boolean inserir(Fabricante fabricante) {
        String insert = "INSERT INTO fabricante (nome,telefone,e_mail)"
                + " VALUES (\'" + fabricante.getNome() + "\',\'" + fabricante.getTelefone()+ "\',\'"
                + fabricante.getEmail() + "\')";
        try {
            DAOconf.execute(insert);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Fabricante buscar(long codigo) {
        String consulta = "select * from fabricante where id = " + codigo;
        try {
            ResultSet rs = DAOconf.Consulta(consulta);
            rs.next();
            Fabricante c = new Fabricante(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4));
            c.setAtivo(rs.getBoolean(5));
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Fabricante> listarTodos() {
        List<Fabricante> fabricante = new ArrayList<Fabricante>();
        try {
            ResultSet rs = DAOconf.Consulta("Select * from fabricante where ativo = true");
            while (rs.next()) {
                Fabricante c = new Fabricante(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4));
                c.setAtivo(rs.getBoolean(5));
                fabricante.add(c);
            }
            Collections.sort(fabricante);
            return fabricante;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean remover(long codigo) {
        String delete = "Select ativo from fabricante where id = " + codigo;
        try {
            ResultSet rs = DAOconf.Consulta(delete);
            rs.next();
            if (rs.getBoolean(1) == true) {
                String update = "update fabricante set ativo = false where id=" + codigo;
                DAOconf.execute(update);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean atualizar(long codigo, Fabricante t) {
                String insert = "update fabricante set"
                +  " nome=\'" + t.getNome() + "\',telefone=\'" + t.getTelefone()+ "\',e_mail=\'"
                + t.getEmail() + "\' where id = "+ codigo;
        try {
            DAOconf.execute(insert);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
