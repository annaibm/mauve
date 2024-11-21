/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectInputOutput;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class HierarchyTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(baos);
            objectOutputStream.writeObject(new Derived());
        }
        catch (IOException e) {
            harness.debug(e);
            harness.fail("Serialiazing a simple class deriving from a non serializable class");
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(bais);
            Derived serialized = (Derived)objectInputStream.readObject();
            harness.check(serialized.getA(), new Integer(-1), "Checking value from non serializable super class");
        }
        catch (Exception e) {
            harness.debug(e);
            harness.fail("Deserialiazing a simple class");
        }
    }

    private static class Derived
    extends Base
    implements Serializable {
        private static final long serialVersionUID = 7027787387780503451L;

        private Derived() {
        }
    }

    private static abstract class Base {
        private Integer a = new Integer(-1);

        Base() {
        }

        Integer getA() {
            return this.a;
        }
    }
}

