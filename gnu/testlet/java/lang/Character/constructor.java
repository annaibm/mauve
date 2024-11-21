/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Character;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Character object1 = new Character('a');
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"a");
        Character object2 = new Character(' ');
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)" ");
        Character object3 = new Character('\n');
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"\n");
    }
}

