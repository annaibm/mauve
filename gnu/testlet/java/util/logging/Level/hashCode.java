/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Level;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.util.logging.Level.TestUtils;
import java.util.logging.Level;

public class hashCode
implements Testlet {
    @Override
    public void test(TestHarness h) {
        TestUtils.CustomLevel l1 = new TestUtils.CustomLevel("CUSTOM_TEST_LEVEL", Level.WARNING.intValue());
        TestUtils.CustomLevel l2 = new TestUtils.CustomLevel("CUSTOM_TEST_LEVEL", Level.WARNING.intValue());
        h.check(l1.hashCode(), Level.WARNING.hashCode());
        h.check(l2.hashCode(), Level.WARNING.hashCode());
    }
}

