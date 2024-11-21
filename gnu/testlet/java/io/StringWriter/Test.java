/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.StringWriter;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.StringWriter;

public class Test
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringWriter sw = new StringWriter();
        String str = "There are a ton of great places to see live, original\nmusic in Chicago.  Places like Lounge Ax, Schuba's, the Empty\nBottle, and even the dreaded Metro with their sometimes asshole\nbouncers.\n";
        char[] buf = new char[str.length()];
        str.getChars(0, str.length(), buf, 0);
        sw.write(buf, 0, 5);
        sw.write(buf, 5, 8);
        sw.flush();
        harness.check(sw.toString(), str.substring(0, 13), "flush()");
        harness.check(sw.getBuffer().toString(), str.substring(0, 13), "getBuffer()");
        sw.write(buf, 13, 12);
        sw.write(buf[25]);
        sw.write(buf, 26, buf.length - 26);
        try {
            sw.close();
        }
        catch (Throwable t) {
            harness.debug("Caught unexpected exception: " + t);
            harness.fail("Unexpected Throwable");
            return;
        }
        harness.debug(sw.toString());
        harness.check(sw.toString(), str, "string equality");
    }
}

