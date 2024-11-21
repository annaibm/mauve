/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicComboBoxEditor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxEditor;

public class addActionListener
implements Testlet,
ActionListener {
    @Override
    public void test(TestHarness harness) {
        BasicComboBoxEditor e = new BasicComboBoxEditor();
        JTextField tf = (JTextField)e.getEditorComponent();
        ActionListener[] listeners = tf.getActionListeners();
        harness.check(listeners.length, 0);
        e.addActionListener(this);
        listeners = tf.getActionListeners();
        harness.check(listeners.length, 1);
        harness.check(listeners[0], this);
        e.addActionListener(null);
        listeners = tf.getActionListeners();
        harness.check(listeners.length, 1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

