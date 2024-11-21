/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.TreePath;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.tree.TreePath;

public class serialization
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TreePath p1 = new TreePath(new Object[]{new Integer(1), new Integer(2)});
        TreePath p2 = null;
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(buffer);
            out.writeObject(p1);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
            p2 = (TreePath)in.readObject();
            in.close();
        }
        catch (Exception e) {
            harness.debug(e);
        }
        harness.check(p1.equals(p2));
    }
}

