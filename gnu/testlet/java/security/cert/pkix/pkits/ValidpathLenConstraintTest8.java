/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidpathLenConstraintTest8
extends BaseValidTest {
    public ValidpathLenConstraintTest8() {
        super(new String[]{"data/certs/ValidpathLenConstraintTest8EE.crt", "data/certs/pathLenConstraint0CACert.crt"}, new String[]{"data/crls/pathLenConstraint0CACRL.crl"});
    }
}

