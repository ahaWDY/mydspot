package eu.stamp_project;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MainTestSamples {

    @Test
    public void main() throws IOException {
        Path path = Paths.get("F:\\javapoet\\publicSamples.txt");
        List<String> lines = Files.readAllLines(path);
        String[] parameters = new String[]{
                "--absolute-path-to-project-root", "F:\\javapoet",
                "--test-criterion", "BranchCoverageSelector",
//                "--amplifiers", "TargetMethodAdderOnExistingObjectsAmplifier,MethodDuplicationAmplifier,MethodRemove,FastLiteralAmplifier,MethodAdderOnExistingObjectsAmplifier,ReturnValueAmplifier,NullifierAmplifier,ArrayAmplifier",
                "--amplifiers", "MethodDuplicationAmplifier,MethodRemove,FastLiteralAmplifier,MethodAdderOnExistingObjectsAmplifier,ReturnValueAmplifier,NullifierAmplifier,ArrayAmplifier",
                "--iteration", "1",
                "--test","",
                "--test-cases","",
                "--output-directory", "F:\\javapoet\\target\\dspot\\output",
                "--with-comment","All",
                "--dev-friendly",
                "--verbose",
                "--clean",
                "--target-class","",
                "--target-method","",
                "--target-branch","",
                "--relative-path-to-classes","target\\classes\\",
                "--relative-path-to-test-classes","target\\test-classes\\",
                "--automatic-builder","Maven",
                "--max-test-amplified", "200"
        };
        Map<String, String> testCases = new HashMap<String, String>(){{
            put("AnnotationSpec","equalsAndHashCode");
            put("TypeName","genericType");
            put("ClassName", "bestGuessNonAscii");
            put("CodeBlock", "equalsAndHashCode");
            put("CodeWriter", "emptyLineInJavaDocDosEndings");
            put("FieldSpec", "equalsAndHashCode");
            put("JavaFile", "importStaticReadmeExample");
            put("LineWrapper", "wrap" );
            put("MethodSpec", "nullAnnotationsAddition");
            put("NameAllocator", "usage");
            put("ParameterSpec", "equalsAndHashCode");
            put("TypeSpec", "basic");
            put("Util", "stringLiteral");
        }};
        for(int i=0; i<36; i++) {
            String file = "F:\\javapoet\\publicResultNormal.txt";  //存放数组数据的文件
            FileWriter out = new FileWriter(file,true);  //文件写入流
            out.write(i+",");
            out.close();

            String[] information = lines.get(i).split(",");
            String className = "com.squareup.javapoet."+information[0];
            String targetMethod = information[1];
            String targetBranch = information[2];
            String testClassName = className+"Test";
            String testCase = testCases.get(information[0]);
            parameters[9] = testClassName;
            parameters[11] = testCase;
            parameters[20] = className;
            parameters[22] = targetMethod;
            parameters[24] = targetBranch;
            Main.main(parameters);
        }
    }
}