/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.StringBuffer.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringBuffer o = new StringBuffer("xyzzy");
        Class<StringBuffer> c = o.getClass();
        harness.check(c.isAssignableFrom(StringBuffer.class));
    }
}

