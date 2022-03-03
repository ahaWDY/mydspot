package eu.stamp_project.dspot.selector.branchcoverageselector.clover;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class CloverExecutorTest {

    @Test
    public void instrumentAndRunGivenTest() {
//        List<String> testBody = Arrays.asList("html", "hasValue");
//        Map<String, List<String>> test = new HashMap<String, List<String>>();
//        test.put("AttributeTest", testBody);
        new CloverExecutor().instrumentAndRunTest("F:\\javapoet");
//        new CloverExecutor().instrumentAndRunGivenTestClass("F:\\jsoup","AttributeTest");
    }
}