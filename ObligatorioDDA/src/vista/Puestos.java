/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import Observador.Observable;
import Observador.Observador;
import controlador.ControladorPuestos;
import controlador.VistaPuestos;
import modelo.Trabajador;
import modelo.Fachada;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Puesto;
import modelo.Sector;


public class Puestos extends javax.swing.JDialog implements VistaPuestos {

    private Trabajador trabajador;
    private Fachada ff= Fachada.getInstancia();
    //private Puesto puesto;
    
    private ControladorPuestos controlador;
    
    
    public Puestos(java.awt.Frame parent, boolean modal,Trabajador t) {
        super(parent, modal);
        initComponents();
        controlador= new ControladorPuestos(this,t);
        
    }
    @Override
    public void mostrarTitulo(String s){
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
        jLabel1 = new javax.swing.JLabel();
        txtSector = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Seleccione un puesto de trabajo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(btnContinuar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSector, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(64, 64, 64))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSector, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(btnContinuar)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        Puesto p= (Puesto)this.cboPuestos.getSelectedItem();
        controlador.asignarPuesto(p);
        
        /*this.puesto=p;
        ff.asignarPuesto( p);  
        JDialog atencion = new VistaAtencion(null, false,p);
        this.setVisible(false);
        atencion.setVisible(true);       
        atencion.setLocationRelativeTo(null);*/
    }//GEN-LAST:event_btnContinuarActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JComboBox<Puesto> cboPuestos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel txtSector;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void puestoAsignado(Puesto p,Trabajador t) {
        String msg ="Se le ha asignado el " + p.toString();
        JOptionPane.showMessageDialog(this, msg);
        this.setVisible(false);
        JDialog atencion = new TrabajadorAtencion(null,false,p,t);
        atencion.setVisible(true);     
        atencion.setLocationRelativeTo(null);
    }

    @Override
    public void mostrarError(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

   

    
    

    
}
