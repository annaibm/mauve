/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Handler;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.util.logging.Handler.TestHandler;
import gnu.testlet.java.util.logging.Handler.TestSecurityManager;
import java.util.logging.Level;

public class setLevel
implements Testlet {
    TestSecurityManager sec = new TestSecurityManager();
    TestHandler handler = new TestHandler();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness th) {
        this.sec.install();
        try {
            this.sec.setGrantLoggingControl(false);
            th.check(this.handler.getLevel(), Level.ALL);
            this.sec.setGrantLoggingControl(false);
            Exception caught = null;
            try {
                this.handler.setLevel(Level.INFO);
            }
            catch (Exception ex) {
                caught = ex;
            }
            th.check(caught instanceof SecurityException);
            this.sec.setGrantLoggingControl(true);
            this.handler.setLevel(Level.FINEST);
            th.check(this.handler.getLevel(), Level.FINEST);
            this.sec.setGrantLoggingControl(true);
            caught = null;
            try {
                this.handler.setLevel(null);
            }
            catch (Exception ex) {
                caught = ex;
            }
            th.check(caught instanceof NullPointerException);
        }
        finally {
            this.sec.uninstall();
        }
    }
}

