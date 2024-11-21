/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidNameChainingCapitalizationTest5
extends BaseValidTest {
    public ValidNameChainingCapitalizationTest5() {
        super(new String[]{"data/certs/ValidNameChainingCapitalizationTest5EE.crt", "data/certs/GoodCACert.crt"}, new String[]{"data/crls/GoodCACRL.crl"});
    }
}

