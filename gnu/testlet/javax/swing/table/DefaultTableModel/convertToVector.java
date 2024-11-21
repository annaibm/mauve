/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.DefaultTableModel.MyDefaultTableModel;
import java.util.Vector;

public class convertToVector
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        Object[] data = new Object[]{"X", "Y", null, "Z"};
        Vector v1 = MyDefaultTableModel.convertToVector(data);
        harness.check(v1.get(0), (Object)"X");
        harness.check(v1.get(1), (Object)"Y");
        harness.check(v1.get(2), null);
        harness.check(v1.get(3), (Object)"Z");
        Object[] data2 = new Object[]{};
        Vector v2 = MyDefaultTableModel.convertToVector(data2);
        harness.check(v2.isEmpty());
        Vector v3 = MyDefaultTableModel.convertToVector((Object[])null);
        harness.check(v3 == null);
    }

    public void test2(TestHarness harness) {
        Object[] data1 = new Object[]{"X", "Y", null, "Z"};
        Object[] data2 = new Object[]{"A", "B"};
        Object[][] data = new Object[][]{data1, data2};
        Vector vector = MyDefaultTableModel.convertToVector(data);
        Vector v1 = (Vector)vector.get(0);
        harness.check(v1.get(0), (Object)"X");
        harness.check(v1.get(1), (Object)"Y");
        harness.check(v1.get(2), null);
        harness.check(v1.get(3), (Object)"Z");
        harness.check(v1.size(), 4);
        Vector v2 = (Vector)vector.get(1);
        harness.check(v2.get(0), (Object)"A");
        harness.check(v2.get(1), (Object)"B");
        harness.check(v2.size(), 2);
        Object[][] data3 = new Object[][]{};
        Vector v3 = MyDefaultTableModel.convertToVector(data3);
        harness.check(v3.isEmpty());
        Vector v4 = MyDefaultTableModel.convertToVector((Object[][])null);
        harness.check(v4 == null);
    }
}

