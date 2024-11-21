/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;
import java.security.cert.PKIXParameters;

public class AllCertificatesSamePolicyTest1_1
extends BaseValidTest {
    public AllCertificatesSamePolicyTest1_1() {
        super(new String[]{"data/certs/ValidCertificatePathTest1EE.crt", "data/certs/GoodCACert.crt"}, new String[]{"data/crls/GoodCACRL.crl"});
    }

    @Override
    protected void setupAdditionalParams(PKIXParameters params) {
        params.setExplicitPolicyRequired(true);
    }
}

