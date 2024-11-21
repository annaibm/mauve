/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectStreamClass;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest
implements Testlet,
InvocationHandler {
    @Override
    public Object invoke(Object p, Method m, Object[] os) {
        return null;
    }

    @Override
    public void test(TestHarness harness) {
        Class<?> pc = Proxy.getProxyClass(this.getClass().getClassLoader(), Comparable.class);
        ObjectStreamClass osc = ObjectStreamClass.lookup(pc);
        harness.check(osc.getSerialVersionUID(), 0L, "zero serialVersionUID");
        ObjectStreamField[] osfs = osc.getFields();
        harness.check(osfs != null && osfs.length == 0, "zero ObjectStreamFields");
        harness.check(osc.getField("any"), null, "getField(any) returns null");
        harness.check(osc.getField("h"), null, "getField(h) returns null");
    }
}

