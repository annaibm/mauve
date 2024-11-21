/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.PrintWriter;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class checkError
extends OutputStream
implements Testlet {
    private boolean closed = false;

    @Override
    public void test(TestHarness harness) {
        PrintWriter p = new PrintWriter(new checkError());
        harness.check(!p.checkError());
        p.write("something");
        harness.check(!p.checkError());
        p.close();
        harness.check(!p.checkError());
        p.write("anotherthing");
        harness.check(p.checkError());
    }

    @Override
    public void close() {
        this.closed = true;
    }

    @Override
    public void write(int i) throws IOException {
        if (this.closed) {
            throw new IOException("closed stream");
        }
    }

    @Override
    public void flush() throws IOException {
        if (this.closed) {
            throw new IOException("closed stream");
        }
    }
}

