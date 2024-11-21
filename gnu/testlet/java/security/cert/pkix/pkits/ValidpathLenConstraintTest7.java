/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidpathLenConstraintTest7
extends BaseValidTest {
    public ValidpathLenConstraintTest7() {
        super(new String[]{"data/certs/ValidpathLenConstraintTest7EE.crt", "data/certs/pathLenConstraint0CACert.crt"}, new String[]{"data/crls/pathLenConstraint0CACRL.crl"});
    }
}

