/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectInputOutput;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ExtTest
implements Testlet,
Serializable {
    private Object ext = new Inner();
    private String test = "test";

    @Override
    public void test(TestHarness harness) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            new ObjectOutputStream(baos).writeObject(this);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ExtTest serialized = (ExtTest)new ObjectInputStream(bais).readObject();
            harness.check(serialized.ext.getClass(), this.ext.getClass());
            harness.check(serialized.test.equals(this.test));
        }
        catch (Throwable t) {
            harness.check(false);
            harness.debug(t);
        }
    }

    public static class Inner
    implements Externalizable {
        @Override
        public void readExternal(ObjectInput ois) {
        }

        @Override
        public void writeExternal(ObjectOutput oos) {
        }
    }
}

