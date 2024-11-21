/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidpathLenConstraintTest9
extends BaseInvalidTest {
    public InvalidpathLenConstraintTest9() {
        super(new String[]{"data/certs/InvalidpathLenConstraintTest9EE.crt", "data/certs/pathLenConstraint6subsubCA00Cert.crt", "data/certs/pathLenConstraint6subCA0Cert.crt", "data/certs/pathLenConstraint6CACert.crt"}, new String[]{"data/crls/pathLenConstraint6subsubCA00CRL.crl", "data/crls/pathLenConstraint6subCA0CRL.crl", "data/crls/pathLenConstraint6CACRL.crl"});
    }
}

