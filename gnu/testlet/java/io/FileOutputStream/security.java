/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FileOutputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.FilePermission;
import java.security.Permission;

public class security
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        File dir = new File(harness.getTempDirectory(), "mauve-testdir");
        harness.check(dir.mkdir() || dir.exists(), "temp directory");
        File file = new File(dir, "file");
        String path = file.getPath();
        FilePermission rperm = new FilePermission(path, "read");
        FilePermission wperm = new FilePermission(path, "write");
        RuntimePermission fdPerm = new RuntimePermission("writeFileDescriptor");
        TestSecurityManager sm = new TestSecurityManager(harness);
        try {
            sm.install();
            harness.checkPoint("File constructor");
            try {
                sm.prepareChecks(new Permission[]{wperm}, new Permission[]{rperm});
                new FileOutputStream(file);
                sm.checkAllChecked();
            }
            catch (SecurityException ex) {
                harness.debug(ex);
                harness.check(false, "Unexpected check");
            }
            harness.checkPoint("File, boolean constructor");
            for (int i = 0; i <= 1; ++i) {
                try {
                    sm.prepareChecks(new Permission[]{wperm}, new Permission[]{rperm});
                    new FileOutputStream(file, i == 1);
                    sm.checkAllChecked();
                    continue;
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "Unexpected check");
                }
            }
            harness.checkPoint("String constructor");
            try {
                sm.prepareChecks(new Permission[]{wperm}, new Permission[]{rperm});
                new FileOutputStream(path);
                sm.checkAllChecked();
            }
            catch (SecurityException ex) {
                harness.debug(ex);
                harness.check(false, "Unexpected check");
            }
            harness.checkPoint("String, boolean constructor");
            for (int i = 0; i <= 1; ++i) {
                try {
                    sm.prepareChecks(new Permission[]{wperm}, new Permission[]{rperm});
                    new FileOutputStream(path, i == 1);
                    sm.checkAllChecked();
                    continue;
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "Unexpected check");
                }
            }
            harness.checkPoint("FileDescriptor constructor");
            try {
                sm.prepareChecks(new Permission[]{fdPerm});
                new FileOutputStream(FileDescriptor.out);
                sm.checkAllChecked();
            }
            catch (SecurityException ex) {
                harness.debug(ex);
                harness.check(false, "Unexpected check");
            }
        }
        catch (Exception ex) {
            harness.debug(ex);
            harness.check(false, "Unexpected exception");
        }
        finally {
            sm.uninstall();
            file.delete();
            dir.delete();
        }
    }
}

