/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DoubleSetterTest
implements Testlet {
    protected static TestHarness harness;

    public void test_max() {
        harness.check(!Double.isNaN(Double.MAX_VALUE));
        harness.check(!Double.isNaN(new Double(Double.MAX_VALUE)));
        DoubleHolder doubleHolder = new DoubleHolder();
        doubleHolder.setValue(Double.MAX_VALUE);
        harness.check(Double.MAX_VALUE, doubleHolder.getValue());
        DoubleHolder doubleHolder2 = new DoubleHolder();
        try {
            Method setMethod = DoubleHolder.class.getDeclaredMethod("setValue", Double.TYPE);
            setMethod.invoke((Object)doubleHolder2, new Double(Double.MAX_VALUE));
        }
        catch (NoSuchMethodException e) {
            harness.fail("no method setValue");
        }
        catch (IllegalAccessException e) {
            harness.fail("illegal access");
        }
        catch (InvocationTargetException e) {
            harness.fail("invocation failed");
        }
        harness.check(!Double.isNaN(doubleHolder2.getValue()));
    }

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        this.test_max();
    }

    private static class DoubleHolder {
        private double value;

        private DoubleHolder() {
        }

        public double getValue() {
            return this.value;
        }

        public void setValue(double value2) {
            this.value = value2;
        }
    }
}

