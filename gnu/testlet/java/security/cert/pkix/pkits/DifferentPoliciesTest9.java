/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;
import java.security.cert.PKIXParameters;
import java.util.Collections;

public class DifferentPoliciesTest9
extends BaseInvalidTest {
    public DifferentPoliciesTest9() {
        super(new String[]{"data/certs/DifferentPoliciesTest9EE.crt", "data/certs/PoliciesP123subsubsubCAP12P2P1Cert.crt", "data/certs/PoliciesP123subsubCAP12P1Cert.crt", "data/certs/PoliciesP123subCAP12Cert.crt", "data/certs/PoliciesP123CACert.crt"}, new String[]{"data/crls/PoliciesP123subsubsubCAP12P2P1CRL.crl", "data/crls/PoliciesP123subsubCAP12P1CRL.crl", "data/crls/PoliciesP123subCAP12CRL.crl", "data/crls/PoliciesP123CACRL.crl"});
    }

    @Override
    protected void setupAdditionalParams(PKIXParameters params) {
        params.setInitialPolicies(Collections.EMPTY_SET);
        params.setAnyPolicyInhibited(true);
    }
}

