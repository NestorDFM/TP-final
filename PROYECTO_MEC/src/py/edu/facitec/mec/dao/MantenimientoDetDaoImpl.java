/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.mec.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import py.edu.facitec.mec.model.Mantenimiento;
import py.edu.facitec.mec.model.MantenimientoDetalle;
import py.edu.facitec.mec.util.ConexionManager;

/**
 *
 * @author User
 */
public class MantenimientoDetDaoImpl implements MantenimientoDetalleDao{

    @Override
    public void insertar(MantenimientoDetalle mand) {
        String sql="insert into mantenimiento_detalles(mantenimiento_codigo, servicio_codigo, cantidad, precio, subtotal )"
                + "values("+mand.getMantenimientoCodigo()+", "+mand.getServicioCodigo()+", "+mand.getCantidad()+","
                + " "+mand.getPrecio()+", "+mand.getSubtotal()+")";
               
        ConexionManager.conectar();
        
        try {
            ConexionManager.stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoDaoImpl.class.getName()).log(Level.SEVERE.SEVERE, null, ex);
        }
        
        ConexionManager.desconectar();
    }

    @Override
    public boolean modificar(MantenimientoDetalle mand) {
        String sql="Update mantenimiento_detalles set mantenimiento_codigo="+mand.getMantenimientoCodigo()+", servicio_codigo="+mand.getServicioCodigo()+", "
                + " cantidad="+mand.getCantidad()+", precio="+mand.getPrecio()+", subtotal="+mand.getSubtotal()+" "
                + "where codigo="+mand.getCodigo()+" ";
              
       
      
      boolean resultado=false;
      
      ConexionManager.conectar();
      
        try {
            resultado = ConexionManager.stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      ConexionManager.desconectar();
      
      return resultado;
    }

    @Override
    public MantenimientoDetalle consultar(int codigo) {
       String sql="select mantenimiento_codigo, servicio_codigo, cantidad, precio, subtotal from mantenimiento_detalles where codigo = "+codigo+" ";
        
        MantenimientoDetalle mand= null;
        
        ConexionManager.conectar();
        
        try {
            ResultSet rs = ConexionManager.stm.executeQuery(sql);
            
            if(rs.next()){//si tuvo resultado el sql
               mand = new MantenimientoDetalle();
               mand.setMantenimientoCodigo(rs.getInt("mantenimiento_codigo"));
               mand.setServicioCodigo(rs.getInt("servicio_codigo"));
               mand.setCantidad(rs.getDouble("cantidad"));
               mand.setPrecio(rs.getDouble("precio"));
               mand.setSubtotal(rs.getDouble("subtotal"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConexionManager.desconectar();
        
        return mand;
    }

    @Override
    public void eliminar(int codigo) {
        String sql ="Delete from mantenimiento_detalles where codigo="+codigo+" ";
        
        ConexionManager.conectar();
        
        try {
            ConexionManager.stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConexionManager.desconectar();
    }
    
}
