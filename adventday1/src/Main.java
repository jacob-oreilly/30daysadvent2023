import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("assets/adventday1.txt");
        Scanner scan = new Scanner(file);
        LinkedHashMap<String, Integer> stringNumbers = new LinkedHashMap<>();
        stringNumbers.put("one", 1);
        stringNumbers.put("two", 2);
        stringNumbers.put("three", 3);
        stringNumbers.put("four", 4);
        stringNumbers.put("five", 5);
        stringNumbers.put("six", 6);
        stringNumbers.put("seven", 7);
        stringNumbers.put("eight", 8);
        stringNumbers.put("nine", 9);

        int finalSum = 0;

        while(scan.hasNextLine()) {
            String concatNumber = "";
            String currentLineString = scan.nextLine();
            currentLineString = FormatString(currentLineString, stringNumbers);
            concatNumber += String.valueOf(currentLineString.charAt(0));
            concatNumber += String.valueOf(currentLineString.charAt(currentLineString.length() - 1));

            System.out.println(concatNumber);
            if (!concatNumber.isEmpty()) {
                finalSum += Integer.parseInt(concatNumber);
            }
        }

        System.out.println("Final Sum: " + finalSum);
    }

    public static String FormatString(String currentLine, LinkedHashMap<String, Integer> stringNumbers) {
        String regexString = "[1-9]|(?=(one|two|three|four|five|six|seven|eight|nine))";
        Matcher match = Pattern.compile(regexString).matcher(currentLine.toLowerCase());
        StringBuilder finalLine = new StringBuilder();
        while(match.find()) {
            String currentMatch = match.group();
            if(currentMatch.matches("[1-9]+")) {
                finalLine.append(match.group());
            }
            else {
                finalLine.append(stringNumbers.get(match.group(1)));
            }
        }
        return finalLine.toString();
    }

    //Tests
    @Test
    public void testFormatString() throws IOException {
        String expect = "2134";
        String actual = "";
        String testLine = "xtwone3four";

        LinkedHashMap<String, Integer> stringNumbers = new LinkedHashMap<>();
        stringNumbers.put("one", 1);
        stringNumbers.put("two", 2);
        stringNumbers.put("three", 3);
        stringNumbers.put("four", 4);
        stringNumbers.put("five", 5);
        stringNumbers.put("six", 6);
        stringNumbers.put("seven", 7);
        stringNumbers.put("eight", 8);
        stringNumbers.put("nine", 9);

        actual = FormatString(testLine, stringNumbers);
        assertEquals(expect, actual);
    }
}