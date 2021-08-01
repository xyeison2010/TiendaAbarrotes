package Formatos;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Seteo {

    public static void Limpiar(JTextField jf) {
        jf.setText("");
    }
    public static void Limpiar(JComboBox jcbx) {
        jcbx.setSelectedIndex(0);
    }
    public static void Limpiar(JTextArea jtxa) {
        jtxa.setText("");
    }
    public static void Limpiar(JSpinner jspn) {
        jspn.setValue(0);
    }
    public static void Limpiar(JLabel lbl) {
        lbl.setIcon(null);
        lbl.setText("FOTO");
    }
    public static void Limpiar(JPanel panel){
        panel.removeAll();
        panel.repaint();
    }
}
