/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidades.Produto;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface ProdutoDAO extends GenericDAO<Produto>{
    public Produto buscar(long codigo);    
}
