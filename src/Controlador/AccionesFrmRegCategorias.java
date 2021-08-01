
package Controlador;

import DAO.CRUDcategorias;
import Formatos.Seteo;
import Modelo.Categoria;
import Vista.frmRegCategorias;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionesFrmRegCategorias implements ActionListener {
    frmRegCategorias vista;

    public AccionesFrmRegCategorias(frmRegCategorias vista) {
        this.vista = vista;
        this.vista.jbtnGrabar.addActionListener(this);
    }     
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()== vista.jbtnGrabar){
           //lectura de datos
             Categoria cat = new Categoria();
           cat.setCodigo(Integer.parseInt(vista.jtxtCodigo.getText()));
           cat.setNombre(vista.jtxtNombre.getText()); 
           cat.setDescr(vista.jtxaDescripcion.getText());
           //creamos el objeto
         
           //lo insertamos en la BD
           CRUDcategorias cc = new CRUDcategorias();
           cc.Create(cat);
           LimpiarEntradas();
       }      
    }
    void LimpiarEntradas(){
        Seteo.Limpiar(vista.jtxtCodigo);
        Seteo.Limpiar(vista.jtxtNombre);
        Seteo.Limpiar(vista.jtxaDescripcion);
        vista.jtxtCodigo.requestFocus();
    }
    
}
