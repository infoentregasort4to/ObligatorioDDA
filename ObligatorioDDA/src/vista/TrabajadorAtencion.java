package vista;


import modelo.Fachada;

import modelo.Puesto;
import modelo.Trabajador;

import controlador.ControladorTrabajadorAtencion;

import javax.swing.JOptionPane;

import modelo.Atencion;
import controlador.VistaTrabajadorAtencion;

public class TrabajadorAtencion extends javax.swing.JDialog implements VistaTrabajadorAtencion {

    private Trabajador trabajador;
    private Puesto p;
    private ControladorTrabajadorAtencion controlador;

    public TrabajadorAtencion(java.awt.Frame parent, boolean modal, Puesto p, Trabajador t) {
        super(parent, modal);
        initComponents();
        controlador = new ControladorTrabajadorAtencion(this, p, t);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void Salir()
    {        
        this.setVisible(false);
        dispose();
    }
    
    @Override
    public void finYSiguiente() {        
        txtDesc.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Salir = new javax.swing.JButton();
        finYSiguiente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreAtencion = new javax.swing.JLabel();
        txtInfo = new javax.swing.JLabel();
        valorTiempo = new javax.swing.JLabel();
        txtCant = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtArea = new javax.swing.JLabel();
        txtSector = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Salir.setText("SALIR");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        finYSiguiente.setText("FINALIZAR y SIGUIENTE ");
        finYSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finYSiguienteActionPerformed(evt);
            }
        });

        txtDesc.setColumns(20);
        txtDesc.setRows(5);
        jScrollPane1.setViewportView(txtDesc);

        jLabel1.setText("Comentario de la atencion");

        jLabel2.setText("Atencion actual:");

        nombreAtencion.setText("DISPONIBLE");

        jLabel4.setText("Cantidad de atenciones:");

        jLabel5.setText("Tiempo Promedio de Atencion:");

        jLabel3.setText("Area:");

        jLabel6.setText("Sector:");

        txtArea.setText("jLabel7");

        txtSector.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtArea)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSector)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(valorTiempo)
                                    .addComponent(txtCant))))
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(finYSiguiente)
                                .addGap(18, 18, 18)
                                .addComponent(Salir))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtArea)
                    .addComponent(txtSector))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreAtencion)
                    .addComponent(valorTiempo)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCant)
                    .addComponent(jLabel4))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Salir)
                    .addComponent(finYSiguiente))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        controlador.logout();
    }//GEN-LAST:event_SalirActionPerformed

    private void finYSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finYSiguienteActionPerformed
        controlador.guardarYSeguir(txtDesc.getText());
    }//GEN-LAST:event_finYSiguienteActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controlador.logout();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Salir;
    private javax.swing.JButton finYSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombreAtencion;
    private javax.swing.JLabel txtArea;
    private javax.swing.JLabel txtCant;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JLabel txtInfo;
    private javax.swing.JLabel txtSector;
    private javax.swing.JLabel valorTiempo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarTitulo(String t) {
        this.setTitle(t);
    }
    @Override
    public void mostrarArea(String a) {
        this.txtArea.setText(a);
    }

    @Override
    public void mostrarSector(String s) {
        this.txtSector.setText(s);
    }


    @Override
    public void mostrarAtencion(Object a) {
        if (a != null) {
            Atencion aa = (Atencion) a;
            nombreAtencion.setText("Numero: " + aa.getNumero() + " --- Cliente: " + aa.getCliente());
        } else {
            nombreAtencion.setText("No hay atencion asignada");
        }
    }

    @Override
    public void mostrarMensaje(String s) {
        JOptionPane.showMessageDialog(this, s);
    }

    @Override
    public void actualizarInfo(String tiempo,String cantidad) {
        valorTiempo.setText(tiempo);
        txtCant.setText(cantidad);
    }

    
}
