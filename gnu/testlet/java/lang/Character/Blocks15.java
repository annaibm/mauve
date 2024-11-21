/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Character;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class Blocks15
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Character.UnicodeBlock.forName("Greek"), Character.UnicodeBlock.GREEK);
        harness.check(Character.UnicodeBlock.forName("Combining Marks for Symbols"), Character.UnicodeBlock.COMBINING_MARKS_FOR_SYMBOLS);
        harness.check(Character.UnicodeBlock.forName("CombiningMarksforSymbols"), Character.UnicodeBlock.COMBINING_MARKS_FOR_SYMBOLS);
        harness.check(Character.UnicodeBlock.forName("Miscellaneous Mathematical Symbols-B"), Character.UnicodeBlock.MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B);
        harness.check(Character.UnicodeBlock.forName("MiscellaneousMathematicalSymbols-B"), Character.UnicodeBlock.MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B);
        harness.check(Character.UnicodeBlock.forName("Miscellaneous_Mathematical_Symbols_B"), Character.UnicodeBlock.MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B);
        try {
            Character.UnicodeBlock.forName(null);
            harness.fail("null allowed to forName()");
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        try {
            Character.UnicodeBlock.forName("GNU Classpath Characters");
            harness.fail("Allowed request for invalid character set to forName()");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        harness.check(Character.UnicodeBlock.of(8593), Character.UnicodeBlock.ARROWS);
        harness.check(Character.UnicodeBlock.of(0x100000), Character.UnicodeBlock.SUPPLEMENTARY_PRIVATE_USE_AREA_B);
        try {
            Character.UnicodeBlock.of(0x200000);
            harness.fail("Allowed invalid codepoint to of(int)");
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }
}

