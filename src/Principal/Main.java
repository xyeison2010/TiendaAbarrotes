package Principal;

import Controlador.*;
import DAO.ConectarBD;
import Modelo.ListaCategorias;
import Modelo.ListaProveedores;
import Vista.*;
import java.awt.Frame;
import de.javasoft.plaf.synthetica.SyntheticaBlueLightLookAndFeel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main {

    public static frmMenu m;
    public static frmRegProducto rp;
    public static frmListaProductos lp;
    public static frmRegCategorias rc;
    public static frmListaCategorias lc;
    public static AccionesFrmMenu afm;
    public static frmVerCategoria fvc;
    public static ListaCategorias listacat;
    public static ListaProveedores listaprov;
    public static frmVerProducto fvp;
    
    
  
    public static void main(String[] args) {

        try {
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel(new SyntheticaBlueLightLookAndFeel());
        } catch (Exception e) {  }
    
        m = new frmMenu();
        m.setVisible(true);
        m.setExtendedState(Frame.MAXIMIZED_BOTH);
        afm = new AccionesFrmMenu(m);
      
        
  //PORSIACASO    ConectarBD c = new ConectarBD();
        
    }
}
