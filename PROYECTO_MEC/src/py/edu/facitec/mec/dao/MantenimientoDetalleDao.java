/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.mec.dao;

import py.edu.facitec.mec.model.Mantenimiento;
import py.edu.facitec.mec.model.MantenimientoDetalle;

/**
 *
 * @author User
 */
public interface MantenimientoDetalleDao {
    void insertar(MantenimientoDetalle mand);
    boolean modificar(MantenimientoDetalle mand);
    MantenimientoDetalle consultar(int codigo);
    void eliminar(int codigo);
}
