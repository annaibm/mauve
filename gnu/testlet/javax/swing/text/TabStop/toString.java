/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.TabStop;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.TabStop;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TabStop ts1 = new TabStop(1.0f);
        harness.check(ts1.toString(), (Object)"tab @1.0");
        ts1 = new TabStop(2.0f, 1, 5);
        harness.check(ts1.toString(), (Object)"right tab @2.0 (w/leaders)");
        ts1 = new TabStop(10.999f, 2, 2);
        harness.check(ts1.toString(), (Object)"center tab @10.999 (w/leaders)");
        ts1 = new TabStop(3.3f, 5, 0);
        harness.check(ts1.toString(), (Object)"bar tab @3.3");
        ts1 = new TabStop(3.3f, 4, 3);
        harness.check(ts1.toString(), (Object)"decimal tab @3.3 (w/leaders)");
        ts1 = new TabStop(3.3f, 99, 666);
        harness.check(ts1.toString(), (Object)"tab @3.3 (w/leaders)");
    }
}

