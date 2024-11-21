/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.management.MBeanServerInvocationHandler;

import gnu.testlet.javax.management.MBeanServerInvocationHandler.ChildMXBean;
import gnu.testlet.javax.management.MBeanServerInvocationHandler.Colour;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.management.ObjectName;

public interface TestCMXBean {
    public int getId();

    public void setId(int var1);

    public Integer getSize();

    public void setSize(Integer var1);

    public ObjectName getName();

    public void setName(ObjectName var1);

    public float[] getWeights();

    public void setWeights(float[] var1);

    public String[] getNames();

    public void setNames(String[] var1);

    public Set<Integer> getAges();

    public void setAges(Set<Integer> var1);

    public SortedSet<String> getBiscuits();

    public void setBiscuits(SortedSet<String> var1);

    public Colour getColour();

    public void setColour(Colour var1);

    public Map<String, Integer> getPhoneNumbers();

    public void setPhoneNumbers(Map<String, Integer> var1);

    public SortedMap<String, Integer> getSortedPhoneNumbers();

    public void setSortedPhoneNumbers(SortedMap<String, Integer> var1);

    public ChildMXBean getChild();

    public void setChild(ChildMXBean var1);
}

