/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidDSASignaturesTest4
extends BaseValidTest {
    public ValidDSASignaturesTest4() {
        super(new String[]{"data/certs/ValidDSASignaturesTest4EE.crt", "data/certs/DSACACert.crt"}, new String[]{"data/crls/DSACACRL.crl"});
    }
}

