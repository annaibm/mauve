/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.IOException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IOException o = new IOException("xyzzy");
        Class<IOException> c = o.getClass();
        harness.check(c.isAssignableFrom(IOException.class));
    }
}

