/*
 * Decompiled with CFR 0.152.
 */
package junit.textui;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.runner.BaseTestRunner;

public class TestRunner
extends BaseTestRunner {
    public static void run(Class<?> testClass) {
        TestRunner.run(new TestSuite(testClass));
    }

    public static void run(Test test) {
    }
}

