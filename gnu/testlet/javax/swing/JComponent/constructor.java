/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JComponent;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JComponent c = new JComponent(){};
        harness.check(c.getLayout(), null);
    }
}

