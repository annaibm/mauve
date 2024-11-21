/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JViewport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JViewport.TestViewport;
import javax.swing.JComponent;

public class setView
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testRepaint(harness);
        this.testRevalidate(harness);
    }

    private void testRepaint(TestHarness harness) {
        JComponent c1 = new JComponent(){};
        JComponent c2 = new JComponent(){};
        TestViewport c = new TestViewport();
        c.setView(null);
        c.repaintCalled = false;
        c.setView(c1);
        harness.check(c.repaintCalled, true);
        c.repaintCalled = false;
        c.setView(c1);
        harness.check(c.repaintCalled, true);
        c.repaintCalled = false;
        c.setView(c2);
        harness.check(c.repaintCalled, true);
        c.repaintCalled = false;
        c.setView(c2);
        harness.check(c.repaintCalled, true);
    }

    private void testRevalidate(TestHarness harness) {
        JComponent c1 = new JComponent(){};
        JComponent c2 = new JComponent(){};
        TestViewport c = new TestViewport();
        c.setView(null);
        c.revalidateCalled = false;
        c.setView(c1);
        harness.check(c.revalidateCalled, true);
        c.revalidateCalled = false;
        c.setView(c1);
        harness.check(c.revalidateCalled, true);
        c.revalidateCalled = false;
        c.setView(c2);
        harness.check(c.revalidateCalled, true);
        c.revalidateCalled = false;
        c.setView(c2);
        harness.check(c.revalidateCalled, true);
    }
}

