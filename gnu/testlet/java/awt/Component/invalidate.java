/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Component;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;

public class invalidate
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.testInvalidateInvalidComponent(harness);
    }

    private void test1(TestHarness harness) {
        TestComponent comp = new TestComponent();
        Frame frame = new Frame();
        frame.add(comp);
        frame.setVisible(true);
        comp.invalidated = false;
        comp.setSize(100, 200);
        harness.check(comp.invalidated, true);
        comp.invalidated = false;
        comp.setSize(new Dimension(101, 201));
        harness.check(comp.invalidated, true);
        comp.invalidated = false;
        comp.resize(102, 202);
        harness.check(comp.invalidated, true);
        frame.dispose();
    }

    private void test2(TestHarness harness) {
        myComponent c = new myComponent();
        harness.check(c.isPreferredSizeSet(), false);
        c.setPreferredSize(new Dimension(400, 500));
        Dimension prefSizeOld = c.getPreferredSize();
        harness.check(c.isPreferredSizeSet(), true);
        c.invalidate();
        harness.check(c.isPreferredSizeSet(), true);
        Dimension prefSizeNew = c.getPreferredSize();
        harness.check(prefSizeOld != prefSizeNew);
        harness.check(prefSizeOld.equals(prefSizeNew));
    }

    private void testInvalidateInvalidComponent(TestHarness harness) {
        harness.checkPoint("invalidateInvalidComponent");
        Frame f = new Frame();
        TestContainer c1 = new TestContainer();
        TestComponent c2 = new TestComponent();
        c1.add(c2);
        f.add(c1);
        f.setSize(100, 100);
        f.setVisible(true);
        c1.validate();
        c2.validate();
        harness.check(c1.isValid(), true);
        harness.check(c1.isValid(), true);
        c1.invalidated = false;
        c2.invalidated = false;
        c2.invalidate();
        harness.check(c1.invalidated, true);
        harness.check(c2.invalidated, true);
        c1.invalidated = false;
        c2.invalidated = false;
        c2.invalidate();
        harness.check(c1.invalidated, false);
        harness.check(c2.invalidated, true);
        f.dispose();
    }

    public class myComponent
    extends Component {
    }

    class TestContainer
    extends Container {
        boolean invalidated;

        TestContainer() {
        }

        @Override
        public void invalidate() {
            this.invalidated = true;
            super.invalidate();
        }
    }

    public class TestComponent
    extends Component {
        boolean invalidated;

        @Override
        public void invalidate() {
            this.invalidated = true;
            super.invalidate();
        }
    }
}

