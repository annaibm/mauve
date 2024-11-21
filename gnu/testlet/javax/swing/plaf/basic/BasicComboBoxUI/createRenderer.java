/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI.MyBasicComboBoxUI;
import gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI.MyBasicComboBoxUILAF;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class createRenderer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            UIManager.setLookAndFeel(new MyBasicComboBoxUILAF());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        UIManager.put("Label.font", new Font("Dialog", 0, 21));
        UIManager.put("Label.foreground", Color.green);
        UIManager.put("Label.background", Color.yellow);
        MyBasicComboBoxUI ui = new MyBasicComboBoxUI();
        ListCellRenderer renderer = ui.createRenderer();
        Component c = (Component)((Object)renderer);
        harness.check(c.getFont(), new Font("Dialog", 0, 21));
        harness.check(c.getForeground(), Color.green);
        harness.check(c.getBackground(), Color.yellow);
        ListCellRenderer renderer2 = ui.createRenderer();
        harness.check(renderer != renderer2);
        JComboBox cb = new JComboBox();
        ListCellRenderer renderer3 = cb.getRenderer();
        Component c3 = (Component)((Object)renderer3);
        harness.check(c3.getFont(), new Font("Dialog", 0, 21));
        harness.check(c3.getForeground(), Color.green);
        harness.check(c3.getBackground(), Color.yellow);
        cb.setFont(new Font("Dialog", 1, 10));
        harness.check(c3.getFont(), new Font("Dialog", 0, 21));
        ListCellRenderer renderer4 = cb.getRenderer();
        harness.check(renderer3 == renderer4);
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

