package Controlador;

import DAO.CRUDcategorias;
import DAO.ListarRegistros;
import Formatos.CentrarForma;
import Formatos.Mensajes;
import Modelo.Categoria;
import Principal.Main;
import Vista.frmListaCategorias;
import Vista.frmVerCategoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class AccionesFrmListaCategorias implements ActionListener, MouseListener {

    frmListaCategorias vista;

    public AccionesFrmListaCategorias(frmListaCategorias vista) {
        this.vista = vista;
        this.vista.jtblDatosCategorias.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.jtblDatosCategorias) {
            //recuperamos la informacion de fila y columna
            int column = vista.jtblDatosCategorias.getColumnModel().getColumnIndexAtX(e.getX());
            int row = e.getY() / vista.jtblDatosCategorias.getRowHeight();
            //verificamos si la fila y columna es una celda valida
            if (row < vista.jtblDatosCategorias.getRowCount() && row >= 0
                    && column < vista.jtblDatosCategorias.getColumnCount() && column >= 0) {
                //recuperamos el codigo del estudiante de la fila seleccionada 
                int codcat = Integer.parseInt(vista.jtblDatosCategorias.getValueAt(row, 1).toString());
                //recuperamos el objeto de la celda que esta en la fila y columna
                Object value = vista.jtblDatosCategorias.getValueAt(row, column);
                if (value instanceof JButton) {
                    JButton boton = (JButton) value;
                    if (boton.getName().equals("ver")) {
                        VerFormularios();
                        //llamada al crud
                        CRUDcategorias crud = new CRUDcategorias();
                        Categoria cat = crud.Read(codcat);
                        Main.fvc.jtxtCodigo.setText(Integer.toString(cat.getCodigo()));
                        Main.fvc.jtxtNombre.setText(cat.getNombre());
                        Main.fvc.jtxaDescripcion.setText(cat.getDescr());
                        NoEditable();
                    }
                    if (boton.getName().equals("actualizar")) {
                        VerFormularios();
                        Main.fvc.jtxtCodigo.setEditable(false);
                        CRUDcategorias crud = new CRUDcategorias();
                        Categoria cat = crud.Read(codcat);
         
                        Main.fvc.jtxtCodigo.setText(Integer.toString(cat.getCodigo()));
                        Main.fvc.jtxtNombre.setText(cat.getNombre());
                        Main.fvc.jtxaDescripcion.setText(cat.getDescr());///

                    }
                    if (boton.getName().equals("eliminar")) {
                        int input = JOptionPane.showConfirmDialog(null, "Desea Eliminar el registro?", "Mensaje del Sistema",
                                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                        if (input == 0) { //si                           
                            CRUDcategorias crud = new CRUDcategorias();
                            crud.Delete(codcat);
                            ListarRegistros lr = new ListarRegistros();
                            lr.MostrarCategorias(Main.lc.jtblDatosCategorias);
                        }
                    }
                }

            }

        }

    }

    void VerFormularios() {
        Main.fvc = new frmVerCategoria();
        Main.fvc.setVisible(true);
        CentrarForma.CPanel(Main.m.jpnlContenedor, Main.fvc);
        Main.m.jpnlContenedor.repaint();
        Main.m.jpnlContenedor.add(Main.fvc);
        Main.lc.setVisible(false);
        AccionesVerCategoria avc = new AccionesVerCategoria(Main.fvc);
    }

    void NoEditable() {
        Main.fvc.jtxtCodigo.setEditable(false);
        Main.fvc.jtxtNombre.setEditable(false);
        Main.fvc.jtxaDescripcion.setEditable(false);
        Main.fvc.jbtnActualizar.setEnabled(false);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
