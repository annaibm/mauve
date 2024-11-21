/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidpathLenConstraintTest6
extends BaseInvalidTest {
    public InvalidpathLenConstraintTest6() {
        super(new String[]{"data/certs/InvalidpathLenConstraintTest6EE.crt", "data/certs/pathLenConstraint0subCACert.crt", "data/certs/pathLenConstraint0CACert.crt"}, new String[]{"data/crls/pathLenConstraint0subCACRL.crl", "data/crls/pathLenConstraint0CACRL.crl"});
    }
}

