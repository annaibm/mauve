/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSplitPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JSplitPane.MyJSplitPane;

public class paramString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyJSplitPane s = new MyJSplitPane();
        harness.check(s.paramString().endsWith(",continuousLayout=false,dividerSize=10,lastDividerLocation=0,oneTouchExpandable=false,orientation=HORIZONTAL_SPLIT"));
        s.setOrientation(0);
        harness.check(s.paramString().endsWith(",continuousLayout=false,dividerSize=10,lastDividerLocation=0,oneTouchExpandable=false,orientation=VERTICAL_SPLIT"));
    }
}

