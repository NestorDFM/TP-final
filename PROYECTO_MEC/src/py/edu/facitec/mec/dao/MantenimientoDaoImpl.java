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
import py.edu.facitec.mec.util.ConexionManager;

/**
 *
 * @author User_2
 */
public class MantenimientoDaoImpl implements MantenimientoDao{

    @Override
    public void insertar(Mantenimiento man) {
        String sql="insert into mantenimiento( fecha, cliente_codigo, condicion, importe_total, observacion, situacion)"
                + "values ('"+man.getFecha()+"', "+man.getClienteCodigo()+", '"+man.getCondicion()+"', "+man.getImporteTotal()+", "
                + " '"+man.getObservacion()+"', '"+man.getSituacion()+"' )";
        ConexionManager.conectar();
        
        try {
            ConexionManager.stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MantenimientoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConexionManager.desconectar();
        
    }

    @Override
    public boolean modificar(Mantenimiento man) {
        
       String sql="Update mantenimiento set fecha='"+man.getFecha()+"', cliente_codigo="+man.getClienteCodigo()+", condicion='"+man.getCondicion()+"', "
               + " importe_total="+man.getImporteTotal()+", '"+man.getObservacion()+"', '"+man.getSituacion()+"' where codigo="+man.getCodigo()+"";
              
       
      
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
    public Mantenimiento consultar(int codigo) {
        String sql="select fecha, cliente_codigo, condicion, importe_total, observacion, situacion from mantenimiento where codigo = "+codigo+" ";
        
        Mantenimiento man= null;
        
        ConexionManager.conectar();
        
        try {
            ResultSet rs = ConexionManager.stm.executeQuery(sql);
            
            if(rs.next()){//si tuvo resultado el sql
                man= new Mantenimiento();
                man.setFecha(rs.getString("fecha"));
                man.setClienteCodigo(rs.getInt("cliente_codigo"));
                man.setCondicion(rs.getString("condicion"));
                man.setImporteTotal(rs.getDouble("importe_total"));
                man.setObservacion(rs.getString("observacion"));
                man.setSituacion(rs.getString("situacion"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConexionManager.desconectar();
        
        return man;
    }

    @Override
    public void eliminar(int codigo) {
         String sql ="Delete from mantenimiento where codigo="+codigo+" ";
        
        ConexionManager.conectar();
        
        try {
            ConexionManager.stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConexionManager.desconectar();
    }
    
}
