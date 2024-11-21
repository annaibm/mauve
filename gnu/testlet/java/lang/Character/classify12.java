/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Character;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class classify12
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Character.isUpperCase('\u2102'));
    }
}

