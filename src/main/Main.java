package main;

//import com.raven.model.Model_Menu;
import swing.ScrollBar;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import repository.MusicServices;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        init();
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Lógica para realizar acciones antes de cerrar la ventana
                System.out.println("Cerrando la aplicación");
                
                MusicServices musicRepository = new MusicServices();
                
                musicRepository.eliminarCancionGeneral();
                
                System.exit(0);
            }
        });
    }

    private void init() {
        sp.setVerticalScrollBar(new ScrollBar());
        setBackground(new Color(0, 0, 0, 0)); // Remove background color
        /*
         * list1.addItem(new Model_Menu("Playlist", "playlist"));
         * list1.addItem(new Model_Menu("Artists", "artists"));
         * list1.addItem(new Model_Menu("Albums", "albums"));
         * list1.addItem(new Model_Menu("Songs", "song"));
         * 
         * list2.addItem(new Model_Menu("Store", "store"));
         * list2.addItem(new Model_Menu("Radio", "radio"));
         * list2.addItem(new Model_Menu("For You", "love"));
         * list2.addItem(new Model_Menu("Browse", "browse"));
         */
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new swing.Panel();
        menu1 = new component.Menu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelMoving = new javax.swing.JPanel();
        sp = new javax.swing.JScrollPane();
        form_Artists1 = new form.MusicPlayerForm();
        bottom1 = new component.Bottom(form_Artists1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1260, 671));

        panel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 229, 229));
        jLabel1.setText("LIBRARY");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 50, 1, 1));

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(229, 229, 229));
        jLabel2.setText("DISCOVER");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 50, 1, 1));

        panelMoving.setOpaque(false);
        panelMoving.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelMovingMouseDragged(evt);
            }
        });
        panelMoving.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelMovingMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
                panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE));
        panelMovingLayout.setVerticalGroup(
                panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 40, Short.MAX_VALUE));

        javax.swing.GroupLayout menu1Layout = new javax.swing.GroupLayout(menu1);
        menu1.setLayout(menu1Layout);
        menu1Layout.setHorizontalGroup(
                menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(menu1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 233,
                                                Short.MAX_VALUE))
                                .addContainerGap())
                        .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        menu1Layout.setVerticalGroup(
                menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(menu1Layout.createSequentialGroup()
                                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addContainerGap()));

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setViewportView(form_Artists1);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
                                .addContainerGap()));
        panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bottom1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(bottom1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private int x;
    private int y;

    private void panelMovingMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_panelMovingMousePressed
        x = evt.getX();
        y = evt.getY();
    }// GEN-LAST:event_panelMovingMousePressed

    private void panelMovingMouseDragged(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_panelMovingMouseDragged
        setLocation(evt.getXOnScreen() - x, evt.getYOnScreen() - y);
    }// GEN-LAST:event_panelMovingMouseDragged

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.Bottom bottom1;
    private form.MusicPlayerForm form_Artists1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private component.Menu menu1;
    private swing.Panel panel1;
    private javax.swing.JPanel panelMoving;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
