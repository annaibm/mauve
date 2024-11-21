/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;
import java.security.cert.PKIXParameters;
import java.util.Collections;

public class AllCertificatesSamePoliciesTest10_2
extends BaseValidTest {
    public AllCertificatesSamePoliciesTest10_2() {
        super(new String[]{"data/certs/AllCertificatesSamePoliciesTest10EE.crt", "data/certs/PoliciesP12CACert.crt"}, new String[]{"data/crls/PoliciesP12CACRL.crl"});
    }

    @Override
    protected void setupAdditionalParams(PKIXParameters params) {
        params.setInitialPolicies(Collections.singleton("2.16.840.1.101.3.2.1.48.1"));
    }
}

