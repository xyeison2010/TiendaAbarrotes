
package DAO;

import Formatos.Mensajes;
import Modelo.Producto;
import java.sql.*;


public class CRUDproductos implements ImplementarCrudProd {
    Connection conex;
    Statement st;
    ResultSet rs;
    ConectarBD c;
    public CRUDproductos(){
        c = new ConectarBD();
        conex = c.cn;
    }   
    
    @Override
    public void Create(Producto p) {
        
        try{
            st = conex.createStatement();
            rs =  st.executeQuery("insert into productos(idproducto,nombreProducto,idProveedor,idCategoria,cantidadPorUnidad,precioUnidad,\n"
                    + " unidadesEnExistencia) values("+p.getIdproducto()+",'"+p.getNomprod()+"',"+p.getIdprov()+","+p.getIdcat()+",'"+p.getCantxunid()+"',"+p.getPrecio()+","+p.getUnidexis()+")"
                            + "update productos set indicador ='S' where idproducto ="+p.getIdproducto()+" ");     
             
        }catch(Exception e){
            Mensajes.MD("Datos guardados Correctamente!!!" + e);
        }
       
       
    }

    @Override
    public Producto Read(int codprod) {
  Producto p = new Producto();
        try{
            st = conex.createStatement();
       rs = st.executeQuery("select p.idproducto,p.nombreProducto,p.cantidadPorUnidad,p.precioUnidad,p.unidadesEnExistencia,p.idCategoria,\n" +
" p.idProveedor from productos p,proveedores pr,categorias c where p.idProveedor = pr.idProveedor\n" +
" and p.idCategoria = c.idcategoria and idproducto="+codprod+"");
            rs.next();
            p.setIdproducto(rs.getInt(1));
           p.setNomprod(rs.getString(2));
           p.setCantxunid(rs.getString(3));
            p.setPrecio(rs.getDouble(4));
            p.setUnidexis(rs.getInt(5));//HACER CON EL SET NOMBRE COMPAÑIA 
           p.setIdcat(rs.getInt(6));               //  p.setIdcat(rs.getInt(6));
            p.setIdprov(rs.getInt(7));           // p.setIdprov(rs.getInt(7));
        }catch (Exception ex) {
            Mensajes.MD("Error no se recupera datos!!"+ex);
        }
       
        return p;
         }

    @Override
    public void Update(Producto p) {
       try{
            st = conex.createStatement();
            rs = st.executeQuery("update productos set nombreProducto='"+p.getNomprod()+"',cantidadPorUnidad='"+p.getCantxunid()+
      "',precioUnidad="+p.getPrecio() 
                    +",unidadesEnExistencia="+p.getUnidexis()+",idCategoria="+p.getIdcat()+",idProveedor="+p.getIdprov()+" "
         + " where idproducto="+p.getIdproducto()+"");           
        }catch(Exception e){
            Mensajes.MD("Datos actualizados correctamente!!");
        }
    }

    @Override
    public void Delete(int codprod) {
     try{
            st = conex.createStatement();
            rs = st.executeQuery("update productos set indicador = 'N' where idproducto="+codprod+"");
        
        }catch(Exception e){
               Mensajes.MD("Dato eliminado correctamente");  
    }  
    }
    
}
