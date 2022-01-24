package eu.stamp_project.dspot.selector.branchcoverageselector;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import eu.stamp_project.dspot.selector.branchcoverageselector.BranchCoverage;
import eu.stamp_project.dspot.selector.branchcoverageselector.MethodBranchCoverage;
import eu.stamp_project.dspot.selector.branchcoverageselector.Region;
import eu.stamp_project.dspot.selector.branchcoverageselector.ClassBranchCoverage;

public class TestMethodBranchCoverage {
    public final String testMethodName;

    public final Map<String, ClassBranchCoverage> classBranchCoverageList;

    public TestMethodBranchCoverage(String testMethodName) {
        this.testMethodName = testMethodName;
        this.classBranchCoverageList = new ConcurrentHashMap<>();
    }

    public synchronized void addCoverage(String className, String methodName, Region region, int trueHitCount, int falseHitCount) {
        if (!this.classBranchCoverageList.containsKey(className)) {
            this.classBranchCoverageList.put(className, new ClassBranchCoverage(className));
        }
        this.classBranchCoverageList.get(className).addCoverage(methodName, region, trueHitCount, falseHitCount);
    }

    public Set<String> getClasses() {
        return this.classBranchCoverageList.keySet();
    }

    public String getTestMethodName() {
        return testMethodName;
    }

    public Map<String, ClassBranchCoverage> getClassBranchCoverageList() {
        return classBranchCoverageList;
    }

    public Map<String, MethodBranchCoverage> getBranchCoverageForClass(String className) {
        return this.classBranchCoverageList.get(className).getMethodBranchCoverageList();
    }

    @Override
    public String toString() {
        return "TestMethodBranchCoverage{" +
                "testMethodName='" + testMethodName + '\'' +
                ", classBranchCoverageList=" + classBranchCoverageList +
                '}';
    }
}
