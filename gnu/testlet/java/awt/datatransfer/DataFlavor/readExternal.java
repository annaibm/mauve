/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.datatransfer.DataFlavor;

import java.awt.datatransfer.DataFlavor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import junit.framework.TestCase;

public class readExternal
extends TestCase {
    public void testBasicRead() {
        try {
            DataFlavor f = new DataFlavor("application/text; param1=xyz", "Plain Text");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            f.writeExternal(oos);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            DataFlavor read2 = new DataFlavor();
            read2.readExternal(ois);
            readExternal.assertEquals(f.getPrimaryType(), read2.getPrimaryType());
            readExternal.assertEquals(f.getSubType(), read2.getSubType());
            readExternal.assertEquals(f.getRepresentationClass(), read2.getRepresentationClass());
            readExternal.assertEquals(f.getHumanPresentableName(), read2.getHumanPresentableName());
            readExternal.assertEquals("xyz", read2.getParameter("param1"));
            readExternal.assertNull(read2.getParameter("humanPresentableName"));
            readExternal.assertEquals(f.getRepresentationClass().getName(), read2.getParameter("class"));
        }
        catch (IOException ex) {
            readExternal.fail();
        }
        catch (ClassNotFoundException ex) {
            readExternal.fail();
        }
    }
}

