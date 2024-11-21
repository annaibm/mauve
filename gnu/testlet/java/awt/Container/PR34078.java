/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Container;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Container;

public class PR34078
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Container c = new Container();
        harness.check(c.isAncestorOf(c), false, "Container is not its own ancestor");
    }
}

