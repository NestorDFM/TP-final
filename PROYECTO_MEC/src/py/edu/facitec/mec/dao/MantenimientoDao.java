/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.mec.dao;

import py.edu.facitec.mec.model.Mantenimiento;

/**
 *
 * @author User_2
 */
public interface MantenimientoDao {
    void insertar(Mantenimiento man);
    boolean modificar(Mantenimiento man);
    Mantenimiento consultar(int codigo);
    void eliminar(int codigo);
}
