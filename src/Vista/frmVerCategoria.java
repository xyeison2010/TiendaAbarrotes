/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author secacad-sistemas
 */
public class frmVerCategoria extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmRegProducto
     */
    public frmVerCategoria() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtxtCodigo = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxaDescripcion = new javax.swing.JTextArea();
        jbtnCerrar = new javax.swing.JButton();
        jbtnActualizar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("VER CATEGORIAS");
        setToolTipText("");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtCodigo.setBackground(new java.awt.Color(153, 204, 255));
        jtxtCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtCodigo.setForeground(new java.awt.Color(51, 51, 255));
        jtxtCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "CODIGO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.add(jtxtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 390, 70));

        jtxtNombre.setBackground(new java.awt.Color(153, 204, 255));
        jtxtNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtNombre.setForeground(new java.awt.Color(51, 51, 255));
        jtxtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "NOMBRE DE CATEGORIA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.add(jtxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 390, 80));

        jtxaDescripcion.setBackground(new java.awt.Color(153, 204, 255));
        jtxaDescripcion.setColumns(20);
        jtxaDescripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxaDescripcion.setForeground(new java.awt.Color(51, 51, 255));
        jtxaDescripcion.setRows(5);
        jtxaDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "DESCRIPCION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jScrollPane1.setViewportView(jtxaDescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 390, 110));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 300));

        jbtnCerrar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtnCerrar.setText("CERRAR");
        getContentPane().add(jbtnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 170, 50));

        jbtnActualizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbtnActualizar.setText("ACTUALIZAR");
        getContentPane().add(jbtnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 190, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtnActualizar;
    public javax.swing.JButton jbtnCerrar;
    public javax.swing.JTextArea jtxaDescripcion;
    public javax.swing.JTextField jtxtCodigo;
    public javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables
}