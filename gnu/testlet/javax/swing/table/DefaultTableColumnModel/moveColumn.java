/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableColumnModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.DefaultTableColumnModel.MyListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class moveColumn
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testGeneral(harness);
        this.testSpecial(harness);
    }

    public void testGeneral(TestHarness harness) {
        harness.checkPoint("moveColumn(int, int) - General");
        DefaultTableColumnModel m1 = new DefaultTableColumnModel();
        m1.addColumn(new TableColumn(1, 23));
        m1.addColumn(new TableColumn(2, 34));
        m1.addColumn(new TableColumn(3, 45));
        m1.addColumn(new TableColumn(4, 56));
        m1.moveColumn(1, 3);
        TableColumn tc0 = m1.getColumn(0);
        TableColumn tc1 = m1.getColumn(1);
        TableColumn tc2 = m1.getColumn(2);
        TableColumn tc3 = m1.getColumn(3);
        harness.check(tc0.getWidth(), 23);
        harness.check(tc1.getWidth(), 45);
        harness.check(tc2.getWidth(), 56);
        harness.check(tc3.getWidth(), 34);
        MyListener listener = new MyListener();
        m1.addColumnModelListener(listener);
        m1.moveColumn(0, 1);
        harness.check(listener.getEvent() != null);
        harness.check(listener.getEvent().getFromIndex(), 0);
        harness.check(listener.getEvent().getToIndex(), 1);
    }

    public void testSpecial(TestHarness harness) {
        harness.checkPoint("moveColumn(int, int) - Special");
        DefaultTableColumnModel m1 = new DefaultTableColumnModel();
        m1.addColumn(new TableColumn(1, 23));
        m1.addColumn(new TableColumn(2, 34));
        m1.addColumn(new TableColumn(3, 45));
        m1.addColumn(new TableColumn(4, 56));
        MyListener listener = new MyListener();
        m1.addColumnModelListener(listener);
        m1.moveColumn(1, 1);
        TableColumn tc0 = m1.getColumn(0);
        TableColumn tc1 = m1.getColumn(1);
        TableColumn tc2 = m1.getColumn(2);
        TableColumn tc3 = m1.getColumn(3);
        harness.check(tc0.getWidth(), 23);
        harness.check(tc1.getWidth(), 34);
        harness.check(tc2.getWidth(), 45);
        harness.check(tc3.getWidth(), 56);
        harness.check(listener.getEvent() != null);
        harness.check(listener.getEvent().getFromIndex(), 1);
        harness.check(listener.getEvent().getToIndex(), 1);
        boolean pass = false;
        try {
            m1.moveColumn(-1, 0);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1.moveColumn(0, -1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1.moveColumn(4, 3);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1.moveColumn(3, 4);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        m1.moveColumn(0, 3);
    }
}

