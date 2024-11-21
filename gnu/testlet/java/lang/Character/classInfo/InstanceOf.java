/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Character.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Character o = new Character('!');
        harness.check(o instanceof Character);
        harness.check(o instanceof Object);
    }
}

