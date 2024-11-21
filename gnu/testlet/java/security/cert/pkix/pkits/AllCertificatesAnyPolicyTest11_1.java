/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;
import java.security.cert.PKIXParameters;

public class AllCertificatesAnyPolicyTest11_1
extends BaseValidTest {
    public AllCertificatesAnyPolicyTest11_1() {
        super(new String[]{"data/certs/AllCertificatesanyPolicyTest11EE.crt", "data/certs/anyPolicyCACert.crt"}, new String[]{"data/crls/anyPolicyCACRL.crl"});
    }

    @Override
    protected void setupAdditionalParams(PKIXParameters params) {
    }
}

