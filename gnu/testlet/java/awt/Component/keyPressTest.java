/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Component;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Robot;

public class keyPressTest
implements Testlet {
    final Object lock = new Object();
    volatile Integer key = null;
    Robot r;
    myFrame f;
    TestHarness h;

    @Override
    public void test(TestHarness h) {
        this.f = new myFrame();
        this.r = h.createRobot();
        this.h = h;
        this.f.setSize(200, 200);
        this.f.show();
        this.waitForWindow();
        this.runTest(65, 'a');
        this.runTest(66, 'b');
        this.runTest(67, 'c');
        this.runTest(68, 'd');
        this.runTest(69, 'e');
        this.runTest(70, 'f');
        this.runTest(71, 'g');
        this.runTest(72, 'h');
        this.runTest(73, 'i');
        this.runTest(74, 'j');
        this.runTest(75, 'k');
        this.runTest(76, 'l');
        this.runTest(77, 'm');
        this.runTest(78, 'n');
        this.runTest(79, 'o');
        this.runTest(80, 'p');
        this.runTest(81, 'q');
        this.runTest(82, 'r');
        this.runTest(83, 's');
        this.runTest(84, 't');
        this.runTest(85, 'u');
        this.runTest(86, 'v');
        this.runTest(87, 'w');
        this.runTest(88, 'x');
        this.runTest(89, 'y');
        this.runTest(90, 'z');
        this.f.dispose();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void runTest(int code, char chr) {
        int k;
        this.r.mouseMove(60, 60);
        Object object = this.lock;
        synchronized (object) {
            this.key = null;
            this.r.keyPress(code);
            this.r.keyRelease(code);
            try {
                this.lock.wait();
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            k = this.key;
        }
        this.h.check(k, chr);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void waitForWindow() {
        Object object = this.lock;
        synchronized (object) {
            while (this.key == null) {
                this.r.keyPress(61);
                this.r.keyRelease(61);
                try {
                    this.lock.wait(100L);
                }
                catch (InterruptedException interruptedException) {}
            }
            this.r.keyPress(59);
            this.r.keyRelease(59);
        }
        while (this.key != 59) {
            try {
                Thread.sleep(100L);
            }
            catch (InterruptedException interruptedException) {}
        }
    }

    class myFrame
    extends Frame {
        myFrame() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean keyDown(Event e, int i) {
            Object object = keyPressTest.this.lock;
            synchronized (object) {
                keyPressTest.this.key = new Integer(e.key);
                keyPressTest.this.lock.notifyAll();
            }
            return super.keyDown(e, i);
        }
    }
}

