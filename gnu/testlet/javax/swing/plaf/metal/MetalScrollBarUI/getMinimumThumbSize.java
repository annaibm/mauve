/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalScrollBarUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.metal.MetalScrollBarUI.MyMetalScrollBarUI;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class getMinimumThumbSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyMetalScrollBarUI ui = new MyMetalScrollBarUI();
        harness.check(ui.getMinimumThumbSize(), new Dimension(0, 0));
        JScrollBar sb = new JScrollBar(0);
        sb.setUI(ui);
        sb.putClientProperty("JScrollBar.isFreeStanding", Boolean.FALSE);
        harness.check(ui.getMinimumThumbSize(), new Dimension(15, 15));
        sb.putClientProperty("JScrollBar.isFreeStanding", Boolean.TRUE);
        harness.check(ui.getMinimumThumbSize(), new Dimension(17, 17));
    }
}

