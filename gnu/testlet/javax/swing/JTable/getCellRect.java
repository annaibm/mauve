/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;
import javax.swing.JTable;

public class getCellRect
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JTable table2 = new JTable(0, 0);
        Rectangle rectangle = table2.getCellRect(0, 0, false);
        harness.check(rectangle.x, 0);
        harness.check(rectangle.y, 0);
        harness.check(rectangle.width, 0);
        harness.check(rectangle.height, 0);
        table2 = new JTable(2, 3);
        rectangle = table2.getCellRect(1, 2, false);
        harness.check(rectangle.x, 150);
        harness.check(rectangle.y, 16);
        harness.check(rectangle.width, 74);
        harness.check(rectangle.height, 15);
        table2 = new JTable(2, 3);
        rectangle = table2.getCellRect(0, 2, false);
        harness.check(rectangle.x, 150);
        harness.check(rectangle.y, 0);
        harness.check(rectangle.width, 74);
        harness.check(rectangle.height, 15);
        table2 = new JTable(2, 3);
        rectangle = table2.getCellRect(1, 0, false);
        harness.check(rectangle.x, 0);
        harness.check(rectangle.y, 16);
        harness.check(rectangle.width, 74);
        harness.check(rectangle.height, 15);
        table2 = new JTable(0, 1);
        rectangle = table2.getCellRect(0, 0, true);
        harness.check(rectangle.x, 0);
        harness.check(rectangle.y, 0);
        harness.check(rectangle.width, 75);
        harness.check(rectangle.height, 0);
        table2 = new JTable(2, 3);
        rectangle = table2.getCellRect(1, 2, true);
        harness.check(rectangle.x, 150);
        harness.check(rectangle.y, 16);
        harness.check(rectangle.width, 75);
        harness.check(rectangle.height, 16);
        table2 = new JTable(2, 3);
        rectangle = table2.getCellRect(0, 2, true);
        harness.check(rectangle.x, 150);
        harness.check(rectangle.y, 0);
        harness.check(rectangle.width, 75);
        harness.check(rectangle.height, 16);
        table2 = new JTable(2, 3);
        rectangle = table2.getCellRect(1, 0, true);
        harness.check(rectangle.x, 0);
        harness.check(rectangle.y, 16);
        harness.check(rectangle.width, 75);
        harness.check(rectangle.height, 16);
        table2 = new JTable(2, 3);
        table2.setRowHeight(0, 11);
        table2.setRowHeight(1, 12);
        harness.check(table2.getCellRect(0, 2, false), new Rectangle(150, 0, 74, 10));
        harness.check(table2.getCellRect(1, 2, false), new Rectangle(150, 11, 74, 11));
        table2 = new JTable(2, 3);
        table2.getColumnModel().getColumn(0).setWidth(11);
        table2.getColumnModel().getColumn(1).setWidth(15);
        table2.getColumnModel().getColumn(2).setWidth(17);
        harness.check(table2.getCellRect(0, 0, false), new Rectangle(0, 0, 14, 15));
        harness.check(table2.getCellRect(1, 1, false), new Rectangle(15, 16, 14, 15));
        harness.check(table2.getCellRect(0, 2, false), new Rectangle(30, 0, 16, 15));
        harness.check(table2.getCellRect(1, 0, false), new Rectangle(0, 16, 14, 15));
        harness.check(table2.getCellRect(0, 1, false), new Rectangle(15, 0, 14, 15));
        harness.check(table2.getCellRect(1, 2, false), new Rectangle(30, 16, 16, 15));
        table2 = new JTable(2, 3);
        harness.check(table2.getCellRect(-1, 0, true), new Rectangle(0, 0, 75, 0));
        table2 = new JTable(2, 3);
        harness.check(table2.getCellRect(99, 0, true), new Rectangle(0, 0, 75, 0));
        harness.check(table2.getCellRect(0, -1, true), new Rectangle(0, 0, 0, 16));
        harness.check(table2.getCellRect(0, 99, true), new Rectangle(0, 0, 0, 16));
    }
}

