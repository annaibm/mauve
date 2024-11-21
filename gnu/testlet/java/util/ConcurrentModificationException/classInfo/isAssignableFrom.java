/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.ConcurrentModificationException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ConcurrentModificationException;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ConcurrentModificationException o = new ConcurrentModificationException("ConcurrentModificationException");
        Class<ConcurrentModificationException> c = o.getClass();
        harness.check(c.isAssignableFrom(ConcurrentModificationException.class));
    }
}

