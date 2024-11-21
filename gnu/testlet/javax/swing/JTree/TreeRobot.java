/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTree;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.org.omg.CORBA.Asserter;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class TreeRobot
extends Asserter
implements Testlet {
    JTree tree = new JTree();
    JFrame frame;
    Robot r;
    static Random ran = new Random();
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
    DefaultMutableTreeNode a = new DefaultMutableTreeNode("a");
    DefaultMutableTreeNode b = new DefaultMutableTreeNode("b");
    DefaultMutableTreeNode c = new DefaultMutableTreeNode("c");
    DefaultMutableTreeNode aa = new DefaultMutableTreeNode("aa");
    DefaultMutableTreeNode ab = new DefaultMutableTreeNode("ab");
    DefaultMutableTreeNode aaa = new DefaultMutableTreeNode("aaa");
    DefaultMutableTreeNode aab = new DefaultMutableTreeNode("aab");
    DefaultMutableTreeNode aac = new DefaultMutableTreeNode("aac");
    DefaultMutableTreeNode ba = new DefaultMutableTreeNode("ba");
    DefaultMutableTreeNode ca = new DefaultMutableTreeNode("ca");

    protected void setUp() throws Exception {
        this.frame = new JFrame();
        this.frame.getContentPane().add(this.tree);
        this.frame.setSize(400, 400);
        this.frame.setVisible(true);
        this.root.add(this.a);
        this.root.add(this.b);
        this.root.add(this.c);
        this.a.add(this.aa);
        this.a.add(this.ab);
        this.b.add(this.ba);
        this.c.add(this.ca);
        this.aa.add(this.aaa);
        this.aa.add(this.aab);
        this.aa.add(this.aac);
        DefaultTreeModel model2 = new DefaultTreeModel(this.root);
        this.tree.setModel(model2);
        this.tree.setEditable(true);
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

    public void typeDigit(char character) {
        int code = 48 + (character - 48);
        this.r.keyPress(code);
        this.r.keyRelease(code);
    }

    public void type(int code) {
        this.r.keyPress(code);
        this.r.keyRelease(code);
    }

    public void testTree() throws Exception {
        this.assertEquals("Value before F2 editing", this.root.getUserObject(), "root");
        TreePath rootPath = this.tree.getPathForRow(0);
        this.clickPath(this.tree, rootPath);
        this.type(113);
        this.type(35);
        this.typeDigit('0');
        this.type(10);
        this.assertEquals("Value after F2 editing", this.root.getUserObject(), "root0");
        this.clickPath(this.tree, rootPath);
        this.r.delay(1000);
        this.clickPath(this.tree, rootPath);
        this.r.delay(1000);
        this.type(35);
        this.typeDigit('1');
        this.type(10);
        this.assertEquals("Value after click-pause-click", this.root.getUserObject(), "root01");
        this.tree.setRootVisible(true);
        this.testNavigation();
    }

    public void testNavigation() throws Exception {
        this.type(40);
        this.assertEquals("navigation down 1", this.getFocus(), "a");
        this.type(40);
        this.assertEquals("navigation down 2", this.getFocus(), "b");
        this.type(40);
        this.assertEquals("navigation down 3", this.getFocus(), "c");
        this.type(38);
        this.assertEquals("navigation up 1", this.getFocus(), "b");
        this.type(38);
        this.assertEquals("navigation up 2", this.getFocus(), "a");
        this.type(39);
        this.assertEquals("expansion", this.getFocus(), "a");
        this.type(40);
        this.assertEquals("navigation down after expansion 1", this.getFocus(), "aa");
        this.type(40);
        this.assertEquals("navigation down after expansion 2", this.getFocus(), "ab");
        this.type(40);
        this.assertEquals("navigation down after expansion 3", this.getFocus(), "b");
        this.type(38);
        this.assertEquals("navigation up after expansion 1", this.getFocus(), "ab");
        this.type(38);
        this.assertEquals("navigation up after expansion 2", this.getFocus(), "aa");
        this.type(39);
        this.assertEquals("expansion 2", this.getFocus(), "aa");
        this.type(40);
        this.assertEquals("navigation down after expansion 1", this.getFocus(), "aaa");
        this.type(40);
        this.assertEquals("navigation down after expansion 2", this.getFocus(), "aab");
        this.type(40);
        this.assertEquals("navigation down after expansion 3", this.getFocus(), "aac");
        this.type(40);
        this.assertEquals("navigation up after expansion 1", this.getFocus(), "ab");
        this.type(40);
        this.assertEquals("navigation up after expansion 2", this.getFocus(), "b");
        this.type(38);
        this.type(38);
        this.type(37);
        this.assertEquals("navigation 1", this.getFocus(), "aa");
        this.type(37);
        this.assertEquals("navigation 1", this.getFocus(), "aa");
        this.type(40);
        this.assertEquals("navigation down after expansion 2", this.getFocus(), "ab");
        this.type(40);
        this.assertEquals("navigation down after expansion 3", this.getFocus(), "b");
        TreePath bPath = this.tree.getSelectionPath();
        this.assertTrue("b path must be collapsed", !this.tree.isExpanded(bPath));
        Rectangle bounds = this.tree.getPathBounds(bPath);
        this.click(this.tree, bounds.x - 9, bounds.y + 9);
        this.r.delay(200);
        this.assertTrue("b path must be expanded", this.tree.isExpanded(bPath));
        this.type(40);
        this.assertEquals("navigation down after expansion 4", this.getFocus(), "ba");
        this.type(38);
        this.click(this.tree, bounds.x - 9, bounds.y + 9);
        this.r.delay(200);
        this.type(40);
        this.assertEquals("navigation down after expansion 5", this.getFocus(), "c");
        this.tree.setSelectionRow(0);
        this.type(37);
    }

    public Object getFocus() {
        return ((DefaultMutableTreeNode)this.tree.getSelectionPath().getLastPathComponent()).getUserObject();
    }

    @Override
    public void test(TestHarness harness) {
        try {
            this.h = harness;
            this.setUp();
            try {
                this.testTree();
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

