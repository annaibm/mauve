/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.FormatterClosedException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.FormatterClosedException;

public class getPackage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FormatterClosedException o = new FormatterClosedException();
        Class<?> c = o.getClass();
        Package p = c.getPackage();
        harness.check(p.getName(), (Object)"java.util");
    }
}

