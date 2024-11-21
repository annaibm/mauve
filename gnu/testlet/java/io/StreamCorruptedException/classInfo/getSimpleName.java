/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.StreamCorruptedException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.StreamCorruptedException;

public class getSimpleName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StreamCorruptedException o = new StreamCorruptedException("xyzzy");
        Class<?> c = o.getClass();
        harness.check(c.getSimpleName(), (Object)"StreamCorruptedException");
    }
}

