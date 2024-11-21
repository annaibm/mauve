/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Component;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;

public class repaint
implements Testlet {
    boolean repaint1Called;
    boolean repaint2Called;
    boolean repaint3Called;
    boolean repaint4Called;

    @Override
    public void test(TestHarness harness) {
        this.testNotShowing(harness);
    }

    private void testNotShowing(TestHarness h) {
        h.checkPoint("testNotShowing");
        TestComponent c = new TestComponent();
        h.check(!c.isShowing());
        this.repaint1Called = false;
        this.repaint2Called = false;
        this.repaint3Called = false;
        this.repaint4Called = false;
        c.repaint();
        h.check(this.repaint1Called);
        h.check(!this.repaint2Called);
        h.check(!this.repaint3Called);
        h.check(this.repaint4Called);
        this.repaint1Called = false;
        this.repaint2Called = false;
        this.repaint3Called = false;
        this.repaint4Called = false;
        c.repaint(100L);
        h.check(!this.repaint1Called);
        h.check(this.repaint2Called);
        h.check(!this.repaint3Called);
        h.check(this.repaint4Called);
        this.repaint1Called = false;
        this.repaint2Called = false;
        this.repaint3Called = false;
        this.repaint4Called = false;
        c.repaint(0, 0, 1, 2);
        h.check(!this.repaint1Called);
        h.check(!this.repaint2Called);
        h.check(this.repaint3Called);
        h.check(this.repaint4Called);
        this.repaint1Called = false;
        this.repaint2Called = false;
        this.repaint3Called = false;
        this.repaint4Called = false;
        c.repaint(100L, 0, 0, 1, 2);
        h.check(!this.repaint1Called);
        h.check(!this.repaint2Called);
        h.check(!this.repaint3Called);
        h.check(this.repaint4Called);
    }

    class TestComponent
    extends Component {
        TestComponent() {
        }

        @Override
        public void repaint() {
            super.repaint();
            repaint.this.repaint1Called = true;
        }

        @Override
        public void repaint(long tm) {
            super.repaint(tm);
            repaint.this.repaint2Called = true;
        }

        @Override
        public void repaint(int x, int y, int w, int h) {
            super.repaint(x, y, w, h);
            repaint.this.repaint3Called = true;
        }

        @Override
        public void repaint(long tm, int x, int y, int w, int h) {
            super.repaint(tm, x, y, w, h);
            repaint.this.repaint4Called = true;
        }
    }
}

