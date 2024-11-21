/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComboBox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.TestLookAndFeel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.plaf.metal.MetalComboBoxEditor;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class setEditor
implements Testlet,
PropertyChangeListener {
    private PropertyChangeEvent event;

    @Override
    public void test(TestHarness harness) {
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (Exception e) {
            harness.fail("Problem setting MetalLookAndFeel");
        }
        JComboBox<Object> c1 = new JComboBox<Object>(new Object[]{"A", "B", "C"});
        c1.addPropertyChangeListener(this);
        MetalComboBoxEditor editor = new MetalComboBoxEditor();
        c1.setEditor(editor);
        harness.check(c1.getEditor(), editor);
        harness.check(this.event.getPropertyName(), (Object)"editor");
        harness.check(this.event.getNewValue(), editor);
        try {
            UIManager.setLookAndFeel(new TestLookAndFeel());
        }
        catch (Exception e) {
            harness.fail("Problem setting TestLookAndFeel");
        }
        c1.updateUI();
        JComboBox c2 = new JComboBox();
        harness.check(c1.getEditor(), editor);
        harness.check(c2.getEditor() instanceof BasicComboBoxEditor.UIResource);
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (Exception e) {
            harness.fail("Problem restoring MetalLookAndFeel");
        }
        c1.setEditor(null);
        harness.check(c1.getEditor(), null);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.event = e;
    }
}

