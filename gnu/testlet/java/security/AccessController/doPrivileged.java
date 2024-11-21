/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.AccessController;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

public class doPrivileged
implements Testlet,
PrivilegedExceptionAction {
    private Throwable t;

    @Override
    public void test(TestHarness harness) {
        doPrivileged pea = new doPrivileged();
        pea.t = new NullPointerException();
        try {
            AccessController.doPrivileged(pea);
        }
        catch (NullPointerException npe) {
            harness.check(true);
        }
        catch (Throwable tt) {
            harness.debug(tt);
            harness.check(false);
        }
        pea.t = new IOException();
        try {
            AccessController.doPrivileged(pea);
        }
        catch (PrivilegedActionException pae) {
            harness.check(pea.t, pae.getCause());
        }
        catch (Throwable tt) {
            harness.debug(tt);
            harness.check(false);
        }
        pea.t = new ThreadDeath();
        try {
            AccessController.doPrivileged(pea);
        }
        catch (ThreadDeath td) {
            harness.check(true);
        }
        catch (Throwable tt) {
            harness.debug(tt);
            harness.check(false);
        }
    }

    public Object run() throws Exception {
        if (this.t instanceof Error) {
            throw (Error)this.t;
        }
        throw (Exception)this.t;
    }
}

