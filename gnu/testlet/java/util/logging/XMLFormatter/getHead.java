/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.XMLFormatter;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.logging.Formatter;
import java.util.logging.StreamHandler;
import java.util.logging.XMLFormatter;

public class getHead
implements Testlet {
    @Override
    public void test(TestHarness h) {
        XMLFormatter formatter = new XMLFormatter();
        StreamHandler handler = new StreamHandler();
        h.checkPoint("no encoding set");
        h.check(((Formatter)formatter).getHead(handler), (Object)this.getExpectedHead(System.getProperty("file.encoding")));
        h.checkPoint("UTF-8");
        try {
            handler.setEncoding("UTF-8");
        }
        catch (Exception ex) {
            h.check(false);
            h.debug(ex);
        }
        h.check(((Formatter)formatter).getHead(handler), (Object)this.getExpectedHead("UTF-8"));
        h.checkPoint("getHead(null)");
        try {
            ((Formatter)formatter).getHead(null);
            h.check(false);
        }
        catch (Exception ex) {
            h.check(ex instanceof NullPointerException);
        }
    }

    public static String replaceLineSeparator(String pat) {
        String lineSeparator = System.getProperty("line.separator");
        return pat.replace('|', lineSeparator.charAt(0));
    }

    private String getExpectedHead(String encodingName) {
        return getHead.replaceLineSeparator("<?xml version=\"1.0\" encoding=\"" + encodingName + "\" standalone=\"no\"?>|<!DOCTYPE log SYSTEM \"logger.dtd\">|<log>|");
    }
}

