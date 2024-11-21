/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.BoxLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class removeLayoutComponent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            BoxLayout layout2 = new BoxLayout(new JPanel(), 0);
            layout2.removeLayoutComponent(new JPanel());
            layout2.removeLayoutComponent(null);
            harness.check(true);
        }
        catch (Throwable e) {
            harness.check(false);
        }
    }
}

