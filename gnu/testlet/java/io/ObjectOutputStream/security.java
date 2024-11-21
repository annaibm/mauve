/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectOutputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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
            TestObjectOutputStream teststream = new TestObjectOutputStream();
            Permission[] enableSubclassImplementation = new Permission[]{new SerializablePermission("enableSubclassImplementation")};
            Permission[] enableSubstitution = new Permission[]{new SerializablePermission("enableSubstitution")};
            Permission[] noPerms = new Permission[]{};
            TestSecurityManager sm = new TestSecurityManager(harness);
            try {
                sm.install();
                harness.checkPoint("constructor");
                try {
                    sm.prepareChecks(enableSubclassImplementation);
                    new TestObjectOutputStream();
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("constructor with outputstream, no overrides");
                try {
                    sm.prepareChecks(noPerms);
                    new TestObjectOutputStream(new ByteArrayOutputStream());
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("constructor with outputstream, putFields override");
                try {
                    sm.prepareChecks(enableSubclassImplementation);
                    new TestObjectOutputStream2(new ByteArrayOutputStream());
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("constructor with outputstream, writeUnshared overrides");
                try {
                    sm.prepareChecks(enableSubclassImplementation);
                    new TestObjectOutputStream3(new ByteArrayOutputStream());
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("enableReplaceObject");
                try {
                    sm.prepareChecks(noPerms);
                    teststream.testEnableReplaceObject(false);
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                try {
                    sm.prepareChecks(enableSubstitution);
                    teststream.testEnableReplaceObject(true);
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

    private static class TestObjectOutputStream3
    extends ObjectOutputStream {
        public TestObjectOutputStream3(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        public void writeUnshared(Object obj) throws IOException {
        }
    }

    private static class TestObjectOutputStream2
    extends ObjectOutputStream {
        public TestObjectOutputStream2(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        public ObjectOutputStream.PutField putFields() throws IOException {
            return null;
        }
    }

    private static class TestObjectOutputStream
    extends ObjectOutputStream {
        public TestObjectOutputStream() throws IOException {
        }

        public TestObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        public boolean testEnableReplaceObject(boolean enable) {
            return this.enableReplaceObject(enable);
        }
    }
}

