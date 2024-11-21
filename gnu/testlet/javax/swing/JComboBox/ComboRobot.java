/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComboBox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.org.omg.CORBA.Asserter;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

public class ComboRobot
extends Asserter
implements Testlet {
    JComboBox combo = new JComboBox<String>(new String[]{"a", "b", "c", "d", "e", "f", "a234"});
    JFrame frame;
    Robot r;
    static Random ran = new Random();

    protected void setUp() throws Exception {
        this.frame = new JFrame();
        this.frame.getContentPane().add(this.combo);
        this.frame.setSize(200, 80);
        this.frame.setVisible(true);
        this.r = new Robot();
        this.r.setAutoDelay(50);
        this.r.delay(500);
    }

    protected void tearDown() throws Exception {
        this.frame.dispose();
    }

    public void click(JComponent c, int x, int y) {
        Point p = new Point();
        p.x = x;
        p.y = y;
        SwingUtilities.convertPointToScreen(p, c);
        this.r.mouseMove(p.x, p.y);
        this.r.mousePress(16);
        this.r.mouseRelease(16);
    }

    public void clickPath(JTree tree, TreePath path) {
        Rectangle rect = tree.getPathBounds(path);
        Point p = new Point(rect.x + rect.width / 2, rect.y + rect.height / 2);
        SwingUtilities.convertPointToScreen(p, tree);
        this.r.mouseMove(p.x, p.y);
        this.r.mousePress(16);
        this.r.delay(50);
        this.r.mouseRelease(16);
        this.r.delay(50);
    }

    public void type(int code) {
        this.r.keyPress(code);
        this.r.keyRelease(code);
    }

    public void testCombo(boolean editable) throws Exception {
        this.click(this.combo, this.combo.getWidth() / 2, this.combo.getHeight() / 2);
        this.click(this.combo, this.combo.getWidth() / 2, this.combo.getHeight() / 2);
        this.type(40);
        this.type(10);
        this.assertEquals("Selecting first component with keyboard", "a", this.getFocus());
        this.type(40);
        this.type(40);
        this.type(10);
        this.assertEquals("Selecting second component with keyboard", "b", this.getFocus());
        this.type(40);
        this.type(40);
        this.type(40);
        this.type(10);
        this.assertEquals("Selecting forth component with keyboard", "d", this.getFocus());
        if (!editable) {
            this.combo.setSelectedIndex(-1);
            for (char i = 'a'; i <= 'f'; i = (char)(i + '\u0001')) {
                this.type(40);
                this.type(65 + (i - 97));
                this.type(10);
                this.assertEquals("Selecting with letter key, " + i, new String(new char[]{i}), this.getFocus());
            }
            this.combo.setSelectedIndex(-1);
            this.type(40);
            this.type(65);
            this.type(10);
            this.assertEquals("Selecting with letter key (duplicate)", "a", this.getFocus());
            this.type(40);
            this.type(65);
            this.type(10);
            this.assertEquals("Selecting with letter key (duplicate)", "a234", this.getFocus());
        }
        this.type(40);
        this.type(27);
        this.assertEquals("Cancelling popup with escape key", false, this.combo.isPopupVisible());
        this.combo.setSelectedIndex(0);
        Thread.sleep(5000L);
    }

    public Object getFocus() {
        return this.combo.getSelectedItem();
    }

    @Override
    public void test(TestHarness harness) {
        try {
            this.h = harness;
            this.setUp();
            try {
                this.testCombo(false);
                this.combo.setEditable(true);
                this.testCombo(true);
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

