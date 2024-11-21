/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JComponent.TestComponent;

public class setOpaque
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testRepaint(harness);
        this.testRevalidate(harness);
    }

    private void testRepaint(TestHarness harness) {
        TestComponent c = new TestComponent();
        c.setOpaque(false);
        c.repaintCalled = false;
        c.setOpaque(true);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setOpaque(true);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setOpaque(false);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setOpaque(false);
        harness.check(c.repaintCalled, false);
    }

    private void testRevalidate(TestHarness harness) {
        TestComponent c = new TestComponent();
        c.setOpaque(false);
        c.revalidateCalled = false;
        c.setOpaque(true);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setOpaque(true);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setOpaque(false);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setOpaque(false);
        harness.check(c.revalidateCalled, false);
    }
}

