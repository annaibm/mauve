/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Container;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.awt.Container.DisabledEventQueue;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

public class addImpl
implements Testlet {
    boolean componentAddedCalled;

    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        Toolkit.getDefaultToolkit().getSystemEventQueue().push(new DisabledEventQueue());
        final TestHarness transfer = harness;
        Container c = new Container(){
            TestHarness harness;
            {
                this.harness = transfer;
            }

            @Override
            public void repaint(long tm, int x, int y, int w, int h) {
                this.harness.fail("repaint has been called.");
            }
        };
        c.addContainerListener(new TestContainerListener());
        harness.check(c.isShowing(), false);
        this.componentAddedCalled = false;
        Component a = new Component(){
            TestHarness harness;
            {
                this.harness = transfer;
            }

            @Override
            public void repaint(long tm, int x, int y, int w, int h) {
                this.harness.fail("repaint has been called.");
            }
        };
        Component b = new Component(){
            TestHarness harness;
            {
                this.harness = transfer;
            }

            @Override
            public void repaint(long tm, int x, int y, int w, int h) {
                this.harness.fail("repaint has been called.");
            }
        };
        c.add(a);
        harness.check(this.componentAddedCalled, true);
        Container two = new Container(){
            TestHarness harness;
            {
                this.harness = transfer;
            }

            @Override
            public void repaint(long tm, int x, int y, int w, int h) {
                this.harness.fail("repaint has been called.");
            }
        };
        two.setLayout(new LayoutManager(){
            TestHarness harness;
            Dimension size;
            {
                this.harness = transfer;
                this.size = new Dimension();
            }

            @Override
            public void removeLayoutComponent(Component comp) {
            }

            @Override
            public Dimension preferredLayoutSize(Container cont) {
                return this.size;
            }

            @Override
            public Dimension minimumLayoutSize(Container cont) {
                return this.size;
            }

            @Override
            public void layoutContainer(Container container) {
            }

            @Override
            public void addLayoutComponent(String name2, Component comp) {
                boolean pass = name2 != null;
                this.harness.check(pass, true);
            }
        });
        harness.check(two.isShowing(), false);
        this.componentAddedCalled = false;
        two.addContainerListener(new TestContainerListener());
        two.add(b);
        harness.check(this.componentAddedCalled, true);
    }

    public void test2(TestHarness harness) {
        final TestHarness transfer = harness;
        Frame f = new Frame(){
            TestHarness harness;
            {
                this.harness = transfer;
            }

            @Override
            public void repaint(long tm, int x, int y, int w, int h) {
                this.harness.fail("repaint has been called.");
            }
        };
        Panel a = new Panel(){
            TestHarness harness;
            {
                this.harness = transfer;
            }

            @Override
            public void repaint(long tm, int x, int y, int w, int h) {
                this.harness.fail("repaint has been called.");
            }
        };
        Label l = new Label("!!!!!"){
            TestHarness harness;
            {
                super(x0);
                this.harness = transfer;
            }

            @Override
            public void repaint(long tm, int x, int y, int w, int h) {
                this.harness.fail("repaint has been called.");
            }
        };
        Container c = new Container(){
            TestHarness harness;
            {
                this.harness = transfer;
            }

            @Override
            public void repaint(long tm, int x, int y, int w, int h) {
                this.harness.fail("repaint has been called.");
            }
        };
        a.add(c);
        a.add(l);
        c.setSize(100, 100);
        f.add(a);
        f.pack();
        f.show();
        harness.check(a.isShowing(), true);
        harness.check(c.isShowing(), true);
        harness.check(l.isShowing(), true);
        harness.check(f.isShowing(), true);
        harness.check(c.isLightweight(), true);
        harness.check(a.isLightweight(), false);
        harness.check(l.isLightweight(), false);
        f.dispose();
    }

    class TestContainerListener
    implements ContainerListener {
        TestContainerListener() {
        }

        @Override
        public void componentAdded(ContainerEvent event) {
            addImpl.this.componentAddedCalled = true;
        }

        @Override
        public void componentRemoved(ContainerEvent event) {
        }
    }
}

