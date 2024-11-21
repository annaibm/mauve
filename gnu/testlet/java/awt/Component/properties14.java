/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Component;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class properties14
implements Testlet {
    private String propertyName;

    @Override
    public void test(TestHarness harness) {
        TestComponent comp = new TestComponent();
        comp.addPropertyChangeListener(new PropertyChangeListener(){

            @Override
            public void propertyChange(PropertyChangeEvent ev) {
                properties14.this.propertyName = ev.getPropertyName();
            }
        });
        this.propertyName = null;
        comp.setFocusable(false);
        comp.setFocusable(true);
        harness.check(this.propertyName, "focusable", "Property: focusable");
        this.propertyName = null;
        comp.setFocusTraversalKeysEnabled(false);
        comp.setFocusTraversalKeysEnabled(true);
        harness.check(this.propertyName, "focusTraversalKeysEnabled", "Property: focusTraversalKeysEnabled");
        this.propertyName = null;
        comp.setIgnoreRepaint(false);
        comp.setIgnoreRepaint(true);
        harness.check(this.propertyName, null, "Property: ignoreRepaint");
    }

    public class TestComponent
    extends Component {
    }
}

