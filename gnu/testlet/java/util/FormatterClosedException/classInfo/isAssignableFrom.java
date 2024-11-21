/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.FormatterClosedException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.FormatterClosedException;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FormatterClosedException o = new FormatterClosedException();
        Class<FormatterClosedException> c = o.getClass();
        harness.check(c.isAssignableFrom(FormatterClosedException.class));
    }
}

