/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComboBox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.ComboBoxEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.metal.MetalComboBoxEditor;

public class getEditor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testDefault(harness);
        this.testPR30337(harness);
    }

    private void testDefault(TestHarness harness) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }
        catch (Exception e) {
            harness.fail("Problem setting MetalLookAndFeel");
        }
        JComboBox<Object> c1 = new JComboBox<Object>(new Object[]{"A", "B", "C"});
        ComboBoxEditor editor = c1.getEditor();
        harness.check(editor instanceof MetalComboBoxEditor.UIResource);
        c1.setEditor(new MetalComboBoxEditor());
        harness.check(!(c1.getEditor() instanceof UIResource));
    }

    private void testPR30337(TestHarness h) {
        TestComboBox cb = new TestComboBox();
        JFrame f = new JFrame();
        boolean pass = true;
        try {
            f.getContentPane().add(cb);
            f.setVisible(true);
        }
        catch (NullPointerException ex) {
            pass = false;
        }
        h.check(pass);
        f.dispose();
        cb = new TestComboBox();
        f = new JFrame();
        pass = false;
        try {
            cb.setEditable(true);
            f.getContentPane().add(cb);
            f.setVisible(true);
        }
        catch (NullPointerException ex) {
            pass = true;
        }
        h.check(pass);
        f.dispose();
    }

    private class TestComboBox
    extends JComboBox {
        private TestComboBox() {
        }

        @Override
        public ComboBoxEditor getEditor() {
            return null;
        }
    }
}

