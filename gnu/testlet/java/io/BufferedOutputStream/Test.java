/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.BufferedOutputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Test
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(24);
            BufferedOutputStream bos = new BufferedOutputStream(baos, 12);
            String str = "The Kroger on College Mall Rd. in Bloomington\nused to sell Kroger brand frozen pizzas for 68 cents.\nI ate a lot of those in college.  It was kind of embarrassing\nwalking out of the grocery with nothing but 15 frozen pizzas.\n";
            boolean passed = true;
            byte[] buf = str.getBytes();
            bos.write(buf, 0, 5);
            harness.check(baos.toByteArray().length, 0, "buffering/toByteArray");
            bos.write(buf, 5, 8);
            bos.write(buf, 13, 12);
            bos.write(buf[25]);
            bos.write(buf, 26, buf.length - 26);
            bos.close();
            String str2 = new String(baos.toByteArray());
            harness.check(str, str2, "did all bytes come through?");
            harness.debug(str2, false);
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

