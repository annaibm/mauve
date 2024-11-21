/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.DecimalFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.AttributedCharacterIterator;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Set;

public class formatToCharacterIterator
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DecimalFormat f1 = new DecimalFormat();
        boolean pass = false;
        try {
            f1.formatToCharacterIterator(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            f1.formatToCharacterIterator("Not a number");
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        harness.checkPoint("Check for attributes after a valid parse");
        DecimalFormat f2 = new DecimalFormat("0.##;-0.##");
        AttributedCharacterIterator chIter = f2.formatToCharacterIterator(-1234.56);
        Set<AttributedCharacterIterator.Attribute> _keys = chIter.getAllAttributeKeys();
        boolean pass1 = false;
        boolean pass2 = false;
        boolean pass3 = false;
        boolean pass4 = false;
        for (NumberFormat.Field field : _keys) {
            if (field.equals(NumberFormat.Field.INTEGER)) {
                pass1 = true;
            }
            if (field.equals(NumberFormat.Field.FRACTION)) {
                pass2 = true;
            }
            if (field.equals(NumberFormat.Field.DECIMAL_SEPARATOR)) {
                pass3 = true;
            }
            if (!field.equals(NumberFormat.Field.SIGN)) continue;
            pass4 = true;
        }
        harness.check(pass1 && pass2 && pass3 && pass4);
    }
}

