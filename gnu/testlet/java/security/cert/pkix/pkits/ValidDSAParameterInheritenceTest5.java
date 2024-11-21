/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidDSAParameterInheritenceTest5
extends BaseValidTest {
    public ValidDSAParameterInheritenceTest5() {
        super(new String[]{"data/certs/ValidDSAParameterInheritanceTest5EE.crt", "data/certs/DSAParametersInheritedCACert.crt", "data/certs/DSACACert.crt"}, new String[]{"data/crls/DSACACRL.crl", "data/crls/DSAParametersInheritedCACRL.crl"});
    }
}

