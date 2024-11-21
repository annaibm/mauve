/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidBasicSelfIssuedCRLSigningKeyTest8
extends BaseInvalidTest {
    public InvalidBasicSelfIssuedCRLSigningKeyTest8() {
        super(new String[]{"data/certs/InvalidBasicSelfIssuedCRLSigningKeyTest8EE.crt", "data/certs/BasicSelfIssuedCRLSigningKeyCACert.crt"}, new String[]{"data/crls/BasicSelfIssuedCRLSigningKeyCACRL.crl"}, new String[]{"data/certs/BasicSelfIssuedCRLSigningKeyCRLCert.crt"});
    }
}

