/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.locales;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class LocaleTest
implements Testlet {
    private void checkLocale(TestHarness h, Locale locale, ExpectedValues expected, ExpectedDateValues expectedDate, ExpectedNumberValues expectedNumber1, ExpectedNumberValues expectedNumberCurrency1, ExpectedNumberValues expectedNumberCurrency2, ExpectedNumberValues expectedNumber3, ExpectedNumberValues expectedNumber4, ExpectedNumberValues expectedNumberProcent) {
        NumberFormat nf;
        h.checkPoint("Locale " + locale);
        Locale.setDefault(Locale.GERMAN);
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        if (expected != null) {
            h.check(locale.getLanguage(), (Object)expected.language);
            h.check(locale.getCountry(), (Object)expected.country);
            h.check(locale.getVariant(), (Object)expected.variant);
            h.check(locale.toString(), (Object)expected.localeStr);
            h.check(locale.getISO3Language(), (Object)expected.iso3language);
            h.check(locale.getISO3Country(), (Object)expected.iso3country);
            h.check(locale.getDisplayLanguage(), (Object)expected.displayLanguage);
            h.check(locale.getDisplayCountry(), (Object)expected.displayCountry);
            h.check(locale.getDisplayVariant(), (Object)expected.displayVariant);
            h.check(locale.getDisplayName(), (Object)expected.displayName);
        }
        h.debug("Locale " + locale + " date/time formats");
        if (expectedDate != null) {
            Date date1 = new Date(74, 2, 18, 17, 20, 30);
            DateFormat df = DateFormat.getDateInstance(2, locale);
            h.check(df.format(date1), expectedDate.a, "DateFormat.DEFAULT " + locale);
            df = DateFormat.getDateInstance(3, locale);
            h.check(df.format(date1), expectedDate.b, "DateFormat.SHORT " + locale);
            df = DateFormat.getDateInstance(2, locale);
            h.check(df.format(date1), expectedDate.c, "DateFormat.MEDIUM " + locale);
            df = DateFormat.getDateInstance(1, locale);
            h.check(df.format(date1), expectedDate.d, "DateFormat.LONG " + locale);
            df = DateFormat.getDateInstance(2, locale);
            h.check(df.format(date1), expectedDate.c, "DateFormat.DEFAULT == DateFormat.MEDIUM " + locale);
            df = DateFormat.getTimeInstance(2, locale);
            h.check(df.format(date1), expectedDate.e, "DateFormat.DEFAULT " + locale);
            df = DateFormat.getTimeInstance(3, locale);
            h.check(df.format(date1), expectedDate.f, "DateFormat.SHORT " + locale);
            df = DateFormat.getTimeInstance(2, locale);
            h.check(df.format(date1), expectedDate.g, "DateFormat.MEDIUM " + locale);
            df = DateFormat.getTimeInstance(1, locale);
            h.check(df.format(date1), expectedDate.h, "DateFormat.LONG " + locale);
            df = DateFormat.getTimeInstance(2, locale);
            h.check(df.format(date1), expectedDate.g, "DateFormat.DEFAULT == DateFormat.MEDIUM " + locale);
        }
        h.checkPoint("numberformats locale: " + locale);
        if (expectedNumber1 != null) {
            nf = NumberFormat.getInstance(locale);
            h.check(nf.format(1000L), (Object)expectedNumber1.a);
            h.check(nf.format(1000000L), (Object)expectedNumber1.b);
            h.check(nf.format(100.0), (Object)expectedNumber1.c);
            h.check(nf.format(100.1234), (Object)expectedNumber1.d);
            h.check(nf.format(1.00000001234E7), (Object)expectedNumber1.e);
        }
        if (expectedNumberCurrency1 != null) {
            nf = NumberFormat.getCurrencyInstance(locale);
            h.check(nf.format(1000L), (Object)expectedNumberCurrency1.a);
            h.check(nf.format(1000000L), (Object)expectedNumberCurrency1.b);
            h.check(nf.format(100.0), (Object)expectedNumberCurrency1.c);
            h.check(nf.format(100.1234), (Object)expectedNumberCurrency1.d);
            h.check(nf.format(1.00000001234E7), (Object)expectedNumberCurrency1.e);
        }
        if (expectedNumberCurrency2 != null) {
            nf = NumberFormat.getCurrencyInstance(locale);
            h.check(nf.format(-1000L), (Object)expectedNumberCurrency2.a);
            h.check(nf.format(-1000000L), (Object)expectedNumberCurrency2.b);
            h.check(nf.format(-100.0), (Object)expectedNumberCurrency2.c);
            h.check(nf.format(-100.1234), (Object)expectedNumberCurrency2.d);
            h.check(nf.format(-1.00000001234E7), (Object)expectedNumberCurrency2.e);
        }
        if (expectedNumber3 != null) {
            nf = NumberFormat.getIntegerInstance(locale);
            h.check(nf.format(1000L), (Object)expectedNumber3.a);
            h.check(nf.format(1000000L), (Object)expectedNumber3.b);
            h.check(nf.format(100.0), (Object)expectedNumber3.c);
            h.check(nf.format(100.1234), (Object)expectedNumber3.d);
            h.check(nf.format(1.00000001234E7), (Object)expectedNumber3.e);
        }
        if (expectedNumber4 != null) {
            nf = NumberFormat.getNumberInstance(locale);
            h.check(nf.format(1000L), (Object)expectedNumber4.a);
            h.check(nf.format(1000000L), (Object)expectedNumber4.b);
            h.check(nf.format(100.0), (Object)expectedNumber4.c);
            h.check(nf.format(100.1234), (Object)expectedNumber4.d);
            h.check(nf.format(1.00000001234E7), (Object)expectedNumber4.e);
        }
        if (expectedNumberProcent != null) {
            nf = NumberFormat.getPercentInstance(locale);
            h.check(nf.format(1000L), (Object)expectedNumberProcent.a);
            h.check(nf.format(1000000L), (Object)expectedNumberProcent.b);
            h.check(nf.format(100.0), (Object)expectedNumberProcent.c);
            h.check(nf.format(100.1234), (Object)expectedNumberProcent.d);
            h.check(nf.format(1.00000001234E7), (Object)expectedNumberProcent.e);
        }
        h.checkPoint("Currencies locale: " + locale);
        if (expected != null) {
            Currency currency = Currency.getInstance(locale);
            h.check(currency.getCurrencyCode(), (Object)expected.currencyCode);
            h.check(currency.getDefaultFractionDigits(), expected.currencyFractionDigits);
            h.check(currency.getSymbol(), (Object)expected.currencySymbol);
            try {
                Currency byCode = Currency.getInstance(currency.getCurrencyCode());
                h.check(currency.getCurrencyCode(), (Object)byCode.getCurrencyCode());
                h.check(currency.getDefaultFractionDigits(), byCode.getDefaultFractionDigits());
                h.check(currency.getSymbol(), (Object)byCode.getSymbol());
            }
            catch (IllegalArgumentException e) {
                h.fail("Currency code not supported: " + currency.getCurrencyCode());
            }
        }
    }

    @Override
    public void test(TestHarness h) {
        this.checkLocale(h, new Locale("de", "DE"), new ExpectedValues("de", "DE", "", "de_DE", "deu", "DEU", "Deutsch", "Deutschland", "", "Deutsch (Deutschland)", "EUR", 2, "EUR"), new ExpectedDateValues("18.03.1974", "18.03.74", "18.03.1974", "18. M\u00e4rz 1974", "17:20:30", "17:20", "17:20:30", "17:20:30 GMT"), new ExpectedNumberValues("1.000", "1.000.000", "100", "100,123", "10.000.000,123"), new ExpectedNumberValues("1.000,00 \u20ac", "1.000.000,00 \u20ac", "100,00 \u20ac", "100,12 \u20ac", "10.000.000,12 \u20ac"), new ExpectedNumberValues("-1.000,00 \u20ac", "-1.000.000,00 \u20ac", "-100,00 \u20ac", "-100,12 \u20ac", "-10.000.000,12 \u20ac"), new ExpectedNumberValues("1.000", "1.000.000", "100", "100", "10.000.000"), new ExpectedNumberValues("1.000", "1.000.000", "100", "100,123", "10.000.000,123"), new ExpectedNumberValues("100.000%", "100.000.000%", "10.000%", "10.012%", "1.000.000.012%"));
        this.checkLocale(h, new Locale("fr", "BE"), new ExpectedValues("fr", "BE", "", "fr_BE", "fra", "BEL", "Franz\u00f6sisch", "Belgien", "", "Franz\u00f6sisch (Belgien)", "EUR", 2, "EUR"), new ExpectedDateValues("18-mars-1974", "18/03/74", "18-mars-1974", "18 mars 1974", "17:20:30", "17:20", "17:20:30", "17:20:30 GMT"), new ExpectedNumberValues("1.000", "1.000.000", "100", "100,123", "10.000.000,123"), new ExpectedNumberValues("1.000,00 \u20ac", "1.000.000,00 \u20ac", "100,00 \u20ac", "100,12 \u20ac", "10.000.000,12 \u20ac"), new ExpectedNumberValues("-1.000,00 \u20ac", "-1.000.000,00 \u20ac", "-100,00 \u20ac", "-100,12 \u20ac", "-10.000.000,12 \u20ac"), new ExpectedNumberValues("1.000", "1.000.000", "100", "100", "10.000.000"), new ExpectedNumberValues("1.000", "1.000.000", "100", "100,123", "10.000.000,123"), new ExpectedNumberValues("100.000 %", "100.000.000 %", "10.000 %", "10.012 %", "1.000.000.012 %"));
        this.checkLocale(h, new Locale("en", "IE"), new ExpectedValues("en", "IE", "", "en_IE", "eng", "IRL", "Englisch", "Irland", "", "Englisch (Irland)", "EUR", 2, "EUR"), new ExpectedDateValues("18-Mar-1974", "18/03/74", "18-Mar-1974", "18 March 1974", "17:20:30", "17:20", "17:20:30", "17:20:30 GMT"), new ExpectedNumberValues("1,000", "1,000,000", "100", "100.123", "10,000,000.123"), new ExpectedNumberValues("\u20ac1,000.00", "\u20ac1,000,000.00", "\u20ac100.00", "\u20ac100.12", "\u20ac10,000,000.12"), new ExpectedNumberValues("-\u20ac1,000.00", "-\u20ac1,000,000.00", "-\u20ac100.00", "-\u20ac100.12", "-\u20ac10,000,000.12"), new ExpectedNumberValues("1,000", "1,000,000", "100", "100", "10,000,000"), new ExpectedNumberValues("1,000", "1,000,000", "100", "100.123", "10,000,000.123"), new ExpectedNumberValues("100,000%", "100,000,000%", "10,000%", "10,012%", "1,000,000,012%"));
        this.checkLocale(h, new Locale("fr", "FR"), new ExpectedValues("fr", "FR", "", "fr_FR", "fra", "FRA", "Franz\u00f6sisch", "Frankreich", "", "Franz\u00f6sisch (Frankreich)", "EUR", 2, "EUR"), null, null, null, null, null, null, null);
        this.checkLocale(h, new Locale("es", "ES"), new ExpectedValues("es", "ES", "", "es_ES", "spa", "ESP", "Spanisch", "Spanien", "", "Spanisch (Spanien)", "EUR", 2, "EUR"), null, null, null, null, null, null, null);
        this.checkLocale(h, new Locale("pt", "PT"), new ExpectedValues("pt", "PT", "", "pt_PT", "por", "PRT", "Portugiesisch", "Portugal", "", "Portugiesisch (Portugal)", "EUR", 2, "EUR"), null, null, null, null, null, null, null);
        this.checkLocale(h, new Locale("it", "IT"), new ExpectedValues("it", "IT", "", "it_IT", "ita", "ITA", "Italienisch", "Italien", "", "Italienisch (Italien)", "EUR", 2, "EUR"), null, null, null, null, null, null, null);
        this.checkLocale(h, new Locale("nl", "NL"), new ExpectedValues("nl", "NL", "", "nl_NL", "nld", "NLD", "Niederl\u00e4ndisch", "Niederlande", "", "Niederl\u00e4ndisch (Niederlande)", "EUR", 2, "EUR"), new ExpectedDateValues("18-mrt-1974", "18-3-74", "18-mrt-1974", "18 maart 1974", "17:20:30", "17:20", "17:20:30", "17:20:30 GMT"), new ExpectedNumberValues("1.000", "1.000.000", "100", "100,123", "10.000.000,123"), new ExpectedNumberValues("\u20ac 1.000,00", "\u20ac 1.000.000,00", "\u20ac 100,00", "\u20ac 100,12", "\u20ac 10.000.000,12"), new ExpectedNumberValues("\u20ac 1.000,00-", "\u20ac 1.000.000,00-", "\u20ac 100,00-", "\u20ac 100,12-", "\u20ac 10.000.000,12-"), new ExpectedNumberValues("1.000", "1.000.000", "100", "100", "10.000.000"), new ExpectedNumberValues("1.000", "1.000.000", "100", "100,123", "10.000.000,123"), new ExpectedNumberValues("100.000%", "100.000.000%", "10.000%", "10.012%", "1.000.000.012%"));
        this.checkLocale(h, new Locale("fr", "LU"), new ExpectedValues("fr", "LU", "", "fr_LU", "fra", "LUX", "Franz\u00f6sisch", "Luxemburg", "", "Franz\u00f6sisch (Luxemburg)", "EUR", 2, "EUR"), null, null, null, null, null, null, null);
        this.checkLocale(h, Locale.UK, new ExpectedValues("en", "GB", "", "en_GB", "eng", "GBR", "Englisch", "Vereinigtes K\u00f6nigreich", "", "Englisch (Vereinigtes K\u00f6nigreich)", "GBP", 2, "GBP"), new ExpectedDateValues("18-Mar-1974", "18/03/74", "18-Mar-1974", "18 March 1974", "17:20:30", "17:20", "17:20:30", "17:20:30 GMT"), new ExpectedNumberValues("1,000", "1,000,000", "100", "100.123", "10,000,000.123"), new ExpectedNumberValues("\u00a31,000.00", "\u00a31,000,000.00", "\u00a3100.00", "\u00a3100.12", "\u00a310,000,000.12"), new ExpectedNumberValues("-\u00a31,000.00", "-\u00a31,000,000.00", "-\u00a3100.00", "-\u00a3100.12", "-\u00a310,000,000.12"), new ExpectedNumberValues("1,000", "1,000,000", "100", "100", "10,000,000"), new ExpectedNumberValues("1,000", "1,000,000", "100", "100.123", "10,000,000.123"), new ExpectedNumberValues("100,000%", "100,000,000%", "10,000%", "10,012%", "1,000,000,012%"));
        this.checkLocale(h, Locale.US, new ExpectedValues("en", "US", "", "en_US", "eng", "USA", "Englisch", "Vereinigte Staaten von Amerika", "", "Englisch (Vereinigte Staaten von Amerika)", "USD", 2, "USD"), new ExpectedDateValues("Mar 18, 1974", "3/18/74", "Mar 18, 1974", "March 18, 1974", "5:20:30 PM", "5:20 PM", "5:20:30 PM", "5:20:30 PM GMT"), new ExpectedNumberValues("1,000", "1,000,000", "100", "100.123", "10,000,000.123"), new ExpectedNumberValues("$1,000.00", "$1,000,000.00", "$100.00", "$100.12", "$10,000,000.12"), new ExpectedNumberValues("($1,000.00)", "($1,000,000.00)", "($100.00)", "($100.12)", "($10,000,000.12)"), new ExpectedNumberValues("1,000", "1,000,000", "100", "100", "10,000,000"), new ExpectedNumberValues("1,000", "1,000,000", "100", "100.123", "10,000,000.123"), new ExpectedNumberValues("100,000%", "100,000,000%", "10,000%", "10,012%", "1,000,000,012%"));
        this.checkLocale(h, new Locale("fi", "FI"), new ExpectedValues("fi", "FI", "", "fi_FI", "fin", "FIN", "Finnisch", "Finnland", "", "Finnisch (Finnland)", "EUR", 2, "EUR"), new ExpectedDateValues("18.3.1974", "18.3.1974", "18.3.1974", "18. maaliskuuta 1974", "17:20:30", "17:20", "17:20:30", "klo 17.20.30"), new ExpectedNumberValues("1\u00a0000", "1\u00a0000\u00a0000", "100", "100,123", "10\u00a0000\u00a0000,123"), new ExpectedNumberValues("1\u00a0000,00 \u20ac", "1\u00a0000\u00a0000,00 \u20ac", "100,00 \u20ac", "100,12 \u20ac", "10\u00a0000\u00a0000,12 \u20ac"), new ExpectedNumberValues("-1\u00a0000,00 \u20ac", "-1\u00a0000\u00a0000,00 \u20ac", "-100,00 \u20ac", "-100,12 \u20ac", "-10\u00a0000\u00a0000,12 \u20ac"), new ExpectedNumberValues("1\u00a0000", "1\u00a0000\u00a0000", "100", "100", "10\u00a0000\u00a0000"), new ExpectedNumberValues("1\u00a0000", "1\u00a0000\u00a0000", "100", "100,123", "10\u00a0000\u00a0000,123"), new ExpectedNumberValues("100\u00a0000%", "100\u00a0000\u00a0000%", "10\u00a0000%", "10\u00a0012%", "1\u00a0000\u00a0000\u00a0012%"));
        this.checkLocale(h, new Locale("tr", "TR"), new ExpectedValues("tr", "TR", "", "tr_TR", "tur", "TUR", "T\u00fcrkisch", "T\u00fcrkei", "", "T\u00fcrkisch (T\u00fcrkei)", "TRY", 2, "TRY"), new ExpectedDateValues("18.Mar.1974", "18.03.1974", "18.Mar.1974", "18 Mart 1974 Pazartesi", "17:20:30", "17:20", "17:20:30", "17:20:30 GMT"), new ExpectedNumberValues("1.000", "1.000.000", "100", "100,123", "10.000.000,123"), new ExpectedNumberValues("1.000,00 YTL", "1.000.000,00 YTL", "100,00 YTL", "100,12 YTL", "10.000.000,12 YTL"), new ExpectedNumberValues("-1.000,00 YTL", "-1.000.000,00 YTL", "-100,00 YTL", "-100,12 YTL", "-10.000.000,12 YTL"), new ExpectedNumberValues("1.000", "1.000.000", "100", "100", "10.000.000"), new ExpectedNumberValues("1.000", "1.000.000", "100", "100,123", "10.000.000,123"), new ExpectedNumberValues("% 100.000", "% 100.000.000", "% 10.000", "% 10.012", "% 1.000.000.012"));
        this.checkLocale(h, new Locale("kk", "KZ"), new ExpectedValues("kk", "KZ", "", "kk_KZ", "kaz", "KAZ", "Kasachisch", "Kasachstan", "", "Kasachisch (Kasachstan)", "KZT", 2, "KZT"), null, null, null, null, null, null, null);
        this.checkLocale(h, new Locale("et", "EE"), new ExpectedValues("et", "EE", "", "et_EE", "est", "EST", "Estnisch", "Estland", "", "Estnisch (Estland)", "EEK", 2, "EEK"), new ExpectedDateValues("18.03.1974", "18.03.74", "18.03.1974", "esmasp\u00e4ev, 18. M\u00e4rts 1974. a", "17:20:30", "17:20", "17:20:30", "17:20:30 GMT"), new ExpectedNumberValues("1\u00a0000", "1\u00a0000\u00a0000", "100", "100,123", "10\u00a0000\u00a0000,123"), new ExpectedNumberValues("1\u00a0000 kr", "1\u00a0000\u00a0000 kr", "100 kr", "100,12 kr", "10\u00a0000\u00a0000,12 kr"), new ExpectedNumberValues("-1\u00a0000 kr", "-1\u00a0000\u00a0000 kr", "-100 kr", "-100,12 kr", "-10\u00a0000\u00a0000,12 kr"), new ExpectedNumberValues("1\u00a0000", "1\u00a0000\u00a0000", "100", "100", "10\u00a0000\u00a0000"), new ExpectedNumberValues("1\u00a0000", "1\u00a0000\u00a0000", "100", "100,123", "10\u00a0000\u00a0000,123"), new ExpectedNumberValues("100\u00a0000%", "100\u00a0000\u00a0000%", "10\u00a0000%", "10\u00a0012%", "1\u00a0000\u00a0000\u00a0012%"));
    }

    public class ExpectedNumberValues {
        String a;
        String b;
        String c;
        String d;
        String e;

        public ExpectedNumberValues(String a, String b, String c, String d, String e) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }
    }

    public class ExpectedDateValues {
        String a;
        String b;
        String c;
        String d;
        String e;
        String f;
        String g;
        String h;

        public ExpectedDateValues(String a, String b, String c, String d, String e, String f, String g, String h) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
            this.h = h;
        }
    }

    public class ExpectedValues {
        String language;
        String country;
        String variant;
        String localeStr;
        String iso3language;
        String iso3country;
        String displayLanguage;
        String displayCountry;
        String displayVariant;
        String displayName;
        String currencyCode;
        int currencyFractionDigits;
        String currencySymbol;

        public ExpectedValues(String language, String country, String variant, String localeStr, String iso3language, String iso3country, String displayLanguage, String displayCountry, String displayVariant, String displayName, String currencyCode, int currencyFractionDigits, String currencySymbol) {
            this.language = language;
            this.country = country;
            this.variant = variant;
            this.localeStr = localeStr;
            this.iso3language = iso3language;
            this.iso3country = iso3country;
            this.displayLanguage = displayLanguage;
            this.displayCountry = displayCountry;
            this.displayVariant = displayVariant;
            this.displayName = displayName;
            this.currencyCode = currencyCode;
            this.currencyFractionDigits = currencyFractionDigits;
            this.currencySymbol = currencySymbol;
        }
    }
}

