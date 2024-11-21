/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectInputOutput;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.io.ObjectInputOutput.SerializableLoopA;
import gnu.testlet.java.io.ObjectInputOutput.SerializableLoopB;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxySerializationTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SerBaseInterface proxy = (SerBaseInterface)Proxy.newProxyInstance(SerBaseInterface.class.getClassLoader(), new Class[]{SerBaseInterface.class}, (InvocationHandler)new DummyInvocationHandler());
        SerializableLoopA serializableLoopA = new SerializableLoopA();
        SerializableLoopB serializableLoopB = new SerializableLoopB();
        serializableLoopA.setB(serializableLoopB);
        serializableLoopB.setA(serializableLoopA);
        harness.checkPoint("ProxySerializationTest");
        harness.check(proxy.getA(), -25679, "Proxy interception checking");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(baos);
            objectOutputStream.writeObject(proxy);
            objectOutputStream.writeObject(serializableLoopA);
            objectOutputStream.writeObject(serializableLoopB);
        }
        catch (IOException e) {
            harness.debug(e);
            harness.fail("Error while serialiazing a proxy");
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(bais);
            SerBaseInterface serialized = (SerBaseInterface)objectInputStream.readObject();
            harness.check(serialized.getA(), -25679, "Reserialized proxy working checking");
            SerializableLoopA serializableLoopA2 = (SerializableLoopA)objectInputStream.readObject();
            SerializableLoopB serializableLoopB2 = (SerializableLoopB)objectInputStream.readObject();
            harness.check(serializableLoopA.getB(), serializableLoopA2.getB());
        }
        catch (Exception e) {
            harness.debug(e);
            harness.fail("Error while deserialiazing a proxy");
        }
    }

    private static interface SerBaseInterface {
        public int getA();
    }

    private static class DummyInvocationHandler
    implements InvocationHandler,
    Serializable {
        private static final long serialVersionUID = -6475900781578075262L;

        private DummyInvocationHandler() {
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if ("getA".equals(method.getName())) {
                return new Integer(-25679);
            }
            return method.invoke(proxy, args);
        }
    }
}

