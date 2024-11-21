/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FileInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileInputStream;

public class read
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        String tmpfile = harness.getTempDirectory() + File.separator + "mauve-filein.tst";
        File f = new File(tmpfile);
        f.delete();
        try {
            harness.check(f.createNewFile(), "Empty file created");
            harness.check(new FileInputStream(tmpfile).read(new byte[0]), 0, "empty byte[] read");
        }
        catch (Throwable t) {
            harness.fail("Empty file created or empty byte[] read");
            harness.debug(t);
        }
        finally {
            f.delete();
        }
    }
}

