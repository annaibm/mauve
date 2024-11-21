/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.Serializable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ParentReadResolve
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            ByteArrayOutputStream outb = new ByteArrayOutputStream();
            ObjectOutputStream outs = new ObjectOutputStream(outb);
            outs.writeObject(MySingleton.instance);
            outs.writeObject(new MyFoo());
            byte[] store = outb.toByteArray();
            ByteArrayInputStream inb = new ByteArrayInputStream(store);
            ObjectInputStream ins = new ObjectInputStream(inb);
            MySingleton x = (MySingleton)ins.readObject();
            harness.check(x == MySingleton.instance);
            MyFoo foo = (MyFoo)ins.readObject();
            harness.check(!foo.resolved);
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
        boolean resolved = false;

        Foo() {
        }

        private Object readResolve() {
            this.resolved = true;
            return this;
        }
    }

    static class MySingleton
    extends Singleton {
        static final MySingleton instance = new MySingleton();

        MySingleton() {
        }

        @Override
        Singleton getInstance() {
            return instance;
        }
    }

    static abstract class Singleton
    implements Serializable {
        Singleton() {
        }

        abstract Singleton getInstance();

        Object readResolve() {
            return this.getInstance();
        }
    }
}

