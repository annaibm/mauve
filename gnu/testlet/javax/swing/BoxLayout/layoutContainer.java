/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.BoxLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AWTError;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class layoutContainer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testXAxis(harness);
        this.testYAxis(harness);
        this.testLineAxis(harness);
        this.testPageAxis(harness);
        this.testOriginalContainer(harness);
        this.testOverflowCase(harness);
    }

    private void testXAxis(TestHarness harness) {
        harness.checkPoint("testXAxis");
        JPanel container = new JPanel();
        container.setSize(100, 200);
        container.setLayout(new BoxLayout(container, 0));
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        p1.setPreferredSize(new Dimension(11, 22));
        p2.setPreferredSize(new Dimension(33, 44));
        p3.setPreferredSize(new Dimension(55, 66));
        container.add(p1);
        container.add(p2);
        container.add(p3);
        container.doLayout();
        harness.check(p1.getBounds(), new Rectangle(0, 0, 11, 200));
        harness.check(p2.getBounds(), new Rectangle(11, 0, 33, 200));
        harness.check(p3.getBounds(), new Rectangle(44, 0, 55, 200));
    }

    private void testYAxis(TestHarness harness) {
        harness.checkPoint("testYAxis");
        JPanel container = new JPanel();
        container.setSize(100, 200);
        container.setLayout(new BoxLayout(container, 1));
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        p1.setPreferredSize(new Dimension(11, 22));
        p2.setPreferredSize(new Dimension(33, 44));
        p3.setPreferredSize(new Dimension(55, 66));
        container.add(p1);
        container.add(p2);
        container.add(p3);
        container.doLayout();
        harness.check(p1.getBounds(), new Rectangle(0, 0, 100, 44));
        harness.check(p2.getBounds(), new Rectangle(0, 44, 100, 66));
        harness.check(p3.getBounds(), new Rectangle(0, 110, 100, 88));
    }

    private void testLineAxis(TestHarness harness) {
        harness.checkPoint("testLineAxis");
        JPanel container = new JPanel();
        container.setSize(100, 200);
        container.setLayout(new BoxLayout(container, 2));
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        p1.setPreferredSize(new Dimension(11, 22));
        p2.setPreferredSize(new Dimension(33, 44));
        p3.setPreferredSize(new Dimension(55, 66));
        container.add(p1);
        container.add(p2);
        container.add(p3);
        container.doLayout();
        harness.check(p1.getBounds(), new Rectangle(0, 0, 11, 200));
        harness.check(p2.getBounds(), new Rectangle(11, 0, 33, 200));
        harness.check(p3.getBounds(), new Rectangle(44, 0, 55, 200));
    }

    private void testPageAxis(TestHarness harness) {
        harness.checkPoint("testPageAxis");
        JPanel container = new JPanel();
        container.setSize(100, 200);
        container.setLayout(new BoxLayout(container, 3));
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        p1.setPreferredSize(new Dimension(11, 22));
        p2.setPreferredSize(new Dimension(33, 44));
        p3.setPreferredSize(new Dimension(55, 66));
        container.add(p1);
        container.add(p2);
        container.add(p3);
        container.doLayout();
        harness.check(p1.getBounds(), new Rectangle(0, 0, 100, 44));
        harness.check(p2.getBounds(), new Rectangle(0, 44, 100, 66));
        harness.check(p3.getBounds(), new Rectangle(0, 110, 100, 88));
    }

    private void testOriginalContainer(TestHarness harness) {
        harness.checkPoint("testOriginalContainer");
        JPanel container = new JPanel();
        BoxLayout layout2 = new BoxLayout(container, 0);
        boolean pass = false;
        try {
            layout2.layoutContainer(new JPanel());
        }
        catch (AWTError e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testOverflowCase(TestHarness harness) {
        harness.checkPoint("overflowCase");
        JComponent c1 = new JComponent(){};
        c1.setMinimumSize(new Dimension(4, 4));
        c1.setPreferredSize(new Dimension(49, 11));
        c1.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        JComponent c2 = new JComponent(){};
        c2.setMinimumSize(new Dimension(4, 4));
        c2.setPreferredSize(new Dimension(49, 11));
        c2.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        JComponent c3 = new JComponent(){};
        c3.setMinimumSize(new Dimension(4, 4));
        c3.setPreferredSize(new Dimension(49, 11));
        c3.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        Container c = new Container();
        BoxLayout l = new BoxLayout(c, 0);
        c.setLayout(l);
        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.setSize(670, 46);
        l.invalidateLayout(c);
        l.layoutContainer(c);
        harness.check(c1.getX(), 0);
        harness.check(c1.getY(), 0);
        harness.check(c1.getWidth(), 223);
        harness.check(c1.getHeight(), 46);
        harness.check(c2.getX(), 223);
        harness.check(c2.getY(), 0);
        harness.check(c2.getWidth(), 223);
        harness.check(c2.getHeight(), 46);
        harness.check(c3.getX(), 446);
        harness.check(c3.getY(), 0);
        harness.check(c3.getWidth(), 223);
        harness.check(c3.getHeight(), 46);
    }
}

