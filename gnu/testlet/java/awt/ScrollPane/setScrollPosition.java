/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.ScrollPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.Point;
import java.awt.ScrollPane;

public class setScrollPosition
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
        this.test4(harness);
        this.test5(harness);
    }

    public void test1(TestHarness harness) {
        ScrollPane pane = new ScrollPane();
        boolean fail = false;
        try {
            pane.setScrollPosition(0, 0);
        }
        catch (NullPointerException e) {
            fail = true;
        }
        harness.check(fail);
    }

    public void test2(TestHarness harness) {
        ScrollPane pane = new ScrollPane();
        Button button = new Button();
        pane.add(button);
        harness.check(pane.getComponentCount(), 1);
        harness.check(pane.getComponent(0), button);
        harness.check(pane.getScrollPosition(), new Point());
    }

    public void test3(TestHarness harness) {
        ScrollPane pane = new ScrollPane();
        pane.add(new Button());
        pane.setScrollPosition(1, 1);
        harness.check(pane.getScrollPosition(), new Point(0, 0));
        pane.setScrollPosition(new Point(1, 1));
        harness.check(pane.getScrollPosition(), new Point(0, 0));
    }

    public void test4(TestHarness harness) {
        ScrollPane pane = new ScrollPane();
        pane.add(new Button());
        pane.setScrollPosition(-1, -1);
        harness.check(pane.getScrollPosition(), new Point());
        pane.setScrollPosition(0, 0);
        harness.check(pane.getScrollPosition(), new Point());
    }

    public void test5(TestHarness harness) {
        ScrollPane pane = new ScrollPane();
        Button button = new Button();
        button.setSize(100, 100);
        pane.add(button);
        harness.check(pane.getComponent(0).getWidth(), 100);
        harness.check(pane.getComponent(0).getHeight(), 100);
        harness.check(pane.getViewportSize().getWidth(), 100.0);
        harness.check(pane.getViewportSize().getHeight(), 100.0);
        int x = 100;
        int y = 100;
        int tempx = (int)((double)pane.getComponent(0).getWidth() - pane.getViewportSize().getWidth());
        int tempy = (int)((double)pane.getComponent(0).getHeight() - pane.getViewportSize().getHeight());
        harness.check(tempx < x);
        harness.check(tempy < y);
        pane.setScrollPosition(x, y);
        harness.check(pane.getScrollPosition().getX(), (double)tempx);
        harness.check(pane.getScrollPosition().getY(), (double)tempy);
    }
}

