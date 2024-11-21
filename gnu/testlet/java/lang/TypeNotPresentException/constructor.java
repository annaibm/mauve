/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.TypeNotPresentException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TypeNotPresentException object1 = new TypeNotPresentException("java.lang.TypeNotPresentException", new Throwable());
        harness.check(object1 != null);
        harness.check(object1.toString() != null);
    }
}

