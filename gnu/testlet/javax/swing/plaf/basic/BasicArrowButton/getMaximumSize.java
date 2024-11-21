/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicArrowButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import javax.swing.plaf.basic.BasicArrowButton;

public class getMaximumSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BasicArrowButton b = new BasicArrowButton(1);
        harness.check(b.getMaximumSize(), new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        b.setMaximumSize(new Dimension(12, 34));
        harness.check(b.getMaximumSize(), new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        Dimension m = b.getMaximumSize();
        m.setSize(1, 2);
        harness.check(b.getMaximumSize(), new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }
}

