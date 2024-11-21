/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.ObjectInputStream;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.io.ObjectInputStream.TestObjectInputValidation;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class registerValidation
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestObjectInputValidation t1 = new TestObjectInputValidation("Name1");
        TestObjectInputValidation t2 = null;
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(buffer);
            out.writeObject(t1);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            t2 = (TestObjectInputValidation)in.readObject();
            in.close();
            harness.check(t2, t1);
            harness.check(t2.object, t2);
            harness.check(t2.validated != null);
            Object[] ps = t2.validated.toArray();
            int[] priorities = new int[ps.length];
            for (int i = 0; i < ps.length; ++i) {
                priorities[i] = (Integer)ps[i];
            }
            harness.check(priorities != null);
            harness.check(priorities.length, 5);
            harness.check(priorities[0], -12);
            harness.check(priorities[1], -10);
            harness.check(priorities[2], 10);
            harness.check(priorities[3], 11);
            harness.check(priorities[4], 10);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false, e.toString());
        }
    }
}

