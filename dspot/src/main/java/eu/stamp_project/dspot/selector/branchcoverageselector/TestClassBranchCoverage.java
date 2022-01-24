package eu.stamp_project.dspot.selector.branchcoverageselector;

import eu.stamp_project.dspot.selector.branchcoverageselector.TestMethodBranchCoverage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TestClassBranchCoverage {
    public final String testClassName;

    public final Map<String, TestMethodBranchCoverage> testMethodsBranchCoverage;

    public TestClassBranchCoverage(String testClassName) {
        this.testClassName = testClassName;
        this.testMethodsBranchCoverage = new ConcurrentHashMap<>();
    }

    public synchronized void addCoverage(String testMethodName, String className, String methodName, Region region, int trueHitCount, int falseHitCount) {
        if (!this.testMethodsBranchCoverage.containsKey(testMethodName)) {
            this.testMethodsBranchCoverage.put(testMethodName, new TestMethodBranchCoverage(testMethodName));
        }
        this.testMethodsBranchCoverage.get(testMethodName).addCoverage(className, methodName, region, trueHitCount, falseHitCount);
    }

    public Set<String> getTestMethods() {
        return this.testMethodsBranchCoverage.keySet();
    }

    public Set<String> getClassesForTestMethodName(String testMethodName) {
        return this.testMethodsBranchCoverage.get(testMethodName).getClasses();
    }

    public Map<String, MethodBranchCoverage> getCoverageForTestMethodAndClassNames(String testMethodName, String className) {
        return this.testMethodsBranchCoverage.get(testMethodName).getBranchCoverageForClass(className);
    }

    public Map<String, ClassBranchCoverage> getTestMethodCoverage(String testMethodName) {
        return this.testMethodsBranchCoverage.get(testMethodName).getClassBranchCoverageList();
    }

    @Override
    public String toString() {
        return "TestClassBranchCoverage{" +
                "testClassName='" + testClassName + '\'' +
                ", testMethodsBranchCoverage=" + testMethodsBranchCoverage +
                '}';
    }
}
