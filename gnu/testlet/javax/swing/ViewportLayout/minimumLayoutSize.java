/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.ViewportLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import javax.swing.ViewportLayout;

public class minimumLayoutSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ViewportLayout l = new ViewportLayout();
        Dimension minSize = l.minimumLayoutSize(null);
        harness.check(minSize, new Dimension(4, 4));
    }
}

