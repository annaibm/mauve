/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseValidTest;

public class ValidbasicConstraintsNotCriticalTest4
extends BaseValidTest {
    public ValidbasicConstraintsNotCriticalTest4() {
        super(new String[]{"data/certs/ValidbasicConstraintsNotCriticalTest4EE.crt", "data/certs/basicConstraintsNotCriticalCACert.crt"}, new String[]{"data/crls/basicConstraintsNotCriticalCACRL.crl"});
    }
}

