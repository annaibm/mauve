/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JComponent.TestComponent;
import java.awt.Font;

public class setFont
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testRepaint(harness);
        this.testRevalidate(harness);
    }

    private void testRepaint(TestHarness harness) {
        Font f1 = new Font("Dialog", 0, 12);
        Font f2 = new Font("Dialog", 0, 14);
        TestComponent c = new TestComponent();
        c.setFont(f1);
        c.repaintCalled = false;
        c.setFont(f2);
        harness.check(c.repaintCalled, true);
        c.repaintCalled = false;
        c.setFont(f2);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setFont(f1);
        harness.check(c.repaintCalled, true);
        c.repaintCalled = false;
        c.setFont(f1);
        harness.check(c.repaintCalled, false);
    }

    private void testRevalidate(TestHarness harness) {
        Font f1 = new Font("Dialog", 0, 12);
        Font f2 = new Font("Dialog", 0, 14);
        TestComponent c = new TestComponent();
        c.setFont(f1);
        c.revalidateCalled = false;
        c.setFont(f2);
        harness.check(c.revalidateCalled, true);
        c.revalidateCalled = false;
        c.setFont(f2);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setFont(f1);
        harness.check(c.revalidateCalled, true);
        c.revalidateCalled = false;
        c.setFont(f1);
        harness.check(c.revalidateCalled, false);
    }
}

