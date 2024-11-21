/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.charset.Charset;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.nio.charset.Charset;

public class forName2
implements Testlet {
    private void checkCharset(TestHarness h, String name2) {
        boolean supported = false;
        try {
            Charset cs = Charset.forName(name2);
            if (cs != null) {
                supported = true;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        h.check(supported, "Charset '" + name2 + "' supported");
    }

    @Override
    public void test(TestHarness h) {
        this.checkCharset(h, "uTf-8");
        this.checkCharset(h, "utf8");
        this.checkCharset(h, "UtF-16bE");
        this.checkCharset(h, "uTf-16Le");
        this.checkCharset(h, "IsO-iR-100");
        this.checkCharset(h, "iSo_8859-1");
        this.checkCharset(h, "LATIN1");
        this.checkCharset(h, "L1");
        this.checkCharset(h, "IbM819");
        this.checkCharset(h, "cp819");
        this.checkCharset(h, "CSisolATIN1");
        this.checkCharset(h, "iSo-Ir-6");
        this.checkCharset(h, "AnSi_X3.4-1986");
        this.checkCharset(h, "IsO_646.IRV:1991");
        this.checkCharset(h, "AsCiI");
        this.checkCharset(h, "IsO646-us");
        this.checkCharset(h, "Us");
        this.checkCharset(h, "IbM367");
        this.checkCharset(h, "cP367");
        this.checkCharset(h, "CSASCII");
        this.checkCharset(h, "ibm-1208");
        this.checkCharset(h, "ibm-1209");
        this.checkCharset(h, "ibm-5304");
        this.checkCharset(h, "ibm-5305");
        this.checkCharset(h, "windows-65001");
        this.checkCharset(h, "cp1208");
    }
}

