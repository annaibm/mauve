/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

public class getPreferredSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testPlain(harness);
        this.testWithUI(harness);
        this.testWithLayout(harness);
        this.testWithUIAndLayout(harness);
        this.testWithSet(harness);
        this.testWithSetAndUI(harness);
        this.testWithSetAndLayout(harness);
        this.testWithAll(harness);
        this.testSmallerThanMinSize(harness);
        this.testChangeValue(harness);
    }

    private void testPlain(TestHarness h) {
        h.checkPoint("plain");
        TestComponent c = new TestComponent();
        Dimension d = c.getPreferredSize();
        h.check(d.width, 0);
        h.check(d.height, 0);
    }

    private void testWithUI(TestHarness h) {
        h.checkPoint("withUI");
        TestComponent c = new TestComponent();
        c.setUI(new TestUI());
        Dimension d = c.getPreferredSize();
        h.check(d.width, 100);
        h.check(d.height, 100);
    }

    private void testWithLayout(TestHarness h) {
        h.checkPoint("withLayout");
        TestComponent c = new TestComponent();
        c.setLayout(new TestLayout());
        Dimension d = c.getPreferredSize();
        h.check(d.width, 200);
        h.check(d.height, 200);
    }

    private void testWithUIAndLayout(TestHarness h) {
        h.checkPoint("withUIAndLayout");
        TestComponent c = new TestComponent();
        c.setUI(new TestUI());
        c.setLayout(new TestLayout());
        c.invalidate();
        Dimension d = c.getPreferredSize();
        h.check(d.width, 100);
        h.check(d.height, 100);
    }

    private void testWithSet(TestHarness h) {
        h.checkPoint("withSet");
        TestComponent c = new TestComponent();
        c.setPreferredSize(new Dimension(300, 300));
        Dimension d = c.getPreferredSize();
        h.check(d.width, 300);
        h.check(d.height, 300);
    }

    private void testWithSetAndUI(TestHarness h) {
        h.checkPoint("withSetAndUI");
        TestComponent c = new TestComponent();
        c.setPreferredSize(new Dimension(300, 300));
        c.setUI(new TestUI());
        Dimension d = c.getPreferredSize();
        h.check(d.width, 300);
        h.check(d.height, 300);
    }

    private void testWithSetAndLayout(TestHarness h) {
        h.checkPoint("withSetAndLayout");
        TestComponent c = new TestComponent();
        c.setPreferredSize(new Dimension(300, 300));
        c.setLayout(new TestLayout());
        Dimension d = c.getPreferredSize();
        h.check(d.width, 300);
        h.check(d.height, 300);
    }

    private void testWithAll(TestHarness h) {
        h.checkPoint("withAll");
        TestComponent c = new TestComponent();
        c.setUI(new TestUI());
        c.setLayout(new TestLayout());
        c.setPreferredSize(new Dimension(300, 300));
        Dimension d = c.getPreferredSize();
        h.check(d.width, 300);
        h.check(d.height, 300);
    }

    private void testSmallerThanMinSize(TestHarness h) {
        h.checkPoint("smallerThanMinSize");
        TestComponent c = new TestComponent();
        c.setMinimumSize(new Dimension(100, 100));
        c.setPreferredSize(new Dimension(50, 50));
        h.check(c.getPreferredSize(), new Dimension(50, 50));
    }

    private void testChangeValue(TestHarness h) {
        h.checkPoint("changeValue");
        TestComponent c = new TestComponent();
        c.setPreferredSize(new Dimension(100, 100));
        Dimension d = c.getPreferredSize();
        d.width = 200;
        d.height = 200;
        h.check(c.getPreferredSize(), new Dimension(100, 100));
    }

    static class TestLayout
    implements LayoutManager {
        TestLayout() {
        }

        @Override
        public void addLayoutComponent(String name2, Component component2) {
        }

        @Override
        public void removeLayoutComponent(Component component2) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return new Dimension(200, 200);
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return null;
        }

        @Override
        public void layoutContainer(Container parent) {
        }
    }

    static class TestUI
    extends ComponentUI {
        TestUI() {
        }

        @Override
        public Dimension getPreferredSize(JComponent c) {
            return new Dimension(100, 100);
        }
    }

    static class TestComponent
    extends JComponent {
        TestComponent() {
        }

        @Override
        public void setUI(ComponentUI ui) {
            super.setUI(ui);
        }
    }
}

