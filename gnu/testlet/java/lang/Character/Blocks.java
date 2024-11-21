/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Character;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class Blocks
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Character.UnicodeBlock.of('\u2191'), Character.UnicodeBlock.ARROWS);
    }
}

