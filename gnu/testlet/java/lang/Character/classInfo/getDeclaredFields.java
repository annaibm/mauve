/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Character.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Field;
import java.util.HashMap;

public class getDeclaredFields
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, String> testedDeclaredFields = null;
        HashMap<String, String> testedDeclaredFields_jdk6 = new HashMap<String, String>();
        HashMap<String, String> testedDeclaredFields_jdk7 = new HashMap<String, String>();
        testedDeclaredFields_jdk6.put("public static final int java.lang.Character.MIN_RADIX", "MIN_RADIX");
        testedDeclaredFields_jdk6.put("public static final int java.lang.Character.MAX_RADIX", "MAX_RADIX");
        testedDeclaredFields_jdk6.put("public static final char java.lang.Character.MIN_VALUE", "MIN_VALUE");
        testedDeclaredFields_jdk6.put("public static final char java.lang.Character.MAX_VALUE", "MAX_VALUE");
        testedDeclaredFields_jdk6.put("public static final java.lang.Class java.lang.Character.TYPE", "TYPE");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.UNASSIGNED", "UNASSIGNED");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.UPPERCASE_LETTER", "UPPERCASE_LETTER");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.LOWERCASE_LETTER", "LOWERCASE_LETTER");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.TITLECASE_LETTER", "TITLECASE_LETTER");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.MODIFIER_LETTER", "MODIFIER_LETTER");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.OTHER_LETTER", "OTHER_LETTER");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.NON_SPACING_MARK", "NON_SPACING_MARK");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.ENCLOSING_MARK", "ENCLOSING_MARK");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.COMBINING_SPACING_MARK", "COMBINING_SPACING_MARK");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DECIMAL_DIGIT_NUMBER", "DECIMAL_DIGIT_NUMBER");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.LETTER_NUMBER", "LETTER_NUMBER");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.OTHER_NUMBER", "OTHER_NUMBER");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.SPACE_SEPARATOR", "SPACE_SEPARATOR");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.LINE_SEPARATOR", "LINE_SEPARATOR");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.PARAGRAPH_SEPARATOR", "PARAGRAPH_SEPARATOR");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.CONTROL", "CONTROL");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.FORMAT", "FORMAT");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.PRIVATE_USE", "PRIVATE_USE");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.SURROGATE", "SURROGATE");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DASH_PUNCTUATION", "DASH_PUNCTUATION");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.START_PUNCTUATION", "START_PUNCTUATION");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.END_PUNCTUATION", "END_PUNCTUATION");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.CONNECTOR_PUNCTUATION", "CONNECTOR_PUNCTUATION");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.OTHER_PUNCTUATION", "OTHER_PUNCTUATION");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.MATH_SYMBOL", "MATH_SYMBOL");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.CURRENCY_SYMBOL", "CURRENCY_SYMBOL");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.MODIFIER_SYMBOL", "MODIFIER_SYMBOL");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.OTHER_SYMBOL", "OTHER_SYMBOL");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.INITIAL_QUOTE_PUNCTUATION", "INITIAL_QUOTE_PUNCTUATION");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.FINAL_QUOTE_PUNCTUATION", "FINAL_QUOTE_PUNCTUATION");
        testedDeclaredFields_jdk6.put("static final int java.lang.Character.ERROR", "ERROR");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_UNDEFINED", "DIRECTIONALITY_UNDEFINED");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_LEFT_TO_RIGHT", "DIRECTIONALITY_LEFT_TO_RIGHT");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_RIGHT_TO_LEFT", "DIRECTIONALITY_RIGHT_TO_LEFT");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC", "DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_EUROPEAN_NUMBER", "DIRECTIONALITY_EUROPEAN_NUMBER");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR", "DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR", "DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_ARABIC_NUMBER", "DIRECTIONALITY_ARABIC_NUMBER");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_COMMON_NUMBER_SEPARATOR", "DIRECTIONALITY_COMMON_NUMBER_SEPARATOR");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_NONSPACING_MARK", "DIRECTIONALITY_NONSPACING_MARK");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_BOUNDARY_NEUTRAL", "DIRECTIONALITY_BOUNDARY_NEUTRAL");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_PARAGRAPH_SEPARATOR", "DIRECTIONALITY_PARAGRAPH_SEPARATOR");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_SEGMENT_SEPARATOR", "DIRECTIONALITY_SEGMENT_SEPARATOR");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_WHITESPACE", "DIRECTIONALITY_WHITESPACE");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_OTHER_NEUTRALS", "DIRECTIONALITY_OTHER_NEUTRALS");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING", "DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE", "DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING", "DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE", "DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE");
        testedDeclaredFields_jdk6.put("public static final byte java.lang.Character.DIRECTIONALITY_POP_DIRECTIONAL_FORMAT", "DIRECTIONALITY_POP_DIRECTIONAL_FORMAT");
        testedDeclaredFields_jdk6.put("public static final char java.lang.Character.MIN_HIGH_SURROGATE", "MIN_HIGH_SURROGATE");
        testedDeclaredFields_jdk6.put("public static final char java.lang.Character.MAX_HIGH_SURROGATE", "MAX_HIGH_SURROGATE");
        testedDeclaredFields_jdk6.put("public static final char java.lang.Character.MIN_LOW_SURROGATE", "MIN_LOW_SURROGATE");
        testedDeclaredFields_jdk6.put("public static final char java.lang.Character.MAX_LOW_SURROGATE", "MAX_LOW_SURROGATE");
        testedDeclaredFields_jdk6.put("public static final char java.lang.Character.MIN_SURROGATE", "MIN_SURROGATE");
        testedDeclaredFields_jdk6.put("public static final char java.lang.Character.MAX_SURROGATE", "MAX_SURROGATE");
        testedDeclaredFields_jdk6.put("public static final int java.lang.Character.MIN_SUPPLEMENTARY_CODE_POINT", "MIN_SUPPLEMENTARY_CODE_POINT");
        testedDeclaredFields_jdk6.put("public static final int java.lang.Character.MIN_CODE_POINT", "MIN_CODE_POINT");
        testedDeclaredFields_jdk6.put("public static final int java.lang.Character.MAX_CODE_POINT", "MAX_CODE_POINT");
        testedDeclaredFields_jdk6.put("private final char java.lang.Character.value", "value");
        testedDeclaredFields_jdk6.put("private static final long java.lang.Character.serialVersionUID", "serialVersionUID");
        testedDeclaredFields_jdk6.put("public static final int java.lang.Character.SIZE", "SIZE");
        testedDeclaredFields_jdk6.put("static final boolean java.lang.Character.$assertionsDisabled", "$assertionsDisabled");
        testedDeclaredFields_jdk7.put("public static final int java.lang.Character.MIN_RADIX", "MIN_RADIX");
        testedDeclaredFields_jdk7.put("public static final int java.lang.Character.MAX_RADIX", "MAX_RADIX");
        testedDeclaredFields_jdk7.put("public static final char java.lang.Character.MIN_VALUE", "MIN_VALUE");
        testedDeclaredFields_jdk7.put("public static final char java.lang.Character.MAX_VALUE", "MAX_VALUE");
        testedDeclaredFields_jdk7.put("public static final java.lang.Class java.lang.Character.TYPE", "TYPE");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.UNASSIGNED", "UNASSIGNED");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.UPPERCASE_LETTER", "UPPERCASE_LETTER");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.LOWERCASE_LETTER", "LOWERCASE_LETTER");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.TITLECASE_LETTER", "TITLECASE_LETTER");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.MODIFIER_LETTER", "MODIFIER_LETTER");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.OTHER_LETTER", "OTHER_LETTER");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.NON_SPACING_MARK", "NON_SPACING_MARK");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.ENCLOSING_MARK", "ENCLOSING_MARK");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.COMBINING_SPACING_MARK", "COMBINING_SPACING_MARK");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DECIMAL_DIGIT_NUMBER", "DECIMAL_DIGIT_NUMBER");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.LETTER_NUMBER", "LETTER_NUMBER");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.OTHER_NUMBER", "OTHER_NUMBER");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.SPACE_SEPARATOR", "SPACE_SEPARATOR");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.LINE_SEPARATOR", "LINE_SEPARATOR");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.PARAGRAPH_SEPARATOR", "PARAGRAPH_SEPARATOR");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.CONTROL", "CONTROL");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.FORMAT", "FORMAT");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.PRIVATE_USE", "PRIVATE_USE");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.SURROGATE", "SURROGATE");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DASH_PUNCTUATION", "DASH_PUNCTUATION");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.START_PUNCTUATION", "START_PUNCTUATION");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.END_PUNCTUATION", "END_PUNCTUATION");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.CONNECTOR_PUNCTUATION", "CONNECTOR_PUNCTUATION");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.OTHER_PUNCTUATION", "OTHER_PUNCTUATION");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.MATH_SYMBOL", "MATH_SYMBOL");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.CURRENCY_SYMBOL", "CURRENCY_SYMBOL");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.MODIFIER_SYMBOL", "MODIFIER_SYMBOL");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.OTHER_SYMBOL", "OTHER_SYMBOL");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.INITIAL_QUOTE_PUNCTUATION", "INITIAL_QUOTE_PUNCTUATION");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.FINAL_QUOTE_PUNCTUATION", "FINAL_QUOTE_PUNCTUATION");
        testedDeclaredFields_jdk7.put("static final int java.lang.Character.ERROR", "ERROR");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_UNDEFINED", "DIRECTIONALITY_UNDEFINED");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_LEFT_TO_RIGHT", "DIRECTIONALITY_LEFT_TO_RIGHT");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_RIGHT_TO_LEFT", "DIRECTIONALITY_RIGHT_TO_LEFT");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC", "DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_EUROPEAN_NUMBER", "DIRECTIONALITY_EUROPEAN_NUMBER");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR", "DIRECTIONALITY_EUROPEAN_NUMBER_SEPARATOR");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR", "DIRECTIONALITY_EUROPEAN_NUMBER_TERMINATOR");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_ARABIC_NUMBER", "DIRECTIONALITY_ARABIC_NUMBER");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_COMMON_NUMBER_SEPARATOR", "DIRECTIONALITY_COMMON_NUMBER_SEPARATOR");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_NONSPACING_MARK", "DIRECTIONALITY_NONSPACING_MARK");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_BOUNDARY_NEUTRAL", "DIRECTIONALITY_BOUNDARY_NEUTRAL");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_PARAGRAPH_SEPARATOR", "DIRECTIONALITY_PARAGRAPH_SEPARATOR");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_SEGMENT_SEPARATOR", "DIRECTIONALITY_SEGMENT_SEPARATOR");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_WHITESPACE", "DIRECTIONALITY_WHITESPACE");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_OTHER_NEUTRALS", "DIRECTIONALITY_OTHER_NEUTRALS");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING", "DIRECTIONALITY_LEFT_TO_RIGHT_EMBEDDING");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE", "DIRECTIONALITY_LEFT_TO_RIGHT_OVERRIDE");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING", "DIRECTIONALITY_RIGHT_TO_LEFT_EMBEDDING");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE", "DIRECTIONALITY_RIGHT_TO_LEFT_OVERRIDE");
        testedDeclaredFields_jdk7.put("public static final byte java.lang.Character.DIRECTIONALITY_POP_DIRECTIONAL_FORMAT", "DIRECTIONALITY_POP_DIRECTIONAL_FORMAT");
        testedDeclaredFields_jdk7.put("public static final char java.lang.Character.MIN_HIGH_SURROGATE", "MIN_HIGH_SURROGATE");
        testedDeclaredFields_jdk7.put("public static final char java.lang.Character.MAX_HIGH_SURROGATE", "MAX_HIGH_SURROGATE");
        testedDeclaredFields_jdk7.put("public static final char java.lang.Character.MIN_LOW_SURROGATE", "MIN_LOW_SURROGATE");
        testedDeclaredFields_jdk7.put("public static final char java.lang.Character.MAX_LOW_SURROGATE", "MAX_LOW_SURROGATE");
        testedDeclaredFields_jdk7.put("public static final char java.lang.Character.MIN_SURROGATE", "MIN_SURROGATE");
        testedDeclaredFields_jdk7.put("public static final char java.lang.Character.MAX_SURROGATE", "MAX_SURROGATE");
        testedDeclaredFields_jdk7.put("public static final int java.lang.Character.MIN_SUPPLEMENTARY_CODE_POINT", "MIN_SUPPLEMENTARY_CODE_POINT");
        testedDeclaredFields_jdk7.put("public static final int java.lang.Character.MIN_CODE_POINT", "MIN_CODE_POINT");
        testedDeclaredFields_jdk7.put("public static final int java.lang.Character.MAX_CODE_POINT", "MAX_CODE_POINT");
        testedDeclaredFields_jdk7.put("private final char java.lang.Character.value", "value");
        testedDeclaredFields_jdk7.put("private static final long java.lang.Character.serialVersionUID", "serialVersionUID");
        testedDeclaredFields_jdk7.put("public static final int java.lang.Character.SIZE", "SIZE");
        testedDeclaredFields_jdk7.put("static final boolean java.lang.Character.$assertionsDisabled", "$assertionsDisabled");
        Character o = new Character('!');
        Class<?> c = o.getClass();
        testedDeclaredFields = this.getJavaVersion() < 7 ? testedDeclaredFields_jdk6 : testedDeclaredFields_jdk7;
        Field[] declaredFields = c.getDeclaredFields();
        int expectedNumberOfDeclaredFields = testedDeclaredFields.size();
        harness.check(declaredFields.length, expectedNumberOfDeclaredFields);
        for (Field declaredField : declaredFields) {
            String fieldName = declaredField.getName();
            String fieldString = declaredField.toString();
            harness.check(testedDeclaredFields.containsKey(fieldString));
            harness.check(testedDeclaredFields.get(fieldString), (Object)fieldName);
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

