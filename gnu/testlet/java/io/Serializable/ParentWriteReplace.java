/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.Serializable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ParentWriteReplace
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            ByteArrayOutputStream outb = new ByteArrayOutputStream();
            ObjectOutputStream outs = new ObjectOutputStream(outb);
            MySingleton singleton = new MySingleton();
            outs.writeObject(singleton);
            harness.check(singleton.replaced);
            MyFoo foo = new MyFoo();
            outs.writeObject(foo);
            harness.check(!foo.replaced);
        }
        catch (Throwable e) {
            harness.debug(e);
        }
    }

    static class MyFoo
    extends Foo {
        MyFoo() {
        }
    }

    static abstract class Foo
    implements Serializable {
        boolean replaced = false;

        Foo() {
        }

        private Object writeReplace() {
            this.replaced = true;
            return this;
        }
    }

    static class MySingleton
    extends Singleton {
        MySingleton() {
        }
    }

    static abstract class Singleton
    implements Serializable {
        boolean replaced = false;

        Singleton() {
        }

        Object writeReplace() {
            this.replaced = true;
            return this;
        }
    }
}

