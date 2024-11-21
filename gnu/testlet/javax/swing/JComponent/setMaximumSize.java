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

public class setMaximumSize
implements Testlet,
PropertyChangeListener {
    PropertyChangeEvent event;

    @Override
    public void test(TestHarness harness) {
        this.testGeneral(harness);
        this.testPropertyChangeEvent(harness);
        this.testRepaint(harness);
        this.testRevalidate(harness);
    }

    private void testGeneral(TestHarness harness) {
        JPanel c = new JPanel();
        harness.check(c.getMaximumSize(), new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
        Dimension d = new Dimension(123, 456);
        c.setMaximumSize(d);
        harness.check(c.getMaximumSize(), d);
        harness.check(c.getMaximumSize() != d);
        c.setMaximumSize(null);
        harness.check(c.getMaximumSize(), new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
    }

    private void testPropertyChangeEvent(TestHarness harness) {
        JPanel c = new JPanel();
        c.addPropertyChangeListener(this);
        c.setMaximumSize(new Dimension(1, 2));
        harness.check(this.event.getPropertyName(), (Object)"maximumSize");
        harness.check(this.event.getOldValue(), null);
        harness.check(this.event.getNewValue(), new Dimension(1, 2));
        this.event = null;
        c.setMaximumSize(null);
        harness.check(this.event.getOldValue(), new Dimension(1, 2));
        harness.check(this.event.getNewValue(), null);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.event = e;
    }

    private void testRepaint(TestHarness harness) {
        Dimension s1 = new Dimension(100, 100);
        Dimension s2 = new Dimension(200, 200);
        TestComponent c = new TestComponent();
        c.setMaximumSize(s1);
        c.repaintCalled = false;
        c.setMaximumSize(s2);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setMaximumSize(s2);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setMaximumSize(s1);
        harness.check(c.repaintCalled, false);
        c.repaintCalled = false;
        c.setMaximumSize(s1);
        harness.check(c.repaintCalled, false);
    }

    private void testRevalidate(TestHarness harness) {
        Dimension s1 = new Dimension(100, 100);
        Dimension s2 = new Dimension(200, 200);
        TestComponent c = new TestComponent();
        c.setMaximumSize(s1);
        c.revalidateCalled = false;
        c.setMaximumSize(s2);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setMaximumSize(s2);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setMaximumSize(s1);
        harness.check(c.revalidateCalled, false);
        c.revalidateCalled = false;
        c.setMaximumSize(s1);
        harness.check(c.revalidateCalled, false);
    }
}

