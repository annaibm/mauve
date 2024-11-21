/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Collections;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;

public class nCopies
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        List<String> list2 = Collections.nCopies(0, "Y");
        harness.check(list2.isEmpty());
        list2 = Collections.nCopies(10, "X");
        harness.check(list2.size() == 10);
        harness.check(list2.get(0).equals("X"));
        harness.check(list2.get(9).equals("X"));
        boolean pass = false;
        try {
            list2 = Collections.nCopies(-1, "X");
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        list2 = Collections.nCopies(3, null);
        harness.check(list2.size() == 3);
        harness.check(list2.get(0) == null);
        harness.check(list2.get(1) == null);
        harness.check(list2.get(2) == null);
        list2 = Collections.nCopies(10, "Y");
        pass = false;
        try {
            list2.add("Z");
        }
        catch (UnsupportedOperationException e) {
            pass = true;
        }
        harness.check(pass);
        this.testSerialization(harness);
    }

    private void testSerialization(TestHarness harness) {
        List<String> list1 = Collections.nCopies(99, "X");
        List list2 = null;
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(buffer);
            out.writeObject(list1);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            list2 = (List)in.readObject();
            in.close();
        }
        catch (Exception e) {
            harness.debug(e);
        }
        harness.check(list1.equals(list2));
    }
}

