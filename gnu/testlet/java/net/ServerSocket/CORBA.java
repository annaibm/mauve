/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.ServerSocket;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.util.Random;

public class CORBA
implements Testlet {
    static int NONE = Integer.MIN_VALUE;

    @Override
    public void test(TestHarness harness) {
        ServerSocket s2;
        Random r = new Random();
        int port = NONE;
        ServerSocket s = null;
        for (int i = 0; i < 54; ++i) {
            port = 1000 + r.nextInt(2000);
            try {
                s = new ServerSocket(port);
                break;
            }
            catch (IOException iOException) {
                continue;
            }
        }
        if (port == NONE) {
            harness.fail("Cannot find any port between 1000 and 3000 in 54 random attempts");
            return;
        }
        harness.check(port, s.getLocalPort(), "getLocalPort, opened");
        try {
            s2 = new ServerSocket(port);
            harness.fail("BindException must be thrown");
        }
        catch (Exception ex) {
            harness.check(ex instanceof BindException, "Not a BindException: " + ex);
        }
        try {
            s.close();
        }
        catch (IOException ex) {
            harness.fail("Exception while closing the socket" + ex);
        }
        harness.check(port, s.getLocalPort(), "getLocalPort, closed, " + s.getLocalPort());
        try {
            s2 = new ServerSocket(port);
            harness.check(port, s2.getLocalPort(), "Port mismatch");
        }
        catch (Exception ex) {
            harness.fail("Unable to reuse the port " + port);
        }
    }
}

