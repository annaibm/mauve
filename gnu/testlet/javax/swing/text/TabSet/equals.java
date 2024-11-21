/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.TabSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TabSet tsA = new TabSet(null);
        TabSet tsB = new TabSet(null);
        harness.check(tsA.equals(tsB));
        tsA = new TabSet(new TabStop[0]);
        tsB = new TabSet(new TabStop[0]);
        harness.check(tsA.equals(tsB));
        tsA = new TabSet(new TabStop[]{new TabStop(1.0f)});
        tsB = new TabSet(new TabStop[]{new TabStop(1.0f)});
        harness.check(tsA.equals(tsB));
        tsA = new TabSet(new TabStop[]{new TabStop(1.1f, 2, 1)});
        harness.check(!tsA.equals(tsB));
        tsB = new TabSet(new TabStop[]{new TabStop(1.1f, 2, 1)});
        harness.check(tsA.equals(tsB));
        harness.check(!tsA.equals(null));
        harness.check(!tsA.equals("a string"));
    }
}

