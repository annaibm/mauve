/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidcAFalseTest3
extends BaseInvalidTest {
    public InvalidcAFalseTest3() {
        super(new String[]{"data/certs/InvalidcAFalseTest3EE.crt", "data/certs/basicConstraintsNotCriticalcAFalseCACert.crt"}, new String[]{"data/crls/basicConstraintsNotCriticalcAFalseCACRL.crl"});
    }
}

