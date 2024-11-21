/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.beancontext.BeanContextSupport;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.beancontext.BeanContextSupport;

public class setDesignTime
implements Testlet,
PropertyChangeListener {
    PropertyChangeEvent lastEvent;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.lastEvent = evt;
    }

    @Override
    public void test(TestHarness harness) {
        BeanContextSupport bcs = new BeanContextSupport();
        bcs.addPropertyChangeListener("designTime", this);
        harness.check(bcs.isDesignTime(), false);
        bcs.setDesignTime(true);
        harness.check(this.lastEvent, null);
        bcs.addPropertyChangeListener("designMode", this);
        bcs.setDesignTime(false);
        harness.check(this.lastEvent.getPropertyName(), (Object)"designMode");
        harness.check(this.lastEvent.getNewValue(), Boolean.FALSE);
        harness.check(this.lastEvent.getOldValue(), Boolean.TRUE);
        harness.check(this.lastEvent.getSource(), bcs);
    }
}

