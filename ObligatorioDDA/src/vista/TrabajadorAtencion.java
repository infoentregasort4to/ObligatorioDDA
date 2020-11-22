package vista;
import Observador.Observable;
import modelo.Fachada;
import java.util.ArrayList;
import javax.swing.JFrame;
import modelo.Puesto;
import modelo.Sector;
import modelo.Trabajador;
import Observador.Observador;
import controlador.ControladorTrabajadorAtencion;
import controlador.VistaTrabajadorAtencion;
import modelo.Area;
import modelo.Atencion;


public class TrabajadorAtencion extends javax.swing.JDialog implements VistaTrabajadorAtencion  {

    private Atencion atencion;
    
    private Fachada ff = modelo.Fachada.getInstancia();
    
    private Trabajador trabajador;
    
    private Sector sector;
    
    private Puesto p;
    
    private ControladorTrabajadorAtencion controlador;
    
    public TrabajadorAtencion(java.awt.Frame parent, boolean modal, Puesto p,Trabajador t)
    {
        super(parent, modal);
        initComponents();
        controlador= new ControladorTrabajadorAtencion(this,p,t);
        this.setLocationRelativeTo(null);         
    } 
    
    @Override
    public void finYSalir() {
        
       // guardar atencion 
        
        controlador.logout(); // verificar si hay atencion pendiente
        
        
        this.setVisible(false);
        dispose();
        //llamar al controlador para hacer el logout()
        //llamo al controladorLogin para hacer el logout()
        //llama al controladorPuestos para liberarPuesto()(controlando que el puesto no tenga número de atención asignado)
    }

    @Override
    public void finYSiguiente() {
       //guardar la atencion
        
        
        //
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        finYSalir = new javax.swing.JButton();
        finYSiguiente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreAtencion = new javax.swing.JLabel();
        txtInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        finYSalir.setText("FINALIZAR Y SALIR");
        finYSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finYSalirActionPerformed(evt);
            }
        });

        finYSiguiente.setText("FINALIZAR y SIGUIENTE ");
        finYSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finYSiguienteActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Comentario de la atencion");

        jLabel2.setText("Atencion actual:");

        nombreAtencion.setText("_sin_atencion_");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreAtencion))
                            .addComponent(txtInfo))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(finYSiguiente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(finYSalir))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 31, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombreAtencion))
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finYSalir)
                    .addComponent(finYSiguiente))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void finYSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finYSalirActionPerformed
        finYSalir();
    }//GEN-LAST:event_finYSalirActionPerformed

    private void finYSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finYSiguienteActionPerformed
        finYSiguiente();
    }//GEN-LAST:event_finYSiguienteActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton finYSalir;
    private javax.swing.JButton finYSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel nombreAtencion;
    private javax.swing.JLabel txtInfo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarTitulo(String t) {
        this.setTitle(t);
    }

    @Override
    public void mostrarAtencion(Object a) {
        if(a!=null){
            Atencion aa=(Atencion)a;
            nombreAtencion.setText( "Numero: " + aa.getNumero() + " --- Cliente: " +aa.getCliente());    
        }
        else{
            nombreAtencion.setText("No hay atencion asignada");
        }        
    }

    @Override
    public void mostrarInfo(String s)
    {
        txtInfo.setText(s);        
    }
    
}
