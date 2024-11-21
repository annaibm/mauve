/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Random;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Random;

public class basic
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Random rand = new Random(122760L);
        harness.check(rand.nextInt(), -1524104671);
        harness.check(rand.nextLong(), 2785759620113032781L);
        harness.check(String.valueOf(rand.nextDouble()), (Object)"0.8173322904425151");
        harness.check(String.valueOf(rand.nextFloat()), (Object)"0.8239248");
        byte[] b = new byte[]{};
        rand.nextBytes(b);
        harness.check(rand.nextInt(), -899478426);
        rand = new Random(122760L);
        rand.nextInt();
        rand.nextLong();
        rand.nextDouble();
        rand.nextFloat();
        b = new byte[3];
        rand.nextBytes(b);
        harness.check(b[0], 102);
        harness.check(b[1], 12);
        harness.check(b[2], 99);
        harness.check(rand.nextInt(), -1550323395);
        rand = new Random(122760L);
        rand.nextInt();
        rand.nextLong();
        rand.nextDouble();
        rand.nextFloat();
        b = new byte[4];
        rand.nextBytes(b);
        harness.check(b[0], 102);
        harness.check(b[1], 12);
        harness.check(b[2], 99);
        harness.check(b[3], -54);
        harness.check(rand.nextInt(), -1550323395);
        rand = new Random(122760L);
        rand.nextInt();
        rand.nextLong();
        rand.nextDouble();
        rand.nextFloat();
        b = new byte[5];
        rand.nextBytes(b);
        harness.check(b[0], 102);
        harness.check(b[1], 12);
        harness.check(b[2], 99);
        harness.check(b[3], -54);
        harness.check(b[4], 61);
        harness.check(rand.nextInt(), -270809961);
        boolean ok = true;
        rand = new Random(0L);
        for (int i = 0; i < 1000000; ++i) {
            int x = rand.nextInt(1000);
            if (x >= 0 && x < 1000) continue;
            ok = false;
        }
        harness.check(ok);
    }
}

