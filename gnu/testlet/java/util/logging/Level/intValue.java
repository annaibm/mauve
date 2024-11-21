/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Level;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.util.logging.Level.TestUtils;

public class intValue
implements Testlet {
    @Override
    public void test(TestHarness h) {
        for (int i = 0; i < TestUtils.LEVELS.length; ++i) {
            h.checkPoint(TestUtils.NAMES[i]);
            h.check(TestUtils.LEVELS[i].intValue(), TestUtils.VALUES[i]);
        }
    }
}

