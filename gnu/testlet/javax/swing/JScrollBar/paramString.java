/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JScrollBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JScrollBar.MyJScrollBar;

public class paramString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyJScrollBar scrollBar = new MyJScrollBar();
        harness.check(scrollBar.paramString().endsWith(",blockIncrement=10,orientation=VERTICAL,unitIncrement=1"));
    }
}

