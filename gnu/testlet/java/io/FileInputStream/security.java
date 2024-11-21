/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.FileInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilePermission;
import java.security.Permission;

public class security
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        File file = new File(harness.getSourceDirectory(), "ChangeLog");
        String path = file.getPath();
        Permission[] perm = new Permission[]{new FilePermission(path, "read")};
        Permission[] fdPerm = new Permission[]{new RuntimePermission("readFileDescriptor")};
        TestSecurityManager sm = new TestSecurityManager(harness);
        try {
            sm.install();
            harness.checkPoint("File constructor");
            try {
                sm.prepareChecks(perm);
                new FileInputStream(file);
                sm.checkAllChecked();
            }
            catch (SecurityException ex) {
                harness.debug(ex);
                harness.check(false, "Unexpected check");
            }
            harness.checkPoint("String constructor");
            try {
                sm.prepareChecks(perm);
                new FileInputStream(path);
                sm.checkAllChecked();
            }
            catch (SecurityException ex) {
                harness.debug(ex);
                harness.check(false, "Unexpected check");
            }
            harness.checkPoint("FileDescriptor constructor");
            try {
                sm.prepareChecks(fdPerm);
                new FileInputStream(FileDescriptor.in);
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
        }
    }
}

