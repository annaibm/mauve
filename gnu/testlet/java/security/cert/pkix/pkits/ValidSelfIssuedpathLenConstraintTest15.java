/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidSelfIssuedpathLenConstraintTest15
extends BaseValidTest {
    public ValidSelfIssuedpathLenConstraintTest15() {
        super(new String[]{"data/certs/ValidSelfIssuedpathLenConstraintTest15EE.crt", "data/certs/pathLenConstraint0SelfIssuedCACert.crt", "data/certs/pathLenConstraint0CACert.crt"}, new String[]{"data/crls/pathLenConstraint0CACRL.crl"});
    }
}

