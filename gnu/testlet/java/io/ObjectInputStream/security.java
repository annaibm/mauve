/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.SerializablePermission;
import java.security.Permission;

public class security
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        try {
            TestObjectInputStream teststream = new TestObjectInputStream();
            Permission[] enableSubclassImplementation = new Permission[]{new SerializablePermission("enableSubclassImplementation")};
            Permission[] enableSubstitution = new Permission[]{new SerializablePermission("enableSubstitution")};
            Permission[] noPerms = new Permission[]{};
            TestSecurityManager sm = new TestSecurityManager(harness);
            try {
                sm.install();
                harness.checkPoint("constructor");
                try {
                    sm.prepareChecks(enableSubclassImplementation);
                    new TestObjectInputStream();
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("enableResolveObject");
                try {
                    sm.prepareChecks(noPerms);
                    teststream.testEnableResolveObject(false);
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                try {
                    sm.prepareChecks(enableSubstitution);
                    teststream.testEnableResolveObject(true);
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
            }
            finally {
                sm.uninstall();
            }
        }
        catch (Exception ex) {
            harness.debug(ex);
            harness.check(false, "Unexpected exception");
        }
    }

    private static class TestObjectInputStream
    extends ObjectInputStream {
        public boolean testEnableResolveObject(boolean enable) {
            return this.enableResolveObject(enable);
        }
    }
}

