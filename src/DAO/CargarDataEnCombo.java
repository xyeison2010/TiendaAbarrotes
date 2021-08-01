package DAO;

import Formatos.Mensajes;
import Modelo.Categoria;
import Modelo.ListaCategorias;
import Modelo.ListaProveedores;
import Modelo.Proveedor;
import Principal.Main;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;


public class CargarDataEnCombo {
    Connection conex;
    Statement st;
    ResultSet rs;
    ConectarBD c;
    public CargarDataEnCombo(){
        c = new ConectarBD();
        conex = c.cn;
    }
    
    public void CargarCategorias(JComboBox jcbx){
        DefaultComboBoxModel mc = new DefaultComboBoxModel();
        jcbx.setModel(mc);
        try{
            st = conex.createStatement();
            rs = st.executeQuery("select  idcategoria,nombrecategoria from categorias order by 1");
            Main.listacat = new ListaCategorias();
            while(rs.next()){
                 Categoria cat = new Categoria();
                 cat.setCodigo(rs.getInt(1));
                 cat.setNombre(rs.getString(2));
                 Main.listacat.AgregarCategoria(cat);
                 mc.addElement(cat.getNombre()); //sirve para decir quien quiere q se agrege                
            }            
        }catch(Exception e){
            Mensajes.MD("Error no se puede cargar categorias "+e);
        }      
    }
    //ESTE GUIARME PARECE
    public void CargarProveedor(JComboBox jcbx){
        DefaultComboBoxModel mc = new DefaultComboBoxModel();
        jcbx.setModel(mc);
        try{
            st = conex.createStatement();
            rs = st.executeQuery("select idProveedor,nombreCompañia from proveedores order by 2");
            Main.listaprov = new ListaProveedores();
            while(rs.next()){
                 Proveedor prov = new Proveedor();
                 prov.setIdproveedor(rs.getInt(1));
                 prov.setNomprov(rs.getString(2));
                 Main.listaprov.AgregarProveedor(prov);
                 mc.addElement(prov.getNomprov());                
            }            
        }catch(Exception e){
            Mensajes.MD("Error no se puede cargar categorias "+e);
        }      
    }
    
    
    
    
    
    
    
    
}
