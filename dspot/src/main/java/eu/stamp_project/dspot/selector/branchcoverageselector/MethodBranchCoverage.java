package eu.stamp_project.dspot.selector.branchcoverageselector;

import java.util.ArrayList;
import java.util.List;

public class MethodBranchCoverage {
    public final String methodName;

    public final List<BranchCoverage> branchCoverageList;

    public MethodBranchCoverage(String methodName){
        this.methodName = methodName;
        this.branchCoverageList = new ArrayList<>();
    }

    public void addCoverage(Region region, int trueHitCount, int falseHitCount) {
        this.branchCoverageList.add(new BranchCoverage(region, trueHitCount, falseHitCount));
    }

    public List<BranchCoverage> getCoverages() {
        return this.branchCoverageList;
    }

    public boolean contains(Region region) {
        return this.branchCoverageList.stream().anyMatch(BranchCoverage -> BranchCoverage.region == region);
    }

    public String toString() {
        return "MethodBranchCoverage{" +
                "methodName='" + methodName + '\'' +
                ", methodBranchCoverages=" + branchCoverageList +
                '}';
    }

}
