package Controlador;



import DAO.CRUDproductos;
import DAO.ListarRegistros;
import Formatos.CentrarForma;
import Modelo.Producto; //
import Principal.Main;
import Vista.frmListaProductos;
import Vista.frmVerProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class AccionesFrmListaProductos implements ActionListener , MouseListener{
    frmListaProductos vista;

    public AccionesFrmListaProductos(frmListaProductos vista) {
        this.vista = vista;
        vista.jbtnBuscar.addActionListener(this);
        vista.jbtnTodos.addActionListener(this);
        this.vista.jtblListaProductos.addMouseListener(this);
    }    
     
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbtnBuscar) {
            
            if (vista.jcbxCriterio.getSelectedIndex() == 1) {
                String criterio = vista.jtxtTexto.getText();
                ListarRegistros lr = new ListarRegistros();
                lr.MostrarProductosFiltrados(vista.jtblListaProductos, criterio);
            }
            if(vista.jcbxCriterio.getSelectedIndex() == 0){
                int criterio = Integer.parseInt(vista.jtxtTexto.getText());
                ListarRegistros lr = new ListarRegistros();
                lr.MostrarProductosFiltradosporCodigo(vista.jtblListaProductos, criterio);
            }
            
             if(vista.jcbxCriterio.getSelectedIndex() == 2){
                double criterio = Double.parseDouble(vista.jtxtTexto.getText());
                ListarRegistros lr = new ListarRegistros();
                lr.MostrarProductosFiltradosporPrecio(vista.jtblListaProductos, criterio);
            }
        }
       if(e.getSource() == vista.jbtnTodos){
           ListarRegistros lr = new ListarRegistros();
           lr.MostrarProductos(vista.jtblListaProductos);
       }
    }
//
    @Override
    public void mouseClicked(MouseEvent e) {

if (e.getSource() == vista.jtblListaProductos) {
            //recuperamos la informacion de fila y columna
            int column = vista.jtblListaProductos.getColumnModel().getColumnIndexAtX(e.getX());
            int row = e.getY() / vista.jtblListaProductos.getRowHeight();
            //verificamos si la fila y columna es una celda valida
            if (row < vista.jtblListaProductos.getRowCount() && row >= 0
                    && column < vista.jtblListaProductos.getColumnCount() && column >= 0) { 
                //recuperamos el codigo del estudiante de la fila seleccionada 
                int codprod = Integer.parseInt(vista.jtblListaProductos.getValueAt(row, 1).toString());
                //recuperamos el objeto de la celda que esta en la fila y columna
                Object value = vista.jtblListaProductos.getValueAt(row, column);
                if (value instanceof JButton) {
                    JButton boton = (JButton) value;
                    if (boton.getName().equals("ver")) {
                        VerFormularios();
                        //llamada al crud
                        CRUDproductos crud = new CRUDproductos();
                        Producto p = crud.Read(codprod);
                        Principal.Main.fvp.jtxtCodigo.setText(Integer.toString(p.getIdproducto()));
                        Principal.Main.fvp.jtxtNombre.setText(p.getNomprod());
                        Principal.Main.fvp.jtxtCategoria.setText(Integer.toString(p.getIdcat()));
                        Principal.Main.fvp.jtxtProveedor.setText(Integer.toString(p.getIdprov()));
                        Principal.Main.fvp.jtxtCantidad.setText(p.getCantxunid());///AAAAAAAAA
                        Principal.Main.fvp.jtxtPrecio.setText(Double.toString(p.getPrecio()));
                        Principal.Main.fvp.jtxtExistencia.setText(Integer.toString(p.getUnidexis()));
                        NoEditable();
                    }
                    if (boton.getName().equals("actualizar")) {
                        VerFormularios();
                        Principal.Main.fvp.jtxtCodigo.setEditable(false);
                       CRUDproductos crud = new CRUDproductos();
                         Producto p = crud.Read(codprod);
                        Principal.Main.fvp.jtxtCodigo.setText(Integer.toString(p.getIdproducto()));
                        Principal.Main.fvp.jtxtNombre.setText(p.getNomprod());
                        Principal.Main.fvp.jtxtCategoria.setText(Integer.toString(p.getIdcat()));
                        Principal.Main.fvp.jtxtProveedor.setText(Integer.toString(p.getIdprov()));
                        Principal.Main.fvp.jtxtCantidad.setText((p.getCantxunid()));///AAAAAAAAA
                        Principal.Main.fvp.jtxtPrecio.setText(Double.toString(p.getPrecio()));
                        Principal.Main.fvp.jtxtExistencia.setText(Integer.toString(p.getUnidexis()));

                    }
                    if (boton.getName().equals("eliminar")) {
                        int input = JOptionPane.showConfirmDialog(null, "Desea Eliminar el registro?", "Mensaje del Sistema",
                                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                        if (input == 0) { //si                           
                            CRUDproductos crud = new CRUDproductos();
                            crud.Delete(codprod);
                            ListarRegistros lr = new ListarRegistros();
                            lr.MostrarProductos(Main.lp.jtblListaProductos);
                        }
                    }
                }

            }

        }

    }
void VerFormularios() {
       Principal.Main.fvp = new frmVerProducto();
        Principal.Main.fvp.setVisible(true);
        CentrarForma.CPanel(Principal.Main.m.jpnlContenedor, Principal.Main.fvp);
        Principal.Main.m.jpnlContenedor.repaint();
        Principal.Main.m.jpnlContenedor.add(Principal.Main.fvp);
        Principal.Main.lp.setVisible(false);
        AccionesVerProducto avp = new AccionesVerProducto(Principal.Main.fvp);
     
     }

   void NoEditable() {
       Principal.Main.fvp.jtxtCodigo.setEditable(false);
        Principal.Main.fvp.jtxtNombre.setEditable(false);
        Principal.Main.fvp.jtxtCategoria.setEditable(false);
        Principal.Main.fvp.jtxtProveedor.setEditable(false);
        Principal.Main.fvp.jtxtCantidad.setEditable(false);
        Principal.Main.fvp.jtxtPrecio.setEditable(false);
        Principal.Main.fvp.jtxtExistencia.setEnabled(false);
        Principal.Main.fvp.jbtnActualizar.setEnabled(false);
   
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

     
   
    
}
