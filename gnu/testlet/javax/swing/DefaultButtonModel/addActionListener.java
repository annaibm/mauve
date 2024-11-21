/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultButtonModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultButtonModel;

public class addActionListener
implements Testlet,
ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void test(TestHarness harness) {
        DefaultButtonModel m = new DefaultButtonModel();
        m.addActionListener(this);
        harness.check(m.getActionListeners()[0], this);
        m.addActionListener(null);
        harness.check(m.getActionListeners().length, 1);
    }
}

