/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JRootPane.RootLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.awt.Container;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.JRootPane;

public class layoutContainer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testWithBorder(harness);
    }

    private void testWithBorder(TestHarness harness) {
        harness.checkPoint("withBorder");
        JRootPane rp = new JRootPane();
        rp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        rp.setSize(100, 100);
        rp.getLayout().layoutContainer(rp);
        Insets i = rp.getInsets();
        Component gp = rp.getGlassPane();
        harness.check(gp.getBounds(), new Rectangle(i.left, i.right, rp.getWidth() - i.left - i.right, rp.getHeight() - i.top - i.bottom));
        JLayeredPane lp = rp.getLayeredPane();
        harness.check(lp.getBounds(), new Rectangle(i.left, i.right, rp.getWidth() - i.left - i.right, rp.getHeight() - i.top - i.bottom));
        Container cp = rp.getContentPane();
        harness.check(cp.getBounds(), new Rectangle(0, 0, rp.getWidth() - i.left - i.right, rp.getHeight() - i.top - i.bottom));
    }
}

