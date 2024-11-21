/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Component;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.awt.Frame;

public class isValid
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testShowing(harness);
        this.testNotShowing(harness);
    }

    private void testShowing(TestHarness h) {
        h.checkPoint("showing");
        Frame f = new Frame();
        Component c = new Component(){};
        f.add(c);
        f.setSize(100, 100);
        f.setVisible(true);
        c.invalidate();
        h.check(!c.isValid());
        c.validate();
        h.check(c.isValid());
    }

    private void testNotShowing(TestHarness h) {
        h.checkPoint("notShowing");
        Component c = new Component(){};
        c.invalidate();
        h.check(!c.isValid());
        c.validate();
        h.check(!c.isValid());
    }
}

