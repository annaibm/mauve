/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StringContent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Locale;
import javax.swing.text.BadLocationException;
import javax.swing.text.StringContent;

public class BadLocationExceptionTest
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.checkPoint("BadLocationTest");
        Locale.setDefault(Locale.US);
        StringContent sc = new StringContent();
        try {
            sc.insertString(-1, "path");
            h.fail("badlocation");
        }
        catch (BadLocationException ble) {
            h.check("Invalid location", ble.getMessage(), "BadLocation message should be 'Invalid location' and is: " + ble.getMessage());
            h.check(1, ble.offsetRequested(), "OffsetRequested() should be 1 and is: " + ble.offsetRequested());
        }
        try {
            sc.insertString(1, "path");
            h.fail("badlocation");
        }
        catch (BadLocationException ble) {
            h.check("Invalid location", ble.getMessage(), "BadLocation message should be 'Invalid location' and is: " + ble.getMessage());
            h.check(1, ble.offsetRequested(), "OffsetRequested() should be 1 and is: " + ble.offsetRequested());
        }
        try {
            sc.insertString(4, "path");
            h.fail("badlocation");
        }
        catch (BadLocationException ble) {
            h.check("Invalid location", ble.getMessage(), "BadLocation message should be 'Invalid location' and is: " + ble.getMessage());
            h.check(1, ble.offsetRequested(), "OffsetRequested() should be 1 and is: " + ble.offsetRequested());
        }
        try {
            sc.insertString(0, "path");
            sc.getString(1, sc.length());
            h.fail("badlocation");
        }
        catch (BadLocationException ble) {
            h.check("Invalid range", ble.getMessage(), "BadLocation message should be 'Invalid range' and is: " + ble.getMessage());
            h.check(5, ble.offsetRequested(), "OffsetRequested() should be 5 and is: " + ble.offsetRequested());
        }
        try {
            sc.insertString(0, "path");
            sc.getString(0, sc.length() + 1);
            h.fail("badlocation");
        }
        catch (BadLocationException ble) {
            h.check("Invalid range", ble.getMessage(), "BadLocation message should be 'Invalid range' and is: " + ble.getMessage());
            h.check(9, ble.offsetRequested(), "OffsetRequested() should be 9 and is: " + ble.offsetRequested());
        }
    }
}

