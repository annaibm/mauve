/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DecimalFormat;

public class setGroupingSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DecimalFormat f1 = new DecimalFormat();
        f1.setGroupingSize(5);
        harness.check(f1.getGroupingSize(), 5);
        f1.setGroupingSize(0);
        harness.check(f1.getGroupingSize(), 0);
        f1.setGroupingSize(-1);
        harness.check(f1.getGroupingSize(), -1);
        f1.setGroupingSize(300);
        harness.check(f1.getGroupingSize(), 44);
    }
}

