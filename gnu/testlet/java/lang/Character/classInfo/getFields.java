/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Character.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Field;
import java.util.HashMap;

public class getFields
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, String> testedFields = null;
        HashMap<String, String> testedFields_jdk6 = new HashMap<String, String>();
        HashMap<String, String> testedFields_jdk7 = new HashMap<String, String>();
        testedFields_jdk6.put("public static final int java.lang.Character.MIN_RADIX", "MIN_RADIX");
        testedFields_jdk6.put("public static final int java.lang.Character.MAX_RADIX", "MAX_RADIX");
        testedFields_jdk6.put("public static final char java.lang.Character.MIN_VALUE", "MIN_VALUE");
        testedFields_jdk6.put("public static final char java.lang.Character.MAX_VALUE", "MAX_VALUE");
        testedFields_jdk6.put("public static final java.lang.Class java.lang.Character.TYPE", "TYPE");
        testedFields_jdk6.put("public static final byte java.lang.Character.UNASSIGNED", "UNASSIGNED");
        testedFields_jdk6.put("public static final byte java.lang.Character.UPPERCASE_LETTER", "UPPERCASE_LETTER");
        testedFields_jdk6.put("public static final byte java.lang.Character.LOWERCASE_LETTER", "LOWERCASE_LETTER");
        testedFields_jdk6.put("public static final byte java.lang.Character.TITLECASE_LETTER", "TITLECASE_LETTER");
        testedFields_jdk6.put("public static final byte java.lang.Character.MODIFIER_LETTER", "MODIFIER_LETTER");
        testedFields_jdk6.put("public static final byte java.lang.Character.OTHER_LETTER", "OTHER_LETTER");
        testedFields_jdk6.put("public static final byte java.lang.Character.NON_SPACING_MARK", "NON_SPACING_MARK");
        testedFields_jdk6.put("public static final byte java.lang.Character.ENCLOSING_MARK", "ENCLOSING_MARK");
        testedFields_jdk6.put("public static final byte java.lang.Character.COMBINING_SPACING_MARK", "COMBINING_SPACING_MARK");
        testedFields_jdk6.put("public static final byte java.lang.Character.DECIMAL_DIGIT_NUMBER", "DECIMAL_DIGIT_NUMBER");
        testedFields_jdk6.put("public static final byte java.lang.Character.LETTER_NUMBER", "LETTER_NUMBER");
        testedFields_jdk6.put("public static final byte java.lang.Character.OTHER_NUMBER", "OTHER_NUMBER");
        testedFields_jdk6.put("public static final byte java.lang.Character.SPACE_SEPARATOR", "SPACE_SEPARATOR");
        testedFields_jdk6.put("public static final byte java.lang.Character.LINE_SEPARATOR", "LINE_SEPARATOR");
        testedFields_jdk6.put("public static final byte java.lang.Character.PARAGRAPH_SEPARATOR", "PARAGRAPH_SEPARATOR");
        testedFields_jdk6.put("public static final byte java.lang.Character.CONTROL", "CONTROL");
        testedFields_jdk6.put("public static final byte java.lang.Character.FORMAT", "FORMAT");
        testedFields_jdk6.put("public static final byte java.lang.Character.PRIVATE_USE", "PRIVATE_USE");
        testedFields_jdk6.put("public static final byte java.lang.Character.SURROGATE", "SURROGATE");
        testedFields_jdk6.put("public static final byte java.lang.Character.DASH_PUNCTUATION", "DASH_PUNCTUATION");
        testedFields_jdk6.put("public static final byte java.lang.Character.START_PUNCTUATION", "START_PUNCTUATION");
        testedFields_jdk6.put("public static final byte java.lang.Character.END_PUNCTUATION", "END_PUNCTUATION");
        testedFields_jdk6.put("public static final byte java.lang.Character.CONNECTOR_PUNCTUATION", "CONNECTOR_PUNCTUATION");
        testedFields_jdk6.put("public static final byte java.lang.Character.OTHER_PUNCTUATION", "OTHER_PUNCTUATION");
        testedFields_jdk6.put("public static final byte java.lang.Character.MATH_SYMBOL", "MATH_SYMBOL");
        testedFields_jdk6.put("public static final byte java.lang.Character.CURRENCY_SYMBOL", "CURRENCY_SYMBOL");
        testedFields_jdk6.put("public static final byte java.lang.Character.MODIFIER_SYMBOL", "MODIFIER_SYMBOL");
        testedFields_jdk6.put("public static final byte java.lang.Character.OTHER_SYMBOL", "OTHER_SYMBOL");
        testedFields_jdk6.put("public static final byte java.lang.Character.INITIAL_QUOTE_PUNCTUATION", "INITIAL_QUOTE_PUNCTUATION");
        testedFields_jdk6.put("public static final byte java.lang.Character.FINAL_QUOTE_PUNCTUATION", "FINAL_QUOTE_PUNCTUATION");
        testedFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_UNDEFINED", "DIRECTIONALITY_UNDEFINED");
        testedFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_LEFT_TO_RIGHT", "DIRECTIONALITY_LEFT_TO_RIGHT");
        testedFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_RIGHT_TO_LEFT", "DIRECTIONALITY_RIGHT_TO_LEFT");
        testedFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC", "DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC");
        testedFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_EUROPEAN_NUMBER", "DIRECTIONALITY_EUROPEAN_NUMBER");
        testedFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR", "DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR");
        testedFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR", "DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR");
        testedFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_ARABIC_NUMBER", "DIRECTIONALITY_ARABIC_NUMBER");
        testedFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_COMMON_NUMBER_SEPARATOR", "DIRECTIONALITY_COMMON_NUMBER_SEPARATOR");
        testedFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_NONSPACING_MARK", "DIRECTIONALITY_NONSPACING_MARK");
        testedFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_BOUNDARY_NEUTRAL", "DIRECTIONALITY_BOUNDARY_NEUTRAL");
        testedFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_PARAGRAPH_SEPARATOR", "DIRECTIONALITY_PARAGRAPH_SEPARATOR");
        testedFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_SEGMENT_SEPARATOR", "DIRECTIONALITY_SEGMENT_SEPARATOR");
        testedFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_WHITESPACE", "DIRECTIONALITY_WHITESPACE");
        testedFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_OTHER_NEUTRALS", "DIRECTIONALITY_OTHER_NEUTRALS");
        testedFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING", "DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING");
        testedFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE", "DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE");
        testedFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING", "DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING");
        testedFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE", "DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE");
        testedFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_POP_DIRECTIONAL_FORMAT", "DIRECTIONALITY_POP_DIRECTIONAL_FORMAT");
        testedFields_jdk6.put("public static final char java.lang.Character.MIN_HIGH_SURROGATE", "MIN_HIGH_SURROGATE");
        testedFields_jdk6.put("public static final char java.lang.Character.MAX_HIGH_SURROGATE", "MAX_HIGH_SURROGATE");
        testedFields_jdk6.put("public static final char java.lang.Character.MIN_LOW_SURROGATE", "MIN_LOW_SURROGATE");
        testedFields_jdk6.put("public static final char java.lang.Character.MAX_LOW_SURROGATE", "MAX_LOW_SURROGATE");
        testedFields_jdk6.put("public static final char java.lang.Character.MIN_SURROGATE", "MIN_SURROGATE");
        testedFields_jdk6.put("public static final char java.lang.Character.MAX_SURROGATE", "MAX_SURROGATE");
        testedFields_jdk6.put("public static final int java.lang.Character.MIN_SUPPLEMENTARY_CODE_POINT", "MIN_SUPPLEMENTARY_CODE_POINT");
        testedFields_jdk6.put("public static final int java.lang.Character.MIN_CODE_POINT", "MIN_CODE_POINT");
        testedFields_jdk6.put("public static final int java.lang.Character.MAX_CODE_POINT", "MAX_CODE_POINT");
        testedFields_jdk6.put("public static final int java.lang.Character.SIZE", "SIZE");
        testedFields_jdk7.put("public static final int java.lang.Character.MIN_RADIX", "MIN_RADIX");
        testedFields_jdk7.put("public static final int java.lang.Character.MAX_RADIX", "MAX_RADIX");
        testedFields_jdk7.put("public static final char java.lang.Character.MIN_VALUE", "MIN_VALUE");
        testedFields_jdk7.put("public static final char java.lang.Character.MAX_VALUE", "MAX_VALUE");
        testedFields_jdk7.put("public static final java.lang.Class java.lang.Character.TYPE", "TYPE");
        testedFields_jdk7.put("public static final byte java.lang.Character.UNASSIGNED", "UNASSIGNED");
        testedFields_jdk7.put("public static final byte java.lang.Character.UPPERCASE_LETTER", "UPPERCASE_LETTER");
        testedFields_jdk7.put("public static final byte java.lang.Character.LOWERCASE_LETTER", "LOWERCASE_LETTER");
        testedFields_jdk7.put("public static final byte java.lang.Character.TITLECASE_LETTER", "TITLECASE_LETTER");
        testedFields_jdk7.put("public static final byte java.lang.Character.MODIFIER_LETTER", "MODIFIER_LETTER");
        testedFields_jdk7.put("public static final byte java.lang.Character.OTHER_LETTER", "OTHER_LETTER");
        testedFields_jdk7.put("public static final byte java.lang.Character.NON_SPACING_MARK", "NON_SPACING_MARK");
        testedFields_jdk7.put("public static final byte java.lang.Character.ENCLOSING_MARK", "ENCLOSING_MARK");
        testedFields_jdk7.put("public static final byte java.lang.Character.COMBINING_SPACING_MARK", "COMBINING_SPACING_MARK");
        testedFields_jdk7.put("public static final byte java.lang.Character.DECIMAL_DIGIT_NUMBER", "DECIMAL_DIGIT_NUMBER");
        testedFields_jdk7.put("public static final byte java.lang.Character.LETTER_NUMBER", "LETTER_NUMBER");
        testedFields_jdk7.put("public static final byte java.lang.Character.OTHER_NUMBER", "OTHER_NUMBER");
        testedFields_jdk7.put("public static final byte java.lang.Character.SPACE_SEPARATOR", "SPACE_SEPARATOR");
        testedFields_jdk7.put("public static final byte java.lang.Character.LINE_SEPARATOR", "LINE_SEPARATOR");
        testedFields_jdk7.put("public static final byte java.lang.Character.PARAGRAPH_SEPARATOR", "PARAGRAPH_SEPARATOR");
        testedFields_jdk7.put("public static final byte java.lang.Character.CONTROL", "CONTROL");
        testedFields_jdk7.put("public static final byte java.lang.Character.FORMAT", "FORMAT");
        testedFields_jdk7.put("public static final byte java.lang.Character.PRIVATE_USE", "PRIVATE_USE");
        testedFields_jdk7.put("public static final byte java.lang.Character.SURROGATE", "SURROGATE");
        testedFields_jdk7.put("public static final byte java.lang.Character.DASH_PUNCTUATION", "DASH_PUNCTUATION");
        testedFields_jdk7.put("public static final byte java.lang.Character.START_PUNCTUATION", "START_PUNCTUATION");
        testedFields_jdk7.put("public static final byte java.lang.Character.END_PUNCTUATION", "END_PUNCTUATION");
        testedFields_jdk7.put("public static final byte java.lang.Character.CONNECTOR_PUNCTUATION", "CONNECTOR_PUNCTUATION");
        testedFields_jdk7.put("public static final byte java.lang.Character.OTHER_PUNCTUATION", "OTHER_PUNCTUATION");
        testedFields_jdk7.put("public static final byte java.lang.Character.MATH_SYMBOL", "MATH_SYMBOL");
        testedFields_jdk7.put("public static final byte java.lang.Character.CURRENCY_SYMBOL", "CURRENCY_SYMBOL");
        testedFields_jdk7.put("public static final byte java.lang.Character.MODIFIER_SYMBOL", "MODIFIER_SYMBOL");
        testedFields_jdk7.put("public static final byte java.lang.Character.OTHER_SYMBOL", "OTHER_SYMBOL");
        testedFields_jdk7.put("public static final byte java.lang.Character.INITIAL_QUOTE_PUNCTUATION", "INITIAL_QUOTE_PUNCTUATION");
        testedFields_jdk7.put("public static final byte java.lang.Character.FINAL_QUOTE_PUNCTUATION", "FINAL_QUOTE_PUNCTUATION");
        testedFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_UNDEFINED", "DIRECTIONALITY_UNDEFINED");
        testedFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_LEFT_TO_RIGHT", "DIRECTIONALITY_LEFT_TO_RIGHT");
        testedFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_RIGHT_TO_LEFT", "DIRECTIONALITY_RIGHT_TO_LEFT");
        testedFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC", "DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC");
        testedFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_EUROPEAN_NUMBER", "DIRECTIONALITY_EUROPEAN_NUMBER");
        testedFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR", "DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR");
        testedFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR", "DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR");
        testedFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_ARABIC_NUMBER", "DIRECTIONALITY_ARABIC_NUMBER");
        testedFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_COMMON_NUMBER_SEPARATOR", "DIRECTIONALITY_COMMON_NUMBER_SEPARATOR");
        testedFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_NONSPACING_MARK", "DIRECTIONALITY_NONSPACING_MARK");
        testedFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_BOUNDARY_NEUTRAL", "DIRECTIONALITY_BOUNDARY_NEUTRAL");
        testedFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_PARAGRAPH_SEPARATOR", "DIRECTIONALITY_PARAGRAPH_SEPARATOR");
        testedFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_SEGMENT_SEPARATOR", "DIRECTIONALITY_SEGMENT_SEPARATOR");
        testedFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_WHITESPACE", "DIRECTIONALITY_WHITESPACE");
        testedFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_OTHER_NEUTRALS", "DIRECTIONALITY_OTHER_NEUTRALS");
        testedFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING", "DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING");
        testedFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE", "DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE");
        testedFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING", "DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING");
        testedFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE", "DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE");
        testedFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_POP_DIRECTIONAL_FORMAT", "DIRECTIONALITY_POP_DIRECTIONAL_FORMAT");
        testedFields_jdk7.put("public static final char java.lang.Character.MIN_HIGH_SURROGATE", "MIN_HIGH_SURROGATE");
        testedFields_jdk7.put("public static final char java.lang.Character.MAX_HIGH_SURROGATE", "MAX_HIGH_SURROGATE");
        testedFields_jdk7.put("public static final char java.lang.Character.MIN_LOW_SURROGATE", "MIN_LOW_SURROGATE");
        testedFields_jdk7.put("public static final char java.lang.Character.MAX_LOW_SURROGATE", "MAX_LOW_SURROGATE");
        testedFields_jdk7.put("public static final char java.lang.Character.MIN_SURROGATE", "MIN_SURROGATE");
        testedFields_jdk7.put("public static final char java.lang.Character.MAX_SURROGATE", "MAX_SURROGATE");
        testedFields_jdk7.put("public static final int java.lang.Character.MIN_SUPPLEMENTARY_CODE_POINT", "MIN_SUPPLEMENTARY_CODE_POINT");
        testedFields_jdk7.put("public static final int java.lang.Character.MIN_CODE_POINT", "MIN_CODE_POINT");
        testedFields_jdk7.put("public static final int java.lang.Character.MAX_CODE_POINT", "MAX_CODE_POINT");
        testedFields_jdk7.put("public static final int java.lang.Character.SIZE", "SIZE");
        Character o = new Character('!');
        Class<?> c = o.getClass();
        testedFields = this.getJavaVersion() < 7 ? testedFields_jdk6 : testedFields_jdk7;
        Field[] fields = c.getFields();
        int expectedNumberOfFields = testedFields.size();
        harness.check(fields.length, expectedNumberOfFields);
        for (Field field : fields) {
            String fieldName = field.getName();
            String fieldString = field.toString();
            harness.check(testedFields.containsKey(fieldString));
            harness.check(testedFields.get(fieldString), (Object)fieldName);
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

