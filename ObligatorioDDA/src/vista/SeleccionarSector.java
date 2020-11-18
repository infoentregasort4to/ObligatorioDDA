/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Fachada;
import javax.swing.JOptionPane;
import modelo.Area;
import modelo.Cliente;
import modelo.Sector;

/**
 *
 * @author sebaa
 */
public class SeleccionarSector extends javax.swing.JDialog {

    private Fachada ff = Fachada.getInstancia();
    private Area aa;
    public SeleccionarSector(java.awt.Frame parent, boolean modal, Area a) {
        super(parent, modal);
        setLocationRelativeTo(null);
        this.setTitle("Seleccione un Sectore ingrese su numero de cliente");
        initComponents();
        this.aa = a;
        sectores();
    }
    private void sectores()
    {       
        this.cboSectores.removeAllItems();
        
        for(Sector s : aa.getSectores())
        {
            cboSectores.addItem(s);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        cboSectores = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtNumeroCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnPedirNumero = new javax.swing.JButton();

        jButton1.setText("Seleccionar Sector");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cboSectores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSectoresActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione un Sector: ");

        jLabel2.setText("Indique Su numero de CLiente");

        btnPedirNumero.setText("PEDIR NUMERO");
        btnPedirNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedirNumeroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPedirNumero)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboSectores, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboSectores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnPedirNumero)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPedirNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedirNumeroActionPerformed
        
        Sector s = (Sector)this.cboSectores.getSelectedItem();
        
        String ncliente = txtNumeroCliente.getText();        
        
        ///try catch para verificar si el cliente existe
        Cliente cc = ff.getCliente(ncliente);        
        
        ff.crearAtencion(cc, aa, s);        
        
        JOptionPane.showMessageDialog(this, "Muchas gracias, ya esta por ser atendido!!");
        
        this.setVisible(false);        
    }//GEN-LAST:event_btnPedirNumeroActionPerformed

    private void cboSectoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSectoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSectoresActionPerformed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPedirNumero;
    private javax.swing.JComboBox<Sector> cboSectores;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtNumeroCliente;
    // End of variables declaration//GEN-END:variables
}
