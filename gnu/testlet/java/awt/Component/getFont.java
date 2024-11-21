/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Component;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.awt.Frame;

public class getFont
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestComponent c = new TestComponent();
        harness.check(c.getFont(), null);
        Frame f = new Frame();
        f.add(c);
        f.setSize(100, 100);
        f.setVisible(true);
        harness.check(c.getFont(), c.getGraphics().getFont());
        f.dispose();
    }

    class TestComponent
    extends Component {
        TestComponent() {
        }
    }
}

