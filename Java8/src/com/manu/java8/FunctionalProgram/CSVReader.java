package com.manu.java8.FunctionalProgram;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static void main(String[] args) {

        String csvFile = "C:/Users/manogupta/Desktop/Orange_Telecom_Churn_Data.csv";  
        BufferedReader br = null;
        String intl_plan = "intl_plan";
        List<Long> list=new ArrayList<Long>();
        try {

            br = new BufferedReader(new FileReader(csvFile));
            br.lines().skip(1).forEach(OrangeTelecom::create);
            /*Long l=list.stream().filter(intl_plan  -> intl_plan.equals("Yes")).;*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
