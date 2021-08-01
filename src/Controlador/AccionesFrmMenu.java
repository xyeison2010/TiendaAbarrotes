
package Controlador;

import DAO.CargarDataEnCombo;
import DAO.ListarRegistros;
import Formatos.CentrarForma;
import Formatos.Seteo;
import Vista.frmMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Principal.*;
import Vista.*;

public class AccionesFrmMenu implements ActionListener {
     frmMenu vista;
     public AccionesFrmMenu(frmMenu v){
         vista=v;
         vista.menuRegProducto.addActionListener(this);
         vista.menuRegCat.addActionListener(this);
         vista.menuListaProducto.addActionListener(this);
         vista.menuListaCat.addActionListener(this);  // lista las categorias       
     }
    
    public void actionPerformed(ActionEvent e) {
        Seteo.Limpiar(vista.jpnlContenedor);
        if (e.getSource() == vista.menuRegProducto) {
            Main.rp = new frmRegProducto();
            vista.jpnlContenedor.add(Main.rp);
            Main.rp.setVisible(true);
            CentrarForma.CPanel(vista.jpnlContenedor,Main.rp);
            CargarDataEnCombo cdec = new CargarDataEnCombo();
            cdec.CargarCategorias(Main.rp.jcbxCategoria);
            cdec.CargarProveedor(Main.rp.jcbProveedor);
            AccionesFrmRegProducto afrp = new AccionesFrmRegProducto(Main.rp);
            
            
        }
        if (e.getSource() == vista.menuListaProducto) {
            Main.lp = new frmListaProductos();
            vista.jpnlContenedor.add(Main.lp);           
            Main.lp.setVisible(true);
            CentrarForma.CPanel(vista.jpnlContenedor,Main.lp);
            ListarRegistros lr = new ListarRegistros();
            lr.MostrarProductos(Main.lp.jtblListaProductos);
            AccionesFrmListaProductos aflp = new AccionesFrmListaProductos(Main.lp);
            
            
        }
        if (e.getSource() == vista.menuRegCat) {
            Main.rc = new frmRegCategorias();
            vista.jpnlContenedor.add(Main.rc);
            Main.rc.setVisible(true);
            CentrarForma.CPanel(vista.jpnlContenedor,Main.rc);
             AccionesFrmRegCategorias afrc = new AccionesFrmRegCategorias(Main.rc);
            
        }
        if (e.getSource() == vista.menuListaCat) {
            Main.lc = new frmListaCategorias();
            vista.jpnlContenedor.add(Main.lc);           
            Main.lc.setVisible(true);
            CentrarForma.CPanel(vista.jpnlContenedor,Main.lc);
            //cargando la informacion de las categorias a la tabla
            ListarRegistros lr = new ListarRegistros();
            lr.MostrarCategorias(Main.lc.jtblDatosCategorias);
            AccionesFrmListaCategorias afc = new AccionesFrmListaCategorias(Principal.Main.lc);
           
        }
    }
    
}
