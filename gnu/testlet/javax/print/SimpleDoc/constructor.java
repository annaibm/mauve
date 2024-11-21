/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.print.SimpleDoc;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.CharArrayReader;
import javax.print.DocFlavor;
import javax.print.SimpleDoc;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            new SimpleDoc(new byte[100], DocFlavor.BYTE_ARRAY.GIF, null);
            harness.check(true);
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            harness.check(false);
        }
        try {
            new SimpleDoc(new CharArrayReader(new char[]{'A', 'b'}), DocFlavor.READER.TEXT_PLAIN, null);
            harness.check(true);
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            harness.check(false);
        }
        try {
            new SimpleDoc(new byte[100], DocFlavor.CHAR_ARRAY.TEXT_PLAIN, null);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            new SimpleDoc(null, DocFlavor.CHAR_ARRAY.TEXT_PLAIN, null);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            new SimpleDoc(new String("kk"), null, null);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }
}

