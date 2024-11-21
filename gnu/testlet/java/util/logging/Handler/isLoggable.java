/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Handler;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.util.logging.Handler.TestHandler;
import gnu.testlet.java.util.logging.Handler.TestSecurityManager;

public class isLoggable
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
            Exception caught = null;
            try {
                this.handler.isLoggable(null);
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

