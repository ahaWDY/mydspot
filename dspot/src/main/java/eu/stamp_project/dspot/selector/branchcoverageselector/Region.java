package eu.stamp_project.dspot.selector.branchcoverageselector;

public class Region {
    public final int startLine;

    public final int startColumn;

    public final int endLine;

    public final int endColumn;

    public Region(int startLine, int startColumn, int endLine, int endColumn){
        this.startLine = startLine;
        this.startColumn = startColumn;
        this.endLine = endLine;
        this.endColumn = endColumn;
    }
    @Override
    public String toString() {
        return "Region{" + startLine + ","+startColumn+","+endLine+","+endColumn+ "}";
    }

}
