/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.URL;

import gnu.testlet.TestHarness;
import gnu.testlet.TestSecurityManager;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.net.NetPermission;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.security.Permission;

public class security
implements Testlet {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness harness) {
        try {
            TestURLStreamHandler handler = new TestURLStreamHandler();
            URL context = new URL("http://www.redhat.com/");
            Permission[] specifyStreamHandler = new Permission[]{new NetPermission("specifyStreamHandler")};
            Permission[] checkSetFactory = new Permission[]{new RuntimePermission("setFactory")};
            TestSecurityManager sm = new TestSecurityManager(harness);
            try {
                sm.install();
                harness.checkPoint("URL(String, String, int, String, URLStreamHandler)");
                try {
                    sm.prepareChecks(specifyStreamHandler);
                    new URL("redhat", "redhat.com", 23, "/red/hat/", handler);
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("URL(String, String, int, String, URLStreamHandler)");
                try {
                    sm.prepareChecks(specifyStreamHandler);
                    new URL(context, "/red/hat/", handler);
                    sm.checkAllChecked();
                }
                catch (SecurityException ex) {
                    harness.debug(ex);
                    harness.check(false, "unexpected check");
                }
                harness.checkPoint("setURLStreamHandlerFactory");
                try {
                    sm.prepareHaltingChecks(checkSetFactory);
                    URL.setURLStreamHandlerFactory(null);
                    harness.check(false);
                }
                catch (TestSecurityManager.SuccessException ex) {
                    harness.check(true);
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

    private static class TestURLStreamHandler
    extends URLStreamHandler {
        private TestURLStreamHandler() {
        }

        @Override
        public URLConnection openConnection(URL url) throws IOException {
            throw new RuntimeException("not implemented");
        }
    }
}

