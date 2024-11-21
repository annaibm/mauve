/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.System;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getProperty
implements Testlet {
    TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.getPropTest(null, "NullPointerException");
        this.getPropTest("", "IllegalArgumentException");
        this.getPropTest("__dummy_mauve_prop_not_set__", null);
        System.setProperty("__dummy_mauve_prop_set__", "yes");
        this.getPropTest("__dummy_mauve_prop_set__", "yes");
    }

    void getPropTest(String key, String expect) {
        String result;
        try {
            result = System.getProperty(key);
        }
        catch (NullPointerException npe) {
            result = "NullPointerException";
        }
        catch (IllegalArgumentException iae) {
            result = "IllegalArgumentException";
        }
        catch (Throwable t) {
            result = t.toString();
        }
        this.harness.check(result, expect, "'" + key + "'");
    }
}

