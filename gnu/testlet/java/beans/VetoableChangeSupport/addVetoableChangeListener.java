/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.VetoableChangeSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

public class addVetoableChangeListener
implements Testlet,
VetoableChangeListener {
    @Override
    public void vetoableChange(PropertyChangeEvent e) throws PropertyVetoException {
    }

    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
    }

    public void testMethod1(TestHarness harness) {
        harness.checkPoint("(VetoableChangeListener)");
        VetoableChangeSupport vcs = new VetoableChangeSupport(this);
        harness.check(vcs.getVetoableChangeListeners().length, 0);
        vcs.addVetoableChangeListener(this);
        harness.check(vcs.getVetoableChangeListeners().length, 1);
        vcs.addVetoableChangeListener(null);
        harness.check(vcs.getVetoableChangeListeners().length, 1);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(String, VetoableChangeListener)");
        VetoableChangeSupport vcs = new VetoableChangeSupport(this);
        harness.check(vcs.getVetoableChangeListeners().length, 0);
        vcs.addVetoableChangeListener("A", this);
        vcs.addVetoableChangeListener("B", this);
        harness.check(vcs.getVetoableChangeListeners().length, 2);
        harness.check(vcs.getVetoableChangeListeners("A").length, 1);
        harness.check(vcs.getVetoableChangeListeners("B").length, 1);
        vcs.addVetoableChangeListener("B", null);
        harness.check(vcs.getVetoableChangeListeners().length, 2);
        harness.check(vcs.getVetoableChangeListeners("B").length, 1);
        vcs.addVetoableChangeListener(null, this);
        harness.check(vcs.getVetoableChangeListeners().length, 2);
        harness.check(vcs.getVetoableChangeListeners("A").length, 1);
        harness.check(vcs.getVetoableChangeListeners("B").length, 1);
    }
}

