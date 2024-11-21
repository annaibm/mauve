/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.reflect.Proxy;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.lang.reflect.Proxy.ProxyUtils;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

public class DeclaringClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Class[] testableInterfaces = new Class[]{Serializable.class, WithObjectOverrides.class, WithoutObjectOverrides.class, Base.class, Derived.class};
        for (int i = 0; i < testableInterfaces.length; ++i) {
            Class interfaceItem = testableInterfaces[i];
            Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{interfaceItem}, (InvocationHandler)new ExpectObjectDeclaringClassIfPossibleHandler(harness));
            harness.checkPoint("Testing " + interfaceItem);
            proxy.equals(new Object());
            proxy.hashCode();
            proxy.toString();
        }
    }

    private static interface Derived
    extends Base {
        @Override
        public void foo();
    }

    private static interface Base {
        public void foo();
    }

    private static interface WithoutObjectOverrides {
        public boolean equals();

        public long hashCode(Object var1);

        public void toString(long var1);
    }

    private static interface WithObjectOverrides {
        public boolean equals(Object var1);

        public int hashCode();

        public String toString();
    }

    private static class ExpectObjectDeclaringClassIfPossibleHandler
    implements InvocationHandler {
        static Collection objectMethods = new ArrayList();
        TestHarness harness;

        public ExpectObjectDeclaringClassIfPossibleHandler(TestHarness harness) {
            this.harness = harness;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            boolean expectObjectDeclaringClass = false;
            for (Method objectMethod : objectMethods) {
                if (!ProxyUtils.compareMethodOnNameAndParameterTypes(objectMethod, method)) continue;
                expectObjectDeclaringClass = true;
            }
            this.harness.check(method.getDeclaringClass() == Object.class == expectObjectDeclaringClass);
            return ProxyUtils.getNeutralValue(method.getReturnType());
        }

        static {
            try {
                objectMethods.add(Object.class.getMethod("equals", Object.class));
                objectMethods.add(Object.class.getMethod("hashCode", null));
                objectMethods.add(Object.class.getMethod("toString", null));
            }
            catch (NoSuchMethodException e) {
                e.printStackTrace();
                throw new Error("Missing core methods in Object");
            }
        }
    }
}

