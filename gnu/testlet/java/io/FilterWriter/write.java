/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FilterWriter;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.io.FilterWriter.MyFilterWriter;
import java.io.CharArrayWriter;
import java.io.IOException;

public class write
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CharArrayWriter caw = new CharArrayWriter();
        MyFilterWriter tfw = new MyFilterWriter(caw);
        try {
            tfw.write(65);
            harness.check(true, "write(int)");
            char[] ba = new char[]{'A', 'B', 'C', 'D'};
            tfw.write(ba, 1, 2);
            harness.check(true, "write(buf,off,len)");
            tfw.write("CDEF", 1, 3);
            harness.check(caw.toString(), "ABCDEF", "wrote all characters okay");
            tfw.flush();
            harness.check(true, "flush()");
            tfw.close();
            harness.check(true, "close()");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.fail("IOException unexpected");
        }
        try {
            new MyFilterWriter(null);
            harness.check(false, "new MyFilterWriter(null) -> no exception");
        }
        catch (NullPointerException ex) {
            harness.check(true, "new MyFilterWriter(null) -> NullPointerException");
        }
    }
}

