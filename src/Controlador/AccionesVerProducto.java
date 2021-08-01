
package Controlador;

import DAO.CRUDproductos;
import DAO.ListarRegistros;
import Formatos.CentrarForma;
import Modelo.Producto;
import Principal.Main;
import Vista.frmVerProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AccionesVerProducto  implements ActionListener{

    frmVerProducto vista;
    
    public AccionesVerProducto(frmVerProducto vista) {
        this.vista = vista;
        vista.jbtnCerrar.addActionListener(this);
        vista.jbtnActualizar.addActionListener(this);
          
    }

    public void actionPerformed(ActionEvent e) {

     if (e.getSource() == vista.jbtnCerrar) {
            CambioVistas();
        }
        if (e.getSource() == vista.jbtnActualizar) {
            //creamos el objeto categoria
            Producto p = new Producto();
            p.setIdproducto(Integer.parseInt(vista.jtxtCodigo.getText()));
            p.setNomprod(vista.jtxtNombre.getText());
            p.setIdcat(Integer.parseInt(vista.jtxtCategoria.getText()));//AA
            p.setIdprov(Integer.parseInt(vista.jtxtProveedor.getText()));//AA
            p.setCantxunid(vista.jtxtCantidad.getText());
            p.setPrecio(Double.parseDouble(vista.jtxtPrecio.getText()));
            p.setUnidexis(Integer.parseInt(vista.jtxtExistencia.getText()));
            //llamada al crud para actualizar
            CRUDproductos crud = new CRUDproductos();
            crud.Update(p);
            //cargando la informacion de las categorias a la tabla
            ListarRegistros lr = new ListarRegistros();
            lr.MostrarProductos(Main.lp.jtblListaProductos);
            CambioVistas();
        }   
  }

  void CambioVistas() {
        Principal.Main.fvp.setVisible(false);
        CentrarForma.CPanel(Principal.Main.m.jpnlContenedor, Principal.Main.lp);
        Principal.Main.m.jpnlContenedor.repaint();
        Principal.Main.m.jpnlContenedor.add(Principal.Main.lp);
        Principal.Main.lp.setVisible(true);    }
    
}
