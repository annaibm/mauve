/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.HeadlessException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.HeadlessException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HeadlessException a = new HeadlessException("");
        harness.check(((Throwable)a).getMessage(), (Object)"");
        a = new HeadlessException("HeadlessException");
        harness.check(((Throwable)a).getMessage(), (Object)"HeadlessException");
        try {
            throw new HeadlessException("");
        }
        catch (Throwable t) {
            harness.check(t.getMessage(), (Object)"");
            harness.check(t instanceof HeadlessException);
            try {
                throw new HeadlessException("HeadlessException");
            }
            catch (Throwable t2) {
                harness.check(t2.getMessage(), (Object)"HeadlessException");
                harness.check(t2 instanceof HeadlessException);
                return;
            }
        }
    }
}

