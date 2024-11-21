/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.UnsupportedClassVersionError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UnsupportedClassVersionError o = new UnsupportedClassVersionError("UnsupportedClassVersionError");
        Class<UnsupportedClassVersionError> c = o.getClass();
        harness.check(c.isAssignableFrom(UnsupportedClassVersionError.class));
    }
}

