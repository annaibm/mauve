/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FileOutputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileOutputStream;

public class write
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        String tmpfile = harness.getTempDirectory() + File.separator + "mauve-fileout.tst";
        try {
            new FileOutputStream(tmpfile).write(new byte[0]);
            harness.check(new File(tmpfile).exists(), "empty byte[] write");
        }
        catch (Throwable t) {
            harness.fail("empty byte[] write");
            harness.debug(t);
        }
        finally {
            File f = new File(tmpfile);
            f.delete();
        }
    }
}

