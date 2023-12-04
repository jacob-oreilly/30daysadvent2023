import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("assets/adventday1.txt");
        Scanner scan = new Scanner(file);

        int finalSum = 0;

        while(scan.hasNextLine()) {
            String firstInt = "";
            String lastInt = "";
            String concatNumber = "";
            char[] currentLine = scan.nextLine().toCharArray();
            for(char character: currentLine) {
                if(Character.isDigit(character)) {
                    concatNumber += Character.toString(character);
                    break;
                }
            }
            for(int i = currentLine.length - 1; i > 0; i-- ) {
                if(Character.isDigit(currentLine[i])) {
                    concatNumber += Character.toString(currentLine[i]);
                    break;
                }
            }
            System.out.println(concatNumber);

            finalSum += Integer.parseInt(concatNumber);
            System.out.println(finalSum);
        }

        System.out.println("Final Sum: " + finalSum);
    }
}