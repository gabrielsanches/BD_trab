/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexão;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.util.PSQLException;

/**
 *
 * @author Gabriel
 */
public class DAOconf {

    public static Connection Conexao = null;
    public static Statement Comando = null;
    public static PreparedStatement SQL = null;

    public static boolean Conecta() {
        try {
            Class.forName("org.postgresql.Driver");
            Conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BD_trab", "postgres", "postgres");
            Comando = Conexao.createStatement();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DAOconf.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static ResultSet Consulta(String Consulta) throws SQLException {
        if (Comando.execute("select 1")) {
            try {
                return Comando.executeQuery(Consulta);
            } catch (PSQLException ex) {
                Logger.getLogger(DAOconf.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Erro conect BD_trab.");
        }
        return null;
    }
    
    public static boolean execute(String Consulta) throws SQLException {
        if (Comando.execute("select 1")) {
            try {
                return Comando.execute(Consulta);
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        } else {
            System.out.println("Erro conect BD_trab.");
            return false;
        }
        
    }    

    public static void Close() {
        try {
            if (!Conexao.isClosed()) {
                Conexao.close();
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
