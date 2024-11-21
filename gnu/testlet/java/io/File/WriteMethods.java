/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.File;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.IOException;

public class WriteMethods
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String tmp = harness.getTempDirectory();
        File tmpfile = new File(tmp, "mauve-testfile");
        try {
            tmpfile.createNewFile();
        }
        catch (IOException e) {
            harness.fail("cannot create file for test.");
            return;
        }
        boolean write2 = tmpfile.canWrite();
        harness.check(write2);
        write2 = tmpfile.setWritable(false);
        harness.check(write2);
        write2 = tmpfile.canWrite();
        harness.check(!write2);
        tmpfile.delete();
    }
}

