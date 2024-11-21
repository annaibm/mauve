/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class replaceAll
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String result = "Test #".replaceAll("#", "\\\\n");
        harness.check(result, "Test \\n", result);
    }
}

