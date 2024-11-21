/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTextArea;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

public class gettingText
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String content = "abcdefghijklmnopqrstuvwxyz";
        JTextArea area = new JTextArea(content);
        int l = content.length();
        block2: for (int a = 0; a < l; ++a) {
            for (int b = 0; b < l; ++b) {
                area.setSelectionStart(a);
                area.setSelectionEnd(b);
                int mark2 = area.getCaret().getMark();
                int dot = area.getCaret().getDot();
                if (mark2 <= dot) continue;
                harness.fail("mark, " + mark2 + " > dot, " + dot + " when setting [" + a + ".." + b + "]");
                break block2;
            }
        }
        block4: for (int a = 0; a < l; ++a) {
            for (int b = a + 1; b < l; ++b) {
                String s = content.substring(a, b);
                try {
                    area.setSelectionStart(a);
                    area.setSelectionEnd(b);
                    if (!area.getSelectedText().equals(s)) {
                        harness.check(area.getText(a, b), s, "getSelectedText [" + a + "," + b + "]");
                        break block4;
                    }
                    area.select(1, 2);
                    area.select(a, b);
                    if (!area.getSelectedText().equals(s)) {
                        harness.check(area.getSelectedText(), s, "getSelectedText select[" + a + "," + b + "]");
                        break block4;
                    }
                    if (area.getText(a, b - a).equals(s)) continue;
                    harness.check(area.getText(a, b - a), s, "getText [" + a + "," + (b - a) + "]");
                    continue;
                }
                catch (BadLocationException ex) {
                    harness.fail("BadLocationException in getSelectedText [" + a + "," + b + "]");
                }
            }
        }
        area.setSelectionStart(5);
        area.moveCaretPosition(0);
        harness.check(area.getSelectedText(), "abcde", "moveCaretPositio()");
    }
}

