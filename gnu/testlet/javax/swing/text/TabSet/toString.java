/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.TabSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TabSet s = new TabSet(null);
        harness.check(s.toString(), (Object)"[  ]");
        s = new TabSet(new TabStop[0]);
        harness.check(s.toString(), (Object)"[  ]");
        s = new TabSet(new TabStop[]{new TabStop(1.0f)});
        harness.check(s.toString(), (Object)"[ tab @1.0 ]");
        s = new TabSet(new TabStop[]{new TabStop(1.0f), new TabStop(2.0f)});
        harness.check(s.toString(), (Object)"[ tab @1.0 - tab @2.0 ]");
    }
}

