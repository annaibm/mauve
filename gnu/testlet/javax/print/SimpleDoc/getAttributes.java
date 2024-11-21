/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.print.SimpleDoc;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.print.DocFlavor;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.UnmodifiableSetException;
import javax.print.attribute.standard.Compression;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.Sides;

public class getAttributes
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashDocAttributeSet set2 = new HashDocAttributeSet();
        set2.add(Sides.DUPLEX);
        set2.add(Compression.COMPRESS);
        set2.add(OrientationRequested.LANDSCAPE);
        SimpleDoc doc = new SimpleDoc(new byte[100], DocFlavor.BYTE_ARRAY.GIF, set2);
        DocAttributeSet set1 = doc.getAttributes();
        DocAttributeSet set22 = doc.getAttributes();
        harness.check(set1 == set22);
        try {
            set1.remove(Compression.class);
            harness.check(false);
        }
        catch (UnmodifiableSetException e) {
            harness.check(true);
        }
    }
}

