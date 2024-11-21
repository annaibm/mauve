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
import java.lang.reflect.UndeclaredThrowableException;

public class ExceptionRaising
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testWrappedException(harness);
        this.testReturnNull(harness);
        this.testClassCastException(harness);
    }

    private void testReturnNull(TestHarness harness) {
        Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Serializable.class}, (InvocationHandler)new NullInvocationHandler());
        try {
            proxy.getClass();
            harness.checkPoint("Passed returning null when a non primitive object is expected");
        }
        catch (Exception e) {
            harness.fail("Returning null should be safe when a non primitive object is expected");
        }
        try {
            proxy.hashCode();
            harness.fail("Returning null when a primitive return value is expected should have thrown an exception");
        }
        catch (Exception e) {
            harness.check(e instanceof NullPointerException, "Checking that exception thrown is a NullPointerException");
        }
    }

    private void testWrappedException(TestHarness harness) {
        Exception exception = new Exception();
        Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Serializable.class}, (InvocationHandler)new ExceptionInvocationHandler(exception));
        try {
            proxy.toString();
            harness.fail("Call to toString via a proxy should have failed with an exception");
        }
        catch (UndeclaredThrowableException e) {
            harness.check(e.getUndeclaredThrowable(), exception, "Exception thrown check");
        }
    }

    private void testClassCastException(TestHarness harness) {
        Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Serializable.class}, (InvocationHandler)new ThisInvocationHandler());
        try {
            proxy.toString();
        }
        catch (Exception e) {
            harness.check(e instanceof ClassCastException, "Checking that the raised exception was a ClassPathException");
        }
    }

    private static class ThisInvocationHandler
    implements InvocationHandler {
        private ThisInvocationHandler() {
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return this;
        }
    }

    private static class NullInvocationHandler
    implements InvocationHandler {
        private NullInvocationHandler() {
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }

    private static class ExceptionInvocationHandler
    implements InvocationHandler {
        Exception exception;

        public ExceptionInvocationHandler(Exception exception) {
            this.exception = exception;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            throw this.exception;
        }
    }
}

