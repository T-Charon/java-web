package com.blb.thread01;

/**
 * @Author Charon
 * @Date 2022/7/27
 **/

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * 实现一个线程，用于扫描某个目录下的所有文本文件（包括：java、txt、html），并将文字内容打印出来。
 */
public class Test02 {
    private static String[] type = {"java", "txt", "html", "jpg","xml"};

    public static void main(String[] args) {
        new Thread(() -> {
            File file = new File("C:\\javacode");
            getFiles(file);
        }).start();
    }

    private static void getFiles(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            Arrays.stream(files).forEach(a -> getFiles(a));
        } else {
            String fileName = file.getName();
            String name = file.getName();
            List<String> stringList = Arrays.asList(type);
            if (stringList.contains(fileName.substring(fileName.lastIndexOf(".") + 1))) {
                System.out.println(name);
            }
        }
    }
}
