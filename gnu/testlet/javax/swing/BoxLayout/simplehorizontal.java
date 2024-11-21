/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.BoxLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;
import javax.swing.BoxLayout;
import javax.swing.JComponent;

public class simplehorizontal
implements Testlet {
    @Override
    public void test(TestHarness h) {
        JComponent comp = new JComponent(){};
        BoxLayout layout2 = new BoxLayout(comp, 0);
        JComponent c1 = new JComponent(){};
        JComponent c2 = new JComponent(){};
        comp.add(c1);
        comp.add(c2);
        comp.setSize(400, 400);
        layout2.layoutContainer(comp);
        Rectangle b1 = c1.getBounds();
        Rectangle b2 = c2.getBounds();
        h.check(b1.x, 0, String.valueOf(b1.x));
        h.check(b1.y, 0, String.valueOf(b1.y));
        h.check(b1.width, 200, String.valueOf(b1.width));
        h.check(b1.height, 400, String.valueOf(b1.height));
        h.check(b2.x, 200, String.valueOf(b2.x));
        h.check(b2.y, 0, String.valueOf(b2.y));
        h.check(b2.width, 200, String.valueOf(b2.width));
        h.check(b2.height, 400, String.valueOf(b2.height));
    }
}

