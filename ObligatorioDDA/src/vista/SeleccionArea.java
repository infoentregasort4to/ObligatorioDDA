package vista;
import controlador.ControladorSeleccionArea;
import modelo.Fachada;
import java.util.ArrayList;
import javax.swing.JDialog;
import modelo.Area;
import modelo.Cliente;
import controlador.VistaSeleccionArea;

public class SeleccionArea extends javax.swing.JDialog implements VistaSeleccionArea {

    ControladorSeleccionArea controlador;
    
    public SeleccionArea(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        controlador=  new ControladorSeleccionArea(this);
        this.setTitle("Seleccionar Area"); 
    } 
    
    @Override
    public void MostrarAreas(ArrayList<Area> areas)
    {
        for(Area a : areas)
        {
            cboAreas.addItem(a);
        }
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnContinuar = new javax.swing.JButton();
        cboAreas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        cboAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAreasActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione un area: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboAreas, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnContinuar)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboAreas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnContinuar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
       dispose();
       Area a= (Area)this.cboAreas.getSelectedItem();        
       JDialog PedirNumero = new SacarNumero(null, false,a);
       PedirNumero.setResizable(false);
       PedirNumero.setLocationRelativeTo(null);
       PedirNumero.setVisible(true);
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void cboAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAreasActionPerformed
        
    }//GEN-LAST:event_cboAreasActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JComboBox<Area> cboAreas;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void Siguiente(Object a) {
        
    }

    
}
