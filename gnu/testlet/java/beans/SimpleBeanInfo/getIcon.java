/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.beans.SimpleBeanInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.SimpleBeanInfo;

public class getIcon
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleBeanInfo i = new SimpleBeanInfo();
        harness.check(i.getIcon(1), null);
        harness.check(i.getIcon(2), null);
        harness.check(i.getIcon(3), null);
        harness.check(i.getIcon(4), null);
        harness.check(i.getIcon(-99), null);
    }
}

