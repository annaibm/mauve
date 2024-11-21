/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.Utilities;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

public class getPreviousWord
implements Testlet {
    String text1 = "GNU Classpath, Essential Libraries for Java, is a GNU project to create free core class libraries for use with virtual machines and compilers for the java programming language.";
    JTextField tf = new JTextField(this.text1);
    int[] expected1 = new int[]{176, 175, 167, 155, 150, 146, 142, 132, 128, 119, 111, 106, 102, 98, 88, 82, 77, 72, 65, 62, 54, 50, 48, 45, 43, 39, 35, 25, 15, 13, 4, 0};
    String text2 = "foo 333 . **777.1)/&";
    int[] expected2 = new int[]{19, 18, 17, 12, 11, 10, 8, 4, 0};

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("indices-normal");
        try {
            for (int i = 0; i < this.expected1.length - 1; ++i) {
                harness.check(Utilities.getPreviousWord(this.tf, this.expected1[i]), this.expected1[i + 1]);
            }
        }
        catch (BadLocationException ble) {
            ble.printStackTrace();
            harness.verbose("index: " + ble.offsetRequested());
            harness.fail("BadLocationException occurred!");
        }
        harness.checkPoint("exception");
        boolean correctException = false;
        try {
            Utilities.getPreviousWord(this.tf, 180);
        }
        catch (Exception e) {
            correctException = e instanceof BadLocationException;
        }
        harness.check(correctException);
        correctException = false;
        try {
            Utilities.getPreviousWord(this.tf, 0);
        }
        catch (Exception e) {
            correctException = e instanceof BadLocationException;
        }
        harness.check(correctException);
        correctException = false;
        try {
            Utilities.getPreviousWord(this.tf, -1);
        }
        catch (Exception e) {
            correctException = e instanceof BadLocationException;
        }
        harness.check(correctException);
        this.tf.setText(this.text2);
        harness.checkPoint("indices-tricky");
        try {
            for (int i = 0; i < this.expected2.length - 1; ++i) {
                harness.check(Utilities.getPreviousWord(this.tf, this.expected2[i]), this.expected2[i + 1]);
            }
        }
        catch (BadLocationException ble) {
            ble.printStackTrace();
            harness.verbose("index: " + ble.offsetRequested());
            harness.fail("BadLocationException occurred!");
        }
    }
}

