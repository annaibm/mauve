/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Object;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public final class wait
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            this.wait(-1L);
            harness.fail("bad arg not detected");
        }
        catch (IllegalArgumentException iae) {
            harness.check(true, "bad arg detected");
        }
        catch (IllegalMonitorStateException imse) {
            harness.fail("bad arg not detected");
        }
        catch (InterruptedException ie) {
            harness.fail("bad arg not detected");
        }
        try {
            this.wait(0L, -1);
            harness.fail("bad arg not detected");
        }
        catch (IllegalArgumentException iae) {
            harness.check(true, "bad arg detected");
        }
        catch (IllegalMonitorStateException imse) {
            harness.fail("bad arg not detected");
        }
        catch (InterruptedException ie) {
            harness.fail("bad arg not detected");
        }
        try {
            this.wait(0L, 1000000);
            harness.fail("bad arg not detected");
        }
        catch (IllegalArgumentException iae) {
            harness.check(true, "bad arg detected");
        }
        catch (IllegalMonitorStateException imse) {
            harness.fail("bad arg not detected");
        }
        catch (InterruptedException ie) {
            harness.fail("bad arg not detected");
        }
        try {
            this.wait();
            harness.fail("wait called outside synchronized block");
        }
        catch (IllegalMonitorStateException imse) {
            harness.check(true, "wait called outside synchronized block");
        }
        catch (InterruptedException ie) {
            harness.fail("wait called outside synchronized block");
        }
        try {
            this.wait(1L);
            harness.fail("wait called outside synchronized block");
        }
        catch (IllegalMonitorStateException imse) {
            harness.check(true, "wait called outside synchronized block");
        }
        catch (InterruptedException ie) {
            harness.fail("wait called outside synchronized block");
        }
        try {
            this.wait(1L, 0);
            harness.fail("wait called outside synchronized block");
        }
        catch (IllegalMonitorStateException imse) {
            harness.check(true, "wait called outside synchronized block");
        }
        catch (InterruptedException ie) {
            harness.fail("wait called outside synchronized block");
        }
        try {
            this.notify();
            harness.fail("notify called outside synchronized block");
        }
        catch (IllegalMonitorStateException imse) {
            harness.check(true, "notify called outside synchronized block");
        }
        try {
            this.notifyAll();
            harness.fail("notifyAll called outside synchronized block");
        }
        catch (IllegalMonitorStateException imse) {
            harness.check(true, "notifyAll called outside synchronized block");
        }
    }
}

