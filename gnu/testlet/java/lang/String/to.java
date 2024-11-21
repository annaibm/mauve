/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class to
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String b = new String(" abc\tABC 123\t");
        harness.check(b.toLowerCase(), (Object)" abc\tabc 123\t");
        harness.check(b.toUpperCase(), (Object)" ABC\tABC 123\t");
    }
}

