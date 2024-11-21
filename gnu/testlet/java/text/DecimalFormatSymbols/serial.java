/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormatSymbols;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class serial
implements Testlet {
    private static String infinity = "supermuch";
    private static String nan = "Ehe?";

    @Override
    public void test(TestHarness harness) {
        DecimalFormatSymbols dfs1 = new DecimalFormatSymbols(Locale.US);
        dfs1.setInfinity(infinity);
        dfs1.setNaN(nan);
        Object o = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(dfs1);
            oos.close();
            byte[] bs = baos.toByteArray();
            ByteArrayInputStream bois = new ByteArrayInputStream(bs);
            ObjectInputStream ois = new ObjectInputStream(bois);
            o = ois.readObject();
            ois.close();
        }
        catch (IOException ioe) {
            harness.debug(ioe);
        }
        catch (ClassNotFoundException cnfe) {
            harness.debug(cnfe);
        }
        DecimalFormatSymbols dfs2 = (DecimalFormatSymbols)o;
        harness.check(dfs1, dfs2);
        harness.check(dfs2.getInfinity(), (Object)infinity);
        harness.check(dfs2.getNaN(), (Object)nan);
    }
}

