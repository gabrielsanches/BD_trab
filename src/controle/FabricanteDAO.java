/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidades.Fabricante;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface FabricanteDAO extends GenericDAO<Fabricante>{
    public Fabricante buscar(long codigo);
}
