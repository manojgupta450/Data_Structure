package com.test;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

/**
 * @author devendra.nalawade on 2/14/17
 * output:
 * Response for 0: Zero Dollar
 * Response for 54: Fifty Four Dollars
 * Response for 333: Three Hundred and Thirty Three Dollars
 * Response for 5457: Five Thousand Four Hundred and Fifty Seven Dollars
 * Response for 1234: One Thousand Two Hundred and Thirty Four Dollars
 * Response for 15987: Fifteen Thousand Nine Hundred and Eighty Seven Dollars
 * Response for MAX INT: Two Billion One Hundred and Fourty Seven Million Four Hundred and Eighty Three Thousand Six Hundred and Fourty Seven Dollars
 */
public class CurrencyToText {

    private static final int BASE_DIVISOR = 1000;

    private static final String[] BASE10 = {
            "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ",
            "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ",
            "Nineteen ", "Twenty "
    };

    private static final String[] DECIMALS = {"Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};

    private static final String[] BASES = {
            "",
            "Thousand ",
            "Million ",
            "Billion "
    };

    private List<Integer> sections = new ArrayList<>();

    public static void main(String[] args) {
        CurrencyToText test = new CurrencyToText();

        System.out.println("Response for 0: " + test.prettyPrintCurrency(0));
        System.out.println("Response for 54: " + test.prettyPrintCurrency(54));
        System.out.println("Response for 333: " + test.prettyPrintCurrency(333));
        System.out.println("Response for 5457: " + test.prettyPrintCurrency(5457));
        System.out.println("Response for 1234: " + test.prettyPrintCurrency(1234));
        System.out.println("Response for 15987: " + test.prettyPrintCurrency(15987));
        System.out.println("Response for MAX INT: " + test.prettyPrintCurrency(Integer.MAX_VALUE));
    }

    private String prettyPrintCurrency(int amount) {

        sections.clear();

        if(amount < 0) throw new RuntimeException("Only accepts positive arguments");

        makeCalculations(amount);

        //sections.forEach(System.out::println);

        if(sections.isEmpty()) return "Zero Dollar";

        StringBuffer displayValue = new StringBuffer();
        for(int i = sections.size() - 1; i >= 0; i--) {
            displayValue.append(convertHundredsToText(sections.get(i)) + BASES[i]);
        }

        return displayValue.toString() + "Dollars";
    }

    private void makeCalculations(int amount) {
        if (amount == 0) return;

        int division = amount / BASE_DIVISOR;
        int mod = amount % BASE_DIVISOR;

        sections.add(mod);

        if (division > BASE_DIVISOR) {
            makeCalculations(division);
        } else if (division > 0){
            sections.add(division);
        }

    }

    private String convertHundredsToText(int num) {
        if (num > 0 && num <= 20) {
            return BASE10[num - 1];
        } else if (num < 100) {
            int base1 = num % 10;
            int base10 = num / 10;
            return DECIMALS[base10 - 1] + BASE10[base1 - 1];
        }else{
            int base10 = num % 100;
            int base100 = num / 100;
            return BASE10[base100 - 1] + "Hundred and " + convertHundredsToText(base10);
        }
    }

}
