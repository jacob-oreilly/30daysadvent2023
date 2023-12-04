import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("assets/adventday1.txt");
        Scanner scan = new Scanner(file);

        int finalSum = 0;
        int count = 0;

        while(scan.hasNextLine()) {
            String firstInt = "";
            String lastInt = "";
            String concatNumber = "";
            String currentLineString = scan.nextLine();
            char[] currentLineArray = currentLineString.toCharArray();
            if(currentLineString.matches(".*\\d.*")) {
                for(char character: currentLineArray) {
                    if(Character.isDigit(character)) {
                        concatNumber += Character.toString(character);
                        break;
                    }
                }
                for(int i = currentLineArray.length - 1; i >= 0; i--) {
                    if(Character.isDigit(currentLineArray[i])) {
                        concatNumber += Character.toString(currentLineArray[i]);
                        break;
                    }
                }
            }

            if (!concatNumber.isEmpty()) {
                finalSum += Integer.parseInt(concatNumber);
            }
            System.out.println(finalSum);
        }

        System.out.println("Final Sum: " + finalSum);
    }
}