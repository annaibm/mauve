/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;
import java.security.cert.PKIXParameters;
import java.util.Collections;

public class OverlappingPoliciesTest6_3
extends BaseInvalidTest {
    public OverlappingPoliciesTest6_3() {
        super(new String[]{"data/certs/OverlappingPoliciesTest6EE.crt", "data/certs/PoliciesP1234subsubCAP123P12Cert.crt", "data/certs/PoliciesP1234subCAP123Cert.crt", "data/certs/PoliciesP1234CACert.crt"}, new String[]{"data/crls/PoliciesP1234subsubCAP123P12CRL.crl", "data/crls/PoliciesP1234subCAP123CRL.crl", "data/crls/PoliciesP1234CACRL.crl"});
    }

    @Override
    protected void setupAdditionalParams(PKIXParameters params) {
        params.setExplicitPolicyRequired(true);
        params.setInitialPolicies(Collections.singleton("2.16.840.1.101.3.2.1.48.2"));
    }
}

