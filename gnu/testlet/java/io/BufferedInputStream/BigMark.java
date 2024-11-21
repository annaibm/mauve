/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.BufferedInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BigMark
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test(harness, 32768);
        this.test(harness, 131072);
        this.test(harness, 0x100000);
        this.test(harness, 0x7FFFFBFF);
        this.test(harness, 0x7FFFFFFE);
        this.test(harness, Integer.MAX_VALUE);
    }

    public void test(TestHarness harness, int size2) {
        harness.checkPoint("mark(" + size2 + ")");
        try {
            int i;
            int K = 16;
            byte[] dummy2 = new byte[16384];
            dummy2[2] = 42;
            dummy2[3] = 13;
            ByteArrayInputStream bais = new ByteArrayInputStream(dummy2);
            BufferedInputStream bis = new BufferedInputStream(bais);
            bis.read();
            bis.read();
            bis.mark(size2);
            int answer = bis.read();
            harness.check(answer, 42);
            for (i = 0; i < 8; ++i) {
                bis.skip(1024L);
            }
            bis.reset();
            answer = bis.read();
            harness.check(answer, 42);
            bis.mark(size2);
            answer = bis.read();
            harness.check(answer, 13);
            for (i = 0; i < 8192; ++i) {
                bis.read();
            }
            bis.reset();
            answer = bis.read();
            harness.check(answer, 13);
        }
        catch (IOException e) {
            harness.debug(e);
            harness.check(false);
        }
    }
}

