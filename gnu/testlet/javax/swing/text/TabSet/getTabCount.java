/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.TabSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;

public class getTabCount
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TabStop ts1 = new TabStop(1.0f);
        TabStop ts2 = new TabStop(2.0f);
        TabStop ts3 = new TabStop(3.0f);
        TabStop[] tabs = new TabStop[]{ts1, ts2, ts3};
        TabSet s = new TabSet(tabs);
        harness.check(s.getTabCount(), 3);
        harness.check(new TabSet(null).getTabCount(), 0);
    }
}

