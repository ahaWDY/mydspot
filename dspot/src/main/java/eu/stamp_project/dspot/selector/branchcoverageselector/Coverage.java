package eu.stamp_project.dspot.selector.branchcoverageselector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Coverage {
    public void clear() {
        this.testClassBranchCoverageMap.clear();
    }

    public int size() {
        return this.testClassBranchCoverageMap.size();
    }

    public final Map<String, TestClassBranchCoverage> testClassBranchCoverageMap;

    public Coverage() {
        this.testClassBranchCoverageMap = new ConcurrentHashMap<>();
    }

    public synchronized void addCoverage(String testClassName, String testMethodName, String className, String methodName, Region region, int trueHitCount, int falseHitCount) {
        if (!this.testClassBranchCoverageMap.containsKey(testClassName)) {
            this.testClassBranchCoverageMap.put(testClassName, new TestClassBranchCoverage(testClassName));
        }
        this.testClassBranchCoverageMap.get(testClassName).addCoverage(testMethodName, className, methodName, region, trueHitCount, falseHitCount);
    }

    public Set<String> getTestClasses() {
        return this.testClassBranchCoverageMap.keySet();
    }

    public Set<String> getClassesForTestClassAndMethodName(String testClassName, String testMethodName) {
        return this.testClassBranchCoverageMap.get(testClassName).getClassesForTestMethodName(testMethodName);
    }

    public Set<String> getTestMethodsForTestClassName(String testClassName) {
        return this.testClassBranchCoverageMap.get(testClassName).getTestMethods();
    }

    public Map<String, MethodBranchCoverage> getCoverageForTestClassTestMethodAndClassName(String testClassName, String testMethodName, String className) {
        return this.testClassBranchCoverageMap.get(testClassName).getCoverageForTestMethodAndClassNames(testMethodName, className);
    }

    public Map<String, ClassBranchCoverage> getTestMethodCoverageForClassName(String testClassName, String testMethodName) {
        return this.testClassBranchCoverageMap.get(testClassName).getTestMethodCoverage(testMethodName);
    }

    public List<BranchCoverage> getBranchCoverageForTestClassTestMethodAndClassNameMethodName(String testClassName, String testMethodName, String className, String methodName){
        return this.testClassBranchCoverageMap.get(testClassName).getCoverageForTestMethodAndClassNames(testMethodName,className).get(methodName).getCoverages();
    }

    @Override
    public String toString() {
        return "Coverage{" +
                "testClassCoverage=" + testClassBranchCoverageMap.toString() +
                '}';
    }
}
