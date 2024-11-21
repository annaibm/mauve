/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.StringReader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.StringReader;

public class Test
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String str = "There are a ton of great places to see live, original\nmusic in Chicago.  Places like Lounge Ax, Schuba's, the Empty\nBottle, and even the dreaded Metro with their sometimes asshole\nbouncers.\n";
        StringReader sr = new StringReader(str);
        harness.check(true, "StringReader(String)");
        try {
            harness.check(sr.ready(), "ready()");
        }
        catch (IOException e) {
            harness.fail("Unexpected IOException on ready()");
        }
        harness.check(sr.markSupported(), "markSupported()");
        try {
            sr.mark(0);
            harness.check(true, "mark()");
        }
        catch (IOException e) {
            harness.fail("mark() should not throw exception");
        }
        char[] buf = new char[4];
        try {
            sr.read(buf, 0, 4);
        }
        catch (IOException e) {
            harness.fail("Unexpected IOException on read(buf, off, len)");
        }
        String bufstr = new String(buf);
        harness.check(bufstr, "Ther", "read(buf, off, len)");
        try {
            sr.reset();
        }
        catch (IOException e) {
            harness.fail("Unexpected IOException on reset()");
        }
        harness.check(true, "reset()");
        try {
            sr.skip(7L);
        }
        catch (IOException e) {
            harness.fail("Unexpected IOException on skip()");
        }
        try {
            harness.check(sr.read(), 114, "skip(), read()");
        }
        catch (IOException e) {
            harness.fail("Unexpected IOException on read()");
        }
        sr.close();
        harness.check(true, "close()");
    }
}

