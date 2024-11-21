/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JMenuItem;

import gnu.testlet.VisualTestlet;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRootPane;

public class DragSelectTest
extends VisualTestlet {
    @Override
    public String getInstructions() {
        return "Press the mouse on the 'Menu' menu, hold the button pressed and drag it to one of the menu items. Then release the mouse button";
    }

    @Override
    public String getExpectedResults() {
        return "The menu should be closed and the name of the menu item shown in the panel below";
    }

    @Override
    public Component getTestComponent() {
        JRootPane rp = new JRootPane();
        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        final JLabel label = new JLabel("The selected menu item should show up here");
        ActionListener l = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ev) {
                JMenuItem i = (JMenuItem)ev.getSource();
                label.setText(i.getText());
            }
        };
        JMenuItem item1 = new JMenuItem("MenuItem 1");
        item1.addActionListener(l);
        JMenuItem item2 = new JMenuItem("MenuItem 2");
        item2.addActionListener(l);
        JMenuItem item3 = new JMenuItem("MenuItem 3");
        item3.addActionListener(l);
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        mb.add(menu);
        rp.setJMenuBar(mb);
        rp.getContentPane().add(label);
        return rp;
    }
}

