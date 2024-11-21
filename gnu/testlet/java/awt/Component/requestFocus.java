/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Component;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Frame;

public class requestFocus
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        Frame jf = new Frame();
        jf.show();
        try {
            jf.requestFocus();
        }
        catch (NullPointerException npe) {
            harness.fail("Call to requestFocus generated a NPE");
        }
        finally {
            jf.dispose();
        }
    }
}

