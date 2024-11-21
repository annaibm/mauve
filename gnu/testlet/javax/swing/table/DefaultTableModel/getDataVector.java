/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class getDataVector
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableModel m1 = new DefaultTableModel();
        Vector<Vector> v1 = m1.getDataVector();
        harness.check(v1.isEmpty());
        Object[][] data2 = new Object[2][3];
        data2[0][0] = "V1";
        data2[0][1] = "V2";
        data2[0][2] = "V3";
        data2[1][0] = "V4";
        data2[1][1] = "V5";
        data2[1][2] = "V6";
        Object[] columns2 = new Object[]{"C1", "C2", "C3"};
        DefaultTableModel m2 = new DefaultTableModel(data2, columns2);
        Vector<Vector> v2 = m2.getDataVector();
        harness.check(v2.size(), 2);
        Vector v2a = v2.get(0);
        Vector v2b = v2.get(1);
        harness.check(v2a.get(0), (Object)"V1");
        harness.check(v2a.get(1), (Object)"V2");
        harness.check(v2a.get(2), (Object)"V3");
        harness.check(v2b.get(0), (Object)"V4");
        harness.check(v2b.get(1), (Object)"V5");
        harness.check(v2b.get(2), (Object)"V6");
    }
}

