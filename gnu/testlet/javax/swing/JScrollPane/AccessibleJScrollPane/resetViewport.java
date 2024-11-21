/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JScrollPane.AccessibleJScrollPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;
import java.beans.PropertyChangeEvent;
import javax.accessibility.AccessibleContext;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

public class resetViewport
implements Testlet {
    static boolean resetViewPortCalled;

    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
    }

    void test1(TestHarness harness) {
        TestScrollPane sp = new TestScrollPane();
        JViewport vp = sp.getViewport();
        vp.setView(new JLabel("Hello World"));
        TestScrollPane.TestAccessibleScrollPane asp = (TestScrollPane.TestAccessibleScrollPane)((JScrollPane)sp).getAccessibleContext();
        vp.setViewPosition(new Point(10, 10));
        harness.check(vp.getViewPosition().equals(new Point(0, 0)), false);
        asp.resetViewPort();
        harness.check(vp.getViewPosition().equals(new Point(0, 0)), false);
    }

    void test2(TestHarness harness) {
        TestScrollPane sp = new TestScrollPane();
        TestScrollPane.TestAccessibleScrollPane asp = (TestScrollPane.TestAccessibleScrollPane)((JScrollPane)sp).getAccessibleContext();
        resetViewPortCalled = false;
        asp.propertyChange(new PropertyChangeEvent(sp, "viewport", sp.getViewport(), new JViewport()));
        harness.check(resetViewPortCalled, false);
    }

    void test3(TestHarness harness) {
        TestScrollPane sp = new TestScrollPane();
        TestScrollPane.TestAccessibleScrollPane asp = (TestScrollPane.TestAccessibleScrollPane)((JScrollPane)sp).getAccessibleContext();
        resetViewPortCalled = false;
        sp.setViewport(new JViewport());
        harness.check(resetViewPortCalled, true);
    }

    static class TestScrollPane
    extends JScrollPane {
        TestScrollPane() {
        }

        @Override
        public AccessibleContext getAccessibleContext() {
            if (this.accessibleContext == null) {
                this.accessibleContext = new TestAccessibleScrollPane();
            }
            return this.accessibleContext;
        }

        class TestAccessibleScrollPane
        extends JScrollPane.AccessibleJScrollPane {
            TestAccessibleScrollPane() {
                super(TestScrollPane.this);
            }

            @Override
            public void resetViewPort() {
                resetViewPortCalled = true;
                super.resetViewPort();
            }
        }
    }
}

