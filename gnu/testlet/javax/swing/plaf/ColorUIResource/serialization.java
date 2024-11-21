/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.ColorUIResource;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.plaf.ColorUIResource;

public class serialization
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ColorUIResource c1 = new ColorUIResource(Color.red);
        ColorUIResource c2 = null;
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(buffer);
            out.writeObject(c1);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            c2 = (ColorUIResource)in.readObject();
            in.close();
        }
        catch (Exception e) {
            harness.debug(e);
        }
        harness.check(c1.equals(c2));
    }
}

