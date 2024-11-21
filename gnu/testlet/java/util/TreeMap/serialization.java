/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.TreeMap;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

public class serialization
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TreeMap tm1 = new TreeMap();
        TreeMap tm2 = null;
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(buffer);
            out.writeObject(tm1);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            tm2 = (TreeMap)in.readObject();
            in.close();
        }
        catch (Exception e) {
            harness.debug(e);
        }
        harness.check(tm1.equals(tm2));
    }
}

