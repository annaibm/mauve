/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;
import java.security.cert.PKIXParameters;

public class AllCertificatesSamePoliciesTest10_1
extends BaseValidTest {
    public AllCertificatesSamePoliciesTest10_1() {
        super(new String[]{"data/certs/AllCertificatesSamePoliciesTest10EE.crt", "data/certs/PoliciesP12CACert.crt"}, new String[]{"data/crls/PoliciesP12CACRL.crl"});
    }

    @Override
    protected void setupAdditionalParams(PKIXParameters params) {
    }
}

