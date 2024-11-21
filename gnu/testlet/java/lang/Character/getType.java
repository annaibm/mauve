/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Character;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getType
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
        getType.p(harness, ' ', "space_separator");
        getType.p(harness, '\u2028', "line_separator");
        getType.p(harness, '\u2029', "paragraph_separator");
        getType.p(harness, '\u2110', "uppercase_letter");
        getType.p(harness, 'Z', "uppercase_letter");
        getType.p(harness, '\uff44', "lowercase_letter");
        getType.p(harness, 'z', "lowercase_letter");
        getType.p(harness, '\u1fe4', "lowercase_letter");
        getType.p(harness, '\u01c5', "titlecase_letter");
        getType.p(harness, '\u3005', "modifier_letter");
        getType.p(harness, '\u01bf', "lowercase_letter");
        getType.p(harness, '\u0666', "decimal_digit_number");
        getType.p(harness, '\u216f', "letter_number");
        getType.p(harness, '\u0f32', "other_number");
        getType.p(harness, '\u0f35', "non_spacing_mark");
        getType.p(harness, '\u0488', "enclosing_mark");
        getType.p(harness, '\u0488', "enclosing_mark");
        getType.p(harness, '\u0489', "enclosing_mark");
        getType.p(harness, '\u06de', getType.conformToJDK17() ? "other_symbol" : "enclosing_mark");
        getType.p(harness, '\u20dd', "enclosing_mark");
        getType.p(harness, '\u20de', "enclosing_mark");
        getType.p(harness, '\u20df', "enclosing_mark");
        getType.p(harness, '\u20e0', "enclosing_mark");
        getType.p(harness, '\u20e2', "enclosing_mark");
        getType.p(harness, '\u20e3', "enclosing_mark");
        getType.p(harness, '\u20e4', "enclosing_mark");
        getType.p(harness, '\u0903', "combining_spacing_mark");
        getType.p(harness, '-', "dash_punctuation");
        getType.p(harness, '\ufe59', "start_punctuation");
        getType.p(harness, '\u0f3b', "end_punctuation");
        getType.p(harness, '\uff3f', "connector_punctuation");
        getType.p(harness, '\u2202', "math_symbol");
        getType.p(harness, '\u20ab', "currency_symbol");
        getType.p(harness, '\u02c2', "modifier_symbol");
        getType.p(harness, '\u0ad0', "other_letter");
        getType.p(harness, '\u0b70', "other_symbol");
        getType.p(harness, '\u009f', "control");
        getType.p(harness, '\ufeff', "format");
        getType.p(harness, '\uffff', "unassigned");
        getType.p(harness, '\uffef', "unassigned");
        getType.p(harness, '\uebeb', "private_use");
        getType.p(harness, '\udb9c', "surrogate");
        getType.p(harness, '\u249f', "other_symbol");
        getType.p(harness, '\u2102', "uppercase_letter");
    }

    private static boolean conformToJDK17() {
        String[] javaVersion = System.getProperty("java.version").split("\\.");
        String vendorID = System.getProperty("java.vendor");
        if ("Sun Microsystems Inc.".equals(vendorID)) {
            return Long.parseLong(javaVersion[1]) >= 7L;
        }
        return true;
    }
}

