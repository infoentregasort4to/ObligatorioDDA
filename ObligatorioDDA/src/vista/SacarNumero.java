
package vista;

import controlador.ControladorSacarNumero;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Area;
import modelo.Sector;
import controlador.VistaSacarNumero;


public class SacarNumero extends javax.swing.JDialog implements VistaSacarNumero {

    private ControladorSacarNumero controlador;
    
    public SacarNumero(java.awt.Frame parent, boolean modal,Area a)
    {
        super(parent, modal);
        initComponents();
        this.setTitle("Sacar Numero");
        controlador= new ControladorSacarNumero(this,a);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboSectores = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSectoresTiempos = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCi = new javax.swing.JTextField();
        btnPedirNumero = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listSectores = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Seleccione un sector");

        jScrollPane1.setViewportView(listSectoresTiempos);

        jLabel2.setText("Espera estimada para cada Sector");

        jLabel3.setText("Ingrese su numero de cedula");

        txtCi.setText("1237");
        txtCi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiActionPerformed(evt);
            }
        });

        btnPedirNumero.setText("Pedir numero");
        btnPedirNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedirNumeroActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listSectores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnPedirNumero)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCi)
                                .addComponent(cboSectores, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboSectores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnPedirNumero)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiActionPerformed

    private void btnPedirNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedirNumeroActionPerformed
        Sector s= (Sector)this.cboSectores.getSelectedItem();
        String ci= txtCi.getText();
        controlador.crearAtencion(ci,s);
    }//GEN-LAST:event_btnPedirNumeroActionPerformed
    
    @Override
    public void limpiarValores()
    {
        txtCi.setText("");
    }
    
    @Override
    public void mostrarSectores(ArrayList<Sector> sectores)
    {
        listSectores.setListData(sectores.toArray(new Sector[1]));
        for(Sector s : sectores)
        {
            cboSectores.addItem(s);            
        } 
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPedirNumero;
    private javax.swing.JComboBox<Sector> cboSectores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Sector> listSectores;
    private javax.swing.JList<String> listSectoresTiempos;
    private javax.swing.JTextField txtCi;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarMensaje(String msg)
    {
        JOptionPane.showMessageDialog(this, msg);
    }    

    @Override
    public void mostrarTiempos(ArrayList<String> t) {
        listSectoresTiempos.setListData(t.toArray(new String[1]));
    }
}
