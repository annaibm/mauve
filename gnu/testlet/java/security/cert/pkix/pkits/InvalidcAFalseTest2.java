/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidcAFalseTest2
extends BaseInvalidTest {
    public InvalidcAFalseTest2() {
        super(new String[]{"data/certs/InvalidcAFalseTest2EE.crt", "data/certs/basicConstraintsCriticalcAFalseCACert.crt"}, new String[]{"data/crls/basicConstraintsCriticalcAFalseCACRL.crl"});
    }
}

