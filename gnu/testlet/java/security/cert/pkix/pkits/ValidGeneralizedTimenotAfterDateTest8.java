/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidGeneralizedTimenotAfterDateTest8
extends BaseValidTest {
    public ValidGeneralizedTimenotAfterDateTest8() {
        super(new String[]{"data/certs/ValidGeneralizedTimenotAfterDateTest8EE.crt", "data/certs/GoodCACert.crt"}, new String[]{"data/crls/GoodCACRL.crl"});
    }
}

