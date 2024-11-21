/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.table.DefaultTableModel;

public class getValueAt
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableModel m1 = new DefaultTableModel(2, 3);
        m1.setValueAt("V1", 0, 0);
        m1.setValueAt("V2", 0, 1);
        m1.setValueAt("V3", 0, 2);
        m1.setValueAt("V4", 1, 0);
        m1.setValueAt("V5", 1, 1);
        m1.setValueAt("V6", 1, 2);
        harness.check(m1.getValueAt(0, 0), (Object)"V1");
        harness.check(m1.getValueAt(0, 1), (Object)"V2");
        harness.check(m1.getValueAt(0, 2), (Object)"V3");
        harness.check(m1.getValueAt(1, 0), (Object)"V4");
        harness.check(m1.getValueAt(1, 1), (Object)"V5");
        harness.check(m1.getValueAt(1, 2), (Object)"V6");
        boolean pass = false;
        try {
            m1.getValueAt(-1, 0);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1.getValueAt(99, 0);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1.getValueAt(0, -1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1.getValueAt(0, 99);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

