/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidades.Par_despesa;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface Par_despesaDAO extends GenericDAO<Par_despesa>{
    public Par_despesa buscar(long codigo);
}
