/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JComponent.TestComponent;

public class setEnabled
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testRepaint(harness);
        this.testRevalidate(harness);
    }

    private void testRepaint(TestHarness harness) {
        TestComponent c = new TestComponent();
        c.setBounds(10, 20, 30, 40);
        c.setEnabled(false);
        c.repaintCalled = false;
        c.setEnabled(true);
        harness.check(c.repaintCalled, true);
        c.repaintCalled = false;
        c.setEnabled(true);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setEnabled(false);
        harness.check(c.repaintCalled, true);
        c.repaintCalled = false;
        c.setEnabled(false);
        harness.check(c.repaintCalled, false);
    }

    private void testRevalidate(TestHarness harness) {
        TestComponent c = new TestComponent();
        c.setBounds(10, 20, 30, 40);
        c.setEnabled(false);
        c.revalidateCalled = false;
        c.setEnabled(true);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setEnabled(true);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setEnabled(false);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setEnabled(false);
        harness.check(c.revalidateCalled, false);
    }
}

