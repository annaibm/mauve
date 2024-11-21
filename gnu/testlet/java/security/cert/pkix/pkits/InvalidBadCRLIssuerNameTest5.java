/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidBadCRLIssuerNameTest5
extends BaseInvalidTest {
    public InvalidBadCRLIssuerNameTest5() {
        super(new String[]{"data/certs/InvalidBadCRLIssuerNameTest5EE.crt", "data/certs/BadCRLIssuerNameCACert.crt"}, new String[]{"data/crls/BadCRLIssuerNameCACRL.crl"});
    }
}

