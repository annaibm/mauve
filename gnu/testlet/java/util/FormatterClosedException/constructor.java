/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.FormatterClosedException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.FormatterClosedException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FormatterClosedException object1 = new FormatterClosedException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.util.FormatterClosedException");
    }
}

