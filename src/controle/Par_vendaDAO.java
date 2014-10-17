/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidades.Par_venda;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface Par_vendaDAO extends GenericDAO<Par_venda>{
    public Par_venda buscar(long codigo);     
}
