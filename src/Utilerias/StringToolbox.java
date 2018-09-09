package Utilerias;

import java.util.Scanner;

public class StringToolbox {
    public static String ReverseString(String toReverse) {
        String reversedString = "";
        for (int i = toReverse.length() - 1; i >= 0; i--) {
            reversedString += toReverse.charAt(i);
        }
        return reversedString;
    }

    public static String ReadLastWord(String toReverse) {
        String reversedString;
        String word;
        String reversedWord;
        Scanner sc;

        word = "";
        reversedWord = "";
        reversedString = ReverseString(toReverse);
        sc = new Scanner(reversedString);
        sc.useDelimiter("\\s* \\s*");

        word += sc.next();
        sc.close();

        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord += word.charAt(i);
        }

        return reversedWord;
    }

    public static String uppercaseSplit(String toSplit) {
        String result = "";

        result += toSplit.charAt(0);
        for (int i = 1; i < toSplit.length(); i++) {
            char resultAux = toSplit.charAt(i);
            if(Character.isUpperCase(resultAux)) {
                result += " " + resultAux;
            }
            else {
                result += resultAux;
            }
        }

        return result;
    }

    public static int returnOnlyNumbers(String toScan) {
        int numbers = 0;
        String auxNumbers = "";

        for (int i = 0; i < toScan.length(); i++) {
            char isNumber = toScan.charAt(i);
            if(Character.isDigit(isNumber)) {
                auxNumbers += isNumber;
            }
        }

        try {
            numbers = Integer.parseInt(auxNumbers);
        }
        catch (NumberFormatException e) {
            System.err.println("Error: No hay números en este string.");
        }

        return numbers;
    }

    //TEST
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter String: ");
        String scan = ReverseString(in.nextLine());
        in.close();
        System.out.println("Reversed: " + scan);
    }
}
