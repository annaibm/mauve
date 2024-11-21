/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.System;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class arraycopy
implements Testlet {
    public void fill(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            a[i] = i;
        }
    }

    public void check(TestHarness harness, int[] expect, int[] result) {
        boolean ok = expect.length == result.length;
        for (int i = 0; ok && i < expect.length; ++i) {
            if (expect[i] == result[i]) continue;
            ok = false;
        }
        harness.check(ok);
    }

    public Object copy(Object from, int a, Object to2, int b, int c) {
        try {
            System.arraycopy(from, a, to2, b, c);
        }
        catch (ArrayStoreException xa) {
            return "caught ArrayStoreException";
        }
        catch (IndexOutOfBoundsException xb) {
            return "caught IndexOutOfBoundsException";
        }
        catch (NullPointerException xc) {
            return "caught NullPointerException";
        }
        catch (Throwable xd) {
            return "caught unexpected exception";
        }
        return null;
    }

    @Override
    public void test(TestHarness harness) {
        int[] x = new int[5];
        int[] y = new int[5];
        this.fill(x);
        harness.checkPoint("Copying integer array");
        harness.check(this.copy(x, 0, y, 0, x.length), null);
        int[] one = new int[]{0, 1, 2, 3, 4};
        this.check(harness, y, one);
        harness.check(this.copy(x, 1, y, 0, x.length - 1), null);
        harness.check(this.copy(x, 0, y, x.length - 1, 1), null);
        int[] two = new int[]{1, 2, 3, 4, 0};
        this.check(harness, y, two);
        harness.checkPoint("Incompatible arrays");
        Object[] z = new Object[5];
        harness.check(this.copy(x, 0, z, 0, x.length), (Object)"caught ArrayStoreException");
        harness.checkPoint("negative length");
        harness.check(this.copy(x, 0, y, 0, -23), (Object)"caught IndexOutOfBoundsException");
        harness.checkPoint("null arrays");
        harness.check(this.copy(null, 0, y, 0, -23), (Object)"caught NullPointerException");
        harness.check(this.copy(x, 0, null, 0, -23), (Object)"caught NullPointerException");
        harness.checkPoint("Non arrays");
        String q = "metonymy";
        harness.check(this.copy(q, 0, y, 0, 19), (Object)"caught ArrayStoreException");
        harness.check(this.copy(x, 0, q, 0, 19), (Object)"caught ArrayStoreException");
        harness.checkPoint("Incompatible arrays 2");
        double[] v = new double[5];
        harness.check(this.copy(x, 0, v, 0, 5), (Object)"caught ArrayStoreException");
        harness.checkPoint("Bad offset");
        harness.check(this.copy(x, -1, y, 0, 1), (Object)"caught IndexOutOfBoundsException");
        harness.checkPoint("Incompatible arrays 3");
        harness.check(this.copy(x, 0, z, 0, x.length), (Object)"caught ArrayStoreException");
        harness.checkPoint("Bad offset 2");
        harness.check(this.copy(x, 0, y, -1, 1), (Object)"caught IndexOutOfBoundsException");
        harness.check(this.copy(x, 3, y, 0, 5), (Object)"caught IndexOutOfBoundsException");
        harness.check(this.copy(x, 0, y, 3, 5), (Object)"caught IndexOutOfBoundsException");
        harness.check(this.copy(x, 4, y, 4, Integer.MAX_VALUE), (Object)"caught IndexOutOfBoundsException");
        harness.checkPoint("Object casting");
        Object[] w = new Object[5];
        String[] ss = new String[5];
        for (int i = 0; i < 5; ++i) {
            w[i] = i + "";
            ss[i] = i + 23 + "";
        }
        w[3] = new Integer(23);
        harness.check(this.copy(w, 0, ss, 0, 5), (Object)"caught ArrayStoreException");
        harness.check(ss[0], (Object)"0");
        harness.check(ss[1], (Object)"1");
        harness.check(ss[2], (Object)"2");
        harness.check(ss[3], (Object)"26");
        harness.check(ss[4], (Object)"27");
        harness.checkPoint("Different dimensions");
        harness.check(this.copy(new Object[1][1], 0, new Object[1], 0, 1), null);
        harness.check(this.copy(new int[1][1], 0, new Object[1], 0, 1), null);
        Object[] objs = new Object[]{new int[1]};
        harness.check(this.copy(objs, 0, new int[1][1], 0, 1), null);
        harness.check(this.copy(new String[1][1], 0, new Object[1], 0, 1), null);
        harness.check(this.copy(new int[1][1], 0, new int[1], 0, 1), (Object)"caught ArrayStoreException");
        harness.check(this.copy(new int[1], 0, new int[1][1], 0, 1), (Object)"caught ArrayStoreException");
    }
}

