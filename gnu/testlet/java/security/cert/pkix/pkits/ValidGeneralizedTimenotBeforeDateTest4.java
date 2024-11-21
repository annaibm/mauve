/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidGeneralizedTimenotBeforeDateTest4
extends BaseValidTest {
    public ValidGeneralizedTimenotBeforeDateTest4() {
        super(new String[]{"data/certs/ValidGeneralizedTimenotBeforeDateTest4EE.crt", "data/certs/GoodCACert.crt"}, new String[]{"data/crls/GoodCACRL.crl"});
    }
}

