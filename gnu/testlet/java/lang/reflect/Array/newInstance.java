/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.reflect.Array;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Array;

public class newInstance
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("Void.TYPE");
        int val = 0;
        Object x = null;
        try {
            x = Array.newInstance(Void.TYPE, 10);
            val = 1;
        }
        catch (IllegalArgumentException iae) {
            val = 2;
        }
        catch (NullPointerException npe) {
            val = 4;
        }
        catch (Throwable t) {
            val = 3;
        }
        harness.check(val, 2);
        try {
            harness.check(x, null);
        }
        catch (InternalError ie) {
            harness.check(null, ie);
        }
        harness.checkPoint("Integer.TYPE");
        try {
            x = Array.newInstance(Integer.TYPE, 10);
            val = 1;
        }
        catch (IllegalArgumentException iae) {
            val = 2;
        }
        catch (NullPointerException npe) {
            val = 4;
        }
        catch (Throwable t) {
            val = 3;
        }
        harness.check(val, 1);
        val = 999;
        try {
            val = ((int[])x).length;
        }
        catch (ClassCastException cce) {
            val = 99;
        }
        harness.check(val, 10);
        val = 0;
        try {
            if (x.getClass().getComponentType() == Integer.TYPE) {
                val = 1;
            }
        }
        catch (Throwable t) {
            val = 2;
        }
        harness.check(val, 1);
        harness.checkPoint("NegativeArraySize");
        try {
            x = Array.newInstance(String.class, -101);
            val = 1;
        }
        catch (NegativeArraySizeException nas) {
            val = 2;
        }
        catch (Throwable t) {
            val = 3;
        }
        harness.check(val, 2);
        harness.checkPoint("multi-dimensional");
        val = 0;
        try {
            x = Array.newInstance(String.class, null);
            val = 1;
        }
        catch (NullPointerException e) {
            val = 2;
        }
        catch (Throwable t) {
            harness.debug(t);
            val = 3;
        }
        harness.check(val, 2);
        val = 0;
        try {
            x = Array.newInstance(String.class, new int[0]);
            val = 1;
        }
        catch (IllegalArgumentException e) {
            val = 2;
        }
        catch (Throwable t) {
            harness.debug(t);
            val = 3;
        }
        harness.check(val, 2);
        val = 0;
        try {
            x = Array.newInstance(String.class, new int[255]);
            val = 1;
        }
        catch (Throwable t) {
            harness.debug(t);
            val = 2;
        }
        harness.check(val, 1);
        val = 0;
        try {
            x = Array.newInstance(String.class, 0, -1);
            val = 1;
        }
        catch (NegativeArraySizeException e) {
            val = 2;
        }
        catch (Throwable t) {
            harness.debug(t);
            val = 3;
        }
        harness.check(val, 2);
        val = 0;
        try {
            x = new int[0][-1];
            val = 1;
        }
        catch (NegativeArraySizeException e) {
            val = 2;
        }
        catch (Throwable t) {
            harness.debug(t);
            val = 3;
        }
        harness.check(val, 2);
        val = 0;
        try {
            x = Array.newInstance(String.class, Integer.MAX_VALUE, Integer.MAX_VALUE);
            val = 1;
        }
        catch (OutOfMemoryError e) {
            val = 2;
        }
        catch (Throwable t) {
            harness.debug(t);
            val = 3;
        }
        harness.check(val, 2);
        harness.checkPoint("array");
        Class<?> c = null;
        val = 0;
        try {
            x = Array.newInstance(String.class, new int[254]);
            c = x.getClass();
        }
        catch (Throwable t) {
            val = 1;
        }
        try {
            x = Array.newInstance(c, 1);
            val = 5;
        }
        catch (Throwable t) {
            val = 6;
        }
        harness.check(val, 5);
        val = 0;
        try {
            x = Array.newInstance(int[].class, 1);
            val = 1;
            if (((int[][])x).length == 1) {
                val = 2;
            }
        }
        catch (Throwable t) {
            val = 3;
        }
        harness.check(val, 2);
        harness.checkPoint("interface");
        val = 0;
        try {
            x = Array.newInstance(Runnable.class, 5);
            val = 1;
        }
        catch (Throwable t) {
            val = 2;
        }
        harness.check(val, 1);
        try {
            val = ((Runnable[])x).length;
        }
        catch (ClassCastException cce) {
            val = 3;
        }
        harness.check(val, 5);
        val = 0;
        try {
            if (x.getClass().getComponentType() == Runnable.class) {
                val = 1;
            }
            if (((Runnable[])x)[0] == null) {
                val = 2;
            }
        }
        catch (Throwable t) {
            val = 3;
        }
        harness.check(val, 2);
        harness.checkPoint("String");
        x = "check";
        val = 0;
        try {
            x = Array.newInstance(String.class, 100);
            val = 1;
        }
        catch (IllegalArgumentException iae) {
            val = 2;
        }
        catch (NullPointerException npe) {
            val = 4;
        }
        catch (Throwable t) {
            val = 3;
        }
        harness.check(val, 1);
        try {
            val = ((String[])x).length;
        }
        catch (ClassCastException cce) {
            val = 99;
        }
        harness.check(val, 100);
        harness.debug(x.getClass().toString());
        val = 0;
        try {
            if (x.getClass().getComponentType() == String.class && ((String[])x)[0] == null) {
                val = 1;
            }
        }
        catch (Throwable t) {
            val = 2;
        }
        harness.check(val, 1);
    }
}

