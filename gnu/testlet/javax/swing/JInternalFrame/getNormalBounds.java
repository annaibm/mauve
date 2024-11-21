/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JInternalFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;
import javax.swing.JInternalFrame;

public class getNormalBounds
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JInternalFrame f = new JInternalFrame("Title");
        f.setBounds(2, 4, 6, 8);
        harness.check(f.getNormalBounds(), new Rectangle(2, 4, 6, 8));
        f.setNormalBounds(new Rectangle(1, 2, 3, 4));
        harness.check(f.getNormalBounds(), new Rectangle(1, 2, 3, 4));
        harness.check(f.getBounds(), new Rectangle(2, 4, 6, 8));
    }
}

