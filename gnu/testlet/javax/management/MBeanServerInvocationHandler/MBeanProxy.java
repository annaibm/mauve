/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.MBeanServerInvocationHandler;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.management.MBeanServerInvocationHandler.ChildMXBean;
import gnu.testlet.javax.management.MBeanServerInvocationHandler.Colour;
import gnu.testlet.javax.management.MBeanServerInvocationHandler.Test;
import gnu.testlet.javax.management.MBeanServerInvocationHandler.TestC;
import gnu.testlet.javax.management.MBeanServerInvocationHandler.TestCMXBean;
import gnu.testlet.javax.management.MBeanServerInvocationHandler.TestMBean;
import gnu.testlet.javax.management.MBeanServerInvocationHandler.TestX;
import gnu.testlet.javax.management.MBeanServerInvocationHandler.TestXMBean;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.management.JMX;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

public class MBeanProxy
implements Testlet {
    @Override
    public void test(TestHarness h) {
        ObjectName name2 = null;
        ObjectName namex = null;
        ObjectName namec = null;
        ObjectName namecc = null;
        try {
            name2 = new ObjectName("mauve:test=go");
            namex = new ObjectName("mauve:test=gox");
            namec = new ObjectName("mauve:test=goc");
            namecc = new ObjectName("mauve:test=gocc");
        }
        catch (MalformedObjectNameException e) {
            h.debug(e);
        }
        MBeanServer server = MBeanServerFactory.createMBeanServer();
        try {
            server.registerMBean(new Test("GNU Classpath"), name2);
            server.registerMBean(new TestX("GNU Classpath"), namex);
            server.registerMBean(new TestC(), namec);
        }
        catch (Exception e) {
            h.debug(e);
        }
        TestMBean test = JMX.newMBeanProxy(server, name2, TestMBean.class);
        h.check(test.getName(), "GNU Classpath", "Name test");
        h.check(test.isEdible(), false, "Edible test");
        h.checkPoint("Mutator test");
        test.setName("Mauve");
        h.check(test.getName(), "Mauve", "Name test after change");
        h.check(test.equals(test), "Proxy equivalence reflection test");
        TestXMBean testx = JMX.newMBeanProxy(server, namex, TestXMBean.class);
        h.checkPoint("Calling equals");
        testx.equals(null);
        h.check(testx.getLastMethodCalled(), (Object)"equals");
        h.checkPoint("Calling hashCode");
        testx.hashCode();
        h.check(testx.getLastMethodCalled(), (Object)"hashCode");
        h.checkPoint("Calling toString");
        testx.toString();
        h.check(testx.getLastMethodCalled(), (Object)"toString");
        final TestCMXBean testc = JMX.newMXBeanProxy(server, namec, TestCMXBean.class);
        h.checkPoint("Setting id");
        testc.setId(42);
        h.check(testc.getId(), 42, "Getting id");
        h.checkPoint("Setting size");
        testc.setSize(5);
        h.check(testc.getSize() == 5, "Getting size");
        h.checkPoint("Setting name");
        testc.setName(namec);
        h.check(testc.getName(), namec, "Getting name");
        h.checkPoint("Setting weights");
        float[] weights = new float[]{0.5f, -0.7f};
        testc.setWeights(weights);
        h.check(testc.getWeights(), weights, "Getting weights");
        h.checkPoint("Setting names");
        String[] names = new String[]{"Bob", "Jim", "Jake"};
        testc.setNames(names);
        h.check(testc.getNames(), names, "Getting names");
        h.checkPoint("Setting ages");
        HashSet<Integer> ages = new HashSet<Integer>();
        ages.add(45);
        ages.add(24);
        testc.setAges(ages);
        h.check(testc.getAges(), ages, "Getting ages");
        h.checkPoint("Setting biscuits");
        TreeSet<String> biscuits = new TreeSet<String>();
        biscuits.add("Chocolate");
        biscuits.add("Ginger");
        biscuits.add("Plain");
        testc.setBiscuits(biscuits);
        h.check(testc.getBiscuits(), biscuits, "Getting biscuits");
        h.checkPoint("Setting colour");
        testc.setColour(Colour.RED);
        h.check((Object)testc.getColour(), (Object)Colour.RED, "Getting colour");
        h.checkPoint("Setting phone numbers");
        HashMap<String, Integer> numbers = new HashMap<String, Integer>();
        numbers.put("Bob", 999);
        numbers.put("Jim", 111);
        numbers.put("Sam", 55);
        testc.setPhoneNumbers(numbers);
        h.check(testc.getPhoneNumbers(), numbers, "Getting phone numbers");
        h.checkPoint("Setting sorted phone numbers");
        TreeMap<String, Integer> snumbers = new TreeMap<String, Integer>();
        snumbers.put("Bob", 999);
        snumbers.put("Jim", 111);
        snumbers.put("Sam", 55);
        testc.setSortedPhoneNumbers(snumbers);
        h.check(testc.getSortedPhoneNumbers(), numbers, "Getting sorted phone numbers");
        h.checkPoint("Creating and setting child");
        ChildMXBean child = new ChildMXBean(){

            @Override
            public TestCMXBean getParent() {
                return testc;
            }

            @Override
            public void setParent(TestCMXBean bean) {
            }
        };
        try {
            server.registerMBean(child, namecc);
        }
        catch (Exception e) {
            h.debug(e);
        }
        ChildMXBean cproxy = JMX.newMXBeanProxy(server, namecc, ChildMXBean.class);
        testc.setChild(cproxy);
        h.check(testc.getChild(), cproxy, "Getting child");
    }
}

