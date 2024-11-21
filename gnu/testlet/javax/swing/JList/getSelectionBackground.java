/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getSelectionBackground
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JList list2 = new JList();
        harness.check(list2.getSelectionBackground(), MetalLookAndFeel.getTextHighlightColor());
        list2.setSelectionBackground(Color.yellow);
        harness.check(list2.getSelectionBackground(), Color.yellow);
        list2.setSelectionBackground(null);
        harness.check(list2.getSelectionBackground(), null);
    }
}

