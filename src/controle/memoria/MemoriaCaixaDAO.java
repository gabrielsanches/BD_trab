/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.memoria;

import conexão.DAOconf;
import controle.CaixaDAO;
import entidades.Caixa;
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
class MemoriaCaixaDAO implements CaixaDAO {

    @Override
    public boolean inserir(Caixa caixa) {
        String insert = "INSERT INTO caixa (saldo_final,data_f,saldo_inicial,saldo_aplicado,data)"
                + " VALUES (" + caixa.getSaldo_final() + ",'"
                + caixa.getData_f() + "'," + caixa.getSaldo_incial() + "," + caixa.getSaldo_aplicado() + ",'" + caixa.getData() + "')";
        try {
            DAOconf.execute(insert);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return false;
    }

    @Override
    public Caixa buscar(long codigo) {
        String consulta = "select * from caixa where id = "+ codigo;
        try {
            ResultSet rs = DAOconf.Consulta(consulta);
            rs.next();
            Caixa c = new Caixa(rs.getLong(1), rs.getFloat(2), rs.getDate(3), rs.getFloat(4), rs.getFloat(5), rs.getDate(6));
            c.setAtivo(rs.getBoolean(7));
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Caixa> listarTodos() {
        List<Caixa> caixa1 = new ArrayList<Caixa>();
        try {
            ResultSet rs = DAOconf.Consulta("Select * from caixa where ativo = true");
            while (rs.next()) {
                Caixa c = new Caixa(rs.getLong(1), rs.getFloat(2), rs.getDate(3), rs.getFloat(4), rs.getFloat(5), rs.getDate(6));
                c.setAtivo(rs.getBoolean(7));
                caixa1.add(c);
            }
            Collections.sort(caixa1);
            return caixa1;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean remover(long codigo) {
        String delete = "Select ativo from caixa where id = " + codigo;
        try {
            ResultSet rs = DAOconf.Consulta(delete);
            rs.next();
            if (rs.getBoolean(1) == true){
                String update = "update caixa set ativo = false where id="+codigo;
                DAOconf.execute(update);
                return true;
            }            
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean atualizar(long codigo, Caixa t) {
//        String update = "update caixa set "
//                + "id = " + t.getId() + ", saldo_final = " + t.getSaldo_final() + ",data_f='"
//                + t.getData_f() + "',saldo_inicial=" + t.getSaldo_incial() + 
//                ",saldo_aplicado=" + t.getSaldo_aplicado() + ",data = '" + t.getData()+ "\' where id = "+ codigo;
        String update = "update caixa set "
                 + " saldo_final = " + t.getSaldo_final() + ",data_f='"
                + t.getData_f() + "',saldo_inicial=" + t.getSaldo_incial() + 
                ",saldo_aplicado=" + t.getSaldo_aplicado() + ",data = '" + t.getData()+ "\' where id = "+ codigo;
        try {
            DAOconf.execute(update);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MemoriaCaixaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

}
