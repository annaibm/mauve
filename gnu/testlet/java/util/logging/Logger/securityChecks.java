/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Logger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.util.logging.Logger.TestLogger;
import gnu.testlet.java.util.logging.Logger.TestSecurityManager;
import java.util.logging.ConsoleHandler;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class securityChecks
implements Testlet {
    private final TestSecurityManager sec = new TestSecurityManager();
    private TestHarness harness;

    @Override
    public void test(TestHarness h) {
        this.harness = h;
        try {
            this.sec.install();
            this.testSecurity("Logger.global", Logger.global, true);
            this.testSecurity("Logger.getAnonymousLogger()", Logger.getAnonymousLogger(), false);
            this.testSecurity("Logger.getAnonymousLogger(null)", Logger.getAnonymousLogger(null), false);
            this.testSecurity("<named custom logger>", new TestLogger("foo", null), true);
            this.testSecurity("<anonymous custom logger>", new TestLogger(null, null), true);
        }
        finally {
            this.sec.uninstall();
        }
    }

    private void testSecurity(String checkPoint, Logger logger, boolean expectEnforcement) {
        this.harness.checkPoint(checkPoint);
        this.sec.setGrantLoggingControl(false);
        try {
            logger.setFilter(null);
            this.harness.check(!expectEnforcement);
        }
        catch (Exception ex) {
            this.harness.check(expectEnforcement && ex instanceof SecurityException);
        }
        try {
            logger.setFilter(new Filter(){

                @Override
                public boolean isLoggable(LogRecord r) {
                    return true;
                }
            });
            this.harness.check(!expectEnforcement);
        }
        catch (Exception ex) {
            this.harness.check(expectEnforcement && ex instanceof SecurityException);
        }
        try {
            logger.setLevel(null);
            this.harness.check(!expectEnforcement);
        }
        catch (Exception ex) {
            this.harness.check(expectEnforcement && ex instanceof SecurityException);
        }
        try {
            logger.setLevel(Level.CONFIG);
            this.harness.check(!expectEnforcement);
        }
        catch (Exception ex) {
            this.harness.check(expectEnforcement && ex instanceof SecurityException);
        }
        ConsoleHandler handler = new ConsoleHandler();
        try {
            logger.addHandler(handler);
            this.harness.check(!expectEnforcement);
        }
        catch (Exception ex) {
            this.harness.check(expectEnforcement && ex instanceof SecurityException);
        }
        try {
            logger.removeHandler(handler);
            this.harness.check(!expectEnforcement);
        }
        catch (Exception ex) {
            this.harness.check(expectEnforcement && ex instanceof SecurityException);
        }
        try {
            logger.setParent(new TestLogger("gnu.testlet.Test", null));
            this.harness.check(false);
        }
        catch (Exception ex) {
            this.harness.check(ex instanceof SecurityException);
        }
        try {
            logger.setUseParentHandlers(false);
            this.harness.check(!expectEnforcement);
        }
        catch (Exception ex) {
            this.harness.check(expectEnforcement && ex instanceof SecurityException);
        }
    }
}

