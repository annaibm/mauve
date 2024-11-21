/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Handler;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.util.logging.Handler.TestHandler;
import gnu.testlet.java.util.logging.Handler.TestSecurityManager;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class setFilter
implements Testlet {
    private final TestSecurityManager sec = new TestSecurityManager();
    private final TestHandler handler = new TestHandler();
    private final Filter filter = new Filter(){

        @Override
        public boolean isLoggable(LogRecord rec) {
            return true;
        }
    };

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
                this.handler.setFilter(null);
            }
            catch (Exception ex) {
                caught = ex;
            }
            th.check(caught instanceof SecurityException);
            this.sec.setGrantLoggingControl(true);
            caught = null;
            try {
                this.handler.setFilter(null);
            }
            catch (Exception ex) {
                caught = ex;
            }
            th.check(caught, null);
            this.sec.setGrantLoggingControl(false);
            caught = null;
            try {
                this.handler.setFilter(this.filter);
            }
            catch (Exception ex) {
                caught = ex;
            }
            th.check(caught instanceof SecurityException && this.handler.getFilter() == null);
            this.sec.setGrantLoggingControl(true);
            caught = null;
            try {
                this.handler.setFilter(this.filter);
            }
            catch (Exception ex) {
                caught = ex;
            }
            th.check(caught == null && this.handler.getFilter() == this.filter);
        }
        finally {
            this.sec.uninstall();
        }
    }
}

