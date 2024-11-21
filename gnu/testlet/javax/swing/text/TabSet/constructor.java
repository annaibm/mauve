/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.TabSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TabStop ts4;
        TabStop ts1 = new TabStop(1.0f);
        TabStop ts2 = new TabStop(2.0f);
        TabStop ts3 = new TabStop(3.0f);
        TabStop[] tabs = new TabStop[]{ts1, ts2, ts3};
        TabSet s = new TabSet(tabs);
        harness.check(s.getTabCount(), 3);
        harness.check(s.getTab(0), ts1);
        harness.check(s.getTab(1), ts2);
        harness.check(s.getTab(2), ts3);
        tabs[1] = ts4 = new TabStop(4.0f);
        harness.check(s.getTab(1), ts2);
        TabStop[] tabs2 = new TabStop[]{ts1, ts3, ts2};
        TabSet s2 = new TabSet(tabs2);
        harness.check(s2.getTabCount(), 3);
        harness.check(s2.getTab(0), ts1);
        harness.check(s2.getTab(1), ts3);
        harness.check(s2.getTab(2), ts2);
        s2 = new TabSet(null);
        harness.check(s2.getTabCount(), 0);
    }
}

