/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JComponent.TestComponent;
import javax.swing.border.EtchedBorder;

public class setBorder
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testRepaint(harness);
        this.testRevalidate(harness);
    }

    private void testRepaint(TestHarness harness) {
        EtchedBorder b1 = new EtchedBorder();
        EtchedBorder b2 = new EtchedBorder();
        TestComponent c = new TestComponent();
        c.setBorder(b1);
        c.repaintCalled = false;
        c.setBorder(b2);
        harness.check(c.repaintCalled, true);
        c.repaintCalled = false;
        c.setBorder(b2);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setBorder(b1);
        harness.check(c.repaintCalled, true);
        c.repaintCalled = false;
        c.setBorder(b1);
        harness.check(c.repaintCalled, false);
    }

    private void testRevalidate(TestHarness harness) {
        EtchedBorder b1 = new EtchedBorder();
        EtchedBorder b2 = new EtchedBorder();
        TestComponent c = new TestComponent();
        c.setBounds(10, 20, 30, 40);
        c.setBorder(b1);
        c.revalidateCalled = false;
        c.setBorder(b2);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setBorder(b2);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setBorder(b1);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setBorder(b1);
        harness.check(c.revalidateCalled, false);
    }
}

