
package Formatos;

import java.awt.Dimension;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;


public class CentrarForma {
    public static void CPanel(JPanel pan,JInternalFrame inf){
        Dimension desktopSize = pan.getSize();
        Dimension jifSize = inf.getSize();
        inf.setLocation((desktopSize.width - jifSize.width)/2,
                         (desktopSize.height - jifSize.height)/2-80);
    }
}
