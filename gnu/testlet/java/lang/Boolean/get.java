/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Boolean;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Properties;

public class get
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Properties p = System.getProperties();
        p.put("e1", "true");
        p.put("e2", "false");
        harness.check(Boolean.getBoolean("e1"));
        harness.check(!Boolean.getBoolean("e2"));
        harness.check(!Boolean.getBoolean("e3"));
    }
}

