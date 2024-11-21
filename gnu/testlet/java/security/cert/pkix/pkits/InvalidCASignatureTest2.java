/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidCASignatureTest2
extends BaseInvalidTest {
    public InvalidCASignatureTest2() {
        super(new String[]{"data/certs/InvalidCASignatureTest2EE.crt", "data/certs/BadSignedCACert.crt"}, new String[]{"data/crls/BadSignedCACRL.crl"});
    }
}

