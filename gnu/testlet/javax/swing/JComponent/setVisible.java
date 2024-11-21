/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JComponent.TestComponent;
import javax.swing.JFrame;

public class setVisible
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testRepaint(harness);
        this.testRepaintNotShowing(harness);
        this.testRevalidate(harness);
    }

    private void testRepaint(TestHarness harness) {
        TestComponent c = new TestComponent();
        JFrame f = new JFrame();
        f.getContentPane().add(c);
        f.setSize(200, 200);
        f.setVisible(true);
        c.setBounds(10, 20, 30, 40);
        c.setVisible(false);
        c.repaintCalled = false;
        c.setVisible(true);
        harness.check(c.repaintCalled, true);
        c.repaintCalled = false;
        c.setVisible(true);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setVisible(false);
        harness.check(c.repaintCalled, true);
        c.repaintCalled = false;
        c.setVisible(false);
        harness.check(c.repaintCalled, false);
        f.dispose();
    }

    private void testRepaintNotShowing(TestHarness harness) {
        TestComponent c = new TestComponent();
        c.setVisible(false);
        c.repaintCalled = false;
        c.setVisible(true);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setVisible(true);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setVisible(false);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setVisible(false);
        harness.check(c.repaintCalled, false);
    }

    private void testRevalidate(TestHarness harness) {
        TestComponent c = new TestComponent();
        c.setBounds(10, 20, 30, 40);
        c.setVisible(false);
        c.revalidateCalled = false;
        c.setVisible(true);
        harness.check(c.revalidateCalled, true);
        c.revalidateCalled = false;
        c.setVisible(true);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setVisible(false);
        harness.check(c.revalidateCalled, true);
        c.revalidateCalled = false;
        c.setVisible(false);
        harness.check(c.revalidateCalled, false);
    }
}

