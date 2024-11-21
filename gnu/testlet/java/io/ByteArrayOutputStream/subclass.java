/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ByteArrayOutputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayOutputStream;

public class subclass
extends ByteArrayOutputStream
implements Testlet {
    public subclass() {
        super(10);
    }

    @Override
    public void test(TestHarness harness) {
        int n;
        for (n = 0; n < 10; ++n) {
            this.write(n);
        }
        harness.check(this.count, 10, "count");
        harness.check(this.buf.length, 10, "buf.length");
        for (n = 0; n < 10; ++n) {
            harness.check(this.buf[n], n, "buf[" + n + "]");
        }
    }
}

