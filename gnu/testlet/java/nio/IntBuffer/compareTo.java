/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.IntBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.nio.IntBuffer;

public class compareTo
implements Testlet {
    private TestHarness h;

    @Override
    public void test(TestHarness h) {
        this.h = h;
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] c = new int[]{1, 2, 3, 5, 7, 9};
        this.checkCompareTo(a, a, 0);
        this.checkCompareTo(b, b, 0);
        this.checkCompareTo(c, c, 0);
        this.checkCompareTo(a, b, -1);
        this.checkCompareTo(a, c, -1);
        this.checkCompareTo(b, c, -1);
        this.checkCompareTo(b, a, 1);
        this.checkCompareTo(c, a, 1);
        this.checkCompareTo(c, b, 1);
    }

    private void checkCompareTo(int[] buf1, int[] buf2, int expected) {
        int got;
        IntBuffer b1 = IntBuffer.wrap(buf1);
        IntBuffer b2 = IntBuffer.wrap(buf2);
        int real_got = got = b1.compareTo(b2);
        if (got > 1) {
            got = 1;
        }
        if (got < -1) {
            got = -1;
        }
        this.h.check(got == expected, "expected: " + expected + ", got: " + real_got);
    }
}

