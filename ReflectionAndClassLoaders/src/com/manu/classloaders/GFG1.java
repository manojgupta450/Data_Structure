package com.manu.classloaders;

// Java program to load resources from Classpath using getResourceAsStream() method.

import java.io.*;

public class GFG1 {

    public static void main(String[] args) throws Exception {

        GFG1 obj = new GFG1();

        // name of the resource the resource is stored in our base path of the .class file.
        String fileName = "GFG_text.txt";
        System.out.println("Getting the data of file " + fileName);

        // declaring the input stream and initializing the stream.
        InputStream inputStream = obj.getClass().getClassLoader().getResourceAsStream(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;

        // outputting each line of the file.
        while ((line = bufferedReader.readLine()) != null)
            System.out.println(line);
    }
}
