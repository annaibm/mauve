/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidBasicSelfIssuedCRLSigningKeyTest6
extends BaseValidTest {
    public ValidBasicSelfIssuedCRLSigningKeyTest6() {
        super(new String[]{"data/certs/ValidBasicSelfIssuedCRLSigningKeyTest6EE.crt", "data/certs/BasicSelfIssuedCRLSigningKeyCACert.crt"}, new String[]{"data/crls/BasicSelfIssuedCRLSigningKeyCACRL.crl"}, new String[]{"data/certs/BasicSelfIssuedCRLSigningKeyCRLCert.crt"});
    }
}

