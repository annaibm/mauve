/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JComponent.TestComponent;
import javax.swing.plaf.ComponentUI;

public class setUI
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testRepaint(harness);
        this.testRevalidate(harness);
    }

    private void testRepaint(TestHarness harness) {
        TestComponent c = new TestComponent();
        ComponentUI u1 = new ComponentUI(){};
        ComponentUI u2 = new ComponentUI(){};
        c.setBounds(10, 20, 30, 40);
        c.setUI(u1);
        c.repaintCalled = false;
        c.setUI(u2);
        harness.check(c.repaintCalled, true);
        c.repaintCalled = false;
        c.setUI(u2);
        harness.check(c.repaintCalled, true);
        c.repaintCalled = false;
        c.setUI(u1);
        harness.check(c.repaintCalled, true);
        c.repaintCalled = false;
        c.setUI(u1);
        harness.check(c.repaintCalled, true);
    }

    private void testRevalidate(TestHarness harness) {
        TestComponent c = new TestComponent();
        ComponentUI u1 = new ComponentUI(){};
        ComponentUI u2 = new ComponentUI(){};
        c.setUI(u1);
        c.revalidateCalled = false;
        c.setUI(u2);
        harness.check(c.revalidateCalled, true);
        c.revalidateCalled = false;
        c.setUI(u2);
        harness.check(c.revalidateCalled, true);
        c.revalidateCalled = false;
        c.setUI(u1);
        harness.check(c.revalidateCalled, true);
        c.revalidateCalled = false;
        c.setUI(u1);
        harness.check(c.revalidateCalled, true);
    }
}

