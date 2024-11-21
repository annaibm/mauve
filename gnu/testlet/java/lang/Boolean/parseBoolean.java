/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Boolean;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class parseBoolean
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Boolean.parseBoolean("true"), true);
        harness.check(Boolean.parseBoolean("false"), false);
        harness.check(Boolean.parseBoolean("TRUE"), true);
        harness.check(Boolean.parseBoolean("FALSE"), false);
        harness.check(Boolean.parseBoolean("True"), true);
        harness.check(Boolean.parseBoolean("False"), false);
        harness.check(Boolean.parseBoolean("truE"), true);
        harness.check(Boolean.parseBoolean("falsE"), false);
        harness.check(Boolean.parseBoolean(" true"), false);
        harness.check(Boolean.parseBoolean(" false"), false);
        harness.check(Boolean.parseBoolean(" true "), false);
        harness.check(Boolean.parseBoolean(" false "), false);
    }
}

