/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Character;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getType12
implements Testlet {
    public static void p(TestHarness harness, char c, String expected) {
        String s;
        switch (Character.getType(c)) {
            case 12: {
                s = "space_separator";
                break;
            }
            case 13: {
                s = "line_separator";
                break;
            }
            case 14: {
                s = "paragraph_separator";
                break;
            }
            case 1: {
                s = "uppercase_letter";
                break;
            }
            case 2: {
                s = "lowercase_letter";
                break;
            }
            case 3: {
                s = "titlecase_letter";
                break;
            }
            case 4: {
                s = "modifier_letter";
                break;
            }
            case 5: {
                s = "other_letter";
                break;
            }
            case 9: {
                s = "decimal_digit_number";
                break;
            }
            case 10: {
                s = "letter_number";
                break;
            }
            case 11: {
                s = "other_number";
                break;
            }
            case 6: {
                s = "non_spacing_mark";
                break;
            }
            case 7: {
                s = "enclosing_mark";
                break;
            }
            case 8: {
                s = "combining_spacing_mark";
                break;
            }
            case 20: {
                s = "dash_punctuation";
                break;
            }
            case 21: {
                s = "start_punctuation";
                break;
            }
            case 22: {
                s = "end_punctuation";
                break;
            }
            case 23: {
                s = "connector_punctuation";
                break;
            }
            case 24: {
                s = "other_punctuation";
                break;
            }
            case 25: {
                s = "math_symbol";
                break;
            }
            case 26: {
                s = "currency_symbol";
                break;
            }
            case 27: {
                s = "modifier_symbol";
                break;
            }
            case 28: {
                s = "other_symbol";
                break;
            }
            case 15: {
                s = "control";
                break;
            }
            case 16: {
                s = "format";
                break;
            }
            case 0: {
                s = "unassigned";
                break;
            }
            case 18: {
                s = "private_use";
                break;
            }
            case 19: {
                s = "surrogate";
                break;
            }
            default: {
                s = "???";
            }
        }
        harness.check(s, (Object)expected);
    }

    @Override
    public void test(TestHarness harness) {
        getType12.p(harness, '\u20ac', "currency_symbol");
    }
}

