/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FilterOutputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

public class write
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        FilterOutputStream fos = new FilterOutputStream(baos);
        byte[] ba = new byte[]{66, 67, 68};
        try {
            String tststr = "ABCD";
            fos.write(65);
            harness.check(true, "write(int)");
            fos.write(ba);
            harness.check(true, "write(buf)");
            fos.write(ba, 0, 3);
            harness.check(true, "write(buf,off,len)");
            byte[] finalba = baos.toByteArray();
            String finalstr2 = new String(finalba);
            harness.check(finalstr2.equals("ABCDBCD"), "wrote all characters okay");
            baos.flush();
            harness.check(true, "flush()");
            baos.close();
            harness.check(true, "close()");
        }
        catch (IOException e) {
            harness.fail("IOException unexpected");
        }
    }

    class TestOutputStream
    extends FilterOutputStream {
        TestOutputStream(ByteArrayOutputStream baos) {
            super(baos);
        }
    }
}

