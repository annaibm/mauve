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
import java.io.StreamCorruptedException;

public class LoopSerializationTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SerializableLoopA a = new SerializableLoopA();
        SerializableLoopB b = new SerializableLoopB();
        a.setB(b);
        b.setA(a);
        harness.checkPoint("LoopSerializationTest");
        harness.check(a.getB(), b);
        harness.check(b.getA(), a);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(baos).writeObject(a);
        }
        catch (IOException e) {
            harness.debug(e);
            harness.fail("Serialiazing a loop");
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        try {
            SerializableLoopA serialized = (SerializableLoopA)new ObjectInputStream(bais).readObject();
            harness.check(serialized.getB(), b);
        }
        catch (StreamCorruptedException e) {
            harness.debug(e);
            harness.fail("Deserialiazing a loop");
        }
        catch (ClassNotFoundException e) {
            harness.debug(e);
            harness.fail("Deserialiazing a loop");
        }
        catch (IOException e) {
            harness.debug(e);
            harness.fail("Deserialiazing a loop");
        }
    }
}

