/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.InputStreamReader;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class getEncoding
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String[] nioNames = new String[]{"ISO-8859-1", "ISO-8859-2", "ISO-8859-4", "ISO-8859-5", "ISO-8859-7", "ISO-8859-9", "ISO-8859-13", "ISO-8859-15", "KOI8-R", "US-ASCII", "UTF-8", "UTF-16", "UTF-16BE", "UTF-16LE", "windows-1250", "windows-1251", "windows-1252", "windows-1253", "windows-1254", "windows-1257"};
        String[] ioNames = new String[]{"ISO8859_1", "ISO8859_2", "ISO8859_4", "ISO8859_5", "ISO8859_7", "ISO8859_9", "ISO8859_13", "ISO8859_15", "KOI8_R", "ASCII", "UTF8", "UTF-16", "UnicodeBigUnmarked", "UnicodeLittleUnmarked", "Cp1250", "Cp1251", "Cp1252", "Cp1253", "Cp1254", "Cp1257"};
        ByteArrayInputStream is = new ByteArrayInputStream(new byte[]{13, 14, 10, 13, 11, 14, 14, 15});
        harness.checkPoint("standard charsets");
        for (int i = 0; i < nioNames.length; ++i) {
            boolean supported = true;
            String name2 = null;
            try {
                Charset cs = Charset.forName(nioNames[i]);
                InputStreamReader isr = new InputStreamReader((InputStream)is, cs);
                name2 = isr.getEncoding();
            }
            catch (UnsupportedCharsetException uce) {
                harness.debug(uce);
                supported = false;
            }
            harness.check(name2, (Object)ioNames[i]);
            harness.check(supported, true);
        }
        String[] extNioNames = new String[]{"Big5", "Big5-HKSCS", "EUC-JP", "EUC-KR", "GB18030", "GB2312", "GBK", "IBM-Thai", "IBM00858", "IBM01140", "IBM01141", "IBM01142", "IBM01143", "IBM01144", "IBM01145", "IBM01146", "IBM01147", "IBM01148", "IBM01149", "IBM037", "IBM1026", "IBM1047", "IBM273", "IBM277", "IBM278", "IBM280", "IBM284", "IBM285", "IBM297", "IBM420", "IBM424", "IBM437", "IBM500", "IBM775", "IBM850", "IBM852", "IBM855", "IBM857", "IBM860", "IBM861", "IBM862", "IBM863", "IBM864", "IBM865", "IBM866", "IBM868", "IBM869", "IBM870", "IBM871", "IBM918", "ISO-2022-CN", "ISO-2022-JP", "ISO-2022-KR", "ISO-8859-3", "ISO-8859-6", "ISO-8859-8", "Shift_JIS", "TIS-620", "windows-1255", "windows-1256", "windows-1258", "windows-31j", "x-Big5_Solaris", "x-euc-jp-linux", "x-EUC-TW", "x-eucJP-Open", "x-IBM1006", "x-IBM1025", "x-IBM1046", "x-IBM1097", "x-IBM1098", "x-IBM1112", "x-IBM1122", "x-IBM1123", "x-IBM1124", "x-IBM1381", "x-IBM1383", "x-IBM33722", "x-IBM737", "x-IBM856", "x-IBM874", "x-IBM875", "x-IBM921", "x-IBM922", "x-IBM930", "x-IBM933", "x-IBM935", "x-IBM937", "x-IBM939", "x-IBM942", "x-IBM942C", "x-IBM943", "x-IBM943C", "x-IBM948", "x-IBM949", "x-IBM949C", "x-IBM950", "x-IBM964", "x-IBM970", "x-ISCII91", "x-ISO2022-CN-CNS", "x-ISO2022-CN-GB", "x-iso-8859-11", "x-JISAutoDetect", "x-Johab", "x-MacArabic", "x-MacCentralEurope", "x-MacCroatian", "x-MacCyrillic", "x-MacDingbat", "x-MacGreek", "x-MacHebrew", "x-MacIceland", "x-MacRoman", "x-MacRomania", "x-MacSymbol", "x-MacThai", "x-MacTurkish", "x-MacUkraine", "x-MS950-HKSCS", "x-mswin-936", "x-PCK", "x-windows-874", "x-windows-949", "x-windows-950"};
        String[] extIoNames = new String[]{"Big5", "Big5_HKSCS", "EUC_JP", "EUC_KR", "GB18030", "EUC_CN", "GBK", "Cp838", "Cp858", "Cp1140", "Cp1141", "Cp1142", "Cp1143", "Cp1144", "Cp1145", "Cp1146", "Cp1147", "Cp1148", "Cp1149", "Cp037", "Cp1026", "Cp1047", "Cp273", "Cp277", "Cp278", "Cp280", "Cp284", "Cp285", "Cp297", "Cp420", "Cp424", "Cp437", "Cp500", "Cp775", "Cp850", "Cp852", "Cp855", "Cp857", "Cp860", "Cp861", "Cp862", "Cp863", "Cp864", "Cp865", "Cp866", "Cp868", "Cp869", "Cp870", "Cp871", "Cp918", "ISO2022CN", "ISO2022JP", "ISO2022KR", "ISO8859_3", "ISO8859_6", "ISO8859_8", "SJIS", "TIS620", "Cp1255", "Cp1256", "Cp1258", "MS932", "Big5_Solaris", "EUC_JP_LINUX", "EUC_TW", "EUC_JP_Solaris", "Cp1006", "Cp1025", "Cp1046", "Cp1097", "Cp1098", "Cp1112", "Cp1122", "Cp1123", "Cp1124", "Cp1381", "Cp1383", "Cp33722", "Cp737", "Cp856", "Cp874", "Cp875", "Cp921", "Cp922", "Cp930", "Cp933", "Cp935", "Cp937", "Cp939", "Cp942", "Cp942C", "Cp943", "Cp943C", "Cp948", "Cp949", "Cp949C", "Cp950", "Cp964", "Cp970", "ISCII91", "ISO2022_CN_CNS", "ISO2022_CN_GB", "x-iso-8859-11", "JISAutoDetect", "x-Johab", "MacArabic", "MacCentralEurope", "MacCroatian", "MacCyrillic", "MacDingbat", "MacGreek", "MacHebrew", "MacIceland", "MacRoman", "MacRomania", "MacSymbol", "MacThai", "MacTurkish", "MacUkraine", "MS950_HKSCS", "MS936", "PCK", "MS874", "MS949", "MS950", "x-IBM933", "x-IBM935", "x-IBM937", "x-IBM939", "x-IBM942", "x-IBM942C", "x-IBM943", "x-IBM943C", "x-IBM948", "x-IBM949", "x-IBM949C", "x-IBM950", "x-IBM964", "x-IBM970", "x-ISCII91", "x-ISO2022-CN-CNS", "x-ISO2022-CN-GB", "x-iso-8859-11", "x-JISAutoDetect", "x-Johab", "x-MacArabic", "x-MacCentralEurope", "x-MacCroatian", "x-MacCyrillic", "x-MacDingbat", "x-MacGreek", "x-MacHebrew", "x-MacIceland", "x-MacRoman", "x-MacRomania", "x-MacSymbol", "x-MacThai", "x-MacTurkish", "x-MacUkraine", "x-MS950-HKSCS", "x-mswin-936", "x-PCK", "x-windows-874", "x-windows-949", "x-windows-950"};
        harness.checkPoint("extended charsets");
        for (int i = 0; i < extNioNames.length; ++i) {
            boolean supported = true;
            String name3 = null;
            try {
                Charset cs = Charset.forName(extNioNames[i]);
                InputStreamReader isr = new InputStreamReader((InputStream)is, cs);
                name3 = isr.getEncoding();
            }
            catch (UnsupportedCharsetException uce) {
                supported = false;
            }
            if (!supported) continue;
            harness.check(name3, (Object)extIoNames[i]);
            harness.check(supported, true);
        }
    }
}

