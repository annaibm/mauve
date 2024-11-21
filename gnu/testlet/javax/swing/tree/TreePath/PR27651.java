/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.TreePath;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.TreePath;

public class PR27651
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        A objA = new A("ABC");
        B objB = new B("ABC", 99);
        harness.check(objA.equals(objB));
        boolean pass = false;
        try {
            objB.equals(objA);
        }
        catch (ClassCastException e) {
            pass = true;
        }
        harness.check(pass);
        TreePath p1 = new TreePath(objA);
        TreePath p2 = new TreePath(objB);
        harness.check(p1.isDescendant(p2));
        pass = false;
        try {
            p2.isDescendant(p1);
        }
        catch (ClassCastException e) {
            pass = true;
        }
        harness.check(pass);
    }

    static class B
    extends A {
        int index;

        public B(String id, int index) {
            super(id);
            this.index = index;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!super.equals(obj)) {
                return false;
            }
            B that = (B)obj;
            return this.index == that.index;
        }
    }

    static class A {
        String id;

        public A(String id) {
            if (id == null) {
                id = "";
            }
            this.id = id;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof A) {
                A that = (A)obj;
                return this.id.equals(that.id);
            }
            return false;
        }
    }
}

