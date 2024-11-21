/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Level;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.util.logging.Level.TestUtils;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness h) {
        for (int i = 0; i < TestUtils.LEVELS.length; ++i) {
            h.check(TestUtils.LEVELS[i].toString(), (Object)TestUtils.NAMES[i]);
        }
    }
}

