/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Handler;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.util.logging.Handler.TestHandler;
import gnu.testlet.java.util.logging.Handler.TestSecurityManager;
import java.io.UnsupportedEncodingException;

public class setEncoding
implements Testlet {
    private final TestSecurityManager sec = new TestSecurityManager();
    private final TestHandler handler = new TestHandler();

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
                this.handler.setEncoding(null);
            }
            catch (Exception ex) {
                caught = ex;
            }
            th.check(caught instanceof SecurityException);
            this.sec.setGrantLoggingControl(true);
            caught = null;
            try {
                this.handler.setEncoding(null);
            }
            catch (Exception ex) {
                caught = ex;
            }
            th.check(caught == null);
            th.check(this.handler.getEncoding(), null);
            this.sec.setGrantLoggingControl(false);
            caught = null;
            try {
                this.handler.setEncoding("Nonsense");
            }
            catch (Exception ex) {
                caught = ex;
            }
            th.check(caught instanceof SecurityException);
            this.sec.setGrantLoggingControl(true);
            caught = null;
            try {
                this.handler.setEncoding("Nonsense");
            }
            catch (Exception ex) {
                caught = ex;
            }
            th.check(caught instanceof UnsupportedEncodingException);
            this.sec.setGrantLoggingControl(false);
            caught = null;
            try {
                this.handler.setEncoding("UTF-8");
            }
            catch (Exception ex) {
                caught = ex;
            }
            th.check(caught instanceof SecurityException);
            this.sec.setGrantLoggingControl(true);
            caught = null;
            try {
                this.handler.setEncoding("UTF-8");
            }
            catch (Exception ex) {
                caught = ex;
            }
            th.check(caught == null);
            th.check(this.handler.getEncoding(), (Object)"UTF-8");
        }
        finally {
            this.sec.uninstall();
        }
    }
}

