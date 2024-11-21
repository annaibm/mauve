/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidSignaturesTest1
extends BaseValidTest {
    public ValidSignaturesTest1() {
        super(new String[]{"data/certs/ValidCertificatePathTest1EE.crt", "data/certs/GoodCACert.crt"}, new String[]{"data/crls/GoodCACRL.crl"});
    }
}

