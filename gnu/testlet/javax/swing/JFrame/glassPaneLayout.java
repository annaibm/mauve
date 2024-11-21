/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class glassPaneLayout
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFrame f = new JFrame();
        harness.check(((Container)f.getGlassPane()).getLayout().getClass(), FlowLayout.class);
    }
}

