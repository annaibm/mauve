/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.FlowLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.List;

public class minimumLayoutSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Container container = new Container();
        FlowLayout layout2 = new FlowLayout();
        harness.check(layout2.minimumLayoutSize(container), new Dimension(10, 10));
        container.add(new Button());
        harness.check(layout2.minimumLayoutSize(container), new Dimension(10, 10));
        container.add(new Button());
        container.add(new List());
        harness.check(layout2.minimumLayoutSize(container), new Dimension(20, 10));
    }
}

