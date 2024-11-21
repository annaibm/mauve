/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ClassLoader;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.Permission;

public class security
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        try {
            harness.checkPoint("setup");
            Class<?> testClass = new URLClassLoader(new URL[]{new File(harness.getSourceDirectory()).toURL()}, null).loadClass(this.getClass().getName());
            ClassLoader ourLoader = this.getClass().getClassLoader();
            harness.check(ourLoader != testClass.getClassLoader());
            Method getSystemClassLoaderTest = testClass.getMethod("testGetSystemClassLoader", new Class[0]);
            Method getParentTest = testClass.getMethod("testGetParent", ClassLoader.class);
            new TestClassLoader();
            Permission[] createClassLoader = new Permission[]{new RuntimePermission("createClassLoader")};
            Permission[] getClassLoader = new Permission[]{new RuntimePermission("getClassLoader")};
            TestSecurityManager sm = new TestSecurityManager(harness);
            try {
                sm.install();
                harness.checkPoint("Constructor (no-args)");
                try {
                    sm.prepareChecks(createClassLoader);
                    new TestClassLoader();
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("Constructor (one-arg)");
                try {
                    sm.prepareChecks(createClassLoader);
                    new TestClassLoader(ourLoader);
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("getSystemClassLoader");
                try {
                    sm.prepareChecks(getClassLoader);
                    getSystemClassLoaderTest.invoke(null, new Object[0]);
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("getParent");
                try {
                    sm.prepareChecks(getClassLoader);
                    getParentTest.invoke(null, ourLoader);
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

    public static void testGetSystemClassLoader() {
        ClassLoader.getSystemClassLoader();
    }

    public static void testGetParent(ClassLoader loader) {
        loader.getParent();
    }

    private static class TestClassLoader
    extends ClassLoader {
        public TestClassLoader() {
        }

        public TestClassLoader(ClassLoader parent) {
            super(parent);
        }
    }
}

