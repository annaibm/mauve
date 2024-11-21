/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Component;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

public class getForeground
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestComponent c = new TestComponent();
        harness.check(c.getForeground(), null);
        Container c2 = new Container();
        c2.setForeground(Color.GREEN);
        c2.add(c);
        harness.check(c.getForeground(), Color.GREEN);
    }

    class TestComponent
    extends Component {
        TestComponent() {
        }
    }
}

