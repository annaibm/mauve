/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.ObjectName;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

public class Parsing
implements Testlet {
    @Override
    public void test(TestHarness h) {
        ObjectName name2;
        try {
            h.checkPoint("Default name");
            name2 = new ObjectName("*:*");
            h.check(true);
            h.check(name2.isDomainPattern(), true);
            h.check(name2.isPropertyPattern(), true);
            h.check(name2.isPattern(), true);
            h.check(name2.getDomain(), (Object)"*");
            h.check(name2.getKeyPropertyListString(), (Object)"");
            h.checkPoint("Mixed keys and wildcards");
            name2 = new ObjectName("jboss.management.local:j2eeType=ServiceModule,*,name=jbossmq-httpil.sar");
            h.check(true);
            h.check(name2.isDomainPattern(), false);
            h.check(name2.isPropertyPattern(), true);
            h.check(name2.isPattern(), true);
            h.check(name2.getDomain(), (Object)"jboss.management.local");
            h.check(name2.getKeyPropertyListString(), (Object)"j2eeType=ServiceModule,name=jbossmq-httpil.sar");
            h.checkPoint("Match any domain with specific keys");
            name2 = new ObjectName("*:library=Classpath,project=GNU");
            h.check(true);
            h.check(name2.isDomainPattern(), true);
            h.check(name2.isPropertyPattern(), false);
            h.check(name2.isPattern(), true);
            h.check(name2.getDomain(), (Object)"*");
            h.check(name2.getCanonicalKeyPropertyListString(), (Object)"library=Classpath,project=GNU");
            h.check(name2.getKeyPropertyListString(), (Object)"library=Classpath,project=GNU");
            h.checkPoint("Match any domain with specific keys and wildcard at end");
            name2 = new ObjectName("*:library=Classpath,project=GNU,*");
            h.check(true);
            h.check(name2.isDomainPattern(), true);
            h.check(name2.isPropertyPattern(), true);
            h.check(name2.isPattern(), true);
            h.check(name2.getDomain(), (Object)"*");
            h.check(name2.getKeyPropertyListString(), (Object)"library=Classpath,project=GNU");
            h.checkPoint("Match any domain beginning with 'fs' with specific keys");
            name2 = new ObjectName("fs?:library=Classpath,project=GNU");
            h.check(true);
            h.check(name2.isDomainPattern(), true);
            h.check(name2.isPropertyPattern(), false);
            h.check(name2.isPattern(), true);
            h.check(name2.getDomain(), (Object)"fs?");
            h.check(name2.getKeyPropertyListString(), (Object)"library=Classpath,project=GNU");
            h.checkPoint("Match any domain beginning with 'fs' with specific keys and wildcard at end");
            name2 = new ObjectName("fs?:library=Classpath,project=GNU,*");
            h.check(true);
            h.check(name2.isDomainPattern(), true);
            h.check(name2.isPropertyPattern(), true);
            h.check(name2.isPattern(), true);
            h.check(name2.getDomain(), (Object)"fs?");
            h.check(name2.getKeyPropertyListString(), (Object)"library=Classpath,project=GNU");
            h.checkPoint("Match the FSF domain with specific keys and wildcard at end");
            name2 = new ObjectName("fsf:library=Classpath,project=GNU,*");
            h.check(true);
            h.check(name2.isDomainPattern(), false);
            h.check(name2.isPropertyPattern(), true);
            h.check(name2.isPattern(), true);
            h.check(name2.getDomain(), (Object)"fsf");
            h.check(name2.getKeyPropertyListString(), (Object)"library=Classpath,project=GNU");
            h.checkPoint("Match the FSF domain with specific keys");
            name2 = new ObjectName("fsf:library=Classpath,project=GNU");
            h.check(true);
            h.check(name2.isDomainPattern(), false);
            h.check(name2.isPropertyPattern(), false);
            h.check(name2.isPattern(), false);
            h.check(name2.getDomain(), (Object)"fsf");
            h.check(name2.getKeyPropertyListString(), (Object)"library=Classpath,project=GNU");
            h.checkPoint("Match the FSF domain with specific keys and quoted values");
            name2 = new ObjectName("fsf:library=\"Classpath\",project=GNU");
            h.check(true);
            h.check(name2.isDomainPattern(), false);
            h.check(name2.isPropertyPattern(), false);
            h.check(name2.isPattern(), false);
            h.check(name2.getDomain(), (Object)"fsf");
            h.check(name2.getKeyProperty("library"), (Object)"\"Classpath\"");
            h.check(name2.getKeyPropertyListString(), (Object)"library=\"Classpath\",project=GNU");
            h.checkPoint("Match the FSF domain with specific keys and quoted values with escaped quote");
            name2 = new ObjectName("fsf:library=\"Class\\\"path\",project=GNU");
            h.check(true);
            h.check(name2.isDomainPattern(), false);
            h.check(name2.isPropertyPattern(), false);
            h.check(name2.isPattern(), false);
            h.check(name2.getDomain(), (Object)"fsf");
            h.check(name2.getKeyProperty("library"), (Object)"\"Class\\\"path\"");
            h.check(name2.getKeyPropertyListString(), (Object)"library=\"Class\\\"path\",project=GNU");
            h.checkPoint("Match the FSF domain with specific keys and quoted values with escaped newline");
            name2 = new ObjectName("fsf:library=\"Class\\npath\",project=GNU");
            h.check(true);
            h.check(name2.isDomainPattern(), false);
            h.check(name2.isPropertyPattern(), false);
            h.check(name2.isPattern(), false);
            h.check(name2.getDomain(), (Object)"fsf");
            h.check(name2.getKeyProperty("library"), (Object)"\"Class\\npath\"");
            h.check(name2.getKeyPropertyListString(), (Object)"library=\"Class\\npath\",project=GNU");
            h.checkPoint("Match the FSF domain with specific keys and quoted values with escaped backslash");
            name2 = new ObjectName("fsf:library=\"Class\\\\path\",project=GNU");
            h.check(true);
            h.check(name2.isDomainPattern(), false);
            h.check(name2.isPropertyPattern(), false);
            h.check(name2.isPattern(), false);
            h.check(name2.getDomain(), (Object)"fsf");
            h.check(name2.getKeyProperty("library"), (Object)"\"Class\\\\path\"");
            h.check(name2.getKeyPropertyListString(), (Object)"library=\"Class\\\\path\",project=GNU");
            h.checkPoint("Match the FSF domain with space preservation");
            name2 = new ObjectName("fsf: library = Classpath ");
            h.check(true);
            h.check(name2.isDomainPattern(), false);
            h.check(name2.isPropertyPattern(), false);
            h.check(name2.isPattern(), false);
            h.check(name2.getDomain(), (Object)"fsf");
            h.check(name2.getKeyProperty(" library "), (Object)" Classpath ");
            h.check(name2.getKeyPropertyListString(), (Object)" library = Classpath ");
            h.checkPoint("Key ordering");
            name2 = new ObjectName("fsf:project=GNU,library=Classpath");
            h.check(true);
            h.check(name2.isDomainPattern(), false);
            h.check(name2.isPropertyPattern(), false);
            h.check(name2.isPattern(), false);
            h.check(name2.getDomain(), (Object)"fsf");
            h.check(name2.getCanonicalKeyPropertyListString(), (Object)"library=Classpath,project=GNU");
            h.check(name2.getKeyPropertyListString(), (Object)"project=GNU,library=Classpath");
        }
        catch (MalformedObjectNameException e) {
            h.debug(e);
            h.check(false);
        }
        try {
            name2 = new ObjectName("fsf:lib,rary=Classpath,project=GNU");
            h.fail("Comma allowed in key name");
        }
        catch (MalformedObjectNameException e) {
            h.check(true, "Comma in key name caught");
        }
        try {
            name2 = new ObjectName("fsf:lib=rary=Classpath,project=GNU");
            h.fail("Equals allowed in key name");
        }
        catch (MalformedObjectNameException e) {
            h.check(true, "Equals in key name caught");
        }
        try {
            name2 = new ObjectName("fsf:lib:rary=Classpath,project=GNU");
            h.fail("Colon allowed in key name");
        }
        catch (MalformedObjectNameException e) {
            h.check(true, "Colon in key name caught");
        }
        try {
            name2 = new ObjectName("fsf:lib*rary=Classpath,project=GNU");
            h.fail("Asterisk allowed in key name");
        }
        catch (MalformedObjectNameException e) {
            h.check(true, "Asterisk in key name caught");
        }
        try {
            name2 = new ObjectName("fsf:lib?rary=Classpath,project=GNU");
            h.fail("Question mark allowed in key name");
        }
        catch (MalformedObjectNameException e) {
            h.check(true, "Question mark in key name caught");
        }
        try {
            name2 = new ObjectName("fsf:library=Classpath,library=Sun,project=GNU");
            h.fail("Duplicate key allowed");
        }
        catch (MalformedObjectNameException e) {
            h.check(true, "Duplicate key caught");
        }
        try {
            name2 = new ObjectName("fsf:library=Clas,path,project=GNU");
            h.fail("Comma allowed in unquoted value");
        }
        catch (MalformedObjectNameException e) {
            h.check(true, "Comma in unquoted value caught");
        }
        try {
            name2 = new ObjectName("fsf:library=Clas=path,project=GNU");
            h.fail("Equals allowed in unquoted value");
        }
        catch (MalformedObjectNameException e) {
            h.check(true, "Equals in unquoted value caught");
        }
        try {
            name2 = new ObjectName("fsf:library=Clas:path,project=GNU");
            h.fail("Colon allowed in unquoted value");
        }
        catch (MalformedObjectNameException e) {
            h.check(true, "Colon in unquoted value caught");
        }
        try {
            name2 = new ObjectName("fsf:library=Clas\"path,project=GNU");
            h.fail("Quote allowed in unquoted value");
        }
        catch (MalformedObjectNameException e) {
            h.check(true, "Quote in unquoted value caught");
        }
        try {
            name2 = new ObjectName("fsf:library=\"Classpath,project=GNU");
            h.fail("Unclosed quotes allowed");
        }
        catch (MalformedObjectNameException e) {
            h.check(true, "Unclosed quotes caught");
        }
        try {
            name2 = new ObjectName("fsf:library=\"Class\"path\",project=GNU");
            h.debug(name2.getKeyProperty("library"));
            h.fail("Unescaped quote allowed");
        }
        catch (MalformedObjectNameException e) {
            h.check(true, "Unescaped quote caught");
        }
        try {
            name2 = new ObjectName("fsf:");
            h.fail("Non-pattern with no keys allowed");
        }
        catch (MalformedObjectNameException e) {
            h.check(true, "Non-pattern with no keys caught");
        }
        try {
            name2 = new ObjectName("fsf:*,*");
            h.fail("Pattern with multiple asterisks in properties allowed");
        }
        catch (MalformedObjectNameException e) {
            h.check(true, "Pattern with multiple asterisks in properties caught");
        }
        try {
            name2 = new ObjectName("f\nsf:library=Classpath");
            h.fail("Domain with newline allowed");
        }
        catch (MalformedObjectNameException e) {
            h.check(true, "Domain with newline caught");
        }
        try {
            name2 = new ObjectName("fsf:lib\nrary=Classpath");
            h.fail("Key with newline allowed");
        }
        catch (MalformedObjectNameException e) {
            h.check(true, "Key with newline caught");
        }
        try {
            name2 = new ObjectName("fsf:library=Class\npath");
            h.fail("Unquoted value with newline allowed");
        }
        catch (MalformedObjectNameException e) {
            h.check(true, "Unquoted value with newline caught");
        }
        try {
            name2 = new ObjectName("fsf:library=\"Class\npath\"");
            h.fail("Quoted value with newline allowed");
        }
        catch (MalformedObjectNameException e) {
            h.check(true, "Quoted value with newline caught");
        }
    }
}

