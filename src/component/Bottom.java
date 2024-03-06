package component;

import datos.Lista;
import datos.Nodo;
import form.MusicPlayerForm;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import model.MusicModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.PlaylistModel;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import repository.MusicServices;
import repository.PlaylistServices;

public class Bottom extends javax.swing.JPanel {

    private String title;
    private String artist;
    private String album;
    private int anio;
    private String duracion;
    private int idPlaylist;
    private String ruta;
    private MusicPlayerForm musicPlayerForm;
    PlaylistServices playlistRepository;

    public Bottom(MusicPlayerForm musicPlayerForm) {
        initComponents();
        setOpaque(false);
        setBackground(new Color(68, 68, 68));
        this.musicPlayerForm = musicPlayerForm;
        playlistRepository = new PlaylistServices();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        play1 = new component.Play();
        slider1 = new swing.Slider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        slider1.setMaximum(200);
        slider1.setValue(60);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("01:05");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("03:35");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/speaker.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/browse_selected.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/repeat.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(play1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slider1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(play1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private PlaylistModel obtenerPlaylistPorNombre(Lista<PlaylistModel> lista, String nombrePlaylist) {
        Nodo<PlaylistModel> current = lista.getCabeza();

        while (current != null) {
            PlaylistModel playlist = current.getDato();
            if (playlist.getNombre().equals(nombrePlaylist)) {
                return playlist;  // Encontramos la playlist con el nombre especificado
            }
            current = current.getSiguiente();
        }

        return null;  // No se encontró ninguna playlist con el nombre especificado
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Audio", "mp3", "wav", "flac");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // Muestra opciones al usuario
            String[] options = {"Crear nueva playlist", "Guardar en playlist existentes"};
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Opciones",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    String nuevaPlaylist = JOptionPane.showInputDialog(null, "Ingrese el nombre de la nueva playlist");

                    playlistRepository.agregarPlaylist(new PlaylistModel(nuevaPlaylist));

                    Lista<PlaylistModel> ultimaPlaylist = playlistRepository.obtenerUltimaPlaylist();

                    Nodo<PlaylistModel> actual = ultimaPlaylist.getCabeza();

                    while (actual != null) {
                        PlaylistModel playlidt = actual.getDato();

                        idPlaylist = playlidt.getId();
                        actual = actual.getSiguiente();
                    }

                    musicPlayerForm.agregarDatosAMusicPlayerForm(new PlaylistModel(nuevaPlaylist, new ImageIcon(getClass().getResource("/icon/playlistImg.jpg"))));

                    break;

                case 1:
                    Lista<PlaylistModel> listaPlaylist = playlistRepository.obtenerPlaylist();
                    int size = 0;
                    Nodo<PlaylistModel> current = listaPlaylist.getCabeza();

                    while (current != null) {
                        size++;
                        current = current.getSiguiente();
                    }

                    String[] playlistNamesArray = new String[size];
                    int index = 0;
                    current = listaPlaylist.getCabeza();

                    while (current != null) {
                        playlistNamesArray[index++] = current.getDato().getNombre();
                        current = current.getSiguiente();
                    }

                    if (size > 0) {
                        String selectedPlaylistName = (String) JOptionPane.showInputDialog(
                                null,
                                "Seleccione la playlist",
                                "Guardar en playlist existentes",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                playlistNamesArray,
                                playlistNamesArray[0]);

                        if (selectedPlaylistName != null) {
                            PlaylistModel selectedPlaylist = obtenerPlaylistPorNombre(listaPlaylist, selectedPlaylistName);
                            if (selectedPlaylist != null) {
                                // Lógica para utilizar el objeto PlaylistModel seleccionado 
                                int selectedPlaylistId = selectedPlaylist.getId();
                                
                                idPlaylist = selectedPlaylistId;
                                // ...
                            }
                        }
                    } else {
                        // Manejo si la lista está vacía
                        JOptionPane.showMessageDialog(null, "No hay playlists disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

            }

            try {
                AudioFile audioFile = AudioFileIO.read(selectedFile);
                AudioHeader audioHeader = audioFile.getAudioHeader();

                int durationInSeconds = audioHeader.getTrackLength();

                int minutes = durationInSeconds / 60;
                int seconds = durationInSeconds % 60;

                Tag tag = audioFile.getTag();
                if (tag != null) {
                    title = (tag != null && tag.getFirst(FieldKey.TITLE) != null) ? tag.getFirst(FieldKey.TITLE) : "N/A";
                    artist = (tag != null && tag.getFirst(FieldKey.ARTIST) != null) ? tag.getFirst(FieldKey.ARTIST) : "N/A";
                    album = (tag != null && tag.getFirst(FieldKey.ALBUM) != null) ? tag.getFirst(FieldKey.ALBUM) : "N/A";
                    anio = (tag != null && tag.getFirst(FieldKey.YEAR) != null) ? Integer.parseInt(tag.getFirst(FieldKey.YEAR)) : 0000;
                    duracion = String.format("%02d:%02d", minutes, seconds);
                    ruta = (selectedFile != null) ? selectedFile.toString() : "N/A";

                } else {
                    title = "N/A";
                    artist = "N/A";
                    album = "N/A";
                    anio = 0000;
                    duracion = String.format("%02d:%02d", minutes, seconds);
                    ruta = selectedFile.toString();
                }

                MusicServices musicRepository = new MusicServices();
                Lista<MusicModel> listaCanciones = musicRepository.obtenerCancion();

                MusicModel nuevaCancion = new MusicModel(title, artist, album, anio, duracion, idPlaylist, ruta);

                musicRepository.agregarCancion(nuevaCancion);

                listaCanciones = musicRepository.obtenerUltimaCancion();

                nuevaCancion.setId(listaCanciones.getCabeza().getDato().getId());

                listaCanciones.insertarAlFinal(nuevaCancion);

                musicPlayerForm.agregarDatosAMusic1(nuevaCancion);
            } catch (Exception e) {
                System.err.println("Error reading MP3 file: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.fillRect(0, 0, getWidth(), 25);
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private component.Play play1;
    private swing.Slider slider1;
    // End of variables declaration//GEN-END:variables
}
