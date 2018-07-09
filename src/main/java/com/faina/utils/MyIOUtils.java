package com.faina.utils;

import com.faina.euler13.Main;

import java.io.File;

public class MyIOUtils {

    public static File getFileFromResources(String filename) {
           ClassLoader classLoader = new Main().getClass().getClassLoader();
           return new File(classLoader.getResource(filename).getFile());
    }

}
