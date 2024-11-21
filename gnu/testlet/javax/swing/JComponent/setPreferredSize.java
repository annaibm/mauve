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

public class setPreferredSize
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
        harness.check(c.getPreferredSize(), new Dimension(10, 10));
        Dimension d = new Dimension(123, 456);
        c.setPreferredSize(d);
        harness.check(c.getPreferredSize(), d);
        harness.check(c.getPreferredSize() != d);
        c.setPreferredSize(null);
        harness.check(c.getPreferredSize(), new Dimension(10, 10));
    }

    private void testPropertyChangeEvent(TestHarness harness) {
        JPanel c = new JPanel();
        c.addPropertyChangeListener(this);
        c.setPreferredSize(new Dimension(1, 2));
        harness.check(this.event.getPropertyName(), (Object)"preferredSize");
        harness.check(this.event.getOldValue(), null);
        harness.check(this.event.getNewValue(), new Dimension(1, 2));
        this.event = null;
        c.setPreferredSize(null);
        harness.check(this.event.getOldValue(), new Dimension(1, 2));
        harness.check(this.event.getNewValue(), null);
        this.event = null;
        c.setPreferredSize(null);
        harness.check(this.event.getOldValue(), null);
        harness.check(this.event.getNewValue(), null);
        c.setPreferredSize(new Dimension(12, 34));
        this.event = null;
        c.setPreferredSize(new Dimension(12, 34));
        harness.check(this.event, null);
    }

    private void testRepaint(TestHarness harness) {
        Dimension s1 = new Dimension(100, 100);
        Dimension s2 = new Dimension(200, 200);
        TestComponent c = new TestComponent();
        c.setPreferredSize(s1);
        c.repaintCalled = false;
        c.setPreferredSize(s2);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setPreferredSize(s2);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setPreferredSize(s1);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setPreferredSize(s1);
        harness.check(c.repaintCalled, false);
    }

    private void testRevalidate(TestHarness harness) {
        Dimension s1 = new Dimension(100, 100);
        Dimension s2 = new Dimension(200, 200);
        TestComponent c = new TestComponent();
        c.setPreferredSize(s1);
        c.revalidateCalled = false;
        c.setPreferredSize(s2);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setPreferredSize(s2);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setPreferredSize(s1);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setPreferredSize(s1);
        harness.check(c.revalidateCalled, false);
    }
}

