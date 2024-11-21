/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.ScrollPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.ScrollPane;

public class getScrollPosition
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ScrollPane pane = new ScrollPane();
        boolean fail = false;
        try {
            pane.getScrollPosition();
        }
        catch (NullPointerException e) {
            fail = true;
        }
        harness.check(fail);
    }
}

