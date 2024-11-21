/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidpathLenConstraintTest5
extends BaseInvalidTest {
    public InvalidpathLenConstraintTest5() {
        super(new String[]{"data/certs/InvalidpathLenConstraintTest5EE.crt", "data/certs/pathLenConstraint0subCACert.crt", "data/certs/pathLenConstraint0CACert.crt"}, new String[]{"data/crls/pathLenConstraint0subCACRL.crl", "data/crls/pathLenConstraint0CACRL.crl"});
    }
}

