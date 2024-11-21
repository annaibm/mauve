/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.print.SimpleDoc;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.print.DocFlavor;
import javax.print.SimpleDoc;

public class getStreamForBytes
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleDoc doc = new SimpleDoc(new byte[]{50, 51}, DocFlavor.BYTE_ARRAY.GIF, null);
        try {
            InputStream stream1 = doc.getStreamForBytes();
            InputStream stream2 = doc.getStreamForBytes();
            harness.check(stream1 == stream2);
            harness.check(stream1 instanceof ByteArrayInputStream);
        }
        catch (IOException e) {
            harness.check(false);
        }
        SimpleDoc doc1 = new SimpleDoc(new ByteArrayInputStream(new byte[]{65, 98}), DocFlavor.INPUT_STREAM.GIF, null);
        try {
            InputStream stream3 = doc1.getStreamForBytes();
            InputStream stream4 = doc1.getStreamForBytes();
            harness.check(stream3 == stream4);
            harness.check(stream3 == doc1.getPrintData());
        }
        catch (IOException e) {
            harness.check(false);
        }
    }
}

