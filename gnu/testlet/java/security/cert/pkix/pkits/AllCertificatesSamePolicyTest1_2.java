/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;
import java.security.cert.PKIXParameters;
import java.util.Collections;

public class AllCertificatesSamePolicyTest1_2
extends BaseValidTest {
    public AllCertificatesSamePolicyTest1_2() {
        super(new String[]{"data/certs/ValidCertificatePathTest1EE.crt", "data/certs/GoodCACert.crt"}, new String[]{"data/crls/GoodCACRL.crl"});
    }

    @Override
    protected void setupAdditionalParams(PKIXParameters params) {
        params.setExplicitPolicyRequired(true);
        params.setInitialPolicies(Collections.singleton("2.16.840.1.101.3.2.1.48.1"));
    }
}

