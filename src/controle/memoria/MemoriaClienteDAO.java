/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.memoria;

import conexão.DAOconf;
import controle.ClienteDAO;
import entidades.Caixa;
import entidades.Cliente;
import java.sql.PreparedStatement;
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
public class MemoriaClienteDAO implements ClienteDAO {

    @Override
    public boolean inserir(Cliente cliente) {
        String insert = "INSERT INTO cliente (nome,sobrenome,data_nasc,e_mail,telefone,rua,bairro,numero,complemento,cidade,rg,cpf,uf)"
                + " VALUES (\'" + cliente.getNome() + "\',\'" + cliente.getSobrenome() + "\',\'"
                + cliente.getData_nasc() + "\',\'" + cliente.getEmail() + "\',\'" + cliente.getTelefone() + "\',\'" + cliente.getRua() + "\',\'"
                + cliente.getBairro() + "\'," + cliente.getNumero() + ",\'" + cliente.getComplemento() + "\',\'"
                + cliente.getCidade() + "\',\'" + cliente.getRg() + "\',\'" + cliente.getCpf() + "\',\'" + cliente.getUf() + "\')";
        try {
            DAOconf.execute(insert);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Cliente buscar(long codigo) {
        String consulta = "select * from cliente where id = " + codigo;
        try {
            ResultSet rs = DAOconf.Consulta(consulta);
            rs.next();
            Cliente c = new Cliente(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
            c.setAtivo(rs.getBoolean(15));
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Cliente> listarTodos() {
        List<Cliente> cliente2 = new ArrayList<Cliente>();
        try {
            ResultSet rs = DAOconf.Consulta("Select * from cliente where ativo = true");
            while (rs.next()) {
            Cliente c = new Cliente(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14));
            c.setAtivo(rs.getBoolean(15));
                cliente2.add(c);
            }
            Collections.sort(cliente2);
            return cliente2;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean remover(long codigo) {
        String delete = "Select ativo from cliente where id = " + codigo;
        try {
            ResultSet rs = DAOconf.Consulta(delete);
            rs.next();
            if (rs.getBoolean(1) == true) {
                String update = "update cliente set ativo=false where id=" + codigo;
                DAOconf.execute(update);
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean atualizar(long codigo, Cliente cliente) {
        String update = "update cliente set"
                + " nome=\'" + cliente.getNome() + "\',sobrenome=\'" + cliente.getSobrenome() + "\',data_nasc=\'"
                + cliente.getData_nasc() + "\',e_mail=\'" + cliente.getEmail() + "\',telefone=\'" + cliente.getTelefone() + "\',rua=\'" + cliente.getRua() + "\',bairro=\'"
                + cliente.getBairro() + "\',numero=" + cliente.getNumero() + ",complemento=\'" + cliente.getComplemento() + "\',cidade=\'"
                + cliente.getCidade() + "\',rg=\'" + cliente.getRg() + "\',cpf=\'" + cliente.getCpf() + "\',uf=\'" + cliente.getUf() + "\' where id = "+ codigo;
        try {
            DAOconf.execute(update);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
