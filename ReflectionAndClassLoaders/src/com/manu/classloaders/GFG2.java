package com.manu.classloaders;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

//save file as the name of GFG2
public class GFG2 {

    public static void main(String[] args) throws Exception {

        // creating object of the class important since the getClass() method is not static.
        GFG2 obj = new GFG2();

        // name of the resource which is stored in our base path of the .class file.
        String fileName = "GFG_text.txt";
        System.out.println("Getting the data of file " + fileName);

        // getting the URL of the resource and creating a file object to the given URL
        URL url = obj.getClass().getClassLoader().getResource(fileName);
        File file = new File(url.toURI());

        // reading the file data by creating a list of strings of each line
        List<String> line;
        // method of files class to read all the lines of the file specified.
        line = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

        // reading the list of the line in the file.
        for(String s: line)
            System.out.println(s);
    }
}
