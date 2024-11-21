/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JInternalFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JInternalFrame;

public class setMaximizable
implements Testlet {
    String propertyChanged;

    @Override
    public void test(TestHarness harness) {
        this.testBoundProperty(harness);
    }

    private void testBoundProperty(TestHarness h) {
        h.checkPoint("testBoundProperty");
        JInternalFrame t = new JInternalFrame();
        t.addPropertyChangeListener(new TestPropertyChangeHandler());
        t.setMaximizable(false);
        this.propertyChanged = null;
        t.setMaximizable(true);
        h.check(this.propertyChanged, (Object)"maximizable");
    }

    class TestPropertyChangeHandler
    implements PropertyChangeListener {
        TestPropertyChangeHandler() {
        }

        @Override
        public void propertyChange(PropertyChangeEvent e) {
            setMaximizable.this.propertyChanged = e.getPropertyName();
        }
    }
}

