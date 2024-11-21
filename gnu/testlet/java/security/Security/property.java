/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.Security;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.Security;

public class property
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String key = "Mauve-Key-test-prop";
        String value2 = key + "-value";
        harness.check(Security.getProperty(key), null);
        Security.setProperty(key, value2);
        harness.check(Security.getProperty(key), (Object)value2);
        Security.setProperty(key, null);
        harness.check(Security.getProperty(key), null);
    }
}

