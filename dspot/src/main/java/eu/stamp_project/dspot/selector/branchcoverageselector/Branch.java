package eu.stamp_project.dspot.selector.branchcoverageselector;

public class Branch {
    String className;
    String methodName;
    String testClass;
    String line;
    String symbol;
    public Branch(String className, String methodName, String testClass, String line, String symbol){
        this.className = className;
        this.methodName = methodName;
        this.testClass = testClass;
        this.line = line;
        this.symbol = symbol;
    }

    public String toString(){
        return className+","+methodName.substring(0,methodName.indexOf("("))+","+testClass+","+line+","+symbol;
    }
}
