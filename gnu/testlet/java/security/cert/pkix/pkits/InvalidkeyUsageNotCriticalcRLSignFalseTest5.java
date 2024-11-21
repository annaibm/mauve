/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.java.security.cert.pkix.pkits.BaseInvalidTest;

public class InvalidkeyUsageNotCriticalcRLSignFalseTest5
extends BaseInvalidTest {
    public InvalidkeyUsageNotCriticalcRLSignFalseTest5() {
        super(new String[]{"data/certs/InvalidkeyUsageNotCriticalcRLSignFalseTest5EE.crt", "data/certs/keyUsageNotCriticalcRLSignFalseCACert.crt"}, new String[]{"data/crls/keyUsageNotCriticalcRLSignFalseCACRL.crl"});
    }
}

