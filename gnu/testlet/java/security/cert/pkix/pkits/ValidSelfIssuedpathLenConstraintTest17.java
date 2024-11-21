/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidSelfIssuedpathLenConstraintTest17
extends BaseValidTest {
    public ValidSelfIssuedpathLenConstraintTest17() {
        super(new String[]{"data/certs/ValidSelfIssuedpathLenConstraintTest17EE.crt", "data/certs/pathLenConstraint1SelfIssuedsubCACert.crt", "data/certs/pathLenConstraint1subCACert.crt", "data/certs/pathLenConstraint1SelfIssuedCACert.crt", "data/certs/pathLenConstraint1CACert.crt"}, new String[]{"data/crls/pathLenConstraint1CACRL.crl", "data/crls/pathLenConstraint1subCACRL.crl"});
    }
}

