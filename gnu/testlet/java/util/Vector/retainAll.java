/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Vector;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Vector;

public class retainAll
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testNull(harness);
    }

    private void testNull(TestHarness h) {
        Vector<Object> v = new Vector<Object>();
        v.removeAll(null);
        h.check(true);
        v.add(new Object());
        try {
            v.retainAll(null);
            h.fail("NPE should be thrown");
        }
        catch (NullPointerException ex) {
            h.check(true);
        }
    }
}

