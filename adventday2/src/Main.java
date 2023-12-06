import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class Main {
    final static int blueCubeCount = 14;
    final static int redCubeCount = 12;
    final static int greenCubeCount = 13;
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("assets/adventinput.txt");
        Scanner scan = new Scanner(file);
        int gameCount = 0;
        int gameSum = 0;

        while(scan.hasNextLine()) {
            //System.out.println(scan.nextLine());
            gameCount++;
            if(IsGamePossible(scan.nextLine())) {
                gameSum += gameCount;
            }


        }
        System.out.println(gameSum);
    }

    private static Boolean IsGamePossible(String currentGame) {
        Boolean isPossible = true;
        String regexString = "(?>(\\d). blue)|(?>(\\d). red)|(?>(\\d). green)";
        Matcher match = Pattern.compile(regexString).matcher(currentGame.toLowerCase());
        while(match.find()) {
            String[] group = match.group().split(" ");
            switch (group[1]) {
                case "red":
                    if(Integer.parseInt(group[0]) > redCubeCount)
                        return false;
                    break;
                case "blue":
                    if(Integer.parseInt(group[0]) > blueCubeCount)
                        return false;
                    break;
                case "green":
                    if(Integer.parseInt(group[0]) > greenCubeCount)
                        return false;
                    break;
            }

        }
        return isPossible;
    }

    @Test
    public void testIsGamePossibleTrue() throws IOException {
        Boolean expected = true;
        Boolean actual;
        String currentGame = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
        actual = IsGamePossible(currentGame);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsGamePossibleFalse() throws IOException {
        Boolean expected = false;
        Boolean actual;
        String currentGame = "Game 1: 3 blue, 20 red; 1 red, 2 green, 6 blue; 2 green";
        actual = IsGamePossible(currentGame);
        assertEquals(expected, actual);
    }

}