/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComboBox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

public class listenerList
implements Testlet,
ActionListener,
ItemListener {
    @Override
    public void test(TestHarness harness) {
        JComboBox box = new JComboBox();
        box.addActionListener(this);
        box.addItemListener(this);
        this.checkListenerLists(harness, box);
    }

    private void checkListenerLists(TestHarness harness, JComboBox box) {
        try {
            ActionListener[] a_listeners = box.getActionListeners();
            boolean weAre = false;
            for (int i = 0; i < a_listeners.length; ++i) {
                if (a_listeners[i] != this) continue;
                weAre = true;
                break;
            }
            harness.check(weAre, "Action listener list");
            ItemListener[] i_listeners = box.getItemListeners();
            weAre = false;
            for (int i = 0; i < i_listeners.length; ++i) {
                if (i_listeners[i] != this) continue;
                weAre = true;
                break;
            }
            harness.check(weAre, "Item listener list");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            harness.fail("Cannot check the listerner lists, bug in 1.3, fixed in 1.4");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
    }
}

