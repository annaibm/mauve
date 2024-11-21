/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicArrowButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.plaf.basic.BasicArrowButton;

public class isFocusTraversable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BasicArrowButton b = new BasicArrowButton(1);
        harness.check(b.isFocusTraversable(), false);
    }
}

