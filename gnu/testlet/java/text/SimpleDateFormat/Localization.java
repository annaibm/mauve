/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.SimpleDateFormat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Localization
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleDateFormat format2 = null;
        String standard = "GyMdkHmsSEDFwWahKzYeugAZ";
        String pattern = "EEE, d MMM yyyy HH:mm:ss Z";
        Locale locale = Locale.GERMAN;
        harness.checkPoint("German locale, standard pattern characters in pattern.");
        try {
            format2 = new SimpleDateFormat(pattern, locale);
            harness.check(true);
        }
        catch (IllegalArgumentException e) {
            harness.debug(e);
            harness.check(false);
        }
        String local = format2.getDateFormatSymbols().getLocalPatternChars();
        harness.check(format2.toPattern(), pattern, "Non-localized pattern comes back as is with toPattern().");
        String localizedPattern = this.translateLocalizedPattern(pattern, standard, local);
        harness.check(format2.toLocalizedPattern(), localizedPattern, "Non-localized pattern comes back localized with toLocalizedPattern().");
        harness.checkPoint("German locale, German pattern characters in pattern.");
        format2 = null;
        try {
            format2 = new SimpleDateFormat(localizedPattern, locale);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            format2 = new SimpleDateFormat(pattern, locale);
            format2.applyLocalizedPattern(localizedPattern);
            harness.check(true);
        }
        catch (IllegalArgumentException e) {
            harness.debug(e);
            harness.check(false);
        }
        local = format2.getDateFormatSymbols().getLocalPatternChars();
        harness.check(format2.toLocalizedPattern(), localizedPattern, "Localized pattern comes back as is with toLocalizedPattern().");
        harness.check(format2.toPattern(), pattern, "Localized pattern comes back standardised with toPattern().");
    }

    private String translateLocalizedPattern(String pattern, String oldChars, String newChars) {
        int len = pattern.length();
        StringBuffer buf = new StringBuffer(len);
        boolean quoted = false;
        for (int i = 0; i < len; ++i) {
            int j;
            char ch = pattern.charAt(i);
            if (ch == '\'') {
                boolean bl = quoted = !quoted;
            }
            if (!quoted && (j = oldChars.indexOf(ch)) >= 0 && j < newChars.length()) {
                ch = newChars.charAt(j);
            }
            buf.append(ch);
        }
        return buf.toString();
    }
}

