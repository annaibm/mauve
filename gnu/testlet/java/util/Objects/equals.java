/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Objects;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import java.util.Objects;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Object[] veg1 = new String[]{"Potato", "Onion", "Carrot"};
        Object[] veg2 = new String[]{"Potato", "Onion", "Carrot"};
        boolean[] b1 = new boolean[]{true, true, false};
        boolean[] b2 = new boolean[]{true, true, false};
        byte[] by1 = new byte[]{5, 42, -126};
        byte[] by2 = new byte[]{5, 42, -126};
        char[] c1 = new char[]{'a', 'z', 'A', 'Z'};
        char[] c2 = new char[]{'a', 'z', 'A', 'Z'};
        double[] d1 = new double[]{0.5, 3.14, 6.5};
        double[] d2 = new double[]{0.5, 3.14, 6.5};
        float[] f1 = new float[]{0.5f, 3.14f, 6.5f};
        float[] f2 = new float[]{0.5f, 3.14f, 6.5f};
        int[] i1 = new int[]{5, 4096, 42};
        int[] i2 = new int[]{5, 4096, 42};
        long[] l1 = new long[]{5L, 4096L, 42L};
        long[] l2 = new long[]{5L, 4096L, 42L};
        Object[] nested1 = new Object[]{"Field", veg1, veg2};
        Object[] nested2 = new Object[]{"Field", veg1, veg2};
        short[] s1 = new short[]{5, -2048, 42};
        short[] s2 = new short[]{5, -2048, 42};
        boolean bResult = Objects.equals(null, null);
        harness.debug("Objects.equals(null,null) = " + bResult);
        harness.check(bResult, true, "equals(null,null) == true");
        bResult = Objects.equals(null, "Potato");
        harness.debug("Objects.equals(null,\"Potato\") = " + bResult);
        harness.check(bResult, false, "equals(null,\"Potato\") == false");
        bResult = Objects.equals("Potato", null);
        harness.debug("Objects.equals(\"Potato\",null) = " + bResult);
        harness.check(bResult, false, "equals(\"Potato\",null) == false");
        bResult = Objects.equals("Potato", "Potato");
        harness.debug("Objects.equals(\"Potato\",\"Potato\") = " + bResult);
        harness.check(bResult, true, "equals(\"Potato\",\"Potato\") == true");
        harness.debug("veg1(" + veg1 + ") = " + Arrays.toString(veg1));
        harness.debug("veg2(" + veg2 + ") = " + Arrays.toString(veg2));
        bResult = Objects.equals(veg1, veg1);
        harness.debug("Objects.equals(" + veg1 + "," + veg1 + ") = " + bResult);
        harness.check(bResult, true, "String array ==; equals(" + veg1 + "," + veg1 + ") == true");
        bResult = Objects.equals(veg1, veg2);
        harness.debug("Objects.equals(" + veg1 + "," + veg2 + ") = " + bResult);
        harness.check(bResult, false, "String array !=; equals(" + veg1 + "," + veg2 + ") == false");
        harness.debug("b1(" + b1 + ") = " + Arrays.toString(b1));
        harness.debug("b2(" + b2 + ") = " + Arrays.toString(b2));
        bResult = Objects.equals(b1, b1);
        harness.debug("Objects.equals(" + b1 + "," + b1 + ") = " + bResult);
        harness.check(bResult, true, "boolean array ==; equals(" + b1 + "," + b1 + ") == true");
        bResult = Objects.equals(b1, b2);
        harness.debug("Objects.equals(" + b1 + "," + b2 + ") = " + bResult);
        harness.check(bResult, false, "boolean array !=; equals(" + b1 + "," + b2 + ") == false");
        harness.debug("by1(" + by1 + ") = " + Arrays.toString(by1));
        harness.debug("by2(" + by2 + ") = " + Arrays.toString(by2));
        bResult = Objects.equals(by1, by1);
        harness.debug("Objects.equals(" + by1 + "," + by1 + ") = " + bResult);
        harness.check(bResult, true, "byte array ==; equals(" + by1 + "," + by1 + ") == true");
        bResult = Objects.equals(by1, by2);
        harness.debug("Objects.equals(" + by1 + "," + by2 + ") = " + bResult);
        harness.check(bResult, false, "byte array !=; equals(" + by1 + "," + by2 + ") == false");
        harness.debug("c1(" + c1 + ") = " + Arrays.toString(c1));
        harness.debug("c2(" + c2 + ") = " + Arrays.toString(c2));
        bResult = Objects.equals(c1, c1);
        harness.debug("Objects.equals(" + c1 + "," + c1 + ") = " + bResult);
        harness.check(bResult, true, "char array ==; equals(" + c1 + "," + c1 + ") == true");
        bResult = Objects.equals(c1, c2);
        harness.debug("Objects.equals(" + c1 + "," + c2 + ") = " + bResult);
        harness.check(bResult, false, "char array !=; equals(" + c1 + "," + c2 + ") == false");
        harness.debug("d1(" + d1 + ") = " + Arrays.toString(d1));
        harness.debug("d2(" + d2 + ") = " + Arrays.toString(d2));
        bResult = Objects.equals(d1, d1);
        harness.debug("Objects.equals(" + d1 + "," + d1 + ") = " + bResult);
        harness.check(bResult, true, "double array ==; equals(" + d1 + "," + d1 + ") == true");
        bResult = Objects.equals(d1, d2);
        harness.debug("Objects.equals(" + d1 + "," + d2 + ") = " + bResult);
        harness.check(bResult, false, "double array !=; equals(" + d1 + "," + d2 + ") == false");
        harness.debug("f1(" + f1 + ") = " + Arrays.toString(f1));
        harness.debug("f2(" + f2 + ") = " + Arrays.toString(f2));
        bResult = Objects.equals(f1, f1);
        harness.debug("Objects.equals(" + f1 + "," + f1 + ") = " + bResult);
        harness.check(bResult, true, "float array ==; equals(" + f1 + "," + f1 + ") == true");
        bResult = Objects.equals(f1, f2);
        harness.debug("Objects.equals(" + f1 + "," + f2 + ") = " + bResult);
        harness.check(bResult, false, "float array !=; equals(" + f1 + "," + f2 + ") == false");
        harness.debug("i1(" + i1 + ") = " + Arrays.toString(i1));
        harness.debug("i2(" + i2 + ") = " + Arrays.toString(i2));
        bResult = Objects.equals(i1, i1);
        harness.debug("Objects.equals(" + i1 + "," + i1 + ") = " + bResult);
        harness.check(bResult, true, "int array ==; equals(" + i1 + "," + i1 + ") == true");
        bResult = Objects.equals(i1, i2);
        harness.debug("Objects.equals(" + i1 + "," + i2 + ") = " + bResult);
        harness.check(bResult, false, "int array !=; equals(" + i1 + "," + i2 + ") == false");
        harness.debug("l1(" + l1 + ") = " + Arrays.toString(l1));
        harness.debug("l2(" + l2 + ") = " + Arrays.toString(l2));
        bResult = Objects.equals(l1, l1);
        harness.debug("Objects.equals(" + l1 + "," + l1 + ") = " + bResult);
        harness.check(bResult, true, "long array ==; equals(" + l1 + "," + l1 + ") == true");
        bResult = Objects.equals(l1, l2);
        harness.debug("Objects.equals(" + l1 + "," + l2 + ") = " + bResult);
        harness.check(bResult, false, "long array !=; equals(" + l1 + "," + l2 + ") == false");
        harness.debug("s1(" + s1 + ") = " + Arrays.toString(s1));
        harness.debug("s2(" + s2 + ") = " + Arrays.toString(s2));
        bResult = Objects.equals(s1, s1);
        harness.debug("Objects.equals(" + s1 + "," + s1 + ") = " + bResult);
        harness.check(bResult, true, "short array ==; equals(" + s1 + "," + s1 + ") == true");
        bResult = Objects.equals(s1, s2);
        harness.debug("Objects.equals(" + s1 + "," + s2 + ") = " + bResult);
        harness.check(bResult, false, "short array !=; equals(" + s1 + "," + s2 + ") == false");
        harness.debug("nested1(" + nested1 + ") = " + Arrays.toString(nested1));
        harness.debug("nested2(" + nested2 + ") = " + Arrays.toString(nested2));
        bResult = Objects.equals(nested1, nested1);
        harness.debug("Objects.equals(" + nested1 + "," + nested1 + ") = " + bResult);
        harness.check(bResult, true, "nested array ==; equals(" + nested1 + "," + nested1 + ") == true");
        bResult = Objects.equals(nested1, nested2);
        harness.debug("Objects.equals(" + nested1 + "," + nested2 + ") = " + bResult);
        harness.check(bResult, false, "nested array !=; equals(" + nested1 + "," + nested2 + ") == false");
        bResult = Objects.equals(veg1, i1);
        harness.debug("Objects.equals(" + veg1 + "," + i1 + ") = " + bResult);
        harness.check(bResult, false, "heterogenous arrays; equals(" + veg1 + "," + i1 + ") == false");
        bResult = Objects.equals(i1, veg1);
        harness.debug("Objects.equals(" + i1 + "," + veg1 + ") = " + bResult);
        harness.check(bResult, false, "heterogenous arrays; equals(" + i1 + "," + veg1 + ") == false");
    }
}

