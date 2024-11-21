/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JLayeredPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JLayeredPane;

public class defaultLayoutManager
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JLayeredPane lp = new JLayeredPane();
        harness.check(lp.getLayout(), null);
    }
}

