/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.DataOutputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class writeUTF
implements Testlet {
    TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeUTF("\u0000\u0001\u0002~\u007f\u0080\u0081\u07fe\u07ff\u0800\u0801\ufffe\uffff");
            dos.close();
            byte[] bs = baos.toByteArray();
            byte[] encoded = new byte[]{0, 26, -64, -128, 1, 2, 126, 127, -62, -128, -62, -127, -33, -66, -33, -65, -32, -96, -128, -32, -96, -127, -17, -65, -66, -17, -65, -65};
            this.checkArrayEquals(bs, encoded);
        }
        catch (IOException ioe) {
            harness.fail("Unexpected IOException: " + ioe);
        }
    }

    private void checkArrayEquals(byte[] b1, byte[] b2) {
        int length2 = b1.length;
        if (length2 != b2.length) {
            this.harness.debug("b1.length=" + length2 + ", but b2.length=" + b2.length);
            this.harness.fail("arrays same");
            return;
        }
        for (int i = 0; i < length2; ++i) {
            if (b1[i] == b2[i]) continue;
            this.harness.debug("b1[" + i + "] = " + b1[i] + ", but b2[" + i + "] = " + b2[i]);
            this.harness.fail("arrays not equal");
            return;
        }
        this.harness.check(true, "arrays same");
    }
}

