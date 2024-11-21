/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JLayeredPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class setPosition
implements Testlet {
    boolean addImplCalled;

    @Override
    public void test(TestHarness harness) {
        this.testAddImpl(harness);
    }

    private void testAddImpl(TestHarness h) {
        TestLayeredPane l = new TestLayeredPane();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        l.add(p1);
        l.add(p2);
        l.add(p3);
        this.addImplCalled = false;
        l.setPosition(p2, 0);
        h.check(this.addImplCalled, false);
    }

    class TestLayeredPane
    extends JLayeredPane {
        TestLayeredPane() {
        }

        @Override
        protected void addImpl(Component comp, Object constraint, int index) {
            super.addImpl(comp, constraint, index);
            setPosition.this.addImplCalled = true;
        }
    }
}

