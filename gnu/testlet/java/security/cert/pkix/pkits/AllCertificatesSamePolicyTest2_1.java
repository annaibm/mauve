/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;
import java.security.cert.PKIXParameters;

public class AllCertificatesSamePolicyTest2_1
extends BaseValidTest {
    public AllCertificatesSamePolicyTest2_1() {
        super(new String[]{"data/certs/AllCertificatesNoPoliciesTest2EE.crt", "data/certs/NoPoliciesCACert.crt"}, new String[]{"data/crls/NoPoliciesCACRL.crl"});
    }

    @Override
    protected void setupAdditionalParams(PKIXParameters params) {
    }
}

