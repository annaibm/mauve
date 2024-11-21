/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.GridLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

public class minimumLayoutSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Container container = new Container();
        GridLayout layout2 = new GridLayout();
        harness.check(layout2.minimumLayoutSize(container), new Dimension(0, 0));
    }
}

