/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.memoria;

import conexão.DAOconf;
import controle.FornecedorDAO;
import entidades.Cliente;
import entidades.Fornecedor;
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
class MemoriaFornecedorDAO implements FornecedorDAO {

    @Override
    public Fornecedor buscar(long codigo) {
        String consulta = "select * from fornecedor where id = " + codigo;
        try {
            ResultSet rs = DAOconf.Consulta(consulta);
            rs.next();
            Fornecedor c = new Fornecedor(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
            c.setAtivo(rs.getBoolean(9));
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean inserir(Fornecedor t) {
        String insert = "INSERT INTO fornecedor (nome,sobrenome,telefone,e_mail,cpf,rg,fk_fabricante)"
                + " VALUES (\'" + t.getNome() + "\',\'" + t.getSobrenome() + "\',\'"
                + t.getTelefone() + "\',\'" + t.getEmail() + "\'," + t.getCpf() + "," + t.getRg() + ","
                + t.getFk_fabricante()+ ")";
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
        String delete = "Select ativo from fornecedor where id = " + codigo;
        try {
            ResultSet rs = DAOconf.Consulta(delete);
            rs.next();
            if (rs.getBoolean(1) == true) {
                String update = "update fornecedor set ativo = false where id=" + codigo;
                DAOconf.execute(update);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean atualizar(long codigo, Fornecedor t) {
        String update = "update fornecedor set"
                + " nome=\'" + t.getNome() + "\',sobrenome=\'" + t.getSobrenome() + "\',telefone=\'"
                + t.getTelefone() + "\',e_mail=\'" + t.getEmail() + "\',cpf=\'" + t.getCpf() + "\',rg=\'"
                + t.getRg() + "\',fk_fabricante="+ t.getFk_fabricante()+ " where id = "+ codigo;
        try {
            DAOconf.execute(update);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public List<Fornecedor> listarTodos() {
        List<Fornecedor> fornecedor = new ArrayList<Fornecedor>();
        try {
            ResultSet rs = DAOconf.Consulta("Select * from fornecedor where ativo = true");
            while (rs.next()) {
                Fornecedor c = new Fornecedor(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                c.setAtivo(rs.getBoolean(9));
                fornecedor.add(c);
            }
            Collections.sort(fornecedor);
            return fornecedor;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
}
