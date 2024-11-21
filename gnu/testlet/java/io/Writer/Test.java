/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.Writer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.Writer;

public class Test
extends Writer
implements Testlet {
    private static final int LEN = 100;
    private int index;
    private char[] buf;

    public Test() {
        this.buf = new char[100];
        this.index = 0;
    }

    Test(Object lock2) {
        super(lock2);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = 0; i < len; ++i) {
            this.buf[this.index++] = cbuf[off + i];
        }
    }

    @Override
    public void flush() throws IOException {
    }

    @Override
    public void close() throws IOException {
    }

    public String toString() {
        return new String(this.buf, 0, this.index);
    }

    @Override
    public void test(TestHarness harness) {
        Test tw = new Test();
        char[] buff = new char[]{'A', 'B', 'C', 'D'};
        try {
            tw.write(88);
            harness.check(true, "write(int)");
            tw.write(buff);
            harness.check(true, "write(buf)");
            tw.write(buff, 1, 2);
            harness.check(true, "write(buf, off, len)");
            tw.write("YZ");
            harness.check(true, "write(string)");
            tw.write("abcde", 2, 2);
            harness.check(tw.toString(), "XABCDBCYZcd", "All Characters written okay");
        }
        catch (IOException e) {
            harness.fail("Unexpected IOException");
        }
        boolean npe_thrown = false;
        try {
            new Test(null);
        }
        catch (NullPointerException npe) {
            npe_thrown = true;
        }
        harness.check(npe_thrown, "null lock object");
    }
}

