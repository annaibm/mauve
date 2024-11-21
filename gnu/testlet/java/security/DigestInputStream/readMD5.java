/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.DigestInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class readMD5
implements Testlet {
    private static String md5 = "3858f62230ac3c915f300c664312c63f";

    @Override
    public void test(TestHarness harness) {
        try {
            byte[] foobar = "foobar".getBytes("UTF-8");
            ByteArrayInputStream bais = new ByteArrayInputStream(foobar);
            MessageDigest md5Digest = MessageDigest.getInstance("MD5");
            DigestInputStream dis = new DigestInputStream(bais, md5Digest);
            byte[] buf = new byte[100];
            while (dis.read(buf, 0, buf.length) != -1) {
            }
            byte[] hash2 = dis.getMessageDigest().digest();
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < hash2.length; ++i) {
                result.append(Integer.toHexString(hash2[i] >> 4 & 0xF));
                result.append(Integer.toHexString(hash2[i] & 0xF));
            }
            harness.check(result.toString(), (Object)md5);
        }
        catch (Throwable t) {
            harness.debug(t);
            harness.check(false, t.toString());
        }
    }
}

