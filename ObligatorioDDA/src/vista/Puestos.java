/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import Observador.Observable;
import Observador.Observador;
import modelo.Trabajador;
import controlador.Fachada;
import java.util.ArrayList;
import javax.swing.JDialog;
import modelo.Puesto;
import modelo.Sector;


public class Puestos extends javax.swing.JDialog implements Observador {

    private Trabajador trabajador;
    private Fachada ff= Fachada.getInstancia();
    private Sector sector;
    private Puesto puesto;
    
    
    public Puestos(java.awt.Frame parent, boolean modal,Trabajador t) {
        super(parent, modal);
        initComponents();
        this.trabajador=t;
        ff.agregar(this);
        setTitle("Bienvenido " + t.getNombre());        
        puestosLibres();
    }
    private void puestosLibres()
    {
        
        Sector s = ff.obtenerSector(trabajador);
        
        this.sector=s;
        
        ArrayList<Puesto> puestos = s.getPuestosLibres();
        
        this.cboPuestos.removeAllItems();
        
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
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(cboPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(btnContinuar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(cboPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnContinuar)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        Puesto p= (Puesto)this.cboPuestos.getSelectedItem();
        //sector.ocuparPuesto(p,trabajador);
        this.puesto=p;
        ff.asignarPuesto(trabajador, p);  
        JDialog atencion = new VistaAtencion(null, false,p);
        this.setVisible(false);
        atencion.setVisible(true);       
        atencion.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnContinuarActionPerformed
    @Override
    public void actualizar(Observable origen, Object evento) {
        if(evento.equals(Fachada.Eventos.PuestoDisponible)){//ACA ESTA IMPLEMENTADO POR EL PUESTO, ACCEDO AL ENUM POR LA CLASE PUESTO
                                //SI LO ESTOY HACIENDO POR FACHADA SERIA FACHADA.EVENTOS.PUESTODISPONIBLE
           System.out.println("me actualize");
           ff.asignarAtencion(puesto);
        }  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JComboBox<Puesto> cboPuestos;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    
}
