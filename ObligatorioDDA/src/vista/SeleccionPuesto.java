/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;



import controlador.ControladorSeleccionPuesto;
import modelo.Trabajador;
import modelo.Fachada;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Puesto;

import controlador.VistaSeleccionPuesto;


public class SeleccionPuesto extends javax.swing.JDialog implements VistaSeleccionPuesto {

    private Trabajador trabajador;
    private Fachada ff= Fachada.getInstancia();
    
    private ControladorSeleccionPuesto controlador;
    
    
    public SeleccionPuesto(java.awt.Frame parent, boolean modal,Trabajador t)
    {
        super(parent, modal);
        initComponents();
        controlador= new ControladorSeleccionPuesto(this,t);        
    }
    
    @Override
    public void mostrarTitulo(String s)
    {
        txtSector.setText(s);
    }
    
    @Override
    public void mostrarPuestos( ArrayList<Puesto> puestos)
    {        
        for(Puesto p : puestos)
        {
            cboPuestos.addItem(p);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnContinuar = new javax.swing.JButton();
        cboPuestos = new javax.swing.JComboBox<>();
        txtSector = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        txtSector.setText("AreaXX");

        jLabel1.setText("Seleccione un Puesto del area: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSector)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(cboPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnContinuar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSector)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        Puesto p= (Puesto)this.cboPuestos.getSelectedItem();
        controlador.asignarPuesto(p);
    }//GEN-LAST:event_btnContinuarActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JComboBox<Puesto> cboPuestos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel txtSector;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void puestoAsignado(Puesto p,Trabajador t)
    {
        String msg ="Se le ha asignado el " + p.toString();
        JOptionPane.showMessageDialog(this, msg);
        this.setVisible(false);        
       
        JDialog atencion = new TrabajadorAtencion(null,false,p,t);
        atencion.setResizable(false);           
        atencion.setLocationRelativeTo(null);
        atencion.setVisible(true);  
    }

    @Override
    public void mostrarError(String msg)
    {
        JOptionPane.showMessageDialog(this, msg);
    }
}
