/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.logging.XMLFormatter;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.logging.StreamHandler;
import java.util.logging.XMLFormatter;

public class getTail
implements Testlet {
    @Override
    public void test(TestHarness h) {
        XMLFormatter formatter = new XMLFormatter();
        StreamHandler handler = new StreamHandler();
        h.check(formatter.getTail(handler), (Object)("</log>" + System.getProperty("line.separator")));
        try {
            formatter.getTail(null);
            h.check(true);
        }
        catch (Exception ex) {
            h.check(false);
        }
    }
}

