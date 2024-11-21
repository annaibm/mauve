/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class Invalidpre2000UTCEEnotAfterDateTest7
extends BaseInvalidTest {
    public Invalidpre2000UTCEEnotAfterDateTest7() {
        super(new String[]{"data/certs/Invalidpre2000UTCEEnotAfterDateTest7EE.crt", "data/certs/GoodCACert.crt"}, new String[]{"data/crls/GoodCACRL.crl"});
    }
}

