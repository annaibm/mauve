/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URLClassLoader;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.security.Permission;

public class security
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        try {
            ClassLoader loader = this.getClass().getClassLoader();
            TestUSHFactory ushf = new TestUSHFactory();
            Permission[] createClassLoader = new Permission[]{new RuntimePermission("createClassLoader")};
            TestSecurityManager sm = new TestSecurityManager(harness);
            try {
                sm.install();
                harness.checkPoint("Constructor (1 arg)");
                try {
                    sm.prepareChecks(createClassLoader);
                    new URLClassLoader(new URL[0]);
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("Constructor (2 arg)");
                try {
                    sm.prepareChecks(createClassLoader);
                    new URLClassLoader(new URL[0], loader);
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("Constructor (3 arg)");
                try {
                    sm.prepareChecks(createClassLoader);
                    new URLClassLoader(new URL[0], loader, ushf);
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

    private static class TestUSHFactory
    implements URLStreamHandlerFactory {
        private TestUSHFactory() {
        }

        @Override
        public URLStreamHandler createURLStreamHandler(String protocol) {
            return new URLStreamHandler(){

                @Override
                protected URLConnection openConnection(URL u) throws IOException {
                    throw new RuntimeException("not implemented");
                }
            };
        }
    }
}

