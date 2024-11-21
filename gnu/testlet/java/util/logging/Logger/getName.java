/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Logger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.util.logging.Logger.TestLogger;
import gnu.testlet.java.util.logging.Logger.TestSecurityManager;

public class getName
implements Testlet {
    private final TestSecurityManager sec = new TestSecurityManager();
    private static final String LOGGER_NAME = "gnu.testlet.java.util.logging.Logger.test_getName";

    @Override
    public void test(TestHarness h) {
        try {
            this.sec.install();
            this.sec.setGrantLoggingControl(false);
            TestLogger logger = new TestLogger(LOGGER_NAME, null);
            h.check(logger.getName(), (Object)LOGGER_NAME);
        }
        finally {
            this.sec.uninstall();
        }
    }
}

