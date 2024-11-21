/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.zip.GZIPInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class PR24461
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean canBeOk = false;
        boolean ok = false;
        try {
            ByteArrayOutputStream full = new ByteArrayOutputStream(1024);
            GZIPOutputStream gzout = new GZIPOutputStream(full);
            byte[] buf = new byte[1024];
            new Random().nextBytes(buf);
            gzout.write(buf);
            gzout.close();
            byte[] gzdata = full.toByteArray();
            ByteArrayInputStream truncated = new ByteArrayInputStream(gzdata, 0, 128);
            GZIPInputStream gzin = new GZIPInputStream(truncated);
            byte[] read2 = new byte[1024];
            int cur = 0;
            canBeOk = true;
            while ((cur = gzin.read(read2, cur, read2.length - cur)) != -1) {
            }
        }
        catch (IOException ioe) {
            ok = canBeOk;
        }
        catch (Exception e) {
            harness.debug(e);
        }
        harness.check(ok);
    }
}

