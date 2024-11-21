/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.ScrollPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.ScrollPane;

public class add
implements Testlet {
    private static boolean layoutCalled;

    @Override
    public void test(TestHarness harness) {
        ScrollPane pane = new ScrollPane(1){

            @Override
            public void layout() {
                layoutCalled = true;
            }
        };
        Button b = new Button("Hello");
        b.setSize(400, 400);
        pane.add(b);
        harness.check(!layoutCalled);
        Frame f = new Frame("add");
        f.setSize(300, 300);
        f.add(pane);
        harness.check(!layoutCalled);
        f.show();
        harness.check(layoutCalled);
        harness.check(!(b.getParent() instanceof Panel));
        ScrollPane pane2 = new ScrollPane(1);
        Frame f2 = new Frame("add2");
        Panel p = new Panel();
        p.setSize(400, 400);
        pane2.add(p);
        f2.setSize(300, 300);
        f2.add(pane2);
        f2.show();
        harness.check(!(p.getParent() instanceof Panel));
        ScrollPane pane3 = new ScrollPane(1);
        Frame f3 = new Frame("add2");
        Component c = new Component(){};
        c.setSize(400, 400);
        pane3.add(c);
        f3.setSize(300, 300);
        f3.add(pane3);
        f3.show();
        harness.check(c.getParent() instanceof Panel);
        f.dispose();
        f2.dispose();
        f3.dispose();
    }
}

