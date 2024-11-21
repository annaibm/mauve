/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.net.Socket;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.net.Socket.TestSocketImplFactory;
import java.net.Socket;
import java.net.SocketException;

public class setSocketImplFactory
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            try {
                Socket.setSocketImplFactory(null);
                harness.check(true, "setSocketImplFactory(null) when not already set");
            }
            catch (SocketException se) {
                harness.debug(se);
                harness.check(false, "setSocketImplFactory(null) when not already set");
            }
            Socket.setSocketImplFactory(new TestSocketImplFactory());
            harness.check(true, "setSocketImplFactory() - 1");
            try {
                Socket.setSocketImplFactory(new TestSocketImplFactory());
                harness.check(false, "setSocketImplFactory() - 2");
            }
            catch (SocketException se) {
                harness.check(true, "setSocketImplFactory() - 2");
            }
            try {
                Socket.setSocketImplFactory(null);
                harness.check(false, "setSocketImplFactory(null) when already set");
            }
            catch (SocketException se) {
                harness.debug(se);
                harness.check(true, "setSocketImplFactory(null) when already set");
            }
        }
        catch (Throwable t) {
            harness.debug(t);
            harness.check(false, "setSocketImplFactory() - 1");
        }
    }
}

