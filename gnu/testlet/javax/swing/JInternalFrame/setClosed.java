/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JInternalFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;

public class setClosed
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
        try {
            t.setClosed(false);
            this.propertyChanged = null;
            t.setClosed(true);
            h.check(this.propertyChanged, (Object)"closed");
        }
        catch (PropertyVetoException ex) {
            h.fail(ex.getMessage());
        }
    }

    class TestPropertyChangeHandler
    implements PropertyChangeListener {
        TestPropertyChangeHandler() {
        }

        @Override
        public void propertyChange(PropertyChangeEvent e) {
            setClosed.this.propertyChanged = e.getPropertyName();
        }
    }
}

