/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Container;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;

public class setLayout
implements Testlet {
    private boolean invalidated;

    @Override
    public void test(TestHarness harness) {
        this.testInvalidate(harness);
    }

    private void testInvalidate(TestHarness h) {
        h.checkPoint("invalidate");
        TestContainer c = new TestContainer();
        c.validate();
        h.check(!c.isValid());
        this.invalidated = false;
        c.setLayout(new FlowLayout());
        h.check(!this.invalidated);
        h.check(!c.isValid());
        this.invalidated = false;
        c.setLayout(new FlowLayout());
        h.check(!this.invalidated);
        Frame f = new Frame();
        f.add(c);
        f.setSize(100, 100);
        f.setVisible(true);
        h.check(c.isShowing());
        c.validate();
        h.check(c.isValid());
        this.invalidated = false;
        c.setLayout(new FlowLayout());
        h.check(this.invalidated);
        h.check(!c.isValid());
        this.invalidated = false;
        c.setLayout(new FlowLayout());
        h.check(!this.invalidated);
        f.dispose();
    }

    private class TestContainer
    extends Container {
        private TestContainer() {
        }

        @Override
        public void invalidate() {
            super.invalidate();
            setLayout.this.invalidated = true;
        }
    }
}

