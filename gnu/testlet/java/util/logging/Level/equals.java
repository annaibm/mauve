/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Level;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.util.logging.Level.TestUtils;
import java.util.logging.Level;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness h) {
        TestUtils.CustomLevel l1 = new TestUtils.CustomLevel("CUSTOM_TEST_LEVEL", Level.WARNING.intValue());
        TestUtils.CustomLevel l2 = new TestUtils.CustomLevel("CUSTOM_TEST_LEVEL", Level.WARNING.intValue());
        h.check(!Level.WARNING.equals(null));
        h.check(Level.WARNING.equals(Level.WARNING));
        h.check(!Level.WARNING.equals(Level.INFO));
        h.check(Level.WARNING.equals(l1));
        h.check(Level.WARNING.equals(l2));
        h.check(l1.equals(Level.WARNING));
        h.check(l2.equals(Level.WARNING));
    }
}

