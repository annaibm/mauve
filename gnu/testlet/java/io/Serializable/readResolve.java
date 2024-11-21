/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.Serializable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.io.Serializable.MySerializable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class readResolve
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MySerializable x1 = new MySerializable();
        MySerializable x2 = null;
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(buffer);
            out.writeObject(x1);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            x2 = (MySerializable)in.readObject();
            in.close();
        }
        catch (Exception e) {
            harness.debug(e);
        }
        harness.check(x2.isResolved(), true);
    }
}

