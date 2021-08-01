
package Controlador;

import DAO.CRUDproductos;
import Formatos.Seteo;
import Modelo.Producto;
import Principal.Main;
import Vista.frmRegProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionesFrmRegProducto implements ActionListener{
    frmRegProducto vista;

    public AccionesFrmRegProducto(frmRegProducto vista) {
        this.vista = vista;
        vista.jbtnGrabar.addActionListener(this);
    }
      
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.jbtnGrabar){
            Producto prod = new Producto();
            prod.setIdproducto(Integer.parseInt(vista.jtxtCodigo.getText()));
            prod.setNomprod(vista.jtxtNombre.getText());
            prod.setIdprov((Main.listaprov.RecuperarProveedor(vista.jcbProveedor.getSelectedIndex()).getIdproveedor()));
            prod.setIdcat((Main.listacat.RecuperarCategoria(vista.jcbxCategoria.getSelectedIndex()).getCodigo()));
            prod.setCantxunid(vista.jtxtCantidad.getText());
            prod.setPrecio(Double.parseDouble(vista.jtxtPrecio.getText()));
            prod.setUnidexis(Integer.parseInt(vista.jtxtExistencia.getText()));
            CRUDproductos crud = new CRUDproductos();
            crud.Create(prod);    
             LimpiarEntradas();
        } 
       
    }

    void LimpiarEntradas() {
  Seteo.Limpiar(vista.jtxtCodigo);
        Seteo.Limpiar(vista.jtxtNombre);
        Seteo.Limpiar(vista.jtxtCantidad);
        Seteo.Limpiar(vista.jtxtPrecio);
        Seteo.Limpiar(vista.jtxtExistencia);
        vista.jtxtCodigo.requestFocus();
    
    }
    
}
