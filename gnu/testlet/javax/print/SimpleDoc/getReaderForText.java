/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.print.SimpleDoc;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import javax.print.DocFlavor;
import javax.print.SimpleDoc;

public class getReaderForText
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Reader reader2;
        SimpleDoc doc = new SimpleDoc(new String("Text to print"), DocFlavor.STRING.TEXT_PLAIN, null);
        try {
            Reader reader1 = doc.getReaderForText();
            reader2 = doc.getReaderForText();
            harness.check(reader1 == reader2);
            harness.check(reader1 instanceof StringReader);
        }
        catch (IOException e) {
            harness.check(false);
        }
        SimpleDoc doc1 = new SimpleDoc(new char[]{'A', 'b'}, DocFlavor.CHAR_ARRAY.TEXT_PLAIN, null);
        try {
            reader2 = doc1.getReaderForText();
            Reader reader3 = doc1.getReaderForText();
            harness.check(reader2 == reader3);
            harness.check(reader2 instanceof CharArrayReader);
        }
        catch (IOException e) {
            harness.check(false);
        }
        SimpleDoc doc2 = new SimpleDoc(new CharArrayReader(new char[]{'A', 'b'}), DocFlavor.READER.TEXT_PLAIN, null);
        try {
            Reader reader4 = doc2.getReaderForText();
            Reader reader5 = doc2.getReaderForText();
            harness.check(reader4 == reader5);
            harness.check(reader4 == doc2.getPrintData());
        }
        catch (IOException e) {
            harness.check(false);
        }
        SimpleDoc doc3 = new SimpleDoc(new byte[]{65, 98}, DocFlavor.BYTE_ARRAY.AUTOSENSE, null);
        try {
            Reader reader6 = doc3.getReaderForText();
            harness.check(reader6 == null);
        }
        catch (IOException e) {
            harness.check(false);
        }
    }
}

