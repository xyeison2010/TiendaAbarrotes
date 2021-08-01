    
package DAO;
//librerias
import Formatos.Botones;
import Formatos.Encabezados;
import Formatos.ManejadorTablas;
import Formatos.Mensajes;
import Formatos.RenderTabla;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class ListarRegistros implements Encabezados {
    Connection conexion;
    Statement st;
    ResultSet rs;
    ConectarBD c;
    public ListarRegistros(){
        c = new ConectarBD(); // llamo al constructor para conectar a la BD
        conexion = c.cn;        
    }
    public void MostrarCategorias(JTable tabla){
        DefaultTableModel mt = ManejadorTablas.EsquemaTabla(tabla,enccat);
        ManejadorTablas.FormatoTablaCategorias(tabla);
        int num=0;
        Botones botones = new Botones();
        try{
            st = conexion.createStatement(); // crea espacio para realizar la consulta
            //ejecutamos la consulta
            rs = st.executeQuery("select idcategoria,nombrecategoria,descripcion from categorias where indicador='S'");
            //recorrer toda la consulta y mostrar los datos en la tabla
            while(rs.next()){
                num++;
                Object[] registro={num,rs.getInt(1),rs.getString(2),rs.getString(3),botones.Ver(),
                                  botones.Actualizar(),botones.Eliminar()};
                mt.addRow(registro);               
            }
        }catch(Exception e){
            Mensajes.MD("Error no se puede ejecutar la consulta "+e);
        }        
    } 
    
    
    public void MostrarProductos(JTable tabla){
        DefaultTableModel mt = ManejadorTablas.EsquemaTabla(tabla,encprod);
        ManejadorTablas.FormatoTablaProductos(tabla);
        int num=0;
        Botones botones = new Botones();
        try{
            st = conexion.createStatement(); // crea espacio para realizar la consulta
            //ejecutamos la consulta
            rs = st.executeQuery("select p.idproducto,p.nombreProducto,p.cantidadPorUnidad,p.precioUnidad,p.unidadesEnExistencia,c.nombrecategoria,\n"
                    + "   pr.nombreCompañia\n"
                    + " from productos p,proveedores pr,categorias c\n"
                    + " where p.idProveedor = pr.idProveedor and p.idCategoria = c.idcategoria "  
                    + "  and p.indicador='S' order by 5,2 ");
//select p.idproducto,p.nombreProducto,p.precioUnidad,p.unidadesEnExistencia,c.nombrecategoria,
 //pr.nombreCompañia from productos p,proveedores pr,categorias c where p.idProveedor = pr.idProveedor
 //and p.idCategoria = c.idcategoria order by 5,2

            //recorrer toda la consulta y mostrar los datos en la tabla
            while (rs.next()) {
                num++;
                Object[] registro={num,rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),
                                  rs.getString(6),rs.getString(7),botones.Ver(),
                                  botones.Actualizar(),botones.Eliminar()};
                mt.addRow(registro);               
            }
        }catch(Exception e){
            Mensajes.MD("Error no se puede ejecutar la consulta "+e);
        } 
    }
    
public void MostrarProductosFiltrados(JTable tabla,String criterio){
        DefaultTableModel mt = ManejadorTablas.EsquemaTabla(tabla,encprod);
        ManejadorTablas.FormatoTablaProductos(tabla);
        int num=0;
        Botones botones = new Botones();
        try{
            st = conexion.createStatement();            
            rs = st.executeQuery("select p.idproducto,p.nombreProducto,p.cantidadPorUnidad,p.precioUnidad,p.unidadesEnExistencia,c.nombrecategoria,\n"
                    + "   pr.nombreCompañia\n"
                    + "from productos p,proveedores pr,categorias c\n"
                    + "where p.idProveedor = pr.idProveedor and p.idCategoria = c.idcategoria \n"
                    + "     and p.nombreProducto like '%"+criterio+"%'\n" 
                    + "order by 5,2");
                      while (rs.next()) {
                num++;
                Object[] registro={num,rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),
                                  rs.getString(6),rs.getString(7),botones.Ver(),
                                  botones.Actualizar(),botones.Eliminar()};
                mt.addRow(registro);               
            }
        }catch(Exception e){
            Mensajes.MD("Error no se puede ejecutar la consulta "+e);
        } 
    }
public void MostrarProductosFiltradosporCodigo(JTable tabla,int criterio){
        DefaultTableModel mt = ManejadorTablas.EsquemaTabla(tabla,encprod);
        ManejadorTablas.FormatoTablaProductos(tabla);
        int num=0;
        Botones botones = new Botones();
        try{
            st = conexion.createStatement();            
            rs = st.executeQuery("select p.idproducto,p.nombreProducto,p.cantidadPorUnidad,p.precioUnidad,p.unidadesEnExistencia,c.nombrecategoria,\n"
                    + "   pr.nombreCompañia\n"
                    + "from productos p,proveedores pr,categorias c\n"
                    + "where p.idProveedor = pr.idProveedor and p.idCategoria = c.idcategoria \n"
                    + "     and p.idproducto="+criterio+" \n"
                    + "order by 5,2");
                      while (rs.next()) {
                num++;
                Object[] registro={num,rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),
                                  rs.getString(6),rs.getString(7),botones.Ver(),
                                  botones.Actualizar(),botones.Eliminar()};
                mt.addRow(registro);               
            }
        }catch(Exception e){
            Mensajes.MD("Error no se puede ejecutar la consulta "+e);
        } 
    }

public void MostrarProductosFiltradosporPrecio(JTable tabla,double criterio){
        DefaultTableModel mt = ManejadorTablas.EsquemaTabla(tabla,encprod);
        ManejadorTablas.FormatoTablaProductos(tabla);
        int num=0;
        Botones botones = new Botones();
        try{
            st = conexion.createStatement();            
            rs = st.executeQuery("select p.idproducto,p.nombreProducto,p.cantidadPorUnidad,p.precioUnidad,p.unidadesEnExistencia,c.nombrecategoria,\n"
                    + "   pr.nombreCompañia\n"
                    + "from productos p,proveedores pr,categorias c\n"
                    + "where p.idProveedor = pr.idProveedor and p.idCategoria = c.idcategoria \n"
                    + "     and p.precioUnidad="+criterio+" \n"
                    + "order by 5,2");
                      while (rs.next()) {
                num++;
                Object[] registro={num,rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),
                                  rs.getString(6),rs.getString(7),botones.Ver(),
                                  botones.Actualizar(),botones.Eliminar()};
                mt.addRow(registro);               
            }
        }catch(Exception e){
            Mensajes.MD("Error no se puede ejecutar la consulta "+e);
        } 
    }


}