/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JRootPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.IllegalComponentStateException;
import javax.swing.JRootPane;

public class setLayeredPane
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JRootPane rootPane = new JRootPane();
        boolean fail = false;
        try {
            rootPane.setLayeredPane(null);
        }
        catch (IllegalComponentStateException e) {
            fail = true;
        }
        harness.check(fail);
    }
}

