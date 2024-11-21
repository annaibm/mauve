/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.security.cert.pkix.pkits;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.security.cert.pkix.pkits.PKITS;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertStore;
import java.security.cert.CertStoreParameters;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;

public abstract class BaseInvalidTest
extends PKITS
implements Testlet {
    public static final String PROVIDER = System.getProperty("pkits.provider", "GNU");
    public static final String TRUST_ANCHOR_CERT = "data/certs/TrustAnchorRootCertificate.crt";
    public static final String TRUST_ANCHOR_CRL = "data/crls/TrustAnchorRootCRL.crl";
    protected String[] certPath;
    protected String[] crls;
    protected String[] certs;

    protected BaseInvalidTest(String[] certPath, String[] crls, String[] certs) {
        if (certPath == null || crls == null || certs == null) {
            throw new NullPointerException();
        }
        this.certPath = certPath;
        this.crls = crls;
        this.certs = certs;
    }

    protected BaseInvalidTest(String[] certPath, String[] crls) {
        this(certPath, crls, new String[0]);
    }

    @Override
    public void test(TestHarness harness) {
        String testName2 = this.getClass().getName();
        if (testName2.lastIndexOf(46) > 0) {
            testName2 = testName2.substring(testName2.lastIndexOf(46) + 1);
        }
        harness.checkPoint(testName2);
        try {
            int i;
            CertificateFactory factory = CertificateFactory.getInstance("X.509", PROVIDER);
            TrustAnchor anchor = new TrustAnchor((X509Certificate)factory.generateCertificate(this.getClass().getResourceAsStream(TRUST_ANCHOR_CERT)), null);
            ArrayList<Certificate> pathList = new ArrayList<Certificate>(this.certPath.length);
            for (int i2 = 0; i2 < this.certPath.length; ++i2) {
                pathList.add(factory.generateCertificate(this.getClass().getResourceAsStream(this.certPath[i2])));
            }
            ArrayList<Object> crlsAndCerts = new ArrayList<Object>(this.crls.length + this.certs.length + 1);
            crlsAndCerts.add(factory.generateCRL(this.getClass().getResourceAsStream(TRUST_ANCHOR_CRL)));
            for (i = 0; i < this.crls.length; ++i) {
                crlsAndCerts.add(factory.generateCRL(this.getClass().getResourceAsStream(this.crls[i])));
            }
            for (i = 0; i < this.certs.length; ++i) {
                crlsAndCerts.add(factory.generateCertificate(this.getClass().getResourceAsStream(this.certs[i])));
            }
            CertPath path = factory.generateCertPath(pathList);
            CertStore certStore = CertStore.getInstance("Collection", (CertStoreParameters)new CollectionCertStoreParameters(crlsAndCerts), PROVIDER);
            PKIXParameters params = new PKIXParameters(Collections.singleton(anchor));
            params.addCertStore(certStore);
            params.setExplicitPolicyRequired(false);
            params.setInitialPolicies(Collections.singleton("2.5.29.32.0"));
            params.setPolicyMappingInhibited(false);
            params.setAnyPolicyInhibited(false);
            this.setupAdditionalParams(params);
            CertPathValidator validator = CertPathValidator.getInstance("PKIX", PROVIDER);
            try {
                CertPathValidatorResult result = validator.validate(path, params);
                harness.verbose(((PKIXCertPathValidatorResult)result).getPolicyTree().toString());
                harness.check(false);
            }
            catch (CertPathValidatorException expected) {
                harness.verbose("expected failure reason is: " + expected);
                harness.check(true);
            }
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail(x.toString());
        }
    }

    protected void setupAdditionalParams(PKIXParameters params) {
    }
}

