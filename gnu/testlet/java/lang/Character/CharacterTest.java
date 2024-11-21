/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Character;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class CharacterTest
implements Testlet {
    protected static TestHarness harness;

    public void test_Basics() {
        harness.check(Character.forDigit(8, 2) == '\u0000', "test_forDigit - 50");
        harness.check(Character.forDigit(-3, 2) == '\u0000', "test_forDigit - 51");
        harness.check(Character.forDigit(2, 8) == '2', "test_forDigit - 52");
        harness.check(Character.forDigit(12, 16) == 'c', "test_forDigit - 53");
        harness.check(!Character.isJavaLetter('\uffff'), "test_forDigit - 54");
        harness.check(Character.isJavaLetter('a'), "test_forDigit - 55");
        harness.check(true, "test_Basics - 1");
        harness.check(true, "test_Basics - 2");
        harness.check(true, "test_Basics - 3");
        harness.check(true, "test_Basics - 4");
        Character ch = new Character('b');
        harness.check(ch.charValue() == 'b', "test_Basics - 5");
    }

    public void test_toString() {
        Character ch = new Character('a');
        String str = ch.toString();
        harness.check(str.length() == 1 && str.equals("a"), "test_toString ");
    }

    public void test_equals() {
        Character ch1 = new Character('+');
        Character ch2 = new Character('+');
        Character ch3 = new Character('-');
        harness.check(ch1.equals(ch2) && !ch1.equals(ch3) && !ch1.equals(null), "test_equals - 1");
    }

    public void test_hashCode() {
        Character ch1 = new Character('a');
        harness.check(ch1.hashCode() == 97, "test_hashCode");
    }

    public void test_isSpace() {
        harness.check(Character.isSpace('\t') && Character.isSpace('\f') && Character.isSpace('\r') && Character.isSpace('\n') && Character.isSpace(' ') && !Character.isSpace('+'), "test_isSpace");
    }

    public void test_digit() {
        harness.check(Character.digit('a', 1) == -1, "test_digit - 1");
        harness.check(Character.digit('a', 37) == -1, "test_digit - 2");
    }

    public void test_others() {
        Character.isDefined('a');
        Character.isDefined('\uffff');
        Character.digit('\u0665', 10);
        Character.digit('\u06f5', 10);
        Character.digit('\u0968', 10);
        Character.digit('\u06e8', 10);
        Character.digit('\u0a68', 10);
        Character.digit('\u0ae8', 10);
        Character.digit('\u0b68', 10);
        Character.digit('\u0be8', 10);
        Character.digit('\u0c68', 10);
        Character.digit('\u0ce8', 10);
        Character.digit('\u0d68', 10);
        Character.digit('\u0e52', 10);
        Character.digit('\u0ed2', 10);
        Character.digit('\uff12', 10);
        Character.digit('\uffff', 10);
        Character.isJavaLetterOrDigit('a');
        harness.check(!Character.isJavaLetterOrDigit('\uffff'), "isJavaLetterOrDigit - 60");
        harness.check(!Character.isLetterOrDigit('\uffff'), "isLetterOrDigit - 61");
        Character.isLetterOrDigit('a');
        Character.isLowerCase('A');
        Character.isLowerCase('a');
        Character.isSpace('a');
        Character.isUpperCase('a');
        Character.isUpperCase('A');
    }

    public void testall() {
        this.test_Basics();
        this.test_toString();
        this.test_equals();
        this.test_hashCode();
        this.test_isSpace();
        this.test_digit();
        this.test_others();
    }

    @Override
    public void test(TestHarness the_harness) {
        harness = the_harness;
        this.testall();
    }
}

