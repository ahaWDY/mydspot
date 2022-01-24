package eu.stamp_project.dspot.selector.branchcoverageselector;

public class BranchCoverage {
    public Region region;

    public final int trueHitCount;

    public final int falseHitCount;

    public BranchCoverage(Region region, int trueHitCount, int falseHitCount) {
        this.region = region;
        this.trueHitCount = trueHitCount;
        this.falseHitCount = falseHitCount;
    }

    public Region getRegion() {
        return region;
    }

    public int getTrueHitCount() {
        return trueHitCount;
    }

    public int getFalseHitCount() {
        return falseHitCount;
    }

    @Override
    public String toString() {
        return "BranchCoverage{" + "region=" + region +
                 "trueHitCount=" + trueHitCount + ", falseHitCount=" + falseHitCount +
                '}';
    }
}
