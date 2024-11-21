/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JInternalFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Window;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class setSelected
implements Testlet {
    boolean repainted;
    String propertyChanged;

    @Override
    public void test(TestHarness harness) {
        this.testRepaint(harness);
        this.testBoundProperty(harness);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void testRepaint(TestHarness h) {
        h.checkPoint("testRepaint");
        TestInternalFrame f = new TestInternalFrame();
        f.setVisible(true);
        Window fr = null;
        try {
            this.repainted = false;
            f.setSelected(true);
            h.check(this.repainted, false);
            this.repainted = false;
            f.setSelected(false);
            h.check(this.repainted, false);
            fr = new JFrame();
            ((JFrame)fr).getContentPane().add(f);
            fr.setSize(100, 100);
            fr.setVisible(true);
            h.check(f.isSelected(), false);
            this.repainted = false;
            f.setSelected(true);
            h.check(this.repainted, true);
            this.repainted = false;
            f.setSelected(true);
            h.check(this.repainted, false);
            this.repainted = false;
            f.setSelected(false);
            h.check(this.repainted, true);
            this.repainted = false;
            f.setSelected(false);
            h.check(this.repainted, false);
        }
        catch (PropertyVetoException ex) {
            h.fail("PropertyVetoException");
        }
        finally {
            if (fr != null) {
                fr.dispose();
            }
        }
    }

    private void testBoundProperty(TestHarness h) {
        h.checkPoint("testBoundProperty");
        JInternalFrame t = new JInternalFrame();
        t.addPropertyChangeListener(new TestPropertyChangeHandler());
        try {
            JFrame fr = new JFrame();
            fr.getContentPane().add(t);
            fr.setSize(100, 100);
            fr.setVisible(true);
            t.setVisible(true);
            t.setSelected(false);
            this.propertyChanged = null;
            t.setSelected(true);
            h.check(this.propertyChanged, (Object)"selected");
        }
        catch (PropertyVetoException ex) {
            h.fail(ex.getMessage());
        }
    }

    class TestPropertyChangeHandler
    implements PropertyChangeListener {
        TestPropertyChangeHandler() {
        }

        @Override
        public void propertyChange(PropertyChangeEvent e) {
            setSelected.this.propertyChanged = e.getPropertyName();
        }
    }

    class TestInternalFrame
    extends JInternalFrame {
        TestInternalFrame() {
        }

        @Override
        public void repaint(long t, int x, int y, int w, int h) {
            super.repaint(t, x, y, w, h);
            setSelected.this.repainted = true;
        }
    }
}

