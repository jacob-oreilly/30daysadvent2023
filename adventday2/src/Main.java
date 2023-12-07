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
            gameCount++;
            Matcher match = GetCurrentGameMatch(scan.nextLine());
            if(IsGamePossible(match)) {
                gameSum += gameCount;
            }


        }
        System.out.println(gameSum);
    }

    private static Boolean IsGamePossible(Matcher match) {
        Boolean isPossible = true;
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

    private static int MinPowerPossibleCubes(Matcher match) {
        int minPower = 0;
        return minPower;
    }

    private static Matcher GetCurrentGameMatch(String currentGame) {
        String regexString = "(?>(\\d). blue)|(?>(\\d). red)|(?>(\\d). green)";
        return Pattern.compile(regexString).matcher(currentGame.toLowerCase());
    }


    @Test
    public void testIsGamePossibleTrue() throws IOException {
        Boolean expected = true;
        Boolean actual;
        String currentGame = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
        Matcher match = GetCurrentGameMatch(currentGame);
        actual = IsGamePossible(match);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsGamePossibleFalse() throws IOException {
        Boolean expected = false;
        Boolean actual;
        String currentGame = "Game 1: 3 blue, 20 red; 1 red, 2 green, 6 blue; 2 green";
        Matcher match = GetCurrentGameMatch(currentGame);
        actual = IsGamePossible(match);
        assertEquals(expected, actual);
    }

    @Test
    public void testMinPowerPossibleCubes() throws IOException {
        int expected = 0;
        int actual = 0;
        String currentGame = "Game 1: 3 blue, 20 red; 1 red, 2 green, 6 blue; 2 green";
        Matcher match = GetCurrentGameMatch(currentGame);
        actual = MinPowerPossibleCubes(match);
        assertEquals(expected, actual);
    }


}