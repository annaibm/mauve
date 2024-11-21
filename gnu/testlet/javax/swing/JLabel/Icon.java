/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JLabel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JLabel;

public class Icon
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyIcon icon = new MyIcon();
        JLabel l = new JLabel(icon);
        harness.check(l.getIcon(), icon);
        harness.check(l.getDisabledIcon(), null);
        l.setIcon(icon);
        harness.check(l.getIcon(), icon);
        harness.check(l.getDisabledIcon(), null);
        l = new JLabel();
        Dimension base = l.getPreferredSize();
        l.setIcon(icon);
        Dimension one = l.getPreferredSize();
        harness.check(one.width, base.width + icon.getIconWidth());
        l = new JLabel("bla");
        base = l.getPreferredSize();
        l.setIcon(icon);
        one = l.getPreferredSize();
        harness.check(one.width, base.width + icon.getIconWidth() + l.getIconTextGap());
        l.setIconTextGap(100);
        one = l.getPreferredSize();
        harness.check(one.width, base.width + icon.getIconWidth() + 100);
    }

    private static class MyIcon
    implements javax.swing.Icon {
        private int painted = 0;

        private MyIcon() {
        }

        @Override
        public int getIconHeight() {
            return 10;
        }

        @Override
        public int getIconWidth() {
            return 20;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            ++this.painted;
        }

        public int getPainted() {
            return this.painted;
        }
    }
}

