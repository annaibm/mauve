/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidNameChainingWhitespaceTest3
extends BaseValidTest {
    public ValidNameChainingWhitespaceTest3() {
        super(new String[]{"data/certs/ValidNameChainingWhitespaceTest3EE.crt", "data/certs/GoodCACert.crt"}, new String[]{"data/crls/GoodCACRL.crl"});
    }
}

