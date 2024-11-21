/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.Utilities;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

public class getNextWord
implements Testlet {
    String text1 = "GNU Classpath, Essential Libraries for Java, is a GNU project to create free core class libraries for use with virtual machines and compilers for the java programming language.";
    JTextField tf = new JTextField(this.text1);
    int[] expected1 = new int[]{0, 4, 13, 15, 25, 35, 39, 43, 45, 48, 50, 54, 62, 65, 72, 77, 82, 88, 98, 102, 106, 111, 119, 128, 132, 142, 146, 150, 155, 167, 175};
    String text2 = "foo 333 . **777.1)/&";
    int[] expected2 = new int[]{0, 4, 8, 10, 11, 12, 17, 18, 19};

    @Override
    public void test(TestHarness harness) {
        boolean pos = false;
        harness.checkPoint("indices");
        try {
            for (int i = 0; i < this.expected1.length - 1; ++i) {
                harness.check(Utilities.getNextWord(this.tf, this.expected1[i]), this.expected1[i + 1]);
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
            Utilities.getNextWord(this.tf, 175);
        }
        catch (Exception e) {
            correctException = e instanceof BadLocationException;
        }
        harness.check(correctException);
        correctException = false;
        try {
            Utilities.getNextWord(this.tf, 176);
        }
        catch (Exception e) {
            correctException = e instanceof BadLocationException;
        }
        harness.check(correctException);
        correctException = false;
        try {
            Utilities.getNextWord(this.tf, 177);
        }
        catch (Exception e) {
            correctException = e instanceof BadLocationException;
        }
        harness.check(correctException);
        this.tf.setText(this.text2);
        harness.checkPoint("indices-tricky");
        try {
            for (int i = 0; i < this.expected2.length - 1; ++i) {
                harness.check(Utilities.getNextWord(this.tf, this.expected2[i]), this.expected2[i + 1]);
            }
        }
        catch (BadLocationException ble) {
            ble.printStackTrace();
            harness.verbose("index: " + ble.offsetRequested());
            harness.fail("BadLocationException occurred!");
        }
    }
}

