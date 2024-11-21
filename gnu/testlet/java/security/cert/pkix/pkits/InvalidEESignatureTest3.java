/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidEESignatureTest3
extends BaseInvalidTest {
    public InvalidEESignatureTest3() {
        super(new String[]{"data/certs/InvalidEESignatureTest3EE.crt", "data/certs/GoodCACert.crt"}, new String[]{"data/crls/GoodCACRL.crl"});
    }
}

