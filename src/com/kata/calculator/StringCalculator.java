package com.kata.calculator;

import java.util.Arrays;

/**
 * Created by sterui on 1/23/17.
 */
public class StringCalculator {

    private String [] output;

    public int calculate(String input) throws Exception {


        if (input.isEmpty()) return 0;

        return processInput(input);


    }

    private int processInput(String input) throws Exception {

        String[] output = checkDelimiter(input);
        int sum=0;
        for (String number:output) {
            if (stringToInt(number) < 0) throw new Exception("test");
            if (stringToInt(number) < 1000)
            sum+=stringToInt(number);
        }
        return sum;
    }

    private String[] checkDelimiter(String input) {
        String delimiters = ",|\n";
        char [] del = new char[5];
        if (input.startsWith("//[")) {
            multipleDelimiter(input,del,delimiters);
            return Arrays.copyOfRange(output, 2, output.length);
        } else if (input.startsWith("//")) {
            singleDelimiter(input,del,delimiters);
            return Arrays.copyOfRange(output, 1, output.length);
        }

        return input.split(delimiters);
    }

    private int stringToInt(String input) {
        return Integer.parseInt(input);
    }

    private void multipleDelimiter(String input, char[] del, String delimiters) {

            input.getChars(2,7,del,0);
            String temp = new String(del);
            String delim = temp.substring(1,temp.length()-1);
            delimiters+= "|" + temp +"\n" + "|" +delim;
            output = input.split(delimiters);
    }

    private void singleDelimiter(String input, char[] del, String delimiters) {

        input.getChars(2,3,del,0);
        delimiters+= "|" + del[0] +"\n" + "|" +del[0];
        output = input.split(delimiters);
    }
}
