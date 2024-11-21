/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.BoxLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AWTError;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class preferredLayoutSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testBasic(harness);
        this.testXAxis(harness);
        this.testYAxis(harness);
        this.testLineAxis(harness);
        this.testPageAxis(harness);
        this.testJSeparator(harness);
    }

    private void testBasic(TestHarness harness) {
        JPanel container = new JPanel();
        BoxLayout layout2 = new BoxLayout(container, 0);
        harness.check(layout2.preferredLayoutSize(container), new Dimension(0, 0));
        container.setBorder(BorderFactory.createEmptyBorder(1, 2, 3, 4));
        harness.check(layout2.preferredLayoutSize(container), new Dimension(6, 4));
        boolean pass = false;
        try {
            layout2.preferredLayoutSize(new JPanel());
        }
        catch (AWTError e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testXAxis(TestHarness harness) {
        harness.checkPoint("testXAxis");
        JPanel container = new JPanel();
        container.setSize(100, 200);
        BoxLayout layout2 = new BoxLayout(container, 0);
        container.setLayout(layout2);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        p1.setPreferredSize(new Dimension(11, 22));
        p2.setPreferredSize(new Dimension(33, 44));
        p3.setPreferredSize(new Dimension(55, 66));
        container.add(p1);
        container.add(p2);
        container.add(p3);
        harness.check(layout2.preferredLayoutSize(container), new Dimension(99, 66));
    }

    private void testYAxis(TestHarness harness) {
        harness.checkPoint("testYAxis");
        JPanel container = new JPanel();
        container.setSize(100, 200);
        BoxLayout layout2 = new BoxLayout(container, 1);
        container.setLayout(layout2);
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
        harness.check(layout2.preferredLayoutSize(container), new Dimension(55, 132));
    }

    private void testLineAxis(TestHarness harness) {
        harness.checkPoint("testLineAxis");
        JPanel container = new JPanel();
        container.setSize(100, 200);
        BoxLayout layout2 = new BoxLayout(container, 2);
        container.setLayout(layout2);
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
        harness.check(layout2.preferredLayoutSize(container), new Dimension(99, 66));
    }

    private void testPageAxis(TestHarness harness) {
        harness.checkPoint("testPageAxis");
        JPanel container = new JPanel();
        container.setSize(100, 200);
        BoxLayout layout2 = new BoxLayout(container, 3);
        container.setLayout(layout2);
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
        harness.check(layout2.preferredLayoutSize(container), new Dimension(55, 132));
    }

    private void testJSeparator(TestHarness harness) {
        harness.checkPoint("testJSeparator");
        JPanel container = new JPanel();
        container.setSize(100, 200);
        BoxLayout layout2 = new BoxLayout(container, 1);
        container.setLayout(layout2);
        JSeparator s1 = new JSeparator();
        container.add(s1);
        container.doLayout();
        harness.check(layout2.preferredLayoutSize(container), new Dimension(0, 2));
    }
}

