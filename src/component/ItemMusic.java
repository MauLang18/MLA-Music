package component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import model.MusicModel;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

public class ItemMusic extends javax.swing.JPanel {

    public boolean isPlay() {
        return play;
    }

    private final MusicModel data;
    private boolean play;
    private AdvancedPlayer player;
    private String filePath;

    public void setPlay(boolean play) {
        this.play = play;
        if (play) {
            lbIcon.setText("");
            lbIcon.setIcon(new ImageIcon(getClass().getResource("/icon/playing.png")));
            lbText.setFont(new java.awt.Font("sansserif", 1, 14));
            lbText.setForeground(new Color(203, 30, 148));
            lbTime.setFont(new java.awt.Font("sansserif", 1, 14));
            lbTime.setForeground(new Color(203, 30, 148));

            initializePlayer();
            new Thread(() -> {
                try {
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            }).start();
        } else {
            if (player != null) {
                player.close();
            }
            lbIcon.setIcon(null);
            lbIcon.setText(String.valueOf(data.getId()));
            lbText.setFont(new java.awt.Font("sansserif", 0, 14));
            lbText.setForeground(new Color(51, 51, 51));
            lbTime.setFont(new java.awt.Font("sansserif", 0, 14));
            lbTime.setForeground(new Color(51, 51, 51));
        }
    }
    
    private void initializePlayer() {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            player = new AdvancedPlayer(fileInputStream);
            player.setPlayBackListener(new PlaybackListener() {
                @Override
                public void playbackFinished(PlaybackEvent evt) {
                    setPlay(false);
                }
            });
        } catch (JavaLayerException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ItemMusic(MusicModel data) {
        this.data = data;
        this.filePath = data.getRuta();
        initComponents();
        setOpaque(false);
        lbText.setText(data.getNombreCancion());
        lbTime.setText(data.getDuracion());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbText = new javax.swing.JLabel();
        lbTime = new javax.swing.JLabel();

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbText.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbText.setForeground(new java.awt.Color(51, 51, 51));
        lbText.setText("Music Name");

        lbTime.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbTime.setForeground(new java.awt.Color(51, 51, 51));
        lbTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTime.setText("03:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lbText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTime, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
            .addComponent(lbTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(246, 246, 246));
        g2.fillRect(0, getHeight() - 2, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbText;
    private javax.swing.JLabel lbTime;
    // End of variables declaration//GEN-END:variables
}
