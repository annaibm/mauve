/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.UnsupportedEncodingException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.UnsupportedEncodingException;

public class isPrimitive
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UnsupportedEncodingException o = new UnsupportedEncodingException("xyzzy");
        Class<?> c = o.getClass();
        harness.check(!c.isPrimitive());
    }
}

