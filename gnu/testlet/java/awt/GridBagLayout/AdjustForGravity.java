/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.GridBagLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;

public class AdjustForGravity
implements Testlet {
    @Override
    public void test(TestHarness h) {
        MyLayout l = new MyLayout();
        GridBagConstraints c = new GridBagConstraints();
        Rectangle r = new Rectangle(4, 4, 10, 10);
        Rectangle[] fillRects = new Rectangle[]{new Rectangle(9, 9, 0, 0), new Rectangle(4, 4, 10, 10), new Rectangle(4, 9, 10, 0), new Rectangle(9, 4, 0, 10)};
        for (int i = 0; i <= 3; ++i) {
            r = new Rectangle(4, 4, 10, 10);
            c.fill = i;
            l.AdjustForGravity(c, r);
            h.check(r.equals(fillRects[i - 0]));
        }
        c.fill = 0;
        Rectangle[] anchorRects = new Rectangle[]{new Rectangle(9, 9, 0, 0), new Rectangle(9, 4, 0, 0), new Rectangle(14, 4, 0, 0), new Rectangle(14, 9, 0, 0), new Rectangle(14, 14, 0, 0), new Rectangle(9, 14, 0, 0), new Rectangle(4, 14, 0, 0), new Rectangle(4, 9, 0, 0), new Rectangle(4, 4, 0, 0)};
        for (int i = 10; i <= 18; ++i) {
            r = new Rectangle(4, 4, 10, 10);
            c.anchor = i;
            l.AdjustForGravity(c, r);
            h.check(r.equals(anchorRects[i - 10]));
        }
        c.anchor = 10;
        c.fill = 0;
        c.insets = new Insets(1, 4, 3, 0);
        r = new Rectangle(4, 4, 10, 10);
        l.AdjustForGravity(c, r);
        h.check(r.equals(new Rectangle(11, 8, 0, 0)));
        c.anchor = 10;
        c.fill = 0;
        c.insets = new Insets(0, 4, 0, 1);
        r = new Rectangle(4, 4, 10, 10);
        l.AdjustForGravity(c, r);
        h.check(r.equals(new Rectangle(10, 9, 0, 0)));
        c.anchor = 10;
        c.fill = 0;
        c.insets = new Insets(2, 4, 3, 2);
        r = new Rectangle(4, 4, 10, 10);
        l.AdjustForGravity(c, r);
        h.check(r.equals(new Rectangle(10, 8, 0, 0)));
        c.anchor = 10;
        c.fill = 0;
        c.insets = new Insets(3, 4, 3, 3);
        r = new Rectangle(4, 4, 10, 10);
        l.AdjustForGravity(c, r);
        h.check(r.equals(new Rectangle(9, 9, 0, 0)));
        c.anchor = 10;
        c.fill = 0;
        c.insets = new Insets(0, 0, 0, 0);
        c.ipadx = 1;
        c.ipady = 4;
        r = new Rectangle(4, 4, 10, 10);
        l.AdjustForGravity(c, r);
        h.check(r.equals(new Rectangle(8, 7, 1, 4)));
        c.anchor = 10;
        c.fill = 0;
        c.insets = new Insets(0, 0, 0, 0);
        c.ipadx = 2;
        c.ipady = 3;
        r = new Rectangle(4, 4, 10, 10);
        l.AdjustForGravity(c, r);
        h.check(r.equals(new Rectangle(8, 7, 2, 3)));
        c.anchor = 10;
        c.fill = 0;
        c.insets = new Insets(0, 0, 0, 0);
        c.ipadx = 3;
        c.ipady = 2;
        r = new Rectangle(4, 4, 10, 10);
        l.AdjustForGravity(c, r);
        h.check(r.equals(new Rectangle(7, 8, 3, 2)));
        c.anchor = 10;
        c.fill = 0;
        c.insets = new Insets(0, 0, 0, 0);
        c.ipadx = 4;
        c.ipady = 1;
        r = new Rectangle(4, 4, 10, 10);
        l.AdjustForGravity(c, r);
        h.check(r.equals(new Rectangle(7, 8, 4, 1)));
        c.anchor = 10;
        c.fill = 3;
        c.insets = new Insets(0, 0, 0, 0);
        c.ipadx = 1;
        c.ipady = 4;
        r = new Rectangle(4, 4, 10, 10);
        l.AdjustForGravity(c, r);
        h.check(r.equals(new Rectangle(8, 4, 1, 10)));
        c.anchor = 10;
        c.fill = 3;
        c.insets = new Insets(0, 0, 0, 0);
        c.ipadx = 2;
        c.ipady = 3;
        r = new Rectangle(4, 4, 10, 10);
        l.AdjustForGravity(c, r);
        h.check(r.equals(new Rectangle(8, 4, 2, 10)));
        c.anchor = 10;
        c.fill = 3;
        c.insets = new Insets(0, 0, 0, 0);
        c.ipadx = 3;
        c.ipady = 2;
        r = new Rectangle(4, 4, 10, 10);
        l.AdjustForGravity(c, r);
        h.check(r.equals(new Rectangle(7, 4, 3, 10)));
        c.anchor = 10;
        c.fill = 3;
        c.insets = new Insets(0, 0, 0, 0);
        c.ipadx = 4;
        c.ipady = 1;
        r = new Rectangle(4, 4, 10, 10);
        l.AdjustForGravity(c, r);
        h.check(r.equals(new Rectangle(7, 4, 4, 10)));
        c.anchor = 10;
        c.fill = 0;
        c.insets = new Insets(0, 0, 0, 0);
        c.ipadx = 0;
        c.ipady = 0;
        c.weightx = 0.3;
        c.weighty = 0.3;
        r = new Rectangle(4, 4, 10, 10);
        l.AdjustForGravity(c, r);
        h.check(r.equals(new Rectangle(9, 9, 0, 0)));
        c.gridwidth = 0;
        c.gridheight = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.0;
        c.weighty = 0.0;
        c.ipadx = 1;
        c.ipady = 2;
        c.insets.top = 3;
        c.insets.right = 2;
        c.insets.bottom = 1;
        c.insets.left = 0;
        Rectangle[] allRects = new Rectangle[]{new Rectangle(40, 28, 1, 2), new Rectangle(5, 9, 71, 40), new Rectangle(5, 28, 71, 2), new Rectangle(40, 9, 1, 40), new Rectangle(40, 9, 1, 2), new Rectangle(5, 9, 71, 40), new Rectangle(5, 9, 71, 2), new Rectangle(40, 9, 1, 40), new Rectangle(75, 9, 1, 2), new Rectangle(5, 9, 71, 40), new Rectangle(5, 9, 71, 2), new Rectangle(75, 9, 1, 40), new Rectangle(75, 28, 1, 2), new Rectangle(5, 9, 71, 40), new Rectangle(5, 28, 71, 2), new Rectangle(75, 9, 1, 40), new Rectangle(75, 47, 1, 2), new Rectangle(5, 9, 71, 40), new Rectangle(5, 47, 71, 2), new Rectangle(75, 9, 1, 40), new Rectangle(40, 47, 1, 2), new Rectangle(5, 9, 71, 40), new Rectangle(5, 47, 71, 2), new Rectangle(40, 9, 1, 40), new Rectangle(5, 47, 1, 2), new Rectangle(5, 9, 71, 40), new Rectangle(5, 47, 71, 2), new Rectangle(5, 9, 1, 40), new Rectangle(5, 28, 1, 2), new Rectangle(5, 9, 71, 40), new Rectangle(5, 28, 71, 2), new Rectangle(5, 9, 1, 40), new Rectangle(5, 9, 1, 2), new Rectangle(5, 9, 71, 40), new Rectangle(5, 9, 71, 2), new Rectangle(5, 9, 1, 40)};
        int i = 0;
        for (int anchor = 10; anchor <= 18; ++anchor) {
            int fill2 = 0;
            while (fill2 <= 3) {
                c.anchor = anchor;
                c.fill = fill2++;
                r.x = 5;
                r.y = 6;
                r.width = 73;
                r.height = 44;
                l.AdjustForGravity(c, r);
                h.check(r.equals(allRects[i]));
                ++i;
            }
        }
    }

    public void printConstraints(GridBagConstraints c) {
        System.out.println("fill = " + c.fill);
        System.out.println("anchor = " + c.anchor);
        System.out.println("gridheight = " + c.gridheight);
        System.out.println("gridwidth = " + c.gridwidth);
        System.out.println("gridx = " + c.gridx);
        System.out.println("gridy = " + c.gridy);
        System.out.println("insets = " + c.insets);
        System.out.println("ipadx = " + c.ipadx);
        System.out.println("ipady = " + c.ipady);
        System.out.println("weightx = " + c.weightx);
        System.out.println("weighty = " + c.weighty);
    }

    public void printRectangle(Rectangle r) {
        System.out.println("new Rectangle(" + r.x + ", " + r.y + ", " + r.width + ", " + r.height + "),");
    }

    public class MyLayout
    extends GridBagLayout {
        @Override
        public void AdjustForGravity(GridBagConstraints c, Rectangle r) {
            super.AdjustForGravity(c, r);
        }
    }
}

