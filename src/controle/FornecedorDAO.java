/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidades.Fornecedor;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface FornecedorDAO extends GenericDAO<Fornecedor>{
    public Fornecedor buscar(long codigo);      
}
