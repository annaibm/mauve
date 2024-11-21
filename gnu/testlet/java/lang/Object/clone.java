/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Object;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public final class clone
implements Testlet,
Cloneable {
    private static int count = 0;
    private int prim = 42;
    private Object obj = this;
    private Testlet test = this;
    private float[] array = new float[0];

    public clone() {
        ++count;
    }

    @Override
    public void test(TestHarness harness) {
        int my_count = count;
        clone copy2 = null;
        try {
            copy2 = (clone)this.clone();
        }
        catch (CloneNotSupportedException cnse) {
            harness.fail("clone should pass on Cloneable object");
        }
        harness.check(copy2 != this, "clone built distinct object");
        harness.check(copy2 instanceof clone, "clone built same class - 1");
        harness.check(copy2.getClass() == clone.class, "clone built same class - 2");
        harness.check(count == my_count, "clone called no constructor");
        harness.check(copy2.prim == 42, "primitive field cloned correctly");
        harness.check(copy2.obj == this, "object field cloned correctly");
        harness.check(copy2.test == this, "interface field cloned correctly");
        harness.check(copy2.array == this.array, "array field cloned correctly");
        int[] iarray = new int[]{1, 2};
        int[] icopy = (int[])iarray.clone();
        Object[] oarray = new Object[]{new Object()};
        Object[] ocopy = (Object[])oarray.clone();
        harness.check(iarray != icopy, "cloned arrays are distinct - 1");
        harness.check(oarray != ocopy, "cloned arrays are distinct - 2");
        harness.check(iarray.length == icopy.length, "cloned arrays have same length - 1");
        harness.check(oarray.length == ocopy.length, "cloned arrays have same length - 2");
        harness.check(iarray.getClass() == icopy.getClass(), "cloned arrays have same type - 1");
        harness.check(oarray.getClass() == ocopy.getClass(), "cloned arrays have same type - 2");
        harness.check(iarray.getClass().getComponentType() == icopy.getClass().getComponentType(), "cloned arrays have same component type - 1");
        harness.check(oarray.getClass().getComponentType() == ocopy.getClass().getComponentType(), "cloned arrays have same component type - 2");
        harness.check(iarray[0] == icopy[0], "cloned contents are same - 1");
        harness.check(iarray[1] == icopy[1], "cloned contents are same - 2");
        harness.check(oarray[0] == ocopy[0], "cloned contents are same - 3");
    }
}

