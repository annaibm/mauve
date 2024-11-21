/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Handler;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.util.logging.Handler.TestHandler;
import gnu.testlet.java.util.logging.Handler.TestSecurityManager;
import java.util.logging.ErrorManager;

public class setErrorManager
implements Testlet {
    private final TestSecurityManager sec = new TestSecurityManager();
    private final TestHandler handler = new TestHandler();
    private final ErrorManager mgr = new ErrorManager();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void test(TestHarness th) {
        this.sec.install();
        try {
            this.sec.setGrantLoggingControl(false);
            Exception caught = null;
            try {
                this.handler.setErrorManager(null);
            }
            catch (Exception ex) {
                caught = ex;
            }
            th.check(caught instanceof SecurityException);
            this.sec.setGrantLoggingControl(true);
            caught = null;
            try {
                this.handler.setErrorManager(null);
            }
            catch (Exception ex) {
                caught = ex;
            }
            th.check(caught instanceof NullPointerException);
            this.sec.setGrantLoggingControl(false);
            caught = null;
            try {
                this.handler.setErrorManager(this.mgr);
            }
            catch (Exception ex) {
                caught = ex;
            }
            th.check(caught instanceof SecurityException);
            this.sec.setGrantLoggingControl(true);
            caught = null;
            try {
                this.handler.setErrorManager(this.mgr);
            }
            catch (Exception ex) {
                caught = ex;
            }
            th.check(caught == null && this.handler.getErrorManager() == this.mgr);
        }
        finally {
            this.sec.uninstall();
        }
    }
}

