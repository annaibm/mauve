/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.PipedStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class close
implements Runnable,
Testlet {
    Thread main;
    PipedInputStream in;
    PipedOutputStream out;
    TestHarness harness;

    @Override
    public void run() {
        try {
            Thread.sleep(1000L);
            this.harness.debug("Closing pipe input stream:");
            this.in.close();
            Thread.sleep(1000L);
            this.harness.debug("Interrupting pipe reader:");
            this.main.interrupt();
        }
        catch (Throwable t) {
            this.harness.debug(t);
        }
    }

    @Override
    public void test(TestHarness harness) {
        int val = 23;
        try {
            close test = new close();
            test.harness = harness;
            test.main = Thread.currentThread();
            test.out = new PipedOutputStream();
            test.in = new PipedInputStream(test.out);
            new Thread(test).start();
            val = test.in.read();
        }
        catch (InterruptedIOException t) {
            harness.check(true, "read() interrupted okay");
        }
        catch (IOException t) {
            harness.fail("Unexpected IOException thrown");
        }
    }
}

