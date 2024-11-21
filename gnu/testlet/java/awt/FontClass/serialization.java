/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.FontClass;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class serialization
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Font f1 = new Font("Dialog", 0, 14);
        Font f2 = null;
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(buffer);
            out.writeObject(f1);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            f2 = (Font)in.readObject();
            in.close();
        }
        catch (Exception e) {
            harness.debug(e);
        }
        harness.check(f1.equals(f2));
    }
}

