/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Character;

import gnu.testlet.ResourceNotFoundException;
import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.lang.Character.CharInfo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

public abstract class UnicodeBase
implements Testlet {
    public static boolean testDeprecated;
    public static boolean verbose;
    public static boolean benchmark;
    public int failures;
    public int tests;
    TestHarness harness;
    private Reader bir;
    private StringBuffer sb;

    public UnicodeBase() {
    }

    public UnicodeBase(TestHarness aHarness, String filename) throws ResourceNotFoundException, FileNotFoundException {
        this.harness = aHarness;
        this.bir = this.harness.getResourceReader("gnu#testlet#java#lang#Character#" + filename);
    }

    private String getNext(Reader r) throws IOException {
        this.sb = new StringBuffer();
        while (r.ready()) {
            char ch = (char)r.read();
            if (ch == '\r') continue;
            if (ch == ';' || ch == '\n') {
                return this.sb.toString();
            }
            this.sb.append(ch);
        }
        return this.sb.toString();
    }

    public void performTests() throws IOException {
        CharInfo ci = new CharInfo();
        while (this.bir.ready()) {
            int code;
            ci = new CharInfo();
            String str = this.getNext(this.bir);
            ci.code = code = Integer.parseInt(str, 16);
            ci.name = this.getNext(this.bir);
            ci.category = this.getNext(this.bir);
            this.getNext(this.bir);
            this.getNext(this.bir);
            this.getNext(this.bir);
            str = this.getNext(this.bir);
            ci.decimalDigit = !str.equals("") ? Integer.parseInt(str, 10) : -1;
            str = this.getNext(this.bir);
            ci.digit = !str.equals("") ? Integer.parseInt(str, 10) : -1;
            str = this.getNext(this.bir);
            if (str.equals("")) {
                ci.numericValue = -1;
            } else {
                try {
                    ci.numericValue = Integer.parseInt(str, 10);
                    if (ci.numericValue < 0) {
                        ci.numericValue = -2;
                    }
                }
                catch (NumberFormatException e) {
                    ci.numericValue = -2;
                }
            }
            this.getNext(this.bir);
            this.getNext(this.bir);
            this.getNext(this.bir);
            str = this.getNext(this.bir);
            ci.uppercase = !str.equals("") ? Integer.parseInt(str, 16) : ci.code;
            str = this.getNext(this.bir);
            ci.lowercase = !str.equals("") ? Integer.parseInt(str, 16) : ci.code;
            str = this.getNext(this.bir);
            ci.titlecase = !str.equals("") ? Integer.parseInt(str, 16) : ci.code;
            if (ci.digit != -1 && !"Nd".equals(ci.category)) {
                ci.digit = -1;
            }
            this.testChar(ci);
        }
        CharInfo ch = new CharInfo();
        ch.name = "CJK Ideograph";
        ch.category = "Lo";
        ch.decimalDigit = -1;
        ch.digit = -1;
        ch.numericValue = -1;
        int i = 19969;
        while (i <= 40868) {
            ch.code = i++;
            this.testChar(ch);
        }
        ch = new CharInfo();
        ch.name = "CJK Ideograph Extension A";
        ch.category = "Lo";
        ch.decimalDigit = -1;
        ch.digit = -1;
        ch.numericValue = -1;
        i = 13312;
        while (i <= 19893) {
            ch.code = i++;
            this.testChar(ch);
        }
        ch = new CharInfo();
        ch.name = "Hangul Syllable";
        ch.category = "Lo";
        ch.decimalDigit = -1;
        ch.digit = -1;
        ch.numericValue = -1;
        i = 44033;
        while (i <= 55202) {
            ch.code = i++;
            this.testChar(ch);
        }
        ch = new CharInfo();
        ch.name = "CJK Compatibility Ideograph";
        ch.category = "Lo";
        ch.decimalDigit = -1;
        ch.digit = -1;
        ch.numericValue = -1;
        i = 63745;
        while (i <= 64044) {
            ch.code = i++;
            this.testChar(ch);
        }
        ch = new CharInfo();
        ch.name = "Surrogate";
        ch.category = "Cs";
        ch.decimalDigit = -1;
        ch.digit = -1;
        ch.numericValue = -1;
        i = 55296;
        while ((long)i <= 57343L) {
            ch.code = i++;
            this.testChar(ch);
        }
        ch = new CharInfo();
        ch.name = "Private Use";
        ch.category = "Co";
        ch.decimalDigit = -1;
        ch.digit = -1;
        ch.numericValue = -1;
        i = 57344;
        while (i <= 63743) {
            ch.code = i++;
            this.testChar(ch);
        }
    }

    private void testChar(CharInfo c) {
        int titleCase;
        int upperCase;
        int lowerCase;
        if ("Ll".equals(c.category) != Character.isLowerCase(c.code)) {
            this.reportError(c, Character.isLowerCase(c.code) ? "lowercase" : "not-lowercase");
        }
        if ("Lu".equals(c.category) != Character.isUpperCase(c.code)) {
            this.reportError(c, Character.isUpperCase((char)c.code) ? "uppercase" : "not-uppercase");
        }
        if ("Lt".equals(c.category) != Character.isTitleCase(c.code)) {
            this.reportError(c, Character.isTitleCase((char)c.code) ? "titlecase" : "not-titlecase");
        }
        if ("Nd".equals(c.category) != Character.isDigit(c.code)) {
            this.reportError(c, Character.isDigit((char)c.code) ? "digit" : "not-digit");
        }
        if (!c.category.equals("Cn") != Character.isDefined(c.code)) {
            this.reportError(c, Character.isDefined((char)c.code) ? "defined" : "not-defined");
        }
        if (c.category.charAt(0) == 'L' != Character.isLetter(c.code)) {
            this.reportError(c, Character.isLetter((char)c.code) ? "letter" : "not-letter");
        }
        if (Character.isLetterOrDigit(c.code) != (Character.isLetter(c.code) || Character.isDigit(c.code))) {
            this.reportError(c, Character.isLetterOrDigit(c.code) ? "letterordigit" : "not-letterordigit");
        }
        if (c.category.charAt(0) == 'Z' != Character.isSpaceChar(c.code)) {
            this.reportError(c, Character.isSpaceChar(c.code) ? "spacechar" : "not-spacechar");
        }
        if (this.whitespace(c) != Character.isWhitespace(c.code)) {
            this.reportError(c, Character.isWhitespace(c.code) ? "whitespace" : "not-whitespace");
        }
        if ((c.code <= 31 || this.range(c.code, 127, 159)) != Character.isISOControl(c.code)) {
            this.reportError(c, Character.isISOControl(c.code) ? "isocontrol" : "not-isocontrol");
        }
        int type = Character.getType(c.code);
        String typeStr = null;
        switch (type) {
            case 0: {
                typeStr = "Cn";
                break;
            }
            case 1: {
                typeStr = "Lu";
                break;
            }
            case 2: {
                typeStr = "Ll";
                break;
            }
            case 3: {
                typeStr = "Lt";
                break;
            }
            case 4: {
                typeStr = "Lm";
                break;
            }
            case 5: {
                typeStr = "Lo";
                break;
            }
            case 6: {
                typeStr = "Mn";
                break;
            }
            case 7: {
                typeStr = "Me";
                break;
            }
            case 8: {
                typeStr = "Mc";
                break;
            }
            case 9: {
                typeStr = "Nd";
                break;
            }
            case 10: {
                typeStr = "Nl";
                break;
            }
            case 11: {
                typeStr = "No";
                break;
            }
            case 12: {
                typeStr = "Zs";
                break;
            }
            case 13: {
                typeStr = "Zl";
                break;
            }
            case 14: {
                typeStr = "Zp";
                break;
            }
            case 15: {
                typeStr = "Cc";
                break;
            }
            case 16: {
                typeStr = "Cf";
                break;
            }
            case 18: {
                typeStr = "Co";
                break;
            }
            case 19: {
                typeStr = "Cs";
                break;
            }
            case 20: {
                typeStr = "Pd";
                break;
            }
            case 21: {
                typeStr = "Ps";
                break;
            }
            case 22: {
                typeStr = "Pe";
                break;
            }
            case 23: {
                typeStr = "Pc";
                break;
            }
            case 30: {
                typeStr = "Pf";
                break;
            }
            case 29: {
                typeStr = "Pi";
                break;
            }
            case 24: {
                typeStr = "Po";
                break;
            }
            case 25: {
                typeStr = "Sm";
                break;
            }
            case 26: {
                typeStr = "Sc";
                break;
            }
            case 27: {
                typeStr = "Sk";
                break;
            }
            case 28: {
                typeStr = "So";
                break;
            }
            default: {
                typeStr = "ERROR (" + type + ")";
            }
        }
        if (!(c.category.equals(typeStr) || typeStr.equals("Ps") && c.category.equals("Pi") || typeStr.equals("Pe") && c.category.equals("Pf"))) {
            this.reportError(this.stringChar(c) + " is reported to be type " + typeStr + " instead of " + c.category);
        }
        if (this.identifierStart(c) != Character.isJavaIdentifierStart(c.code)) {
            this.reportError(c, Character.isJavaIdentifierStart(c.code) ? "javaindentifierstart" : "not-javaidentifierstart");
        }
        if (((typeStr = c.category).charAt(0) == 'L' || typeStr.equals("Sc") || typeStr.equals("Pc") || typeStr.equals("Nd") || typeStr.equals("Nl") || typeStr.equals("Mc") || typeStr.equals("Mn") || typeStr.equals("Cf") || typeStr.equals("Cc") && this.ignorable(c)) != Character.isJavaIdentifierPart(c.code)) {
            this.reportError(c, Character.isJavaIdentifierPart(c.code) ? "javaidentifierpart" : "not-javaidentifierpart");
        }
        if (this.unicodeIdentifierStart(c) != Character.isUnicodeIdentifierStart(c.code)) {
            this.reportError(c, Character.isUnicodeIdentifierStart(c.code) ? "unicodeidentifierstart" : "not-unicodeidentifierstart");
        }
        if (((typeStr = c.category).charAt(0) == 'L' || typeStr.equals("Pc") || typeStr.equals("Nd") || typeStr.equals("Nl") || typeStr.equals("Mc") || typeStr.equals("Mn") || typeStr.equals("Cf") || typeStr.equals("Cc") && this.ignorable(c)) != Character.isUnicodeIdentifierPart(c.code)) {
            this.reportError(c, Character.isUnicodeIdentifierPart(c.code) ? "unicodeidentifierpart" : "not-unicodeidentifierpart");
        }
        if (this.ignorable(c) != Character.isIdentifierIgnorable(c.code)) {
            this.reportError(c, Character.isIdentifierIgnorable(c.code) ? "identifierignorable" : "not-identifierignorable");
        }
        int n = lowerCase = c.lowercase != 0 ? c.lowercase : c.code;
        if (Character.toLowerCase(c.code) != lowerCase) {
            this.reportError(this.stringChar(c) + " has wrong lowercase form of " + c.lowercase + " instead of " + this.stringChar(c));
        }
        int n2 = upperCase = c.uppercase != 0 ? c.uppercase : c.code;
        if (Character.toUpperCase(c.code) != upperCase) {
            this.reportError(this.stringChar(c) + " has wrong uppercase form of " + c.uppercase + " instead of " + this.stringChar(c));
        }
        int n3 = c.titlecase != 0 ? c.titlecase : (titleCase = c.uppercase != 0 ? c.uppercase : c.code);
        if ("Lt".equals(c.category)) {
            titleCase = c.code;
        }
        if (Character.toTitleCase(c.code) != titleCase) {
            this.reportError(this.stringChar(c) + " has wrong titlecase form of " + c.titlecase + " instead of " + this.stringChar(c));
        }
        boolean radixPassed = true;
        for (int radix = 2; radix <= 36; ++radix) {
            if (this.range(c.code, 65, 90)) {
                c.digit = c.code - 65 + 10;
            } else if (this.range(c.code, 97, 122)) {
                c.digit = c.code - 97 + 10;
            } else if (this.range(c.code, 65313, 65338)) {
                c.digit = c.code - 65313 + 10;
            } else if (this.range(c.code, 65345, 65370)) {
                c.digit = c.code - 65345 + 10;
            }
            int digit2 = c.digit;
            if (digit2 >= radix) {
                digit2 = -1;
            }
            if (Character.digit(c.code, radix) == digit2) continue;
            this.reportError(this.stringChar(c) + " has wrong digit form of " + Character.digit(c.code, radix) + " for radix " + radix + " instead of " + digit2 + "(" + c.digit + ")");
            radixPassed = false;
        }
        if (radixPassed) {
            this.checkPassed();
        }
        if (this.range(c.code, 65, 90) || this.range(c.code, 97, 122) || this.range(c.code, 65313, 65338) || this.range(c.code, 65345, 65370)) {
            if (c.numericValue != -1) {
                this.reportError(this.stringChar(c) + " has wrong numeric value of " + Character.getNumericValue(c.code) + " instead of -1");
            }
        } else if (c.numericValue != Character.getNumericValue(c.code)) {
            this.reportError(this.stringChar(c) + " has wrong numeric value of " + Character.getNumericValue(c.code) + " instead of " + c.numericValue);
        }
        if (testDeprecated) {
            if (((char)c.code == '$' || (char)c.code == '_' || Character.isLetter(c.code)) != Character.isJavaLetter((char)c.code)) {
                this.reportError(c, Character.isJavaLetter((char)c.code) ? "javaletter" : "not-javaletter");
            }
            if ((Character.isJavaLetter((char)c.code) || Character.isDigit(c.code) || (char)c.code == '$' || (char)c.code == '_') != Character.isJavaLetterOrDigit((char)c.code)) {
                this.reportError(c, Character.isJavaLetterOrDigit((char)c.code) ? "javaletterordigit" : "not-javaletterordigit");
            }
            if (((char)c.code == ' ' || (char)c.code == '\t' || (char)c.code == '\n' || (char)c.code == '\r' || (char)c.code == '\f') != Character.isSpace((char)c.code)) {
                this.reportError(c, Character.isSpace((char)c.code) ? "space" : "non-space");
            }
        }
    }

    protected void reportError(CharInfo c, String what) {
        this.harness.check(false, this.stringChar(c) + " incorrectly reported as " + what);
    }

    protected void reportError(String what) {
        this.harness.check(false, what);
    }

    protected void checkPassed() {
        this.harness.check(true);
    }

    public boolean range(int mid, int low, int high) {
        return mid >= low && mid <= high;
    }

    public boolean whitespace(CharInfo c) {
        return c.category.charAt(0) == 'Z' && c.code != 160 && c.code != 8199 && c.code != 8239 || this.range(c.code, 9, 13) || this.range(c.code, 28, 31);
    }

    public String stringChar(CharInfo c) {
        return "Character " + c.code + ":" + (char)c.code + ":" + c.name;
    }

    public boolean identifierStart(CharInfo c) {
        return "Ll".equals(c.category) || "Lu".equals(c.category) || "Lt".equals(c.category) || "Lm".equals(c.category) || "Lo".equals(c.category) || "Nl".equals(c.category) || "Sc".equals(c.category) || "Pc".equals(c.category);
    }

    public boolean unicodeIdentifierStart(CharInfo c) {
        return "Ll".equals(c.category) || "Lu".equals(c.category) || "Lt".equals(c.category) || "Lm".equals(c.category) || "Lo".equals(c.category) || "Nl".equals(c.category);
    }

    public boolean ignorable(CharInfo c) {
        return this.range(c.code, 0, 8) || this.range(c.code, 14, 27) || this.range(c.code, 127, 159) || "Cf".equals(c.category);
    }
}

