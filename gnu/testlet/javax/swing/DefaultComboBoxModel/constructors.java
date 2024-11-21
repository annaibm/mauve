/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultComboBoxModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("()");
        DefaultComboBoxModel m = new DefaultComboBoxModel();
        harness.check(m.getSelectedItem(), null);
        harness.check(m.getSize(), 0);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("(Object[])");
        DefaultComboBoxModel<Object> m = new DefaultComboBoxModel<Object>(new Object[]{"A", "B"});
        harness.check(m.getSize(), 2);
        harness.check(m.getSelectedItem(), (Object)"A");
        harness.check(m.getElementAt(0), (Object)"A");
        harness.check(m.getElementAt(1), (Object)"B");
        boolean pass = false;
        try {
            m = new DefaultComboBoxModel<Object>((Object[])null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void test3(TestHarness harness) {
        harness.checkPoint("(Vector)");
        Vector<String> v = new Vector<String>();
        v.add("A");
        v.add("B");
        DefaultComboBoxModel m = new DefaultComboBoxModel(v);
        harness.check(m.getSize(), 2);
        harness.check(m.getSelectedItem(), (Object)"A");
        harness.check(m.getElementAt(0), (Object)"A");
        harness.check(m.getElementAt(1), (Object)"B");
        boolean pass = false;
        try {
            m = new DefaultComboBoxModel((Vector)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

