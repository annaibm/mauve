/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalComboBoxButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Insets;
import javax.swing.CellRendererPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.metal.MetalComboBoxButton;
import javax.swing.plaf.metal.MetalComboBoxIcon;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("MetalComboBoxButton(JComboBox, Icon, CellRendererPane, JList)");
        JComboBox<Object> jcb = new JComboBox<Object>(new Object[]{"A", "B", "C"});
        MetalComboBoxIcon icon = new MetalComboBoxIcon();
        MetalComboBoxButton b = new MetalComboBoxButton(jcb, icon, new CellRendererPane(), new JList<Object>());
        harness.check(b.getComboBox() == jcb);
        harness.check(b.getComboIcon() == icon);
        harness.check(!b.isIconOnly());
        Insets margin = b.getMargin();
        harness.check(margin, new Insets(2, 14, 2, 14));
        harness.check(margin instanceof UIResource);
        Insets insets = b.getInsets();
        harness.check(insets, new Insets(5, 17, 5, 17));
        boolean pass = false;
        try {
            b = new MetalComboBoxButton(null, icon, new CellRendererPane(), new JList<Object>());
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        b = new MetalComboBoxButton(jcb, null, new CellRendererPane(), new JList<Object>());
        harness.check(b.getComboIcon() == null);
        b = new MetalComboBoxButton(jcb, icon, null, new JList<Object>());
        b = new MetalComboBoxButton(jcb, icon, new CellRendererPane(), null);
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("MetalComboBoxButton(JComboBox, Icon, boolean, CellRendererPane, JList)");
        JComboBox<Object> jcb = new JComboBox<Object>(new Object[]{"A", "B", "C"});
        MetalComboBoxIcon icon = new MetalComboBoxIcon();
        MetalComboBoxButton b = new MetalComboBoxButton(jcb, icon, true, new CellRendererPane(), new JList<Object>());
        harness.check(b.getComboBox() == jcb);
        harness.check(b.getComboIcon() == icon);
        harness.check(b.isIconOnly());
        boolean pass = false;
        try {
            b = new MetalComboBoxButton(null, icon, true, new CellRendererPane(), new JList<Object>());
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        b = new MetalComboBoxButton(jcb, null, true, new CellRendererPane(), new JList<Object>());
        harness.check(b.getComboIcon() == null);
        b = new MetalComboBoxButton(jcb, icon, true, null, new JList<Object>());
        b = new MetalComboBoxButton(jcb, icon, true, new CellRendererPane(), null);
    }
}

