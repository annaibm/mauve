/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;
import java.security.cert.PKIXParameters;
import java.util.Collections;

public class DifferentPoliciesTest4
extends BaseInvalidTest {
    public DifferentPoliciesTest4() {
        super(new String[]{"data/certs/DifferentPoliciesTest4EE.crt", "data/certs/GoodsubCACert.crt", "data/certs/GoodCACert.crt"}, new String[]{"data/crls/GoodsubCACRL.crl", "data/crls/GoodCACRL.crl"});
    }

    @Override
    protected void setupAdditionalParams(PKIXParameters params) {
        params.setInitialPolicies(Collections.EMPTY_SET);
        params.setAnyPolicyInhibited(true);
    }
}

