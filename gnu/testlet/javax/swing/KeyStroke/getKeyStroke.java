/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.KeyStroke;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.KeyStroke;

public class getKeyStroke
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        KeyStroke ks;
        harness.checkPoint("Calling with unknown string should return 'null'");
        try {
            ks = KeyStroke.getKeyStroke("bad");
            harness.check(ks == null);
        }
        catch (Throwable t) {
            harness.check(false);
        }
        try {
            ks = KeyStroke.getKeyStroke(null);
            harness.check(ks == null);
        }
        catch (Throwable t) {
            harness.check(false);
        }
    }
}

