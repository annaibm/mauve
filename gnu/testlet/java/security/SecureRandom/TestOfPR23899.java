/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.SecureRandom;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.security.SecureRandom;

public class TestOfPR23899
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("TestOfPR23899");
        try {
            SecureRandom prng1 = SecureRandom.getInstance("SHA1PRNG");
            SecureRandom prng2 = SecureRandom.getInstance("SHA1PRNG");
            int ra = prng1.nextInt();
            int rb = prng2.nextInt();
            harness.check(ra != rb, "Similar SecureRandoms MUST NOT generate same bytes when not explicitly seeded");
            prng1 = SecureRandom.getInstance("SHA1PRNG");
            prng1.setSeed(98243647L);
            prng2 = SecureRandom.getInstance("SHA1PRNG");
            prng2.setSeed(98243647L);
            ra = prng1.nextInt();
            rb = prng2.nextInt();
            harness.check(ra == rb, "Similar SecureRandoms MUST generate same bytes when similarly seeded");
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("TestOfPR23899: " + x);
        }
    }
}

