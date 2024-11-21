/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicArrowButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.plaf.basic.BasicArrowButton;

public class isFocusable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BasicArrowButton b = new BasicArrowButton(0);
        harness.check(b.isFocusable(), false);
    }
}

