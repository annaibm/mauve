/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.TabStop;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.TabStop;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("(float)");
        TabStop ts1 = new TabStop(1.0f);
        harness.check(ts1.getPosition(), 1.0);
        harness.check(ts1.getAlignment(), 0);
        harness.check(ts1.getLeader(), 0);
        ts1 = new TabStop(-1.0f);
        harness.check(ts1.getPosition(), -1.0);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(float, int, int)");
        TabStop ts1 = new TabStop(1.0f, 4, 1);
        harness.check(ts1.getPosition(), 1.0);
        harness.check(ts1.getAlignment(), 4);
        harness.check(ts1.getLeader(), 1);
        ts1 = new TabStop(1.0f, 99, 1);
        harness.check(ts1.getPosition(), 1.0);
        harness.check(ts1.getAlignment(), 99);
        harness.check(ts1.getLeader(), 1);
        ts1 = new TabStop(1.0f, 4, 99);
        harness.check(ts1.getPosition(), 1.0);
        harness.check(ts1.getAlignment(), 4);
        harness.check(ts1.getLeader(), 99);
    }
}

