/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.ScrollPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AWTError;
import java.awt.BorderLayout;
import java.awt.ScrollPane;

public class testSetLayout
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ScrollPane pane = new ScrollPane();
        boolean fail = false;
        try {
            pane.setLayout(null);
        }
        catch (AWTError e) {
            fail = true;
        }
        harness.check(fail);
        fail = false;
        try {
            pane.setLayout(new BorderLayout());
        }
        catch (AWTError e) {
            fail = true;
        }
        harness.check(fail);
    }
}

