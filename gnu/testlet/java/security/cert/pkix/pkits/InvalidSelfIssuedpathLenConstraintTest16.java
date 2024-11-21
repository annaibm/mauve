/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidSelfIssuedpathLenConstraintTest16
extends BaseInvalidTest {
    public InvalidSelfIssuedpathLenConstraintTest16() {
        super(new String[]{"data/certs/InvalidSelfIssuedpathLenConstraintTest16EE.crt", "data/certs/pathLenConstraint0subCA2Cert.crt", "data/certs/pathLenConstraint0SelfIssuedCACert.crt", "data/certs/pathLenConstraint0CACert.crt"}, new String[]{"data/crls/pathLenConstraint0CACRL.crl", "data/crls/pathLenConstraint0subCA2CRL.crl"});
    }
}

