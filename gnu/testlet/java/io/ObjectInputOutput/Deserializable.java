/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectInputOutput;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Deserializable
implements Testlet {
    public void testObject(TestHarness harness, Object a) {
        try {
            FileOutputStream fos = new FileOutputStream("frozen_serial");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a);
            oos.flush();
        }
        catch (Exception e) {
            harness.fail("Unexpected exception " + e);
            harness.debug(e);
        }
        harness.checkPoint("Deserialize " + a.getClass().getName());
        try {
            FileInputStream fis = new FileInputStream("frozen_serial");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object b = ois.readObject();
            harness.fail("Was expecting an InvalidClassException");
        }
        catch (InvalidClassException e) {
            harness.check(true);
            harness.debug(e);
        }
        catch (Exception e2) {
            harness.fail("Wrong exception");
            harness.debug(e2);
        }
    }

    @Override
    public void test(TestHarness harness) {
        this.testObject(harness, new Serialized1(10));
        this.testObject(harness, new Serialized2(10));
    }

    static class Serialized2
    extends NotSerializable2
    implements Serializable {
        static int count = 0;
        public int i;

        public Serialized2(int i) {
            super(i);
            this.i = i;
        }
    }

    static class NotSerializable2 {
        public NotSerializable2(int dummy2) {
        }

        private NotSerializable2() {
        }
    }

    static class Serialized1
    extends NotSerializable1
    implements Serializable {
        public Serialized1(int i) {
            super(i);
        }
    }

    static class NotSerializable1 {
        public NotSerializable1(int dummy2) {
        }
    }
}

