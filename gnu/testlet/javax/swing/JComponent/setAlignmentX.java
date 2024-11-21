/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JComponent.TestComponent;

public class setAlignmentX
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testRepaint(harness);
        this.testRevalidate(harness);
    }

    private void testRepaint(TestHarness harness) {
        TestComponent c = new TestComponent();
        c.setAlignmentX(0.0f);
        c.repaintCalled = false;
        c.setAlignmentX(0.5f);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setAlignmentX(0.5f);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setAlignmentX(1.0f);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setAlignmentX(1.0f);
        harness.check(c.repaintCalled, false);
    }

    private void testRevalidate(TestHarness harness) {
        TestComponent c = new TestComponent();
        c.setAlignmentX(0.0f);
        c.revalidateCalled = false;
        c.setAlignmentX(0.5f);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setAlignmentX(0.5f);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setAlignmentX(1.0f);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setAlignmentX(1.0f);
        harness.check(c.revalidateCalled, false);
    }
}

