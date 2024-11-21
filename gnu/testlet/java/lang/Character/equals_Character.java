/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Character;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class equals_Character
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Character a = new Character('\uffda');
        Character b = new Character('Z');
        Character c = new Character('\uffda');
        Boolean d = new Boolean("true");
        harness.check(!a.equals(null));
        harness.check(!a.equals(b));
        harness.check(a.equals(c));
        harness.check(a.equals(a));
        harness.check(!b.equals(d));
    }
}

