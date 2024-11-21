/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.GapContent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.GapContent;

public class GapContentTest
implements Testlet {
    private void testContent(TestHarness harness, GapContent content) {
        harness.check(content.length(), 1, "content length");
        boolean ok = false;
        try {
            String text2 = content.getString(0, 1);
            if (text2.equals("\n")) {
                ok = true;
            }
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
        harness.check(ok, "default content");
        ok = false;
        try {
            content.insertString(0, "This is a testcase");
            ok = true;
        }
        catch (Exception exception) {
            // empty catch block
        }
        harness.check(ok, "insertString");
        harness.check(content.length(), 19, "content length");
        ok = false;
        try {
            content.insertString(10, "little ");
            ok = true;
        }
        catch (Exception exception) {
            // empty catch block
        }
        harness.check(ok, "insertString");
        harness.check(content.length(), 26, "content length");
    }

    @Override
    public void test(TestHarness harness) {
        this.testContent(harness, new GapContent());
        this.testContent(harness, new GapContent(100));
    }
}

