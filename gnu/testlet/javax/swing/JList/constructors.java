/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("()");
        JList list2 = new JList();
        harness.check(list2.getFont(), MetalLookAndFeel.getControlTextFont());
        harness.check(list2.getForeground(), MetalLookAndFeel.getBlack());
        harness.check(list2.getBackground(), MetalLookAndFeel.getWindowBackground());
        harness.check(list2.getDragEnabled(), false);
        harness.check(list2.getSelectionMode(), 2);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(ListModel)");
        JList list2 = new JList();
        harness.check(list2.getFont(), MetalLookAndFeel.getControlTextFont());
        harness.check(list2.getForeground(), MetalLookAndFeel.getBlack());
        harness.check(list2.getBackground(), MetalLookAndFeel.getWindowBackground());
        harness.check(list2.getDragEnabled(), false);
        harness.check(list2.getSelectionMode(), 2);
        boolean pass = false;
        try {
            new JList((ListModel)null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testConstructor3(TestHarness harness) {
        harness.checkPoint("(Object[])");
        JList list2 = new JList();
        harness.check(list2.getFont(), MetalLookAndFeel.getControlTextFont());
        harness.check(list2.getForeground(), MetalLookAndFeel.getBlack());
        harness.check(list2.getBackground(), MetalLookAndFeel.getWindowBackground());
        harness.check(list2.getDragEnabled(), false);
        harness.check(list2.getSelectionMode(), 2);
        JList<Object> list22 = new JList<Object>((Object[])null);
        harness.check(list22.getModel() != null);
    }

    public void testConstructor4(TestHarness harness) {
        harness.checkPoint("(Vector)");
        JList list2 = new JList();
        harness.check(list2.getFont(), MetalLookAndFeel.getControlTextFont());
        harness.check(list2.getForeground(), MetalLookAndFeel.getBlack());
        harness.check(list2.getBackground(), MetalLookAndFeel.getWindowBackground());
        harness.check(list2.getDragEnabled(), false);
        harness.check(list2.getSelectionMode(), 2);
        JList list22 = new JList((Vector)null);
        harness.check(list22.getModel() != null);
    }
}

