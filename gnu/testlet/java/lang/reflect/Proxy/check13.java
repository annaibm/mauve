/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.reflect.Proxy;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class check13
implements Testlet,
InvocationHandler,
Serializable {
    transient Object proxy;
    transient Object[] args;
    transient Method method;

    @Override
    public void test(TestHarness harness) {
        ActionListener al = (ActionListener)Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{ActionListener.class}, (InvocationHandler)this);
        Method expectedMethod = null;
        try {
            expectedMethod = ActionListener.class.getMethod("actionPerformed", ActionEvent.class);
        }
        catch (NoSuchMethodException nsme) {
            harness.fail("test setup failed");
        }
        ActionEvent event = new ActionEvent(this, 0, "GNU yourself!");
        al.actionPerformed(event);
        harness.check(this.proxy == al, "proxy method called");
        harness.check(this.method, expectedMethod);
        harness.check(this.args.length, 1);
        harness.check(this.args[0] == event);
        harness.checkPoint("serialization");
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this.proxy);
            oos.close();
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Proxy p = (Proxy)ois.readObject();
            harness.check(p.getClass() == this.proxy.getClass());
            harness.check(Proxy.getInvocationHandler(p).getClass() == Proxy.getInvocationHandler(this.proxy).getClass());
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("Unexpected exception");
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.proxy = proxy;
        this.method = method;
        this.args = args;
        return null;
    }
}

