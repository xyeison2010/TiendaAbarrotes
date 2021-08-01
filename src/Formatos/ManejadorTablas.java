
package Formatos;
//librerias

import static Formatos.Encabezados.enccat;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class ManejadorTablas {
    
   
    public static void AnchoColumnas(JTable t, int numcolumna,int ancho) {
        TableColumn column;
        column = t.getColumnModel().getColumn(numcolumna);
        column.setPreferredWidth(ancho);       
    }
   public static void JustificarCelda(JTable t,int numcolumna){
       DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
       modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
       t.getColumnModel().getColumn(numcolumna).setCellRenderer(modelocentrar);       
   }
   public static void FormatoTablaCategorias(JTable tabla){
       AnchoColumnas(tabla,0,30);
       JustificarCelda(tabla,0);
       AnchoColumnas(tabla,1,30);
       JustificarCelda(tabla,1);
       AnchoColumnas(tabla,2,100);
       AnchoColumnas(tabla,3,380);
       AnchoColumnas(tabla,4,6);
       AnchoColumnas(tabla,5,6);
       AnchoColumnas(tabla,6,6);       
   }
   public static void FormatoTablaProductos(JTable tabla){
       AnchoColumnas(tabla,0,30); // numeración
       JustificarCelda(tabla,0);
       AnchoColumnas(tabla,1,50);// codido prod
       JustificarCelda(tabla,1);
       AnchoColumnas(tabla,2,200); // nom prod
       AnchoColumnas(tabla,3,200); // cantidad por unidad
        JustificarCelda(tabla,3);
       AnchoColumnas(tabla,4,50); //precio
        JustificarCelda(tabla,4);
       AnchoColumnas(tabla,5,50); //  unid. ex
       JustificarCelda(tabla,5);
       AnchoColumnas(tabla,6,150); // categoria    
       AnchoColumnas(tabla,7,150); // proveedor
       AnchoColumnas(tabla,8,6);// botones ver, actualizar eliminar
       AnchoColumnas(tabla,9,6);
       AnchoColumnas(tabla,10,6);
   }
   
   

   public static DefaultTableModel EsquemaTabla(JTable tabla, String[] encabezado){
       DefaultTableModel mt = new DefaultTableModel(null,encabezado){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };       
        tabla.setDefaultRenderer(Object.class,new RenderTabla());
        tabla.setModel(mt);
        tabla.setRowHeight(30);
        return mt;
   }
   
     
}
