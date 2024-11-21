/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JProgressBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JProgressBar.MyJProgressBar;

public class paramString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyJProgressBar p = new MyJProgressBar();
        harness.check(p.paramString().endsWith(",orientation=HORIZONTAL,paintBorder=true,paintString=false,progressString=,indeterminateString=false"));
    }
}

