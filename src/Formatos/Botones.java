
package Formatos;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Botones {
    
   public JButton Ver(){
      JButton btn = new JButton();
      btn.setIcon(new ImageIcon(getClass().getResource("/Iconos/buscar_cliente.gif")));
      btn.setName("ver");
      return btn;
   }
   public JButton Actualizar(){
      JButton btn = new JButton();
      btn.setIcon(new ImageIcon(getClass().getResource("/Iconos/edit.gif")));
      btn.setName("actualizar");
      return btn;
   }
   public JButton Eliminar(){
      JButton btn = new JButton();
      btn.setIcon(new ImageIcon(getClass().getResource("/Iconos/cancelar.gif")));
      btn.setName("eliminar");
      return btn;
   }
    
    
    
}
