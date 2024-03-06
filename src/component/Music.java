package component;

import datos.Lista;
import datos.Nodo;
import model.MusicModel;
import repository.MusicServices;

public class Music extends javax.swing.JPanel {

    public Music() {
        initComponents();
        init();
    }

    private void init() {
        MusicServices musicRepository = new MusicServices();

        Lista<MusicModel> listaCanciones = musicRepository.obtenerCancion();

        Nodo<MusicModel> actual = listaCanciones.getCabeza();

        while (actual != null) {
            MusicModel cancion = actual.getDato();

            list.addItem(cancion);
            actual = actual.getSiguiente();
        }
    }
    
    public void agregarDatos(MusicModel model){
        list.addItem(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        list = new component.ListMusic<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Canciones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(list, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(list, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private component.ListMusic<MusicModel> list;
    // End of variables declaration//GEN-END:variables
}
