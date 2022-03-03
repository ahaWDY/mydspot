package eu.stamp_project.dspot.selector.branchcoverageselector.clover;

import eu.stamp_project.dspot.selector.branchcoverageselector.Branch;
import eu.stamp_project.dspot.selector.branchcoverageselector.Coverage;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.*;

public class CloverReaderTest {

    @Test
    public void read() throws IOException {
        CloverReader cloverReader = new CloverReader();
        Coverage coverage = cloverReader.read("F:\\javapoet");

        Set<String> result = cloverReader.scan("F:\\javapoet");

        String[] branches = new String[result.size()];

        result.toArray(branches);

        System.out.println("Totoal public branch number: "+branches.length);

        Set<Integer> samples = new HashSet<>();
        Random ran=new Random();
        ran.setSeed(0);
        while(samples.size()<100){
            int sample = ran.nextInt(branches.length);
            samples.add(sample);
        }

        String[] sampleBranches = new String[100];
        int index=0;
        for(int sample: samples){
            sampleBranches[index] = branches[sample];
            index++;
        }

        //write branches
        File fileBranch = new File("F:\\javapoet\\publicBranches.txt");  //存放数组数据的文件

        FileWriter outBranch = new FileWriter(fileBranch);  //文件写入流

        for(int i=0;i<branches.length;i++){
            outBranch.write((branches[i]));
            outBranch.write("\n");
        }
        outBranch.close();


        File file = new File("F:\\javapoet\\publicSamples.txt");  //存放数组数据的文件

        FileWriter out = new FileWriter(file);  //文件写入流

        for(int i=0;i<sampleBranches.length;i++){
            out.write((sampleBranches[i]));
            out.write("\n");
        }
        out.close();


//        File writeFile = new File("F:\\javapoet\\branches.csv");
//        try{
//            BufferedWriter writeText = new BufferedWriter(new FileWriter(writeFile));
//            for(int i=0;i<branches.length;i++){
//                writeText.newLine();
//                writeText.write(((Branch)branches[i]).toString());
//            }
//            writeText.flush();
//            writeText.close();
//        }catch (FileNotFoundException e){
//            System.out.println("没有找到指定文件");
//        }catch (IOException e){
//            System.out.println("文件读写出错");
//        }
    }
}