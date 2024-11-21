/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.reflect.Proxy;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ToString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FacadeInvocationHandler handler = new FacadeInvocationHandler(new Foo());
        Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Serializable.class}, (InvocationHandler)handler);
        harness.check(proxy.toString(), "foo toString() result", "toString() test");
    }

    private static class Foo {
        private Foo() {
        }

        public String toString() {
            return "foo toString() result";
        }
    }

    private static class FacadeInvocationHandler
    implements InvocationHandler {
        Object facaded;

        public FacadeInvocationHandler(Object facaded) {
            this.facaded = facaded;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(this.facaded, args);
        }
    }
}

