/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.Handler;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.util.logging.Handler.TestErrorManager;
import gnu.testlet.java.util.logging.Handler.TestHandler;
import gnu.testlet.java.util.logging.Handler.TestSecurityManager;

public class reportError
implements Testlet {
    private final TestSecurityManager sec = new TestSecurityManager();
    private final TestHandler handler = new TestHandler();
    private final TestErrorManager mgr = new TestErrorManager();
    private final Exception somex = new IllegalStateException();

    @Override
    public void test(TestHarness th) {
        this.sec.install();
        try {
            this.sec.setGrantLoggingControl(true);
            this.handler.setErrorManager(this.mgr);
            this.sec.setGrantLoggingControl(false);
            this.handler.invokeReportError("foo", this.somex, 2);
            th.check(this.mgr.getLastMessage(), (Object)"foo");
            th.check(this.mgr.getLastException() == this.somex);
            th.check(this.mgr.getLastErrorCode(), 2);
            this.handler.invokeReportError(null, this.somex, 4);
            th.check(this.mgr.getLastMessage(), null);
            th.check(this.mgr.getLastException() == this.somex);
            th.check(this.mgr.getLastErrorCode(), 4);
            this.handler.invokeReportError(null, null, 3);
            th.check(this.mgr.getLastMessage(), null);
            th.check(this.mgr.getLastException(), null);
            th.check(this.mgr.getLastErrorCode(), 3);
            this.handler.invokeReportError("foobar", null, -12345);
            th.check(this.mgr.getLastMessage(), (Object)"foobar");
            th.check(this.mgr.getLastException(), null);
            th.check(this.mgr.getLastErrorCode(), -12345);
        }
        finally {
            this.sec.uninstall();
        }
    }
}

