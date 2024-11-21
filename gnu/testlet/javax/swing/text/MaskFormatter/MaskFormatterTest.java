/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.MaskFormatter;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;

public class MaskFormatterTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter("RE'*B**KS");
            harness.checkPoint("defaults");
            harness.check(formatter.getValueContainsLiteralCharacters());
            harness.check(!formatter.getAllowsInvalid());
            harness.check(formatter.getPlaceholder() == null);
            harness.check(formatter.getPlaceholderCharacter() == ' ');
            harness.check(formatter.getValidCharacters() == null);
            harness.check(formatter.getInvalidCharacters() == null);
            harness.checkPoint("padding");
            formatter.setPlaceholder("MMMMMMMMM");
            formatter.setPlaceholderCharacter('$');
            harness.check(formatter.valueToString("RE"), (Object)"RE*BMMKS");
            formatter.setPlaceholder("8");
            harness.check(formatter.valueToString("RE"), (Object)"RE*B$$KS");
            formatter.setPlaceholder("12345");
            harness.check(formatter.valueToString("RE"), (Object)"RE*B5$KS");
            harness.checkPoint("valid output");
            formatter.setMask("(###) ###-####");
            harness.check(formatter.valueToString("(555) 807-9090"), (Object)"(555) 807-9090");
            harness.check(formatter.stringToValue("(555) 807-9090"), (Object)"(555) 807-9090");
            formatter.setValueContainsLiteralCharacters(false);
            harness.check(formatter.stringToValue("(555) 807-9090"), (Object)"5558079090");
            boolean exception = false;
            try {
                harness.check(formatter.valueToString("(555) 807-9090"), (Object)"(555) 807-9090");
            }
            catch (ParseException pe) {
                exception = true;
            }
            harness.check(exception);
            formatter = new MaskFormatter("T##'FA");
            formatter.setInvalidCharacters("T");
            formatter.setValidCharacters("4");
            harness.check(formatter.valueToString("T44F4"), (Object)"T44F4");
            harness.check(formatter.stringToValue("T44F4"), (Object)"T44F4");
            exception = false;
            try {
                formatter.valueToString("T33F3");
            }
            catch (ParseException pe2) {
                exception = true;
            }
            harness.check(exception);
        }
        catch (ParseException ex) {
            harness.fail("an exception was thrown that shouldn't have been");
        }
    }
}

