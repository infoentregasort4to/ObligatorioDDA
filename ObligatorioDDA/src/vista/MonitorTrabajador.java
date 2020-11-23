package vista;

import Observador.Observable;
import Observador.Observador;
import controlador.ControladorMonitorTrabajador;
import modelo.Fachada;
import java.util.ArrayList;
import modelo.Atencion;
import controlador.VistaMonitorTrabajador;

public class MonitorTrabajador extends javax.swing.JDialog implements VistaMonitorTrabajador
{
    private Fachada ff = modelo.Fachada.getInstancia();
    ControladorMonitorTrabajador controlador;
    
    public MonitorTrabajador(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        controlador= new ControladorMonitorTrabajador(this);
        this.setTitle("Monitor Trabajadores");        
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaAtenciones = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(listaAtenciones);

        jLabel1.setText("Clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaAtenciones;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarAtenciones(ArrayList<Atencion> a)
    {
        this.listaAtenciones.setListData(a.toArray());
    }
    
    
}
