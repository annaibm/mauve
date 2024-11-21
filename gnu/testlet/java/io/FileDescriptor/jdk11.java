/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FileDescriptor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SyncFailedException;

public class jdk11
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            FileOutputStream fos = new FileOutputStream("tmpfile");
            try {
                FileDescriptor fd = fos.getFD();
                harness.check(fd.valid(), "valid()");
                try {
                    fd.sync();
                    harness.check(true, "sync()");
                }
                catch (SyncFailedException e) {
                    harness.debug(e);
                    harness.fail("SyncFailedException thrown");
                }
            }
            catch (IOException e) {
                harness.fail("Can't get FileDescriptor");
            }
        }
        catch (FileNotFoundException e) {
            harness.fail("Can't make file 'tmpfile'");
        }
    }
}

