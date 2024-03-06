/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package component;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import model.MusicModel;

/**
 *
 * @author maula
 * @param <E>
 */
public class ListMusic<E extends Object> extends JList<E> {

    private final DefaultListModel model;
    private int playIndex = -1;

    public ListMusic() {
        model = new DefaultListModel();
        setModel(model);
        setOpaque(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    playIndex = locationToIndex(me.getPoint());
                    repaint();
                }
            }
        });
    }
    
    @Override
    public ListCellRenderer getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
                MusicModel data;
                if (o instanceof MusicModel) {
                    data = (MusicModel) o;
                } else {
                    data = new MusicModel(/*"1", "No Music", "00:00"*/);
                }
                ItemMusic item = new ItemMusic(data);
                item.setPlay(index == playIndex);
                return item;
            }
        };
    }

    public void addItem(MusicModel data) {
        model.addElement(data);
    }
    
    public void update(java.util.List<E> newList) {
        model.removeAllElements();
        for (E item : newList) {
            model.addElement(item);
        }
    }
}
