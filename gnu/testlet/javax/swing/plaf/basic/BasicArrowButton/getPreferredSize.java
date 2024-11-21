/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicArrowButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import javax.swing.plaf.basic.BasicArrowButton;

public class getPreferredSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BasicArrowButton b = new BasicArrowButton(1);
        harness.check(b.getPreferredSize(), new Dimension(16, 16));
        b.setPreferredSize(new Dimension(12, 34));
        harness.check(b.getPreferredSize(), new Dimension(16, 16));
        Dimension p = b.getPreferredSize();
        p.setSize(1, 2);
        harness.check(b.getPreferredSize(), new Dimension(16, 16));
    }
}

