/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.TabSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;

public class getTabIndex
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TabStop ts1 = new TabStop(1.0f);
        TabStop ts2 = new TabStop(2.0f);
        TabStop ts3 = new TabStop(3.0f);
        TabStop[] tabs = new TabStop[]{ts1, ts2, ts3};
        TabSet s = new TabSet(tabs);
        harness.check(s.getTabIndex(ts1), 0);
        harness.check(s.getTabIndex(ts2), 1);
        harness.check(s.getTabIndex(ts3), 2);
        harness.check(s.getTabIndex(new TabStop(2.0f)), -1);
        harness.check(s.getTabIndex(null), -1);
    }
}

