package DAO;

import Formatos.Mensajes;
import Modelo.Categoria;
import java.sql.*;

/**
 * Por cada tabla debe de existir un clase CRUD C: create R: read U: update D:
 * delete
 */
public class CRUDcategorias implements ImplementarCrudCat {

    Connection conexion;
    Statement st;
    ResultSet rs;
    ConectarBD c;

    public CRUDcategorias() {
        c = new ConectarBD();
        conexion = c.cn;
    }

    @Override
    public void Create(Categoria cat) {
        try {
            st = conexion.createStatement();
            rs = st.executeQuery("insert into categorias(idcategoria,nombrecategoria,descripcion)"
                    + " values(" + cat.getCodigo() + ",'" + cat.getNombre() + "','" + cat.getDescr() + "') "
                            + "update categorias set indicador ='S'  where idcategoria="+cat.getCodigo()+" ");

        } catch (Exception ex) {
            Mensajes.MD("Datos registrados correctamente!!");
        }
    }

    @Override
    public Categoria Read(int codcat) {
        Categoria cat = new Categoria();
        try{
            st = conexion.createStatement();
            rs = st.executeQuery("select idcategoria,nombrecategoria,descripcion from categorias where idcategoria="+codcat+"");
            rs.next();
            cat.setCodigo(rs.getInt(1));
            cat.setNombre(rs.getString(2));
            cat.setDescr(rs.getString(3));
        }catch (Exception ex) {
            Mensajes.MD("Error no se recuperar datos!!"+ex);
        }
        return cat;
    }

    @Override
    public void Update(Categoria cat) {
        try{
            st = conexion.createStatement();
            rs = st.executeQuery("update categorias set nombrecategoria='"+cat.getNombre()+"',descripcion='"+cat.getDescr()+"'"
                    + "  where idcategoria="+cat.getCodigo()+"");           
        }catch(Exception e){
            Mensajes.MD("Datos actualizados correctamente!!");
        }
    }

    @Override
    public void Delete(int codcat) {
        try{
            st = conexion.createStatement();
            rs = st.executeQuery("update categorias set indicador = 'N' where idcategoria="+codcat+"");
        
        }catch(Exception e){
               Mensajes.MD("Dato eliminado correctamente");  
    }
    }
}
