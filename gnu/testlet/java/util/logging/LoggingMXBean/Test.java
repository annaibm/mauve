/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.LoggingMXBean;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.util.logging.Logger.TestSecurityManager;
import java.util.logging.LogManager;
import java.util.logging.LoggingMXBean;

public class Test
implements Testlet {
    private TestSecurityManager tsm = new TestSecurityManager();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness h) {
        try {
            Exception caught = null;
            LoggingMXBean bean = LogManager.getLoggingMXBean();
            this.tsm.install();
            caught = null;
            try {
                bean.setLoggerLevel("global", null);
            }
            catch (Exception ex) {
                caught = ex;
            }
            h.check(caught instanceof SecurityException, "loggerLevel");
            try {
                bean.setLoggerLevel("NotALogger", null);
            }
            catch (Exception ex) {
                caught = ex;
            }
            h.check(caught instanceof IllegalArgumentException, "loggerLevel");
            try {
                bean.setLoggerLevel(null, null);
            }
            catch (Exception ex) {
                caught = ex;
            }
            h.check(caught instanceof NullPointerException, "loggerLevel");
        }
        finally {
            this.tsm.uninstall();
        }
    }
}

