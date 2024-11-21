/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Character.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class getDeclaredMethod
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        HashMap<String, Class[]> methodsThatShouldExist_jdk6 = new HashMap<String, Class[]>();
        methodsThatShouldExist_jdk6.put("isJavaIdentifierStart", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("isJavaIdentifierStart", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isJavaIdentifierPart", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("isJavaIdentifierPart", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("equals", new Class[]{Object.class});
        methodsThatShouldExist_jdk6.put("toString", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("toString", new Class[0]);
        methodsThatShouldExist_jdk6.put("hashCode", new Class[0]);
        methodsThatShouldExist_jdk6.put("reverseBytes", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("compareTo", new Class[]{Object.class});
        methodsThatShouldExist_jdk6.put("compareTo", new Class[]{Character.class});
        methodsThatShouldExist_jdk6.put("charValue", new Class[0]);
        methodsThatShouldExist_jdk6.put("valueOf", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("codePointAt", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("codePointAt", new Class[]{new char[1].getClass(), Integer.TYPE});
        methodsThatShouldExist_jdk6.put("codePointAt", new Class[]{CharSequence.class, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("codePointBefore", new Class[]{new char[1].getClass(), Integer.TYPE});
        methodsThatShouldExist_jdk6.put("codePointBefore", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("codePointBefore", new Class[]{CharSequence.class, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("codePointCount", new Class[]{CharSequence.class, Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("codePointCount", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("offsetByCodePoints", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("offsetByCodePoints", new Class[]{CharSequence.class, Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("toLowerCase", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("toLowerCase", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("toUpperCase", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("toUpperCase", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isSupplementaryCodePoint", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("toSurrogates", new Class[]{Integer.TYPE, new char[1].getClass(), Integer.TYPE});
        methodsThatShouldExist_jdk6.put("codePointAtImpl", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("codePointBeforeImpl", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("codePointCountImpl", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("offsetByCodePointsImpl", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("toChars", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("toChars", new Class[]{Integer.TYPE, new char[1].getClass(), Integer.TYPE});
        methodsThatShouldExist_jdk6.put("charCount", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("toUpperCaseEx", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("toUpperCaseCharArray", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("getType", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("getType", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("isValidCodePoint", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("isLowSurrogate", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isHighSurrogate", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isSurrogatePair", new Class[]{Character.TYPE, Character.TYPE});
        methodsThatShouldExist_jdk6.put("toCodePoint", new Class[]{Character.TYPE, Character.TYPE});
        methodsThatShouldExist_jdk6.put("isLowerCase", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isLowerCase", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("isUpperCase", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("isUpperCase", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isTitleCase", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("isTitleCase", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isDigit", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isDigit", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("isDefined", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("isDefined", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isLetter", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("isLetter", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isLetterOrDigit", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isLetterOrDigit", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("isJavaLetter", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isJavaLetterOrDigit", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isUnicodeIdentifierStart", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("isUnicodeIdentifierStart", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isUnicodeIdentifierPart", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("isUnicodeIdentifierPart", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isIdentifierIgnorable", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isIdentifierIgnorable", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("toTitleCase", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("toTitleCase", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("digit", new Class[]{Character.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("digit", new Class[]{Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("getNumericValue", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("getNumericValue", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isSpace", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isSpaceChar", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("isSpaceChar", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isWhitespace", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isWhitespace", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("isISOControl", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("isISOControl", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("forDigit", new Class[]{Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk6.put("getDirectionality", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk6.put("getDirectionality", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isMirrored", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk6.put("isMirrored", new Class[]{Integer.TYPE});
        HashMap<String, Class[]> methodsThatShouldExist_jdk7 = new HashMap<String, Class[]>();
        methodsThatShouldExist_jdk7.put("isJavaIdentifierStart", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isJavaIdentifierStart", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isJavaIdentifierPart", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isJavaIdentifierPart", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("equals", new Class[]{Object.class});
        methodsThatShouldExist_jdk7.put("toString", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("toString", new Class[0]);
        methodsThatShouldExist_jdk7.put("hashCode", new Class[0]);
        methodsThatShouldExist_jdk7.put("reverseBytes", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("compareTo", new Class[]{Object.class});
        methodsThatShouldExist_jdk7.put("compareTo", new Class[]{Character.class});
        methodsThatShouldExist_jdk7.put("charValue", new Class[0]);
        methodsThatShouldExist_jdk7.put("valueOf", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("getName", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("charCount", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("codePointAt", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("codePointAt", new Class[]{CharSequence.class, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("codePointAt", new Class[]{new char[1].getClass(), Integer.TYPE});
        methodsThatShouldExist_jdk7.put("codePointAtImpl", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("codePointBefore", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("codePointBefore", new Class[]{new char[1].getClass(), Integer.TYPE});
        methodsThatShouldExist_jdk7.put("codePointBefore", new Class[]{CharSequence.class, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("codePointBeforeImpl", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("codePointCount", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("codePointCount", new Class[]{CharSequence.class, Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("codePointCountImpl", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("compare", new Class[]{Character.TYPE, Character.TYPE});
        methodsThatShouldExist_jdk7.put("highSurrogate", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isBmpCodePoint", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isValidCodePoint", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("lowSurrogate", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("offsetByCodePoints", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("offsetByCodePoints", new Class[]{CharSequence.class, Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("offsetByCodePointsImpl", new Class[]{new char[1].getClass(), Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("toChars", new Class[]{Integer.TYPE, new char[1].getClass(), Integer.TYPE});
        methodsThatShouldExist_jdk7.put("toChars", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("toLowerCase", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("toLowerCase", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("toSurrogates", new Class[]{Integer.TYPE, new char[1].getClass(), Integer.TYPE});
        methodsThatShouldExist_jdk7.put("toUpperCase", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("toUpperCase", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("toUpperCaseCharArray", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("toUpperCaseEx", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("getType", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("getType", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isHighSurrogate", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isLowSurrogate", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("digit", new Class[]{Character.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("digit", new Class[]{Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("forDigit", new Class[]{Integer.TYPE, Integer.TYPE});
        methodsThatShouldExist_jdk7.put("getDirectionality", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("getDirectionality", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("getNumericValue", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("getNumericValue", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isAlphabetic", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isDefined", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isDefined", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isDigit", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isDigit", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isISOControl", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isISOControl", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isIdentifierIgnorable", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isIdentifierIgnorable", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isIdeographic", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isJavaLetter", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isJavaLetterOrDigit", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isLetter", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isLetter", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isLetterOrDigit", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isLetterOrDigit", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isLowerCase", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isLowerCase", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isMirrored", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isMirrored", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isSpace", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isSpaceChar", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isSpaceChar", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isSupplementaryCodePoint", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isSurrogate", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isSurrogatePair", new Class[]{Character.TYPE, Character.TYPE});
        methodsThatShouldExist_jdk7.put("isTitleCase", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isTitleCase", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isUnicodeIdentifierPart", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isUnicodeIdentifierPart", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isUnicodeIdentifierStart", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isUnicodeIdentifierStart", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isUpperCase", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isUpperCase", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("isWhitespace", new Class[]{Integer.TYPE});
        methodsThatShouldExist_jdk7.put("isWhitespace", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("toCodePoint", new Class[]{Character.TYPE, Character.TYPE});
        methodsThatShouldExist_jdk7.put("toTitleCase", new Class[]{Character.TYPE});
        methodsThatShouldExist_jdk7.put("toTitleCase", new Class[]{Integer.TYPE});
        HashMap<String, Class[]> methodsThatShouldExist = this.getJavaVersion() < 7 ? methodsThatShouldExist_jdk6 : methodsThatShouldExist_jdk7;
        Character o = new Character('!');
        Class<?> c = o.getClass();
        for (Map.Entry methodThatShouldExists : methodsThatShouldExist.entrySet()) {
            try {
                Method method = c.getDeclaredMethod((String)methodThatShouldExists.getKey(), (Class[])methodThatShouldExists.getValue());
                harness.check(method != null);
                String methodName = method.getName();
                harness.check(methodName != null);
                harness.check(methodName, methodThatShouldExists.getKey());
            }
            catch (Exception e) {
                harness.check(false);
            }
        }
    }

    protected int getJavaVersion() {
        String javaVersionStr = System.getProperty("java.version");
        String[] parts = javaVersionStr.split("\\.");
        return Integer.parseInt(parts[1]);
    }
}

