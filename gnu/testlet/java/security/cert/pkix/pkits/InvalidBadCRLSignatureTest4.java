/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidBadCRLSignatureTest4
extends BaseInvalidTest {
    public InvalidBadCRLSignatureTest4() {
        super(new String[]{"data/certs/InvalidBadCRLSignatureTest4EE.crt", "data/certs/BadCRLSignatureCACert.crt"}, new String[]{"data/crls/BadCRLSignatureCACRL.crl"});
    }
}

