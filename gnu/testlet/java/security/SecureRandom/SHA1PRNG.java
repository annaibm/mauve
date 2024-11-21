/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.SecureRandom;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SHA1PRNG
implements Testlet {
    private TestHarness harness = null;
    boolean available = false;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.harness.checkPoint("SHA1PRNG");
        this.instanceTest();
        this.setSeeedTest();
    }

    private void instanceTest() {
        this.available = this.getInstance() != null;
        this.harness.check(this.available, "found implementation");
    }

    private void setSeeedTest() {
        if (!this.available) {
            this.harness.fail("no implementation found");
        } else {
            SecureRandom prng1 = this.getInstance();
            prng1.setSeed(98243647L);
            SecureRandom prng2 = this.getInstance();
            prng2.setSeed(98243647L);
            long a = prng1.nextLong();
            long b = prng2.nextLong();
            this.harness.check(a == b, "instances generate same bytes when similarly seeded");
            for (int i = 0; i < 1000; ++i) {
                prng1.nextLong();
                prng2.nextLong();
            }
            a = prng1.nextLong();
            this.harness.check(a == (b = prng2.nextLong()));
        }
    }

    private SecureRandom getInstance() {
        SecureRandom result = null;
        try {
            result = SecureRandom.getInstance("SHA1PRNG");
        }
        catch (NoSuchAlgorithmException x) {
            this.harness.debug(x);
        }
        return result;
    }
}

