/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JComponent.TestComponent;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;

public class setMinimumSize
implements Testlet,
PropertyChangeListener {
    PropertyChangeEvent event;

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        this.event = event;
    }

    @Override
    public void test(TestHarness harness) {
        this.testGeneral(harness);
        this.testPropertyChangeEvent(harness);
        this.testRepaint(harness);
        this.testRevalidate(harness);
    }

    private void testGeneral(TestHarness harness) {
        JPanel c = new JPanel();
        harness.check(c.getMinimumSize(), new Dimension(10, 10));
        Dimension d = new Dimension(123, 456);
        c.setMinimumSize(d);
        harness.check(c.getMinimumSize(), d);
        harness.check(c.getMinimumSize() != d);
        c.setMinimumSize(null);
        harness.check(c.getMinimumSize(), new Dimension(10, 10));
    }

    private void testPropertyChangeEvent(TestHarness harness) {
        JPanel c = new JPanel();
        c.addPropertyChangeListener(this);
        c.setMinimumSize(new Dimension(1, 2));
        harness.check(this.event.getPropertyName(), (Object)"minimumSize");
        harness.check(this.event.getOldValue(), null);
        harness.check(this.event.getNewValue(), new Dimension(1, 2));
        this.event = null;
        c.setMinimumSize(null);
        harness.check(this.event.getOldValue(), new Dimension(1, 2));
        harness.check(this.event.getNewValue(), null);
        this.event = null;
        c.setMinimumSize(null);
        harness.check(this.event.getOldValue(), null);
        harness.check(this.event.getNewValue(), null);
        c.setMinimumSize(new Dimension(12, 34));
        this.event = null;
        c.setMinimumSize(new Dimension(12, 34));
        harness.check(this.event, null);
    }

    private void testRepaint(TestHarness harness) {
        Dimension s1 = new Dimension(100, 100);
        Dimension s2 = new Dimension(200, 200);
        TestComponent c = new TestComponent();
        c.setMinimumSize(s1);
        c.repaintCalled = false;
        c.setMinimumSize(s2);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setMinimumSize(s2);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setMinimumSize(s1);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setMinimumSize(s1);
        harness.check(c.repaintCalled, false);
    }

    private void testRevalidate(TestHarness harness) {
        Dimension s1 = new Dimension(100, 100);
        Dimension s2 = new Dimension(200, 200);
        TestComponent c = new TestComponent();
        c.setMinimumSize(s1);
        c.revalidateCalled = false;
        c.setMinimumSize(s2);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setMinimumSize(s2);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setMinimumSize(s1);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setMinimumSize(s1);
        harness.check(c.revalidateCalled, false);
    }
}

