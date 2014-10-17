/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface GenericDAO<T> {
    public boolean inserir(T t);
    public boolean remover(long codigo);
    public boolean atualizar(long codigo,T t);
    public List<T> listarTodos();      
}
