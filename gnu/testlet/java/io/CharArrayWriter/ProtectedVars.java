/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.CharArrayWriter;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.CharArrayWriter;

public class ProtectedVars
extends CharArrayWriter
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean pass;
        String str = "Here is a test string";
        ProtectedVars writer = new ProtectedVars();
        try {
            writer.write(str, 0, str.length());
        }
        catch (Throwable t) {
            harness.debug(t);
            harness.check(false, "Unexpected exception");
        }
        harness.check(writer.count, str.length(), "count");
        char[] strArray = new char[str.length()];
        str.getChars(0, str.length(), strArray, 0);
        boolean bl = pass = writer.buf.length >= strArray.length;
        if (pass) {
            for (int i = 0; i < writer.count; ++i) {
                if (writer.buf[i] == strArray[i]) continue;
                pass = false;
            }
        }
        harness.checkPoint("buffer");
        harness.check(pass);
    }
}

