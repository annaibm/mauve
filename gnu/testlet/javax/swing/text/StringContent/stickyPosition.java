/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StringContent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.StringContent;

public class stickyPosition
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.checkPoint("StringContent");
        StringContent sc = new StringContent();
        try {
            sc.insertString(0, "classpath");
            Position position2 = sc.createPosition(1);
            Position position22 = sc.createPosition(4);
            Position position3 = sc.createPosition(sc.length());
            h.check(1, position2.getOffset(), "createPosition(1): Position.getOffset() should be 1 and is: " + position2.getOffset());
            h.check(4, position22.getOffset(), "createPosition(4): Position2.getOffset() should be 4 and is: " + position22.getOffset());
            h.check(10, position3.getOffset(), "createPosition(10): Position3.getOffset() should be 10 and is: " + position3.getOffset());
            sc.insertString(2, "-");
            h.check(1, position2.getOffset(), "Position.getOffset() should be 1 and is: " + position2.getOffset());
            h.check(5, position22.getOffset(), "Position2.getOffset() should be 5 and is: " + position22.getOffset());
            h.check(11, position3.getOffset(), "Position3.getOffset() should be 11 and is: " + position3.getOffset());
            sc.insertString(1, "-");
            h.check(2, position2.getOffset(), "Position.getOffset() should be 2 and is: " + position2.getOffset());
            h.check(6, position22.getOffset(), "Position2.getOffset() should be 6 and is: " + position22.getOffset());
            h.check(12, position3.getOffset(), "Position3.getOffset() should be 12 and is: " + position3.getOffset());
            sc.remove(0, 2);
            h.check(0, position2.getOffset(), "Position.getOffset() should be 0 and is: " + position2.getOffset());
            h.check(4, position22.getOffset(), "Position2.getOffset() should be 4 and is: " + position22.getOffset());
            h.check(10, position3.getOffset(), "Position3.getOffset() should be 10 and is: " + position3.getOffset());
            sc.remove(0, 5);
            h.check(0, position2.getOffset(), "Position.getOffset() should be 0 and is: " + position2.getOffset());
            h.check("path\n", sc.getString(0, sc.length()), "getString(0, length()) should be 'path\\n' and is: " + sc.getString(0, sc.length()));
            h.check(0, position22.getOffset(), "Position.getOffset() should be 0 and is: " + position22.getOffset());
            h.check(5, position3.getOffset(), "Position3.getOffset() should be 5 and is: " + position3.getOffset());
            sc.insertString(0, "class");
            h.check(0, position2.getOffset(), "Position.getOffset() should be 0 and is: " + position2.getOffset());
            h.check("classpath\n", sc.getString(0, sc.length()), "getString(0, length()) should be 'classpath\\n' and is: " + sc.getString(0, sc.length()));
            h.check(0, position22.getOffset(), "Position.getOffset() should be 0 and is: " + position22.getOffset());
            h.check(sc.length(), position3.getOffset(), "Position3 should be 10 and is: " + position3.getOffset());
        }
        catch (BadLocationException ble) {
            h.fail("BadLocation! " + ble.getMessage());
        }
    }
}

