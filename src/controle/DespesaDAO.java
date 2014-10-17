/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidades.Despesa;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface DespesaDAO extends GenericDAO<Despesa>{
    public Despesa buscar(long codigo);
}
