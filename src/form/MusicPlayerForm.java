package form;

import datos.Lista;
import datos.Nodo;
import model.PlaylistModel;
import model.MusicModel;
import repository.PlaylistServices;

public class MusicPlayerForm extends javax.swing.JPanel {

    public MusicPlayerForm() {
        initComponents();
        init();
    }

    private void init() {
        PlaylistServices playlistRepository = new PlaylistServices();

        Lista<PlaylistModel> listaPlaylists = playlistRepository.obtenerPlaylist();

        Nodo<PlaylistModel> actual = listaPlaylists.getCabeza();

        while (actual != null) {
            PlaylistModel cancion = actual.getDato();

            mostPopular.addImage(cancion);
            actual = actual.getSiguiente();
        }
    }
    
    public void agregarDatosAMusic1(MusicModel model){
        music1.agregarDatos(model);
    } 
    
    public void agregarDatosAMusicPlayerForm(PlaylistModel model){
        mostPopular.addImage(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mostPopular = new component.MostPopular();
        music1 = new component.Music();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(169, 29, 177));
        jLabel1.setText("MLA Music");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(80, 80, 80));
        jLabel2.setText("Playlist");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(music1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mostPopular, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mostPopular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(music1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private component.MostPopular mostPopular;
    private component.Music music1;
    // End of variables declaration//GEN-END:variables
}
