/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.PipedStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class receive
extends PipedInputStream
implements Runnable,
Testlet {
    static Thread main;
    static receive in;
    static PipedOutputStream out;

    receive(PipedOutputStream x) throws IOException {
        super(x);
    }

    public receive() {
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000L);
            in.receive(23);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Override
    public void test(TestHarness harness) {
        int val = -1;
        try {
            main = Thread.currentThread();
            out = new PipedOutputStream();
            in = new receive(out);
            new Thread(in).start();
            val = in.read();
        }
        catch (Throwable t) {
            val = -2;
        }
        harness.check(val, 23);
    }
}

