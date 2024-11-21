/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Container;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager2;

public class getPreferredSize
implements Testlet {
    boolean invalidateCalled;

    @Override
    public void test(TestHarness harness) {
        this.testInvalid(harness);
    }

    private void testInvalid(TestHarness harness) {
        Container c = new Container();
        TestLM lm = new TestLM();
        c.setLayout(lm);
        c.invalidate();
        this.invalidateCalled = false;
        c.getPreferredSize();
        c.getPreferredSize();
        harness.check(this.invalidateCalled, false);
    }

    class TestLM
    implements LayoutManager2 {
        TestLM() {
        }

        @Override
        public void addLayoutComponent(Component component2, Object constraints) {
        }

        @Override
        public Dimension maximumLayoutSize(Container target) {
            return null;
        }

        @Override
        public float getLayoutAlignmentX(Container target) {
            return 0.0f;
        }

        @Override
        public float getLayoutAlignmentY(Container target) {
            return 0.0f;
        }

        @Override
        public void invalidateLayout(Container target) {
            getPreferredSize.this.invalidateCalled = true;
        }

        @Override
        public void addLayoutComponent(String name2, Component component2) {
        }

        @Override
        public void removeLayoutComponent(Component component2) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return new Dimension(100, 100);
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return null;
        }

        @Override
        public void layoutContainer(Container parent) {
        }
    }
}

