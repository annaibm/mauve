/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StringContent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Segment;
import javax.swing.text.StringContent;

public class StringContentTest
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.checkPoint("StringContent");
        StringContent sc = new StringContent();
        try {
            h.checkPoint("StringContent -- insertString()");
            sc.insertString(0, "path");
            h.check("path\n", sc.getString(0, sc.length()), "StringContent.insertString(): insert 'path' at 0 getString() is: " + sc.getString(0, sc.length()));
            h.checkPoint("StringContent -- length()");
            h.check(5, sc.length(), "StringContent.length(): should be 5, is: " + sc.length());
            h.checkPoint("StringContent -- insertString() part2");
            sc.insertString(0, "class");
            h.checkPoint("StringContent -- getString()");
            h.check("classpath\n", sc.getString(0, sc.length()), "StringContent.insertString(): put 'class' at 0 should be 'classpath' and is: " + sc.getString(0, sc.length()));
            h.checkPoint("StringContent -- length() part2");
            h.check(10, sc.length(), "StringContent.length(): should be 10, is: " + sc.length());
            h.checkPoint("StringContent -- remove()");
            sc.remove(1, 4);
            h.checkPoint("StringContent -- getString() part2");
            h.check("cpath\n", sc.getString(0, sc.length()), "StringContent.remove(): should be 'cpath' is '" + sc.getString(0, sc.length()) + "'");
            h.checkPoint("StringContent -- remove() part2");
            sc.remove(2, 3);
            h.checkPoint("StringContent -- getString() part3");
            h.check("cp\n", sc.getString(0, sc.length()), "StringContent.remove(): should be 'cp' is '" + sc.getString(0, sc.length()) + "'");
            h.checkPoint("StringContent -- getChars()");
            char[] ctab = new char[]{'c', 'p', '\n'};
            Segment s = new Segment(ctab, 0, 3);
            Segment s2 = new Segment();
            sc.getChars(0, sc.length(), s2);
            h.check(s.toString(), s2.toString(), "StringContent.getChars(): compare to javax.swing.text.Segment (first Segment: " + s + "; second Segment: " + s2 + ")");
            h.checkPoint("StringContent -- StringContent()");
            sc = new StringContent(100);
            h.check("\n", sc.getString(0, sc.length()), "StringContent(100): getString(0, lenght) should be '\\n'");
            h.check(1, sc.length(), "StringContent(100): length() should be 1 and is : " + sc.length());
            h.checkPoint("StringContent -- StringContent() part2");
            sc = new StringContent(1);
            h.check(1, sc.length(), "StringContent(1): length() should be 1 and is : " + sc.length());
            h.checkPoint("StringContent -- StringContent() part3");
            sc = new StringContent(0);
            h.check(1, sc.length(), "StringContent(0): length() should be 1 and is : " + sc.length());
            h.checkPoint("StringContent -- StringContent() part4");
            sc = new StringContent();
            h.check(1, sc.length(), "StringContent(): length() should be 1 and is : " + sc.length());
        }
        catch (BadLocationException ble) {
            h.fail("BadLocation! " + ble.getMessage());
        }
    }
}

