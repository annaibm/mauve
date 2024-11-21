/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.io.ObjectInputStream.ReadResolveHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class readResolve
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ObjectInputStream in;
        ObjectOutputStream out;
        ByteArrayOutputStream buffer;
        harness.checkPoint("readResolve called");
        ReadResolveHelper test = new ReadResolveHelper(5);
        ReadResolveHelper test_deserialized = null;
        try {
            buffer = new ByteArrayOutputStream();
            out = new ObjectOutputStream(buffer);
            out.writeObject(test);
            out.close();
            in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            test_deserialized = (ReadResolveHelper)in.readObject();
            in.close();
            harness.check(test_deserialized.value, 4);
        }
        catch (Throwable e) {
            harness.check(false);
        }
        harness.checkPoint("error thrown");
        test = new ReadResolveHelper(1);
        test_deserialized = null;
        try {
            buffer = new ByteArrayOutputStream();
            out = new ObjectOutputStream(buffer);
            out.writeObject(test);
            out.close();
            in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            test_deserialized = (ReadResolveHelper)in.readObject();
            in.close();
            harness.check(false);
        }
        catch (Throwable e) {
            harness.check(true);
        }
        harness.checkPoint("runtime exception thrown");
        test = new ReadResolveHelper(2);
        test_deserialized = null;
        try {
            buffer = new ByteArrayOutputStream();
            out = new ObjectOutputStream(buffer);
            out.writeObject(test);
            out.close();
            in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            test_deserialized = (ReadResolveHelper)in.readObject();
            in.close();
            harness.check(false);
        }
        catch (Throwable e) {
            harness.check(true);
        }
        harness.checkPoint("InvalidObjectException thrown");
        test = new ReadResolveHelper(3);
        test_deserialized = null;
        try {
            buffer = new ByteArrayOutputStream();
            out = new ObjectOutputStream(buffer);
            out.writeObject(test);
            out.close();
            in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            test_deserialized = (ReadResolveHelper)in.readObject();
            in.close();
            harness.check(false);
        }
        catch (Throwable e) {
            harness.check(true);
        }
    }
}

