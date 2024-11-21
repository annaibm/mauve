/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.ScrollPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.ScrollPane;

public class doLayout
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
    }

    public void test1(TestHarness harness) {
        ScrollPane pane = new ScrollPane();
        Button button = new Button();
        button.setLocation(100, 250);
        pane.add(button);
        harness.check(button.getLocation().getX(), 100.0);
        harness.check(button.getLocation().getY(), 250.0);
        pane.doLayout();
        harness.check(button.getLocation().getX(), 0.0);
        harness.check(button.getLocation().getY(), 0.0);
    }
}

