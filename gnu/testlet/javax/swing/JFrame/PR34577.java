/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JFrame;
import javax.swing.JRootPane;

public class PR34577
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        new TestFrame(harness);
    }

    static class TestFrame
    extends JFrame {
        public TestFrame(TestHarness h) {
            super("TestFrame");
            try {
                this.setRootPane(new JRootPane());
                h.check(true, "Root pane changed successfully.");
            }
            catch (IllegalArgumentException e) {
                h.debug(e);
                h.fail("Root pane could not be changed.");
            }
        }
    }
}

