package eu.stamp_project.dspot.selector.branchcoverageselector;

import eu.stamp_project.dspot.selector.branchcoverageselector.MethodBranchCoverage;
import eu.stamp_project.dspot.selector.branchcoverageselector.Region;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClassBranchCoverage {
    public final String className;

    public final Map<String, MethodBranchCoverage> methodBranchCoverageList;

    public ClassBranchCoverage(String className) {
        this.className = className;
        this.methodBranchCoverageList = new ConcurrentHashMap<>();
    }

    public void addCoverage(String methodName, Region region, int trueHitCount, int falseHitcount) {
        if(!this.methodBranchCoverageList.containsKey("methodName")) {
            methodBranchCoverageList.put(methodName, new MethodBranchCoverage(methodName));
        }
        this.methodBranchCoverageList.get(methodName).addCoverage(region, trueHitCount, falseHitcount);
    }

    public Map<String, MethodBranchCoverage> getMethodBranchCoverageList() {
        return methodBranchCoverageList;
    }

    public MethodBranchCoverage getBranchCoverageForMethod(String methodName){
        return methodBranchCoverageList.get(methodName);
    }

    @Override
    public String toString() {
        return "ClassBranchCoverage{" +
                "className='" + className + '\'' +
                ", classBranchCoverages=" + methodBranchCoverageList +
                '}';
    }
}
