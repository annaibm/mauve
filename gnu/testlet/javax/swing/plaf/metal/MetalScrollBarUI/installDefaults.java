/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalScrollBarUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.metal.MetalScrollBarUI.MyMetalScrollBarUI;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class installDefaults
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        MyMetalScrollBarUI ui = new MyMetalScrollBarUI();
        harness.check(ui.getScrollBarWidthField(), 0);
        ui.setScrollbar(new JScrollBar());
        ui.installDefaults();
        harness.check(ui.getScrollBarWidthField(), 17);
    }
}

