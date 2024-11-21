/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidDSASignatureTest6
extends BaseInvalidTest {
    public InvalidDSASignatureTest6() {
        super(new String[]{"data/certs/InvalidDSASignatureTest6EE.crt", "data/certs/DSACACert.crt"}, new String[]{"data/crls/DSACACRL.crl"});
    }
}

