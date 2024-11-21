/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.TableModelEvent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
        this.testConstructor5(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("(TableModel)");
        DefaultTableModel tm = new DefaultTableModel(2, 3);
        TableModelEvent event = new TableModelEvent(tm);
        harness.check(event.getSource() == tm);
        harness.check(event.getType(), 0);
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), 0);
        harness.check(event.getLastRow(), Integer.MAX_VALUE);
        boolean pass = false;
        try {
            new TableModelEvent(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        catch (NullPointerException e) {
            pass = false;
        }
        harness.check(pass);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(TableModel, int)");
        DefaultTableModel tm = new DefaultTableModel(2, 3);
        TableModelEvent event = new TableModelEvent(tm, 1);
        harness.check(event.getSource() == tm);
        harness.check(event.getType(), 0);
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), 1);
        harness.check(event.getLastRow(), 1);
        boolean pass = false;
        try {
            new TableModelEvent(null, 1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testConstructor3(TestHarness harness) {
        harness.checkPoint("(TableModel, int, int)");
        DefaultTableModel tm = new DefaultTableModel(2, 3);
        TableModelEvent event = new TableModelEvent(tm, 0, 2);
        harness.check(event.getSource() == tm);
        harness.check(event.getType(), 0);
        harness.check(event.getColumn(), -1);
        harness.check(event.getFirstRow(), 0);
        harness.check(event.getLastRow(), 2);
        boolean pass = false;
        try {
            new TableModelEvent(null, 1, 1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        TableModelEvent e = new TableModelEvent(tm, 2, 0);
        harness.check(e.getFirstRow(), 2);
        harness.check(e.getLastRow(), 0);
    }

    public void testConstructor4(TestHarness harness) {
        harness.checkPoint("(TableModel, int, int, int)");
        DefaultTableModel tm = new DefaultTableModel(2, 3);
        TableModelEvent event = new TableModelEvent(tm, 0, 2, 1);
        harness.check(event.getSource() == tm);
        harness.check(event.getType(), 0);
        harness.check(event.getColumn(), 1);
        harness.check(event.getFirstRow(), 0);
        harness.check(event.getLastRow(), 2);
        boolean pass = false;
        try {
            new TableModelEvent(null, 1, 1, 0);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testConstructor5(TestHarness harness) {
        harness.checkPoint("(TableModel, int, int, int, int)");
        DefaultTableModel tm = new DefaultTableModel(2, 3);
        TableModelEvent event = new TableModelEvent(tm, 0, 2, 1, -1);
        harness.check(event.getSource() == tm);
        harness.check(event.getType(), -1);
        harness.check(event.getColumn(), 1);
        harness.check(event.getFirstRow(), 0);
        harness.check(event.getLastRow(), 2);
        boolean pass = false;
        try {
            new TableModelEvent(null, 1, 1, 0, 1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        TableModelEvent e = new TableModelEvent(tm, 0, 2, 1, 999);
        harness.check(e.getType(), 999);
    }
}

