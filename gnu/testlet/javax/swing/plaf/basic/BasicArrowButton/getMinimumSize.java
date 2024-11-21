/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicArrowButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import javax.swing.plaf.basic.BasicArrowButton;

public class getMinimumSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BasicArrowButton b = new BasicArrowButton(1);
        harness.check(b.getMinimumSize(), new Dimension(5, 5));
        b.setMinimumSize(new Dimension(12, 34));
        harness.check(b.getMinimumSize(), new Dimension(5, 5));
        Dimension m = b.getMinimumSize();
        m.setSize(1, 2);
        harness.check(b.getMinimumSize(), new Dimension(5, 5));
    }
}

