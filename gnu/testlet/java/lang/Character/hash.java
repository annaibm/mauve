/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Character;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class hash
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Character a = new Character('\uffda');
        Character b = new Character('Z');
        harness.check(a.hashCode(), 65498);
        harness.check(b.hashCode(), 90);
    }
}

