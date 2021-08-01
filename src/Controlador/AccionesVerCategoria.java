/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.CRUDcategorias;
import DAO.ListarRegistros;
import Formatos.CentrarForma;
import Modelo.Categoria;
import Principal.Main;
import Vista.frmVerCategoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author secacad-sistemas
 */
public class AccionesVerCategoria implements ActionListener {

    frmVerCategoria vista;

    public AccionesVerCategoria(frmVerCategoria vista) {
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
            Categoria cat = new Categoria();
            cat.setCodigo(Integer.parseInt(vista.jtxtCodigo.getText()));
            cat.setNombre(vista.jtxtNombre.getText());
            cat.setDescr(vista.jtxaDescripcion.getText());
            //llamada al crud para actualizar
            CRUDcategorias crud = new CRUDcategorias();
            crud.Update(cat);
            //cargando la informacion de las categorias a la tabla
            ListarRegistros lr = new ListarRegistros();
            lr.MostrarCategorias(Main.lc.jtblDatosCategorias);
            CambioVistas();
        }
    }

    void CambioVistas() {
        Principal.Main.fvc.setVisible(false);
        CentrarForma.CPanel(Principal.Main.m.jpnlContenedor, Principal.Main.lc);
        Principal.Main.m.jpnlContenedor.repaint();
        Principal.Main.m.jpnlContenedor.add(Principal.Main.lc);
        Principal.Main.lc.setVisible(true);
    }

}
