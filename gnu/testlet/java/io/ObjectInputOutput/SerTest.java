/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectInputOutput;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.io.ObjectInputOutput.SerBase;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerTest
extends SerBase
implements Testlet {
    private int a;

    public SerTest() {
        this(1, 2);
    }

    SerTest(int a1, int a2) {
        super(a2);
        this.a = a1;
    }

    @Override
    public void test(TestHarness harness) {
        try {
            SerTest original = this;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            new ObjectOutputStream(baos).writeObject(original);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            SerTest serialized = (SerTest)new ObjectInputStream(bais).readObject();
            harness.check(serialized.a, original.a);
            harness.check(serialized.getA(), original.getA());
        }
        catch (Throwable t) {
            harness.check(false);
            harness.debug(t);
        }
    }
}

