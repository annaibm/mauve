/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Component;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;

public class setFont
implements Testlet {
    private boolean invalidated;

    @Override
    public void test(TestHarness harness) {
        this.testInvalidate(harness);
    }

    private void testInvalidate(TestHarness h) {
        h.checkPoint("invalidate");
        TestComponent c = new TestComponent();
        c.validate();
        h.check(!c.isValid());
        this.invalidated = false;
        c.setFont(new Font("Dialog", 1, 12));
        h.check(this.invalidated);
        h.check(!c.isValid());
        this.invalidated = false;
        c.setFont(new Font("Dialog", 1, 12));
        h.check(!this.invalidated);
        Frame f = new Frame();
        f.add(c);
        f.setSize(100, 100);
        f.setVisible(true);
        h.check(c.isShowing());
        c.validate();
        h.check(c.isValid());
        this.invalidated = false;
        c.setFont(new Font("Dialog", 1, 12));
        h.check(this.invalidated);
        h.check(!c.isValid());
        this.invalidated = false;
        c.setFont(new Font("Dialog", 1, 12));
        h.check(!this.invalidated);
    }

    private class TestComponent
    extends Component {
        private TestComponent() {
        }

        @Override
        public void invalidate() {
            super.invalidate();
            setFont.this.invalidated = true;
        }
    }
}

