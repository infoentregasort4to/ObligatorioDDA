package vista;

import Observador.Observable;
import Observador.Observador;
import modelo.Fachada;
import java.util.ArrayList;
import modelo.Atencion;

public class Monitor extends javax.swing.JDialog implements Observador{

    private Fachada ff = modelo.Fachada.getInstancia();
    
    
    public Monitor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        ff.agregar(this);
        this.setTitle("Monitor");
        initComponents();
    }
    
    @Override
    public void actualizar(Observable origen, Object evento)
    {
        
        if(origen == ff) {
            if(evento.equals(Fachada.Eventos.NuevaAtencion)) {
                this.mostrarListaAtencionesPendientes();
                
            }
        }
    }
    
    private void mostrarListaAtencionesPendientes()
    {          
        ArrayList<modelo.Atencion> ala = ff.atencionesPendientes(); // SECTOR - 123123 - cliente - puesto -- espera         
        this.listaAtenciones.setListData(ala.toArray());
    }
       

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaAtenciones = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(listaAtenciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaAtenciones;
    // End of variables declaration//GEN-END:variables
}
