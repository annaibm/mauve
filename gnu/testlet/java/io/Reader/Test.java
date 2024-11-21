/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.Reader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.Reader;

public class Test
extends Reader
implements Testlet {
    private int index;
    private String s;

    public Test() {
    }

    Test(String str) {
        this.s = str;
        this.index = 0;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int i;
        for (i = 0; i < len; ++i) {
            cbuf[off + i] = this.s.charAt(this.index++);
        }
        return i;
    }

    @Override
    public void close() throws IOException {
    }

    @Override
    public void test(TestHarness harness) {
        String str = "There are a ton of great places to see live, original\nmusic in Chicago.  Places like Lounge Ax, Schuba's, the Empty\nBottle, and even the dreaded Metro with their sometimes asshole\nbouncers.\n";
        Test sr = new Test(str);
        harness.check(true, "StringReader(String)");
        try {
            harness.check(!sr.ready(), "ready()");
        }
        catch (IOException e) {
            harness.fail("Unexpected IOException on ready()");
        }
        harness.check(!sr.markSupported(), "markSupported()");
        try {
            sr.mark(0);
            harness.fail("mark() should throw exception");
        }
        catch (IOException e) {
            harness.check(true, "mark()");
        }
        char[] buf = new char[4];
        try {
            harness.check(sr.read(buf, 0, 4), 4, "read(buf, off, len) return value");
            String bufstr = new String(buf);
            harness.check(bufstr, "Ther", "read(buf, off, len)");
        }
        catch (IOException e) {
            harness.fail("Unexpected IOException on read(buf, off, len)");
        }
        try {
            sr.reset();
            harness.fail("Expected IOException on reset()");
        }
        catch (IOException e) {
            harness.check(true, "reset()");
        }
        try {
            sr.skip(8L);
        }
        catch (IOException e) {
            harness.fail("Unexpected IOException on skip()");
        }
        try {
            harness.check(sr.read(), 116, "skip(), read()");
        }
        catch (IOException e) {
            harness.fail("Unexpected IOException on read()");
        }
        try {
            sr.close();
        }
        catch (IOException e) {
            harness.fail("Unexpected IOException on close()");
        }
        harness.check(true, "close()");
    }
}

