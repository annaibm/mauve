/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.org.omg.CORBA.Asserter;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.util.BitSet;
import java.util.Random;
import java.util.TreeSet;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TableRobot
extends Asserter
implements Testlet {
    int columns = 3;
    int sizes = 4;
    JTable table = new JTable(0, 3);
    JFrame frame;
    String[] EMPTY;
    Robot r;
    static Random ran = new Random();
    String[][] records = new String[5][];
    int rows = 0;

    String[] getRandomRecord() {
        String[] r = new String[this.columns];
        for (int i = 0; i < r.length; ++i) {
            char[] c = new char[this.sizes];
            for (int j = 0; j < c.length; ++j) {
                c[j] = (char)(48 + ran.nextInt(9));
            }
            r[i] = new String(c);
        }
        return r;
    }

    public String[] createRecord() {
        String[] record = this.getRandomRecord();
        ((DefaultTableModel)this.table.getModel()).addRow(this.EMPTY);
        for (int i = 0; i < record.length; ++i) {
            this.clickCell(this.table, this.table.getRowCount() - 1, i);
            this.r.keyPress(113);
            this.r.keyRelease(113);
            for (int j = 0; j < record[i].length(); ++j) {
                this.typeDigit(record[i].charAt(j));
            }
            this.r.keyPress(10);
            this.r.keyRelease(10);
        }
        return record;
    }

    public void verifyTableContent(String[][] records) {
        for (int row = 0; row < records.length; ++row) {
            for (int column = 0; column < records[row].length; ++column) {
                if (this.table.getValueAt(row, column).equals(records[row][column])) continue;
                String msg = "Match failed " + row + ":" + column + ", exp " + records[row][column] + " act " + this.table.getValueAt(row, column);
                this.fail(msg);
            }
        }
    }

    public String[][] getTableContent(int columns) {
        String[][] records = new String[this.table.getRowCount()][];
        for (int row = 0; row < records.length; ++row) {
            records[row] = new String[columns];
            for (int col = 0; col < columns; ++col) {
                records[row][col] = this.table.getModel().getValueAt(row, col).toString();
            }
        }
        return records;
    }

    public String toString(String[] record) {
        StringBuffer b = new StringBuffer();
        for (int i = 0; i < record.length; ++i) {
            b.append(record[i]);
            b.append("#");
        }
        return b.toString();
    }

    public void testTable() throws Exception {
        this.vCreateEditing();
        this.testMultipleSelection();
        this.vEditing();
        this.vTestArrowKeyNavigation();
        this.vDeleteOneByOne();
    }

    private void vDeleteOneByOne() {
        for (int i = 0; i < this.records.length; ++i) {
            this.assertEquals("Deleting row should reduce the row count", this.records.length - i, this.table.getRowCount());
            for (int column = 0; column < this.records[i].length; ++column) {
                this.assertEquals(i + "/" + this.records.length, this.table.getValueAt(0, column), this.records[i][column]);
            }
            this.clickCell(this.table, 0, 0);
            ((DefaultTableModel)this.table.getModel()).removeRow(this.table.getSelectedRow());
        }
    }

    private void vEditing() {
        TreeSet<String> used = new TreeSet<String>();
        for (int i = 0; i < 7; ++i) {
            int col;
            int row;
            String img;
            do {
                row = ran.nextInt(this.records.length);
                col = ran.nextInt(3);
            } while (used.contains(img = row + ":" + col));
            used.add(img);
            String nc = Integer.toString(ran.nextInt(10));
            this.clickCell(this.table, row, col);
            this.r.keyPress(113);
            this.r.keyRelease(113);
            String prev = this.table.getModel().getValueAt(row, col).toString();
            int code = 48 + (nc.charAt(0) - 48);
            this.r.keyPress(code);
            this.r.keyRelease(code);
            this.r.keyPress(10);
            this.r.keyRelease(10);
            this.records[row][col] = this.records[row][col] + nc;
            this.assertEquals("Incorrect value after editing", this.table.getModel().getValueAt(row, col), this.records[row][col]);
        }
    }

    private void testMultipleSelection() {
        int nd = this.records.length / 2;
        BitSet selected = new BitSet();
        boolean ctrl = false;
        for (int i = 0; i < nd; ++i) {
            int d;
            while (selected.get(d = ran.nextInt(this.records.length))) {
            }
            this.clickCell(this.table, d, 0);
            selected.set(d);
            if (ctrl) continue;
            this.r.keyPress(17);
            ctrl = true;
        }
        this.r.keyRelease(17);
        int[] srows = this.table.getSelectedRows();
        this.assertEquals("New row should increase the length", nd, srows.length);
        for (int i = 0; i < srows.length; ++i) {
            this.assertEquals("Selection mismatch", this.table.isRowSelected(srows[i]), selected.get(srows[i]));
        }
    }

    private void vCreateEditing() {
        for (int i = 0; i < this.records.length; ++i) {
            this.assertEquals("New row should increase the length", this.rows++, this.table.getRowCount());
            this.records[i] = this.createRecord();
        }
        this.verifyTableContent(this.records);
    }

    private void vTestArrowKeyNavigation() {
        int i;
        this.clickCell(this.table, 0, 0);
        this.assertEquals("First click", this.table.getSelectedRow(), 0L);
        for (i = 1; i < this.table.getRowCount(); ++i) {
            this.r.keyPress(40);
            this.r.keyRelease(40);
            this.assertEquals("VK_DOWN", this.table.getSelectedRow(), i);
        }
        for (i = this.table.getRowCount() - 2; i >= 0; --i) {
            this.r.keyPress(38);
            this.r.keyRelease(38);
            this.assertEquals("VK_UP", this.table.getSelectedRow(), i);
        }
        for (i = 1; i < this.table.getColumnCount(); ++i) {
            this.r.keyPress(39);
            this.r.keyRelease(39);
            this.assertEquals("VK_DOWN", this.table.getSelectedColumn(), i);
        }
        for (i = this.table.getColumnCount() - 2; i >= 0; --i) {
            this.r.keyPress(37);
            this.r.keyRelease(37);
            this.assertEquals("VK_RIGHT", this.table.getSelectedColumn(), i);
        }
        this.r.keyPress(16);
        for (i = 1; i < this.table.getRowCount(); ++i) {
            this.r.keyPress(40);
            this.r.keyRelease(40);
            this.assertEquals("VK_DOWN+shift", this.table.getSelectedRowCount(), i + 1);
        }
        for (i = this.table.getRowCount() - 2; i >= 0; --i) {
            this.r.keyPress(38);
            this.r.keyRelease(38);
            this.assertEquals("VK_UP+shift", this.table.getSelectedRowCount(), i + 1);
        }
        this.r.keyRelease(16);
    }

    protected void setUp() throws Exception {
        this.EMPTY = new String[this.columns];
        for (int i = 0; i < this.EMPTY.length; ++i) {
            this.EMPTY[i] = "";
        }
        this.frame = new JFrame();
        this.frame.getContentPane().add(this.table);
        this.frame.setSize(400, 400);
        this.frame.setVisible(true);
        this.r = new Robot();
        this.r.setAutoDelay(50);
        this.r.delay(500);
    }

    protected void tearDown() throws Exception {
        this.frame.dispose();
    }

    public void click(JComponent c) {
        Point p = new Point();
        p.x = c.getWidth() / 2;
        p.y = c.getHeight() / 2;
        SwingUtilities.convertPointToScreen(p, c);
        this.r.mouseMove(p.x, p.y);
        this.r.mousePress(16);
        this.r.mouseRelease(16);
    }

    public void clickCell(JTable table2, int row, int column) {
        Rectangle rect = table2.getCellRect(row, column, true);
        Point p = new Point(rect.x + rect.width / 2, rect.y + rect.height / 2);
        SwingUtilities.convertPointToScreen(p, table2);
        this.r.mouseMove(p.x, p.y);
        this.r.mousePress(16);
        this.r.delay(50);
        this.r.mouseRelease(16);
        this.r.delay(50);
    }

    public void typeDigit(char character) {
        int code = 48 + (character - 48);
        this.r.keyPress(code);
        this.r.keyRelease(code);
    }

    @Override
    public void test(TestHarness harness) {
        try {
            this.h = harness;
            this.setUp();
            try {
                this.testTable();
            }
            finally {
                this.tearDown();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            this.h.fail("Exception: " + e);
        }
    }
}

